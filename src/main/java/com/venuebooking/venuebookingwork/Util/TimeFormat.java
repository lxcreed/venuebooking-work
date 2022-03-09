package com.venuebooking.venuebookingwork.Util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {

    //yyyy年MM月dd日
    public static String YearMonthDay(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return simpleDateFormat.format(date);

    }

    //yyyy年MM月dd日 HH时mm分
    public static String YearMonthDayHourMin(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        return simpleDateFormat.format(date);
    }

    //yyyy年MM月dd日 HH时mm分ss秒
    public static String YearMonthDayHourMinSec(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return simpleDateFormat.format(date);
    }

    public static String DigitToTime(int digit) {
        digit += 7;
        return digit + ":00";
    }

    public static String DigitToTimePart(int digit) {
        return digit + "小时";
    }

    public static int TimeToDigit(String time) {
        int length = time.length();
        int valid = length - 3;
        String value = time.substring(0, valid);
        int result = Integer.parseInt(value);
        return result;
    }

}
