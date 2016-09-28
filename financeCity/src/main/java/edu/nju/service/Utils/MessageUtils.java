package edu.nju.service.Utils;

import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/9/28.
 */
public class MessageUtils {
    static private final String AppKey = "d106eaa6d21b99b46f04da73a5d9788e";
    static private final String AppSecret = "6c10b9088b38";
    static private final String Nonce = "investgogroup";
    static private final String CurTime = "1443592222";

    static private boolean getCheckCode(String mobile, String appKey, String appSecret, String nonce, String curTime) {
        try {
            URL url = new URL("https://api.netease.im/sms/sendcode.action");
            URLConnection connection = url.openConnection();

            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            connection.setRequestProperty("AppKey", appKey);
            connection.setRequestProperty("Nonce", nonce);
            connection.setRequestProperty("CurTime", curTime);
            connection.setRequestProperty("CheckSum", CheckSumBuilder.getCheckSum(appSecret, nonce, curTime));

            connection.setDoOutput(true);
            connection.setDoInput(true);

            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print("mobile=" + mobile);
            out.flush();

            Map map = new JsonUtil(connection.getInputStream()).getMap();
            System.out.print(map);

            Integer retCode = (Integer)map.get("code");
            if (retCode == 200) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static private boolean verifyCode(String mobile, String code, String appKey, String appSecret, String nonce, String curTime) {
        try {
            URL url = new URL("https://api.netease.im/sms/verifycode.action");
            URLConnection connection = url.openConnection();

            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            connection.setRequestProperty("AppKey", appKey);
            connection.setRequestProperty("Nonce", nonce);
            connection.setRequestProperty("CurTime", curTime);
            connection.setRequestProperty("CheckSum", CheckSumBuilder.getCheckSum(appSecret, nonce, curTime));

            connection.setDoOutput(true);
            connection.setDoInput(true);

            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print("mobile=" + mobile + "&code=" + code);
            out.flush();

            Map map = new JsonUtil(connection.getInputStream()).getMap();
            System.out.print(map);

            Integer retCode = (Integer)map.get("code");
            if (retCode == 200) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    static public boolean getCheckCode(String phone) {
        return getCheckCode(phone, AppKey, AppSecret, Nonce, CurTime);
    }

    static public boolean verifyCheckCode(String phone, String code) {
        return verifyCode(phone, code, AppKey, AppSecret, Nonce, CurTime);
    }


    static private class CheckSumBuilder {
        // 计算并获取CheckSum
        public static String getCheckSum(String appSecret, String nonce, String curTime) {
            return encode("sha1", appSecret + nonce + curTime);
        }

        // 计算并获取md5值
        public static String getMD5(String requestBody) {
            return encode("md5", requestBody);
        }

        private static String encode(String algorithm, String value) {
            if (value == null) {
                return null;
            }
            try {
                MessageDigest messageDigest
                        = MessageDigest.getInstance(algorithm);
                messageDigest.update(value.getBytes());
                return getFormattedText(messageDigest.digest());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        private static String getFormattedText(byte[] bytes) {
            int len = bytes.length;
            StringBuilder buf = new StringBuilder(len * 2);
            for (int j = 0; j < len; j++) {
                buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
                buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
            }
            return buf.toString();
        }
        private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
                '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }

    static public void main(String[] args) {
        //getCheckCode("18061791527");
        //System.out.print(verifyCheckCode("18061791527", "6837"));
    }
}
