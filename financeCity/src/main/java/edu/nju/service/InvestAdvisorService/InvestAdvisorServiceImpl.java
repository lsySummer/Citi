package edu.nju.service.InvestAdvisorService;

import edu.nju.dao.BaseDao;
import edu.nju.service.BaseService.BaseFunctionService;
import edu.nju.service.BaseService.BaseService;
import edu.nju.service.Exceptions.NotAllConfigurationSetException;
import edu.nju.service.Exceptions.NotLoginException;
import edu.nju.service.InvestAdvisorService.Strategy.InvestStrategy;
import edu.nju.service.POJO.FamilyExpense;
import edu.nju.service.POJO.Identity;
import edu.nju.service.POJO.InvestmentPortFolio;
import edu.nju.service.POJO.Preference;
import edu.nju.vo.FamilySpendingVO;
import edu.nju.vo.IdentityVO;
import edu.nju.vo.TemperPreferVO;
import edu.nju.vo.UserVO;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class InvestAdvisorServiceImpl extends BaseFunctionService implements InvestAdvisorService {

    InvestStrategy investStrategy;

    @Override
    public boolean setIdentity(IdentityVO identity) {
        return false;
    }

    @Override
    public IdentityVO getIdentity() {
        return null;
    }

    @Override
    public boolean setPreference(Preference preference) {
        return false;
    }

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
            BaseDao DAO = getUserService().getUserDao();
            List list = DAO.find("SELECT id FROM Identity identity WHERE identity.id=" + getUserService().getID());
            return !(list == null || list.size() == 0);
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public boolean ifPreferenceIsSet() {
        try {
            BaseDao DAO = getUserService().getUserDao();
            List list = DAO.find("SELECT id FROM Preference preference WHERE preference.id=" + getUserService().getID());
            return !(list == null || list.size() == 0);
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public boolean ifAllSet() {
        try {
            BaseDao DAO = getUserService().getUserDao();
            List list = DAO.find("SELECT id FROM FamilySpending familySpending WHERE familySpending.id=" + getUserService().getID());
            return !(list == null || list.size() == 0);
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public InvestmentPortFolio createInvestmentPortFolio() throws NotAllConfigurationSetException, NotLoginException {
        BaseDao DAO = getUserService().getUserDao();
        Identity identity = (Identity)DAO.find("SELECT id FROM Identity identity WHERE identity.id=" + getUserService().getID()).get(0);
        Preference preference = (Preference)DAO.find("SELECT id FROM Preference preference WHERE preference.id=" + getUserService().getID()).get(0);
        FamilyExpense familyExpense = (FamilyExpense)DAO.find("SELECT id FROM FamilySpending familySpending WHERE familySpending.id=" + getUserService().getID()).get(0);

        return investStrategy.createInvestmentPortfolio(identity, preference, familyExpense);
    }

    @Override
    public UserVO getUserVO() {
        return null;
    }
}
