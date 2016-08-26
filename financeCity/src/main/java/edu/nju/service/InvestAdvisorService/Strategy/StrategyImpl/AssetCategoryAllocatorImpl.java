package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import Jama.Matrix;
import edu.nju.model.CategoryIndex;
import edu.nju.service.POJO.AssetCategoryAllocation;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Utils.ARIMA;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
@Component
public class AssetCategoryAllocatorImpl implements AssetCategoryAllocator {
    static public final String paramSign = "sign";
    static public final String paramCapital = "capital";
    static public final int categoryNum = 14;
    static public final int arimaHistory = 30;
    private Map<String, AssetCategoryAllocation> assetCategoryAllocationList;

    @SuppressWarnings("unchecked")
    @Override
    public void createAllocation(Map<String, Object> param, SearchService searchService) {
        init();

        double capital = 0;
        int k = 0;
        Map<String, Boolean> sign;

        try {
            capital = (double)param.get(paramCapital);
            sign = (Map<String, Boolean>)param.get(paramSign);
        }
        catch (NullPointerException n) {
            n.printStackTrace();
            return;
        }

        k = getK(sign);
    }

    @Override
    public AssetCategoryAllocation getCategoryAllocation(String category) {
        return assetCategoryAllocationList.get(category);
    }

    private void init() {
        assetCategoryAllocationList = new HashMap<>();
    }

    private int getK(Map<String, Boolean> sign) {
        int k = 0;

        for (String type : sign.keySet()) {
            if (sign.get(type)) {
                ++k;
            }
        }

        return k;
    }

    private void calcuCategoryPortion(CategoryInfo[] categoryInfos) {
        int k = categoryInfos.length;
        double[][] dM = new double[k][];
        double sumW = 0;
        double[] Wmkt = new double[k];
        double[] ER = new double[k];
        Matrix P = new Matrix(k, k);

        for (int i = 0; i < k; ++i) {
            dM[i] = categoryInfos[i].E;
            sumW += categoryInfos[i].W;
            ER[i] = categoryInfos[i].Er;
            P.set(k, k, 1);
        }
        for (int i = 0; i < k; ++i) {
            Wmkt[i] = categoryInfos[i].W / sumW;
        }

        Matrix matrix = new Matrix(dM);
        matrix = matrix.transpose();
    }

    private CategoryInfo[] getCategoriesInfo(SearchService searchService, Map<String, Boolean> sign) {
        CategoryInfo[] categoryInfo = initCategoryInfo(sign, searchService);

        for (int i = 0; i < categoryInfo.length; ++i) {
            ARIMA arima = new ARIMA(categoryInfo[i].E);
            categoryInfo[i].Exp = arima.getReulst();
        }

        return categoryInfo;
    }

    private CategoryInfo[] initCategoryInfo(Map<String, Boolean> sign, SearchService searchService) {
        int k = getK(sign);
        CategoryInfo[] categoryInfo = new CategoryInfo[k];
        CategoryIndex categoryIndex = searchService.getCategoryIndex();
        //TODO:set Min insurance
        double Min_Inurance = 0;
        //TODO:add ret rate sequence

        Iterator iterator = sign.keySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            String key = (String)iterator.next();
            if (sign.get(key)) {
                //Market value
                try {
                    categoryInfo[i].W = getMarketValue(key, categoryIndex);
                }
                catch (NullPointerException n) {
                    categoryInfo[i].W = 0;
                }
                //category
                categoryInfo[i].category = key;
                //LC
                categoryInfo[i].LC = 0.5;
                //Min Amount
                if (key.equals(ProductCategoryManager.categoryInsurance)) {
                    categoryInfo[i].MinAmount = Min_Inurance;
                }
                else {
                    categoryInfo[i].MinAmount = 0;
                }

                ++i;
            }
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

    private class CategoryInfo {
        static final int historyNum = 30;
        String category;  //资产类型
        double E[];      //资产的历史收益率序列
        double Er;        //预期年化收益率
        double  W;     //资产的市值
        double  Exp;     //专家预期收益观点
        double  LC;      //观点的置信度
        double MinAmount; //最低额度
    }
}
