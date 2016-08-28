package edu.nju.service.InvestAdvisorService.Strategy;

import edu.nju.model.UserTemperPrefer;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.SearchService.SearchService;
import org.springframework.stereotype.Service;

/**
 * Created by Sun YuHao on 2016/8/10.
 */
@Service
public interface InvestStrategy {
    InvestResult createInvestmentPortfolio(UserTemperPrefer preference, SearchService searchService);
}
