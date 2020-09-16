package com.yidu.fund.utils;

import java.util.UUID;

/**
 * 自动生成主键的工具类
 * @author wx
 * @since 2020/09/06
 */
public class UUIDUtils {

    /**
     * 获取主键的生成
     * @return 主键
     */
    public static String getUUID() {
        //调用生成随机键的工具类获取 随机生成的工具类
        String uuid = UUID.randomUUID().toString();
        //将获取的随机数进行字符串的替换，将"-"替换掉，然后截取18位
        uuid = uuid.replace("-", "").substring(0, 16);
        return uuid;
    }

}
