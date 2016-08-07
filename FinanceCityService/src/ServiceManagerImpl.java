import AssetManagementService.AssetManagementServiceImpl;
import BaseService.BaseService;
import Exceptions.InvalidAPINameException;
import Exceptions.InvalidServiceNameException;
import InvestAdvisorService.InvestAdvisorServiceImpl;
import PayService.PayServiceImpl;
import PushService.PushServiceImpl;
import SearchService.SearchServiceImpl;
import TradeService.TradeServiceImpl;
import UserService.UserServiceImpl;

import java.util.*;

import static javafx.scene.input.KeyCode.M;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class ServiceManagerImpl implements ServiceManager{
    private String[] serviceNames;
    private BaseService[] services;

    public ServiceManagerImpl() {
        serviceNames = new String[] {
                "AssetManagementService",
                "InvestAdvisorService",
                "PayService",
                "PushService",
                "SearchService",
                "TradeService",
                "UserService"
        };

        services = new BaseService[] {
                new AssetManagementServiceImpl(),
                new InvestAdvisorServiceImpl(),
                new PayServiceImpl(),
                new PushServiceImpl(),
                new SearchServiceImpl(),
                new TradeServiceImpl(),
                new UserServiceImpl()
        };
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
    public Object invokeAPI(String serviceName, String apiName, Map<String, Object> param) throws InvalidServiceNameException, InvalidAPINameException {
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
        try {
            return service.invokeAPI(apiName, param);
        }
        catch (InvalidAPINameException e) {
            throw e;
        }
    }

    @Override
    public Object invokeAPI(String apiName, Map<String, Object> param) throws InvalidAPINameException {
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
