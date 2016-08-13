package edu.nju.service.Invoker;

import edu.nju.service.BaseService.BaseService;
import edu.nju.service.Exceptions.DuplicateFunctionNameException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/13.
 */
public class InvokerManagerImpl implements InvokerManager {
    private Map<String, Invoker> invokers;

    public InvokerManagerImpl() {
        invokers = new HashMap<>();
    }

    @Override
    public void addInvoker(String name, BaseService service) throws DuplicateFunctionNameException {
        if (name.equals("wait") || name.equals("notify") || name.equals("notifyAll") || name.equals("equals") ||
                name.equals("hashCode") || name.equals("toString") || name.equals("getClass")) {
            return;
        }

        if (invokers.containsKey(name)) {
            throw new DuplicateFunctionNameException(name);
        }
        else {
            invokers.put(name, new InvokerImpl(name, service));
            System.out.println("Add invoker: " + name);
        }
    }

    @Override
    public Object invokeAPI(String apiName, List<Object> param) {
        return null;
    }

    @Override
    public void loadService(BaseService service, APIFilter apiFilter) throws DuplicateFunctionNameException {
        List<String> apiName = service.getAPIList();

        for (String name : apiName) {
            if (apiFilter == null || apiFilter.isAvailable(name)) {
                addInvoker(name, service);
            }
        }
    }
}
