package edu.nju.service.InvestAdvisorService;

import edu.nju.model.UserTemperPrefer;
import edu.nju.service.ExceptionsAndError.InvalidUserPreferenceException;
import edu.nju.service.ExceptionsAndError.NotAllConfigurationSetException;
import edu.nju.service.POJO.CommonPortfolio;
import edu.nju.service.POJO.PortfolioScores;
import edu.nju.service.POJO.SimpleTradeInfo;
import edu.nju.service.POJO.TradeInfoWithCheckCode;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface InvestAdvisorService {
    /**
     * create investment portfolio
     * @param preference
     * @return invest result
     * @throws NotAllConfigurationSetException
     */
    List<TradeInfoWithCheckCode> createInvestmentPortFolio(UserTemperPrefer preference) throws NotAllConfigurationSetException, InvalidUserPreferenceException;

    PortfolioScores getPortfolioScore(CommonPortfolio commonPortfolio);
}
