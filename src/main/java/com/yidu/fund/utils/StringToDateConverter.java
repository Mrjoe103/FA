package com.yidu.fund.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类的描述：
 *
 * @author 刘顺华
 * @version 1.0
 * since 2020/08/24
 */
public class StringToDateConverter implements Converter<String,Date> {
    private String[] datePatterns = {"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd","yyyy/MM/dd","yyyy年MM月dd日","yyyy.MM.dd"};

    @Override
    public Date convert(String s) {
        Date date = null;
        for (String datePattern:datePatterns){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
            try {
                date = simpleDateFormat.parse(s);
                return date;
            } catch (ParseException e) {
                continue;
            }
        }
        return date;
    }
}
