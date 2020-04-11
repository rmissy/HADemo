package com.rmissy.utils;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Gin
 * @since 2019/3/20 10:52
 */
public class DateUtils {
    private static final ThreadLocal<DateFormat> DATE_FORMATTER = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    private static final ThreadLocal<DateFormat> TIME_FORMATTER = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    private static final ThreadLocal<DateFormat> ONLY_TIME_FORMATTER = ThreadLocal.withInitial(() -> new SimpleDateFormat("HH:mm:ss"));

    private static final long ONE_DAY = 1000 * 3600 * 24;
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";


    public static String dateFormat(Long time){
        if(time == null || time == 0){
            return "";
        }
        return TIME_FORMATTER.get().format(time);
    }

    public static String dateFormatByDay(Long time){
        if(time == null || time == 0){
            return "";
        }
        return DATE_FORMATTER.get().format(time);
    }

    public static String dateFormatByOnlyTime(Long time){
        if(time == null || time == 0){
            return "";
        }
        return ONLY_TIME_FORMATTER.get().format(time);
    }

    public static long dateFormat(String date){
        if(StringUtils.isEmpty(date)){
            return 0;
        }

        try {
            return DATE_FORMATTER.get().parse(date).getTime();
        } catch (ParseException e) {
           throw new RuntimeException(e);
        }
    }

    public static String dateFormat(Long time, String pattern){
        if(time == null || time == 0){
            return "";
        }
        return new SimpleDateFormat(pattern).format(time);
    }

    public static long dateFormat(String date, String pattern){
        try {
            return new SimpleDateFormat(pattern).parse(date).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 对于查询条件 结束日期的计算
     * 结束日期转换为ms时，要加上一天的ms
     *
     * @param date 结束日期
     * @return
     */
    public static long endDateFormat(String date){
        return dateFormat(date) + ONE_DAY;
    }

    public static String endDateFormat(long date){
        return dateFormat(date + ONE_DAY);
    }

    public static long endDateFormat(String date, String pattern){
        return dateFormat(date, pattern) + ONE_DAY;
    }
}
