package PushService;

import Exceptions.InvalidAPINameException;
import POJO.PushConfiguration;
import POJO.PushContent;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/7/25.
 */
public class PushServiceImpl implements PushService {
    @Override
    public Object invokeAPI(String api, Map<String, Object> param) throws InvalidAPINameException {
        return null;
    }

    @Override
    public PushContent updatePushContent(int contentID) {
        return null;
    }

    @Override
    public boolean setPushConfiguration(PushConfiguration pushConfiguration) {
        return false;
    }

    @Override
    public List<String> getAPIList() {
        return null;
    }
}
