package BaseService;

import Exceptions.InvalidAPINameException;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public interface BaseService {
    /**
     * invoke this service's api by name and param object
     */
    Object invokeAPI(String apiName, Map<String, Object> param) throws InvalidAPINameException;

    /**
     * get API list
     */
    List<String> getAPIList();
}
