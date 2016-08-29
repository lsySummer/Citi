package edu.nju.service.InvestAdvisorService;

import edu.nju.model.UserTemperPrefer;
import edu.nju.service.BaseService.BaseService;
import edu.nju.service.ExceptionsAndError.NotAllConfigurationSetException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.SearchService.SearchService;
import edu.nju.vo.FamilySpendingVO;
import edu.nju.vo.IdentityVO;
import edu.nju.vo.TemperPreferVO;
import edu.nju.vo.UserVO;
import org.springframework.stereotype.Service;


/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface InvestAdvisorService extends BaseService {
    /**
     * set identity
     *
     * @return if it's successful
     */
    boolean setIdentity(IdentityVO identity);

    /**
     * get identity
     * @return identity
     */
    IdentityVO getIdentity();

    /**
     * set preference
     *
     * @param temperPreferVO preference .
     * @return if it's successful
     */
    boolean setTemperPrefer(TemperPreferVO temperPreferVO);

    /**
     * get temper preference
     * @return temper preference
     */
    TemperPreferVO getTemperPreferVO();

    /**
     * set family spending
     *
     * @param familySpending .
     * @return if it's successful
     */
    boolean setFamilySpending(FamilySpendingVO familySpending);

    /**
     * get family spending
     *
     * @return family spending
     */
    FamilySpendingVO getFamilySpendingVO();

    /**
     * if identity is set, if yes return true, else return false
     *
     * @return if identity is set
     */
    boolean ifIdentityIsSet();

    /**
     * if prefer is set, if yes return true, else return false
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
    InvestResult createInvestmentPortFolio() throws NotAllConfigurationSetException, NotLoginException;

    InvestResult createInvestmentPortFolio(UserTemperPrefer preference) throws NotAllConfigurationSetException;

    /**
     * get user vo
     * @return user vo
     */
    UserVO getUserVO();

    /**
     * bind search service
     * @param searchService .
     */
    void bindSearchService(SearchService searchService);
}
