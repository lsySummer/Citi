package edu.nju.service.InvestAdvisorService;

import edu.nju.service.BaseService.BaseFunctionService;
import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.Exceptions.NotAllConfigurationSetException;
import edu.nju.service.POJO.InvestmentPortFolio;
import edu.nju.service.POJO.Preference;
import edu.nju.vo.FamilySpendingVO;
import edu.nju.vo.IdentityVO;
import edu.nju.vo.TemperPreferVO;
import edu.nju.vo.UserVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class InvestAdvisorServiceImpl extends BaseFunctionService implements InvestAdvisorService {
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
        return false;
    }

    @Override
    public boolean ifPreferenceIsSet() {
        return false;
    }

    @Override
    public boolean ifAllSet() {
        return false;
    }

    @Override
    public InvestmentPortFolio createInvestmentPortFolio() throws NotAllConfigurationSetException {
        return null;
    }

    @Override
    public UserVO getUserVO(String id) {
        return null;
    }
}
