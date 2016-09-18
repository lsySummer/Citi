package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWLogicalArray;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import edu.nju.model.CategoryIndex;
import edu.nju.model.CategoryMarketWeeklyHistory;
import edu.nju.model.CategoryRtrWeeklyHistory;
import edu.nju.model.UserTemperPrefer;
import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.POJO.AssetCategoryAllocation;
import edu.nju.service.POJO.SharedInfo;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Utils.ARIMA;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.Utils.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import process3.ClassProcess3;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
public class AssetCategoryAllocatorImpl implements AssetCategoryAllocator {
    private Map<String, AssetCategoryAllocation> assetCategoryAllocationList;
    private ClassProcess3 process3;

    @SuppressWarnings("unchecked")
    @Override
    public void createAllocation(UserTemperPrefer userInfo, SearchService searchService, SharedInfo sharedInfo) {
        init(sharedInfo);

        double capital = userInfo.getExpectedCapital().doubleValue();

        CategoryInfo[] categoryInfos = calcuCategoryPortion(capital, userInfo, getCategoriesInfo(searchService, userInfo), searchService);

        for (CategoryInfo categoryInfo : categoryInfos) {
            AssetCategoryAllocation assetCategoryAllocation = new AssetCategoryAllocation();
            assetCategoryAllocation.setFlowCapital(categoryInfo.getFlowCapital());
            assetCategoryAllocation.setFreeCapital(categoryInfo.getFreeCapital());
            assetCategoryAllocationList.put(categoryInfo.getCategory().getCategoryName(), assetCategoryAllocation);
        }
    }

    @Override
    public AssetCategoryAllocation getCategoryAllocation(String category) {
        return assetCategoryAllocationList.get(category);
    }

    private void init(SharedInfo sharedInfo) {
        assetCategoryAllocationList = new HashMap<>();
        process3 = sharedInfo.getProcess3();
    }

