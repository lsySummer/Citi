package edu.nju.service.UserService;

import edu.nju.service.Invoker.APIFilter;

/**
 * Created by Sun YuHao on 2016/8/13.
 */
public class UserServiceAPIFilter implements APIFilter {
    private String[] availableAPI;

    public UserServiceAPIFilter() {
        availableAPI = new String[] {
                "register",
                "login",
                "logout",
                "isLogin",
                "modifyUserInfo",
                "getID"
        };
    }

    @Override
    public boolean isAvailable(String apiName) {
        for (String availableAPIName : availableAPI) {
            if (apiName.equals(availableAPIName)) {
                return true;
            }
        }

        return false;
    }
}
