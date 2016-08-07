package edu.nju.service.PushService;

import edu.nju.service.BaseService.BaseFunctionService;
import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.POJO.PushConfiguration;
import edu.nju.service.POJO.PushContent;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/7/25.
 */
public class PushServiceImpl extends BaseFunctionService implements PushService {

    @Override
    public PushContent updatePushContent(String contentID) {
        return null;
    }

    @Override
    public boolean setPushConfiguration(PushConfiguration pushConfiguration) {
        return false;
    }
}
