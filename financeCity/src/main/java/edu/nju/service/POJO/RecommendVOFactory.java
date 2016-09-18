package edu.nju.service.POJO;

import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.ExceptionsAndError.NoSuchProductException;
import edu.nju.service.InvestAdvisorService.InvestAdvisorService;
import edu.nju.service.SearchService.SearchService;
import edu.nju.vo.RecommendedPortfolioVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/9/15.
 */
public class RecommendVOFactory {
    static public RecommendedPortfolioVO createRecommend(List<TradeInfoWithCheckCode> src,
                                                         SearchService searchService, InvestAdvisorService investAdvisorService) throws NoSuchProductException {
        RecommendedPortfolioVO recommendedPortfolioVO = new RecommendedPortfolioVO();

        List<CommonPortfolio> portfolios = new ArrayList<>();
        for (TradeInfoWithCheckCode tradeInfoWithCheckCode : src) {
            CommonPortfolio commonPortfolio = new CommonPortfolio();double total_amount = 0;

            for (SimpleTradeInfo simpleTradeInfo : tradeInfoWithCheckCode.getTradeInfos()) {
                total_amount += simpleTradeInfo.getAmount();
            }

            List<CommonProductInfo> commonProductInfoList = new ArrayList<>();
            for (SimpleTradeInfo simpleTradeInfo : tradeInfoWithCheckCode.getTradeInfos()) {
                Product product = searchService.getProductByID(simpleTradeInfo.getProductId());
                double percentage = 100 * simpleTradeInfo.getAmount() / total_amount;

                CommonProductInfo commonProductInfo = new CommonProductInfo();
                commonProductInfo.setAmount(simpleTradeInfo.getAmount());
                commonProductInfo.setId(simpleTradeInfo.getProductId());
                commonProductInfo.setName(product.getName());
                commonProductInfo.setProductType(product.getCategory().getCategoryName());
                commonProductInfo.setPercentage(percentage);
                commonProductInfo.setLength(product.getDayLength());
                commonProductInfo.setRisk(product.getCategory().belongTo(ProductCategoryManager.categoryFund));
                commonProductInfo.setRtr(product.getRTR() * 100);
                commonProductInfo.setFlow(product.getCategory().belongTo(ProductCategoryManager.categoryFund) ||
                        product.getCategory().belongTo(ProductCategoryManager.categoryBond));

                commonProductInfoList.add(commonProductInfo);
            }

            commonPortfolio.setTotal_amount(total_amount);
            commonPortfolio.setProducts(commonProductInfoList);
            commonPortfolio.setCheckCode(tradeInfoWithCheckCode.getCheckCode());

            PortfolioScores scores = investAdvisorService.getPortfolioScore(commonPortfolio);
            commonPortfolio.setYield_score(scores.getYield_score());
            commonPortfolio.setRisk_score(scores.getRisk_score());
            commonPortfolio.setLength_score(scores.getLength_score());
            commonPortfolio.setFlow_score(scores.getFlow_score());

            portfolios.add(commonPortfolio);
        }

        recommendedPortfolioVO.setData(portfolios);

        return recommendedPortfolioVO;
    }
}
