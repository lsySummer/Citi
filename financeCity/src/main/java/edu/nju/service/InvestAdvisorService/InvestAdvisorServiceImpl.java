package edu.nju.service.InvestAdvisorService;

import edu.nju.model.UserTemperPrefer;
import edu.nju.service.ExceptionsAndError.InvalidUserPreferenceException;
import edu.nju.service.ExceptionsAndError.NotAllConfigurationSetException;
import edu.nju.service.InvestAdvisorService.Strategy.InvestStrategy;
import edu.nju.service.POJO.*;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class InvestAdvisorServiceImpl implements InvestAdvisorService {
    @Autowired
    SearchService searchService;
    @Autowired
    private InvestStrategy investStrategy;

    @Override
    public List<TradeInfoWithCheckCode> createInvestmentPortFolio(UserTemperPrefer preference) throws NotAllConfigurationSetException, InvalidUserPreferenceException {
        if (preference == null) {
            throw new NotAllConfigurationSetException();
        }

        if (!preference.getEndTime().after(new Date(System.currentTimeMillis()))) {
            throw new InvalidUserPreferenceException();
        }

        List<TradeInfoWithCheckCode> list = new ArrayList<>();
        List<List<SimpleTradeInfo>> info = investStrategy.createInvestmentPortfolio(preference, searchService);

        for (List<SimpleTradeInfo> item : info) {
            TradeInfoWithCheckCode tradeInfoWithCheckCode = new TradeInfoWithCheckCode();
            tradeInfoWithCheckCode.setTradeInfos(item);
            tradeInfoWithCheckCode.setCheckCode(MD5Utils.generateMD5(item.toString()));

            list.add(tradeInfoWithCheckCode);
        }

        return list;
    }

    @Override
    public PortfolioScores getPortfolioScore(CommonPortfolio commonPortfolio) {
        //TODO:calculate scores
        double flow_score = 0;
        double length_score = 0;
        double risk_score = 0;
        double yield_score = 0;

        for (CommonProductInfo productInfo : commonPortfolio.getProducts()) {
            flow_score += productInfo.isFlow() ? productInfo.getPercentage() : 0;
            length_score += productInfo.getLength() * productInfo.getPercentage() / (100 * 30);
            risk_score += productInfo.isRisk() ? productInfo.getPercentage() : 0;
            yield_score += productInfo.getPercentage() / 100 * productInfo.getRtr() * 5;
        }

        PortfolioScores portfolioScores = new PortfolioScores();
        portfolioScores.setFlow_score((int)flow_score);
        portfolioScores.setLength_score((int)(length_score > 100 ? 100 : length_score));
        portfolioScores.setRisk_score((int)risk_score);
        portfolioScores.setYield_score((int)yield_score);

        return portfolioScores;
    }
}
