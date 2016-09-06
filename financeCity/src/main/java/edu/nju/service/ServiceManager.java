package edu.nju.service;

import edu.nju.service.AssetManagementService.AssetManagementService;
import edu.nju.service.BaseService.BaseService;
import edu.nju.service.ExceptionsAndError.InvalidAPINameException;
import edu.nju.service.ExceptionsAndError.InvalidParametersException;
import edu.nju.service.ExceptionsAndError.InvalidServiceNameException;
import edu.nju.service.InvestAdvisorService.InvestAdvisorService;
import edu.nju.service.PayService.PayService;
import edu.nju.service.PushService.PushService;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.TradeService.TradeService;
import edu.nju.service.UserService.UserService;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public interface ServiceManager {
    /**
     * get service list
     * @return services' names
     */
    List<String> getServiceList();

    /**
     * get service's API list
     * @return API's name
     */
    List<String> getAPIList(String serviceName) throws InvalidServiceNameException;

    /**
     * invoke API just by API name and param.
     * @return return Object
     * Note: use the first api found in services
     */
    Object invokeAPI(String apiName, List<Object> param) throws InvalidAPINameException, InvalidParametersException;

    public AssetManagementService getAssetManagementService();

    public InvestAdvisorService getInvestAdvisorService();

    public PayService getPayService();

    public PushService getPushService();

    public SearchService getSearchService();

    public TradeService getTradeService();

    public UserService getUserService();
}
