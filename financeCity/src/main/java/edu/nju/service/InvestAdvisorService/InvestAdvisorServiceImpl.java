package edu.nju.service.InvestAdvisorService;

import edu.nju.dao.UserDao;
import edu.nju.model.User;
import edu.nju.model.UserTemperPrefer;
import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.ExceptionsAndError.NotAllConfigurationSetException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.InvestAdvisorService.Strategy.InvestStrategy;
import edu.nju.service.POJO.*;
import edu.nju.service.SearchService.SearchService;
import edu.nju.vo.FamilySpendingVO;
import edu.nju.vo.IdentityVO;
import edu.nju.vo.TemperPreferVO;
import edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class InvestAdvisorServiceImpl extends BaseFunctionServiceAdaptor implements InvestAdvisorService {
    private SearchService searchService;

    @Autowired
    private InvestStrategy investStrategy;

    //TODO:...
    @Override
    public boolean setIdentity(IdentityVO identity) {
       return false;
    }

    //TODO:...
    @Override
    public IdentityVO getIdentity() {
        return null;
    }

    //TODO:...
    @Override
    public boolean setTemperPrefer(TemperPreferVO temperPreferVO) {
        return false;
    }

    //TODO:...
    @Override
    public TemperPreferVO getTemperPreferVO() {
        return null;
    }

    @Override
    public boolean setFamilySpending(FamilySpendingVO familySpending) {
        return false;
    }

    @Override
    public FamilySpendingVO getFamilySpendingVO() {
        return null;
    }

    @Override
    public boolean ifIdentityIsSet() {
        try {
            UserDao DAO = getUserService().getUserDao();
            List list = DAO.find("SELECT id FROM UserInformation identity WHERE identity.id=" + getUserService().getID());
            return !(list == null || list.size() == 0);
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public boolean ifPreferenceIsSet() {
        try {
            UserDao DAO = getUserService().getUserDao();
            List list = DAO.find("SELECT id FROM UserTemperPrefer preference WHERE preference.id=" + getUserService().getID());
            return !(list == null || list.size() == 0);
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public boolean ifAllSet() {
        try {
            UserDao DAO = getUserService().getUserDao();
            List list = DAO.find("SELECT id FROM UserFamilySpending familySpending WHERE familySpending.id=" + getUserService().getID());
            return !(list == null || list.size() == 0);
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public InvestResult createInvestmentPortFolio() throws NotAllConfigurationSetException, NotLoginException {
        UserDao DAO = getUserService().getUserDao();
        try {
            UserTemperPrefer preference = (UserTemperPrefer) DAO.find("FROM UserTemperPrefer preference WHERE preference.id=" + getUserService().getID()).get(0);
            return investStrategy.createInvestmentPortfolio(preference, searchService);
        }
        catch (NullPointerException n) {
            n.printStackTrace();
            throw new NotAllConfigurationSetException();
        }
    }

    @Override
    public InvestResult createInvestmentPortFolio(UserTemperPrefer preference) throws NotAllConfigurationSetException {
        if (preference == null) {
            throw new NotAllConfigurationSetException();
        }

        return investStrategy.createInvestmentPortfolio(preference, searchService);
    }

    //TODO:set user VO
    @Override
    public UserVO getUserVO() {
        return null;
    }

    @Override
    public void bindSearchService(SearchService searchService) {
        this.searchService = searchService;
    }
}
