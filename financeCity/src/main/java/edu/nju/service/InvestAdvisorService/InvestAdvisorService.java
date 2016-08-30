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
     * set preference
     *
     * @param temperPreferVO preference .
     * @return if it's successful
     */
    boolean setTemperPrefer(TemperPreferVO temperPreferVO) throws NotLoginException;

    /**
     * get temper preference
     * @return temper preference
     */
    TemperPreferVO getTemperPreferVO() throws NotLoginException;

    /**
     * create investment portfolio
     * @param preference
     * @return invest result
     * @throws NotAllConfigurationSetException
     */
    InvestResult createInvestmentPortFolio(UserTemperPrefer preference) throws NotAllConfigurationSetException;

    /**
     * bind search service
     * @param searchService .
     */
    void bindSearchService(SearchService searchService);
}
