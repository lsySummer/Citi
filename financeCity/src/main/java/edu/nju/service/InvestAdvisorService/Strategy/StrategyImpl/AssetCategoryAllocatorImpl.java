package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import edu.nju.model.CategoryIndex;
import edu.nju.model.UserTemperPrefer;
import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.POJO.AssetCategoryAllocation;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Utils.ARIMA;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import org.springframework.stereotype.Component;
import process3.ClassProcess3;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
@Component
public class AssetCategoryAllocatorImpl implements AssetCategoryAllocator {
    static public final int arimaHistory = 30;
    private Map<String, AssetCategoryAllocation> assetCategoryAllocationList;

    @SuppressWarnings("unchecked")
    @Override
    public void createAllocation(UserTemperPrefer userInfo, SearchService searchService) {
        init();

        double capital = userInfo.getExpectedCapital().doubleValue();

        CategoryInfo[] categoryInfos = calcuCategoryPortion(capital, userInfo, getCategoriesInfo(searchService, userInfo), searchService);

        for (CategoryInfo categoryInfo : categoryInfos) {
            AssetCategoryAllocation assetCategoryAllocation = new AssetCategoryAllocation();
            assetCategoryAllocation.setCapital(categoryInfo.capital);
            assetCategoryAllocationList.put(categoryInfo.category, assetCategoryAllocation);
        }
    }

    @Override
    public AssetCategoryAllocation getCategoryAllocation(String category) {
        return assetCategoryAllocationList.get(category);
    }

    private void init() {
        assetCategoryAllocationList = new HashMap<>();
    }

    //TODO:the third one must be insurance
    private CategoryInfo[] calcuCategoryPortion(double capital, UserTemperPrefer userTemperPrefer,
                                                CategoryInfo[] categoryInfos, SearchService searchService) {
        int categoryNum = ProductCategoryManager.categoryNum;
        boolean[][] sign = new boolean[1][categoryNum];
        double[][] E = new double[CategoryInfo.historyNum][categoryNum];
        double[][] ER = new double[1][categoryNum];
        double[][] W = new double[1][categoryNum];
        double[][] Exp = new double[1][categoryNum];
        double[][] LC = new double[1][categoryNum];
        double rf = searchService.getCategoryIndex().getRiskFreeInterest().doubleValue();
        double money_start = capital;
        double volatility_min = userTemperPrefer.getRiskToleranceMin().doubleValue();
        double volatility_max = userTemperPrefer.getRiskToleranceMax().doubleValue();
        double volatility = (volatility_max + volatility_min) / 2;
        double min_insurance = userTemperPrefer.getInsuranceAmount().doubleValue();
        int k = 0;

        for (int i = 0; i < categoryNum; ++i) {
            sign[1][i] = categoryInfos[i].chosen;
            k += categoryInfos[i].chosen ? 1 : 0;
            for (int j = 0; j < CategoryInfo.historyNum; ++j) {
                E[j][i] = categoryInfos[i].E[j];
            }
            ER[1][i] = categoryInfos[i].Er;
            W[1][i] = categoryInfos[i].W;
            Exp[1][i] = categoryInfos[i].Exp;
            LC[1][i] = categoryInfos[i].LC;
        }

        try {
            ClassProcess3 process3 = new ClassProcess3();
            MWNumericArray Msign = new MWNumericArray(sign, MWClassID.LOGICAL);
            MWNumericArray ME = new MWNumericArray(E, MWClassID.DOUBLE);
            MWNumericArray MER = new MWNumericArray(ER, MWClassID.DOUBLE);
            MWNumericArray MW = new MWNumericArray(W, MWClassID.DOUBLE);
            MWNumericArray MExp = new MWNumericArray(Exp, MWClassID.DOUBLE);
            MWNumericArray MLC = new MWNumericArray(LC, MWClassID.DOUBLE);

            Object[] result = process3.process3(1, Msign, k, CategoryInfo.historyNum, ME, MER, MW, MExp, MLC, rf, money_start, volatility, min_insurance);
            MWNumericArray temp = (MWNumericArray)result[0];
            double[][] ret =  (double[][])temp.toDoubleArray();

            for (int i  = 0; i < ProductCategoryManager.categoryNum; ++i) {
                categoryInfos[i].capital = ret[0][i];
            }

            return categoryInfos;
        }
        catch (Exception e) {
            e.printStackTrace();
            return new CategoryInfo[0];
        }
    }

    private CategoryInfo[] getCategoriesInfo(SearchService searchService, UserTemperPrefer userInfo) {
        CategoryInfo[] categoryInfo = initCategoryInfo(userInfo, searchService);

        for (int i = 0; i < categoryInfo.length; ++i) {
            ARIMA arima = new ARIMA(categoryInfo[i].E);
            categoryInfo[i].Exp = arima.getReulst();
        }

        return categoryInfo;
    }

    private CategoryInfo[] initCategoryInfo(UserTemperPrefer userInfo, SearchService searchService) {
        CategoryInfo[] categoryInfo = new CategoryInfo[ProductCategoryManager.categoryNum];
        CategoryIndex categoryIndex = searchService.getCategoryIndex();
        double Min_Inurance = userInfo.getInsuranceAmount().doubleValue();
        List<Category> categoryList = ProductCategoryManager.getCategoryList();
        String sign = userInfo.getChosenProducts();

        for (int i  = 0; i < ProductCategoryManager.categoryNum; ++i) {
            //sign
            categoryInfo[i].chosen = sign.charAt(i) == '1';
            //category
            categoryInfo[i].category = categoryList.get(i).getCategoryName();
            //LC
            categoryInfo[i].LC = 0.5;

            if (categoryInfo[i].chosen) {
                //return rate sequence
                categoryInfo[i].E = getHistoryReturnRateSequence(categoryInfo[i].category);
                if (categoryInfo[i].E.length == 0) {
                    return new CategoryInfo[0];
                }

                //Market value
                try {
                    categoryInfo[i].W = getMarketValue(categoryInfo[i].category, categoryIndex);
                }
                catch (NullPointerException n) {
                    n.printStackTrace();
                    categoryInfo[i].W = 0;
                }

                //Min Amount
                if (categoryInfo[i].category.equals(ProductCategoryManager.categoryInsurance)) {
                    categoryInfo[i].MinAmount = Min_Inurance;
                }
                else {
                    categoryInfo[i].MinAmount = 0;
                }
            }
            else {
                categoryInfo[i].E = new double[CategoryInfo.historyNum];
            }

            ++i;
        }

        return categoryInfo;
    }

    private Double getMarketValue(String category, CategoryIndex categoryIndex) {
        try {
            Field field = CategoryIndex.class.getField(category.toLowerCase() + "MarketValue");
            return field.getDouble(category);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //TODO:sequence
    private double[] getHistoryReturnRateSequence(String category) {
        return new double[0];
    }

    private class CategoryInfo {
        //TODO:change according to database
        static final int historyNum = 30;

        String category;  //资产类型
        boolean chosen;  //是否选中
        double E[];      //资产的历史收益率序列
        double Er;        //预期年化收益率
        double  W;     //资产的市值
        double  Exp;     //专家预期收益观点
        double  LC;      //观点的置信度
        double MinAmount; //最低额度
        double capital; //分到的资金
    }

    static public void main(String[] args) {

    }
}
