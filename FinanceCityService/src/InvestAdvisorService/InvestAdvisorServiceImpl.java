package InvestAdvisorService;

import Exceptions.InvalidAPINameException;
import Exceptions.NotAllConfigurationSetException;
import POJO.FamilyExpense;
import POJO.Identity;
import POJO.InvestmentPortFolio;
import POJO.Preference;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/7/25.
 */
public class InvestAdvisorServiceImpl implements InvestAdvisorService {
    @Override
    public boolean setIdentity(Identity identity) {
        return false;
    }

    @Override
    public boolean setPreference(Preference preference) {
        return false;
    }

    @Override
    public boolean setFamilyExpense(FamilyExpense familyExpense) {
        return false;
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
    public Object invokeAPI(String apiName, Map<String, Object> param) throws InvalidAPINameException {
        return null;
    }

    @Override
    public List<String> getAPIList() {
        return null;
    }
}
