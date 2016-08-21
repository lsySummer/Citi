package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import edu.nju.service.POJO.AssetCategoryAllocation;
import edu.nju.service.SearchService.SearchService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
public class AssetCategoryAllocatorImpl implements AssetCategoryAllocator {
    static private final String paramSign = "sign";
    private Map<String, AssetCategoryAllocation> assetCategoryAllocationList;

    @Override
    public void createAllocation(Map<String, Object> param, SearchService searchService) {
        init();
    }

    @Override
    public AssetCategoryAllocation getCategoryAllocation(String category) {
        return assetCategoryAllocationList.get(category);
    }

    private void init() {
        assetCategoryAllocationList = new HashMap<>();
    }

    class AssetClass {
        double[] E;
        double Er;
        double W;
        double Exp;
        double LC;
    };
}
