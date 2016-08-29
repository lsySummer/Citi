package edu.nju.service.BaseService;

import edu.nju.service.UserService.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by Sun YuHao on 2016/8/7.
 */
@Service
public class BaseFunctionServiceAdaptor extends BaseServiceAdaptor implements BaseFunctionService {
    protected UserService userService;

    @Override
    public void bindUserService(UserService userService) {
        this.userService = userService;
    }

    protected UserService getUserService() {
        return userService;
    }
}
