package edu.nju.service.InvestAdvisorService;

import edu.nju.model.UserTemperPrefer;
import edu.nju.service.ExceptionsAndError.NotAllConfigurationSetException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.InvestAdvisorService.Strategy.InvestStrategy;
import edu.nju.service.POJO.*;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.vo.TemperPreferVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class InvestAdvisorServiceImpl implements InvestAdvisorService {
    private SearchService searchService;
    private UserService userService;

    @Autowired
    private InvestStrategy investStrategy;

    @Override
    public boolean setTemperPrefer(TemperPreferVO temperPreferVO, FinanceCityUser financeCityUser) throws NotLoginException {
        //TODO:check if valid
        userService.getUserDao(financeCityUser).save(temperPreferVO);
        return false;
    }

    //TODO:...
    @Override
    public TemperPreferVO getTemperPreferVO(FinanceCityUser financeCityUser) throws NotLoginException {
        return null;
    }

    @Override
    public InvestResult createInvestmentPortFolio(UserTemperPrefer preference) throws NotAllConfigurationSetException {
        if (preference == null) {
            throw new NotAllConfigurationSetException();
        }

        return investStrategy.createInvestmentPortfolio(preference, searchService);
    }

    @Override
    public void bindSearchService(SearchService searchService) {
        this.searchService = searchService;
    }
}
