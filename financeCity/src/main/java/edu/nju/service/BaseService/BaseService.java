package edu.nju.service.BaseService;

import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.Exceptions.InvalidParametersException;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface BaseService {
    /**
     * invoke this service's api by name and param object
     */
    Object invokeAPI(String apiName, List<Object> param) throws InvalidAPINameException, InvalidParametersException;

    /**
     * get API list
     */
    List<String> getAPIList();

    /**
     * get service name
     * @return name
     */
    String getName();
}
