package edu.nju.service;

import edu.nju.service.AssetManagementService.AssetManagementServiceImpl;
import edu.nju.service.BaseService.BaseFunctionService;
import edu.nju.service.BaseService.BaseService;
import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.Exceptions.InvalidServiceNameException;
import edu.nju.service.Exceptions.NotLoginException;
import edu.nju.service.InvestAdvisorService.InvestAdvisorServiceImpl;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.service.POJO.UserInfo;
import edu.nju.service.PushService.PushServiceImpl;
import edu.nju.service.SearchService.SearchServiceImpl;
import edu.nju.service.TradeService.TradeServiceImpl;
import edu.nju.service.UserService.UserService;
import edu.nju.service.UserService.UserServiceImpl;
import edu.nju.service.PayService.PayServiceImpl;

import java.util.*;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class ServiceManagerImpl implements ServiceManager {
    private String[] serviceNames;
    private BaseFunctionService[] services;
    private UserService userState;

    public ServiceManagerImpl() {
        /**
         * create user state
         */
        userState = new UserServiceImpl();

        /**
         * init function services
         */
        serviceNames = new String[] {
                "AssetManagementService",
                "InvestAdvisorService",
                "PayService",
                "PushService",
                "SearchService",
                "TradeService"
        };
        services = new BaseFunctionService[] {
                new AssetManagementServiceImpl(),
                new InvestAdvisorServiceImpl(),
                new PayServiceImpl(),
                new PushServiceImpl(),
                new SearchServiceImpl(),
                new TradeServiceImpl()
        };
        for (BaseFunctionService service : services) {
            service.bindUserService(userState);
        }
    }

    @Override
    public List<String> getServiceList() {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, serviceNames);

        return list;
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

    @Override
    public Object invokeAPI(String serviceName, String apiName, List<Object> param) throws InvalidServiceNameException, InvalidAPINameException {
        BaseService service = getService(serviceName);

        /**
         * if service name is invalid
         */
        if (service == null) {
            throw new InvalidServiceNameException(serviceName);
        }

        /**
         * invoke api
         */
        return service.invokeAPI(apiName, param);
    }

    /**
     * TODO:Load Methods To Run Faster/Check Methods
     * TODO:Combine filter and this
     * @param apiName .
     * @param param .
     * @return .
     * @throws InvalidAPINameException
     */
    @Override
    public Object invokeAPI(String apiName, List<Object> param) throws InvalidAPINameException {
        for (int i = 0; i < services.length; ++i) {
            BaseService service = services[i];

            List APIList = service.getAPIList();
            for (int j = 0; j < APIList.size(); ++j) {
                if (APIList.get(j).equals(apiName)) {
                    return service.invokeAPI(apiName, param);
                }
            }
        }

        throw new InvalidAPINameException(apiName);
    }

    @Override
    public Long register(RegisterInfo regInfo) {
        return userState.register(regInfo);
    }

    @Override
    public Long login(String userName, String password) {
        return userState.login(userName, password);
    }

    @Override
    public boolean logout() {
        return userState.logout();
    }

    @Override
    public boolean isLogin() {
        return userState.isLogin();
    }

    @Override
    public boolean modifyUserInfo(UserInfo userInfo) {
        return userState.modifyUserInfo(userInfo);
    }

    @Override
    public Long getID() throws NotLoginException {
        return userState.getID();
    }

    private BaseService getService(String serviceName) throws InvalidServiceNameException {
        /**
         * find service
         */
        for (int i = 0; i < serviceNames.length; ++i) {
            if (serviceName.equals(serviceNames[i])) {
                return services[i];
            }
        }

        /**
         * service not found
         */
        return null;
    }
}
