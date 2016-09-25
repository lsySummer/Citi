package edu.nju.service.InvestAdvisorService.Strategy;

import edu.nju.model.UserTemperPrefer;
import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl.*;
import edu.nju.service.POJO.AssetCategoryAllocation;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.POJO.SharedInfo;
import edu.nju.service.POJO.SimpleTradeInfo;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.TradeService.TradeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
@Component
public class InvestStrategyImpl implements InvestStrategy {
    @Autowired
    private SearchService searchService;
    @Autowired
    private SharedInfo sharedInfo;

    private CategoryInvest[] categoryInvest;

    public InvestStrategyImpl() {
        categoryInvest = new CategoryInvest[] {
                new BankInvest(), new BondInvest(),
                new FundInvest(), new InsuranceInvest()
        };
    }

    @Override
    public List<List<SimpleTradeInfo>> createInvestmentPortfolio(UserTemperPrefer preference, SearchService searchService) {
        AssetCategoryAllocator assetCategoryAllocator = new AssetCategoryAllocatorImpl();
        assetCategoryAllocator.createAllocation(preference, searchService, sharedInfo);

        InvestResult investResult = new InvestResult();

        List<Category> categoryList = ProductCategoryManager.getCategoryList();
        InvestResult insuranceList = new InvestResult();
        for (Category category : categoryList) {
            if (category.equals(ProductCategoryManager.categoryFund)) {
                continue;
            }
            AssetCategoryAllocation allocation = assetCategoryAllocator.getCategoryAllocation(category.getCategoryName());
            if (allocation.getFlowCapital() + allocation.getFreeCapital() < 100) {
                continue;
            }
            //AssetCategoryAllocation allocation = new AssetCategoryAllocation();
            //allocation.setFreeCapital(5000);
            //allocation.setFlowCapital(5000);

            for (CategoryInvest invest : categoryInvest) {
                if (category.belongTo(invest.getCategoryName())) {
                    try {
                        if (!category.belongTo(ProductCategoryManager.categoryInsurance)) {
                            investResult.addInvestResult(invest.invest(preference, searchService, allocation));
                        } else {
                            insuranceList = invest.invest(preference, searchService, allocation);
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        List<List<SimpleTradeInfo>> lists = new ArrayList<>();
        List<TradeItem> insurance_item = insuranceList.getTradeItemList();

        if (insurance_item != null && insurance_item.size() != 0) {
            for (int i = 0; i < insurance_item.size(); ++i) {
                List<SimpleTradeInfo> simpleTradeInfoList = new ArrayList<>();

                for (TradeItem tradeItem : investResult.getTradeItemList()) {
                    SimpleTradeInfo simpleTradeInfo = new SimpleTradeInfo();
                    simpleTradeInfo.setProductId(tradeItem.getProduct().getID());
                    simpleTradeInfo.setAmount(tradeItem.getTradingVolume());

                    simpleTradeInfoList.add(simpleTradeInfo);
                }

                SimpleTradeInfo simpleTradeInfo = new SimpleTradeInfo();
                simpleTradeInfo.setAmount(insuranceList.getUnusedAmount());
                simpleTradeInfo.setProductId(insurance_item.get(i).getProduct().getID());
                simpleTradeInfoList.add(simpleTradeInfo);

                lists.add(simpleTradeInfoList);
            }
        }
        else {
            List<SimpleTradeInfo> simpleTradeInfoList = new ArrayList<>();

            for (TradeItem tradeItem : investResult.getTradeItemList()) {
                SimpleTradeInfo simpleTradeInfo = new SimpleTradeInfo();
                simpleTradeInfo.setProductId(tradeItem.getProduct().getID());
                simpleTradeInfo.setAmount(tradeItem.getTradingVolume());

                simpleTradeInfoList.add(simpleTradeInfo);
            }

            lists.add(simpleTradeInfoList);
        }

        return lists;
    }
}
