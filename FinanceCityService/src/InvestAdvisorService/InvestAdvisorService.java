package InvestAdvisorService;

import BaseService.BaseService;
import Exceptions.NotAllConfigurationSetException;
import POJO.FamilyExpense;
import POJO.Identity;
import POJO.InvestmentPortFolio;
import POJO.Preference;


/**
 * Created by dell on 2016/7/25.
 */
public interface InvestAdvisorService extends BaseService {
    /**
     * set identity
     *
     * @return if it's successful
     */
    boolean setIdentity(Identity identity);

    /**
     * set preference
     *
     * @param preference .
     * @return if it's successful
     */
    boolean setPreference(Preference preference);

    /**
     * set family expense
     *
     * @param familyExpense .
     * @return if it's successful
     */
    boolean setFamilyExpense(FamilyExpense familyExpense);

    /**
     * if identity is set, if yes return true, else return false
     *
     * @return if identity is set
     */
    boolean ifIdentityIsSet();

    /**
     * if Preference is set, if yes return true, else return false
     *
     * @return is preference is set
     */
    boolean ifPreferenceIsSet();

    /**
     * if all configuration is set
     *
     * @return if all configuration is set
     */
    boolean ifAllSet();

    /**
     * get investment portfolio
     * @return investment portfolio
     */
    InvestmentPortFolio createInvestmentPortFolio() throws NotAllConfigurationSetException;
}
