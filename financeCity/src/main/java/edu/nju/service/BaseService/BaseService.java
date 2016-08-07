package edu.nju.service.BaseService;

import edu.nju.service.Exceptions.InvalidAPINameException;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public interface BaseService {
    /**
     * invoke this service's api by name and param object
     */
    Object invokeAPI(String apiName, List<Object> param) throws InvalidAPINameException;

    /**
     * get API list
     */
    List<String> getAPIList();
}
