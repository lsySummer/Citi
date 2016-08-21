package edu.nju.service.InvestAdvisorService.Strategy;

import edu.nju.model.UserFamilySpeeding;
import edu.nju.model.UserInformation;
import edu.nju.model.UserTemperPrefer;
import edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl.AssetCategoryAllocator;
import edu.nju.service.POJO.AssetCategoryAllocation;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.POJO.InvestmentPortFolio;
import edu.nju.service.SearchService.SearchService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
public class InvestStrategyImpl implements InvestStrategy {
    @Autowired
    AssetCategoryAllocator assetCategoryAllocator;

    @Override
    public InvestmentPortFolio createInvestmentPortfolio(UserInformation identity, UserTemperPrefer preference, UserFamilySpeeding familyExpense, SearchService searchService) {
        assetCategoryAllocator.createAllocation(null, searchService);

        InvestResult investResult = new InvestResult();

        AssetCategoryAllocation bankAllocation = assetCategoryAllocator.getCategoryAllocation("Bank");
        AssetCategoryAllocation bondAllocation = assetCategoryAllocator.getCategoryAllocation("Bond");
        AssetCategoryAllocation insuranceAllocation = assetCategoryAllocator.getCategoryAllocation("Insurance");

        return new InvestmentPortFolio();
    }
}
