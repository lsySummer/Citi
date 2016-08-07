package edu.nju.service.PushService;

import edu.nju.service.BaseService.BaseService;
import edu.nju.service.POJO.PushConfiguration;
import edu.nju.service.POJO.PushContent;

/**
 * Created by dell on 2016/7/25.
 */
public interface PushService extends BaseService {
    /**
     * update push content if content id is smaller than the latest, else return null
     * @param contentID .
     * @return push content
     */
    PushContent updatePushContent(String contentID);

    /**
     * set push configuration
     * @param pushConfiguration .
     * @return if success
     */
    boolean setPushConfiguration(PushConfiguration pushConfiguration);
}
