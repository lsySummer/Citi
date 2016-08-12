package edu.nju.service;

import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.Exceptions.InvalidServiceNameException;
import edu.nju.service.Exceptions.NotLoginException;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.service.POJO.UserInfo;

import java.util.List;
import java.util.Map;

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
     * invoke API by service name and API name and param
     * @return return Object
     */
    Object invokeAPI(String serviceName, String apiName, List<Object> param) throws InvalidServiceNameException, InvalidAPINameException;

    /**
     * invoke API just by API name and param.
     * @return return Object
     * Note: use the first api found in services
     */
    Object invokeAPI(String apiName, List<Object> param) throws InvalidAPINameException;

    /** User service APIS*/
    Long register(RegisterInfo regInfo);
    Long login(String userName, String password);
    boolean logout();
    boolean isLogin();
    boolean modifyUserInfo(UserInfo userInfo);
    Long getID() throws NotLoginException;
}
