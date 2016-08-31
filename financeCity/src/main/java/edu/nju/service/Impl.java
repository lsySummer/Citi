package edu.nju.service;

import edu.nju.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sun YuHao on 2016/8/28.
 */
public class Impl implements TestService {
    @Autowired
    ServiceManager serviceManager;

    @Override
    public String test(String text) {
        return null;
    }
}
