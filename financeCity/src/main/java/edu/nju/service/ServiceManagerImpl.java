package edu.nju.service;

import edu.nju.service.AssetManagementService.AssetManagementService;
import edu.nju.service.BaseService.BaseFunctionAPIFilter;
import edu.nju.service.BaseService.BaseFunctionService;
import edu.nju.service.BaseService.BaseService;
import edu.nju.service.ExceptionsAndError.DuplicateFunctionNameException;
import edu.nju.service.ExceptionsAndError.InvalidAPINameException;
import edu.nju.service.ExceptionsAndError.InvalidParametersException;
import edu.nju.service.ExceptionsAndError.InvalidServiceNameException;
import edu.nju.service.InvestAdvisorService.InvestAdvisorService;
import edu.nju.service.Invoker.APIFilter;
import edu.nju.service.Invoker.InvokerManager;
import edu.nju.service.PayService.PayService;
import edu.nju.service.PushService.PushService;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.TradeService.TradeService;
import edu.nju.service.UserService.UserService;
import edu.nju.service.UserService.UserServiceAPIFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class ServiceManagerImpl implements ServiceManager {
    private BaseService[] services;
    private List<String> serviceList;
    private Map<String, BaseService> serviceMap;

    @Autowired
    InvokerManager invokerManager;

    @Autowired
    AssetManagementService assetManagementService;
    @Autowired
    InvestAdvisorService investAdvisorService;
    @Autowired
    PayService payService;
    @Autowired
    PushService pushService;
    @Autowired
    SearchService searchService;
    @Autowired
    TradeService tradeService;
    @Autowired
    UserService userService;

    public ServiceManagerImpl() {}

    public ServiceManagerImpl(InvokerManager invokerManager, AssetManagementService assetManagementService,
                              InvestAdvisorService investAdvisorService, PayService payService, PushService pushService,
                              SearchService searchService, TradeService tradeService, UserService userService) {
        /** new vars */
        serviceList = new ArrayList<>();
        serviceMap = new HashMap<>();

        /**
         * init services
         */
        services = new BaseService[] {
                assetManagementService,
                investAdvisorService,
                payService,
                pushService,
                searchService,
                tradeService,
                userService
        };
        try {
            APIFilter BFAPIFilter = new BaseFunctionAPIFilter();
            for (BaseService service : services) {
                System.out.println(service);
                if (service instanceof BaseFunctionService) {
                    ((BaseFunctionService) service).bindUserService(userService);

                    invokerManager.loadService(service, BFAPIFilter);
                }
                else {
                    /** filter user service's APIs */
                    invokerManager.loadService(service, new UserServiceAPIFilter());
                }

                /** build service list */
                serviceList.add(service.getName());
                /** build service map */
                serviceMap.put(service.getName(), service);
            }

            /** bind search service to invest advisor */
            investAdvisorService.bindSearchService(searchService);

            System.out.println("Service Manager Init Successfully");
        }
        catch (DuplicateFunctionNameException d) {
            d.printStackTrace();
        }
    }

    @Override
    public List<String> getServiceList() {
        return serviceList;
    }

    @Override
    public List<String> getAPIList(String serviceName) throws InvalidServiceNameException {
        BaseService service = getService(serviceName);

        if (service != null) {
            return service.getAPIList();
        }
        else {
            throw new InvalidServiceNameException(serviceName);
        }
    }

    /**
     * @param apiName .
     * @param param .
     * @return .
     * @throws InvalidAPINameException .
     */
    @Override
    public Object invokeAPI(String apiName, List<Object> param) throws InvalidAPINameException, InvalidParametersException {
        return invokerManager.invokeAPI(apiName, param);
    }

    private BaseService getService(String serviceName) throws InvalidServiceNameException {
        return serviceMap.get(serviceName);
    }
}
