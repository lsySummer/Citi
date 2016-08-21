package edu.nju.service.BaseService;

import edu.nju.service.Invoker.APIFilter;
import org.springframework.stereotype.Service;

/**
 * Created by Sun YuHao on 2016/8/13.
 */
@Service
public class BaseFunctionAPIFilter implements APIFilter {
    @Override
    public boolean isAvailable(String apiName) {
        if (apiName.equals("bindUserService") || apiName.equals("invokeAPI") || apiName.equals("getAPIList")) {
            return false;
        }
        else {
            return true;
        }
    }
}
