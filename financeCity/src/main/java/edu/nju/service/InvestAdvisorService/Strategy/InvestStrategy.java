package edu.nju.service.InvestAdvisorService.Strategy;


import edu.nju.model.UserFamilySpeeding;
import edu.nju.model.UserInformation;
import edu.nju.model.UserTemperPrefer;
import edu.nju.service.POJO.InvestmentPortFolio;
import edu.nju.service.SearchService.SearchService;
import org.springframework.stereotype.Service;

/**
 * Created by Sun YuHao on 2016/8/10.
 */
@Service
public interface InvestStrategy {
    InvestmentPortFolio createInvestmentPortfolio(UserInformation identity, UserTemperPrefer preference, UserFamilySpeeding familyExpense, SearchService searchService);
}
