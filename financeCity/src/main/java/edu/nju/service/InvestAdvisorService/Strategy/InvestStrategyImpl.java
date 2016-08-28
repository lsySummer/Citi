package edu.nju.service.InvestAdvisorService.Strategy;

import edu.nju.model.UserTemperPrefer;
import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl.*;
import edu.nju.service.POJO.AssetCategoryAllocation;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.SearchService.SearchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
public class InvestStrategyImpl implements InvestStrategy {
    @Autowired
    AssetCategoryAllocator assetCategoryAllocator;

    CategoryInvest[] categoryInvest = {
        new BankInvest(), new BondInvest(),
            new FundInvest(), new InsuranceInvest()
    };

    @Override
    public InvestResult createInvestmentPortfolio(UserTemperPrefer preference, SearchService searchService) {
        assetCategoryAllocator.createAllocation(null, searchService);

        InvestResult investResult = new InvestResult();

        List<Category> categoryList = ProductCategoryManager.getCategoryList();
        for (Category category : categoryList) {
            AssetCategoryAllocation allocation = assetCategoryAllocator.getCategoryAllocation(category.getCategoryName());

            for (CategoryInvest invest : categoryInvest) {
                if (category.belongTo(invest.getCategoryName())) {
                    investResult.addInvestResult(invest.invest(preference,searchService));
                }
            }
        }

        return investResult;
    }
}
