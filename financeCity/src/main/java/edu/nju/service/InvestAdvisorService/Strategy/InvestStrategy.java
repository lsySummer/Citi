package edu.nju.service.InvestAdvisorService.Strategy;


import edu.nju.model.UserFamilySpeeding;
import edu.nju.model.UserInformation;
import edu.nju.model.UserTemperPrefer;
import edu.nju.service.POJO.InvestmentPortFolio;

/**
 * Created by Sun YuHao on 2016/8/10.
 */
public interface InvestStrategy {
    InvestmentPortFolio createInvestmentPortfolio(UserInformation identity, UserTemperPrefer preference, UserFamilySpeeding familyExpense);
}
