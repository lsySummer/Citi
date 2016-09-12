package edu.nju.service.Utils;

import org.springframework.util.DigestUtils;

/**
 * Created by Sun YuHao on 2016/9/11.
 */
public class MD5Utils {
    static public String generateMD5(int id, String timestamp, String meta) {
        return DigestUtils.md5DigestAsHex((timestamp + id + meta).getBytes());
    }
}