    private CategoryInfo[] calcuCategoryPortion(double capital, UserTemperPrefer userTemperPrefer,
                                                CategoryInfo[] categoryInfos, SearchService searchService) {
        int categoryNum = ProductCategoryManager.categoryNum - 1;
        boolean[][] sign = new boolean[1][categoryNum];
        double[][] E = new double[CategoryInfo.historyNum][categoryNum];
        double[][] W = new double[1][categoryNum];
        double[][] Exp = new double[1][categoryNum];
        double[][] LC = new double[1][categoryNum];
        double[][] E_hs = getHS_300(searchService);
        double rf = searchService.getCategoryIndex().getRiskFreeInterest().doubleValue();
        double min_insurance = userTemperPrefer.getInsuranceAmount().doubleValue();
        double money_start = capital - min_insurance;
        double volatility_min = userTemperPrefer.getRiskToleranceMin().doubleValue();
        double volatility_max = userTemperPrefer.getRiskToleranceMax().doubleValue();
        double volatility = (volatility_max + volatility_min) / 2;
        double money_flexble = userTemperPrefer.getMayRedeemAmount().doubleValue();
        int k = 0;

        int no = 0;
        for (int i = 0; i < ProductCategoryManager.categoryNum; ++i) {
            if (categoryInfos[i].getCategory().equals(ProductCategoryManager.categoryInsurance)) {
                continue;
            }

            sign[0][no] = categoryInfos[i].isChosen();
            k += categoryInfos[i].isChosen() ? 1 : 0;
            for (int j = 0; j < CategoryInfo.historyNum; ++j) {
                E[j][no] = categoryInfos[i].getE()[j];
            }
            W[0][no] = categoryInfos[i].getW();
            Exp[0][no] = categoryInfos[i].getExp();
            LC[0][no] = categoryInfos[i].getLC();
            ++no;
        }

        try {
            MWLogicalArray Msign = new MWLogicalArray(sign);
            MWNumericArray Mk = new MWNumericArray(k, MWClassID.DOUBLE);
            MWNumericArray ME = new MWNumericArray(E, MWClassID.DOUBLE);
            MWNumericArray ME_hs = new MWNumericArray(E_hs, MWClassID.DOUBLE);
            MWNumericArray MW = new MWNumericArray(W, MWClassID.DOUBLE);
            MWNumericArray MExp = new MWNumericArray(Exp, MWClassID.DOUBLE);
            MWNumericArray MLC = new MWNumericArray(LC, MWClassID.DOUBLE);
            MWNumericArray Mrf = new MWNumericArray(rf, MWClassID.DOUBLE);
            MWNumericArray Mmoney_start = new MWNumericArray(money_start, MWClassID.DOUBLE);
            MWNumericArray Mmoney_flexble = new MWNumericArray(money_flexble, MWClassID.DOUBLE);
            MWNumericArray Mvolatility = new MWNumericArray(volatility, MWClassID.DOUBLE);

            Object[] result = process3.process3(1, Msign, Mk, ME, ME_hs, MW, MExp, MLC, Mrf, Mmoney_start, Mmoney_flexble, Mvolatility);
            MWNumericArray temp = (MWNumericArray)result[0];
            double[][] ret =  (double[][])temp.toDoubleArray();

            no = 0;
            for (int i  = 0; i < ProductCategoryManager.categoryNum; ++i) {
                if (categoryInfos[i].getCategory().equals(ProductCategoryManager.categoryInsurance)) {
                    categoryInfos[i].setFreeCapital(min_insurance);
                }
                else {
                    categoryInfos[i].setFlowCapital(ret[0][no]);
                    categoryInfos[i].setFreeCapital(ret[1][no]);
                    ++no;
                }
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
            if (categoryInfo[i].getCategory().belongTo(ProductCategoryManager.categoryInsurance)) {
                continue;
            }
            ARIMA arima = new ARIMA(categoryInfo[i].getE());
            categoryInfo[i].setExp(arima.getReulst());
        }

        return categoryInfo;
    }

    @SuppressWarnings("unchecked")
    public CategoryInfo[] initCategoryInfo(UserTemperPrefer userInfo, SearchService searchService) {
        CategoryInfo[] categoryInfoList = CategoryInfo.getCatetories();
        CategoryMarketWeeklyHistory categoryMarketWeeklyHistory = searchService.getCategoryMarket();
        List<CategoryRtrWeeklyHistory> categoryRtrWeeklyHistory = searchService.getCategoryRtrWeeklyHistory(CategoryInfo.historyNum);
        double Min_Inurance = userInfo.getInsuranceAmount().doubleValue();

        for (CategoryInfo categoryInfo : categoryInfoList) {
            //sign
            //TODO:set choose
            if (categoryInfo.getCategory().equals(ProductCategoryManager.categoryInsurance)) {
                categoryInfo.setChosen(Min_Inurance > 0);
                categoryInfo.setFreeCapital(Min_Inurance);
            }
            else {
                categoryInfo.setChosen(true);
            }

            //LC
            categoryInfo.setLC(0.5);

            if (categoryInfo.isChosen()) {
                //return rate sequence
                categoryInfo.setE(getHistoryReturnRateSequence(categoryInfo.getCategory(), categoryRtrWeeklyHistory));
                if (categoryInfo.getE().length == 0) {
                    return new CategoryInfo[0];
                }

                //Market value
                try {
                    categoryInfo.setW(getMarketValue(categoryInfo.getCategory().getCategoryName(), categoryMarketWeeklyHistory));
                }
                catch (NullPointerException n) {
                    n.printStackTrace();
                    categoryInfo.setW(0);
                }
            }
            else {
                categoryInfo.setE(new double[CategoryInfo.historyNum]);
            }
        }

        return categoryInfoList;
    }

    private Double getMarketValue(String category, CategoryMarketWeeklyHistory categoryIndex) {
        try {
            Method getter = MethodUtils.getGetter(CategoryMarketWeeklyHistory.class, category);
            return ((BigDecimal)getter.invoke(categoryIndex)).doubleValue();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private double[][] getHS_300(SearchService searchService) {
        double[][] ret;

        double[] hs300 = searchService.getHS_300ByTime(CategoryInfo.historyNum);
        if (hs300.length > 0) {
            ret = new double[1][];
            ret[0] = hs300;
            return ret;
        }
        else {
            return new double[0][];
        }
    }

    //TODO:sequence 周年化收益率
    private double[] getHistoryReturnRateSequence(Category category, List<CategoryRtrWeeklyHistory> list) {
        Method getter = MethodUtils.getGetter(CategoryRtrWeeklyHistory.class, category.getCategoryName());
        double[] ret = new double[list.size()];

        try {
            for (int i = 0; i < list.size(); ++i) {
                ret[i] = ((BigDecimal) getter.invoke(list.get(i))).doubleValue();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    static public void main(String[] args) {
        System.out.println(System.getProperty("java.library.path"));
        int categoryNum = 4;
        boolean[] sign = new boolean[categoryNum];
        sign[0] = true;sign[1] = true;sign[2] = true;sign[3] = true;
        double[][] E = new double[10][4];
        double[][] W = new double[1][4];
        double[][] Exp = new double[1][4];
        double[][] LC = new double[1][4];
        for (int i =0; i < 4; ++i) {
            for (int j = 0; j < 10; ++j) {
                E[j][i] = Math.random();
            }
        }
        double[][] E_hs = new double[1][4];

        for (int i = 0; i < 4; ++i) {
            W[0][i] = Math.random();
            Exp[0][i] = Math.random();
            LC[0][i] = Math.random();
            E_hs[0][i] = Math.random();
        }
        double rf = 0.03;
        double money_start = 100;
        double volatility_min = 0;
        double volatility_max = 0.2;
        double volatility = (volatility_max + volatility_min) / 2;
        double[] money_flexble = new double[1];
        money_flexble[0] = 90;
        int k = 4;




        try {
            ClassProcess3 process3 = new ClassProcess3();
            MWLogicalArray Msign = new MWLogicalArray(sign);
            MWNumericArray Mk = new MWNumericArray(k, MWClassID.DOUBLE);
            MWNumericArray ME = new MWNumericArray(E, MWClassID.DOUBLE);
            MWNumericArray ME_hs = new MWNumericArray(E_hs, MWClassID.DOUBLE);
            MWNumericArray MW = new MWNumericArray(W, MWClassID.DOUBLE);
            MWNumericArray MExp = new MWNumericArray(Exp, MWClassID.DOUBLE);
            MWNumericArray MLC = new MWNumericArray(LC, MWClassID.DOUBLE);
            MWNumericArray Mrf = new MWNumericArray(rf, MWClassID.DOUBLE);
            MWNumericArray Mmoney_start = new MWNumericArray(money_start, MWClassID.DOUBLE);
            MWNumericArray Mmoney_flexble = new MWNumericArray(money_flexble, MWClassID.DOUBLE);
            MWNumericArray Mvolatility = new MWNumericArray(volatility, MWClassID.DOUBLE);

            Object[] result = process3.process3(1, Msign, Mk, ME, ME_hs, MW, MExp, MLC, Mrf, Mmoney_start, Mmoney_flexble, Mvolatility);
            MWNumericArray temp = (MWNumericArray)result[0];
            System.out.print(temp);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
