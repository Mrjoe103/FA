package com.yidu.fund.utils;

import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 类的描述：
 *
 * @author 刘顺华
 * @version 1.0
 * since 2020/09/01
 */
public class Md5Util {
    public static String encodeByMd5(String string){
        String encode = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            BASE64Encoder encoder = new BASE64Encoder();
            encode = encoder.encode(md5.digest(string.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert encode != null;
        return encode.substring(0,20);
    }

    public static boolean checkPassword(String newStr,String oldStr){
        return encodeByMd5(newStr).equals(oldStr);
    }
}
