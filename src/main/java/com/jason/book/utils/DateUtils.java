package com.jason.book.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DATE_STYLE = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期转换成String类型的格式
     * @param date
     * @return
     */
    public static String DateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat(DATE_STYLE);
        return format.format(date);
    }
}
