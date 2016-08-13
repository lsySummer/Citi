package edu.nju.service.PushService;

import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.POJO.PushConfiguration;
import edu.nju.service.POJO.PushContent;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class PushServiceImpl extends BaseFunctionServiceAdaptor implements PushService {

    @Override
    public PushContent updatePushContent(Long contentID) {
        return null;
    }

    @Override
    public boolean setPushConfiguration(PushConfiguration pushConfiguration) {
        return false;
    }
}
