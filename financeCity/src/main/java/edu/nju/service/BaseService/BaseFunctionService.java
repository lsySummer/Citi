package edu.nju.service.BaseService;

import edu.nju.service.UserService.UserService;

/**
 * Created by Sun YuHao on 2016/8/13.
 */
public interface BaseFunctionService extends BaseService {
    void bindUserService(UserService userService);
}
