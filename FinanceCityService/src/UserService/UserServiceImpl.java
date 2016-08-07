package UserService;

import Exceptions.InvalidAPINameException;

import java.util.Map;

/**
 * Created by dell on 2016/7/25.
 */
public class UserServiceImpl implements UserService {
    @Override
    public Object invokeAPI(String api, Map<String, Object> param) throws InvalidAPINameException {
        return null;
    }

    @Override
    public String[] getAPIList() {
        return new String[0];
    }
}
