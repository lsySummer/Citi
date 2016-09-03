package edu.nju.service.Utils;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/28.
 */
public class TimeTransformation {
    static private final int seconde = 1000;
    static private final int minute = seconde * 60;
    static private final int hour = minute * 60;
    static private final int day = hour * 24;
    static private final int month = day * 30;
    static private final int year = day * 365;

    static public double getTimeFromNow(Timestamp timestamp, char type) {
        int castType;
        switch (type) {
            case 's':case 'S':castType = seconde; break;
            case 'm':castType = minute; break;
            case 'h':case 'H':castType = hour; break;
            case 'd':case 'D':castType = day; break;
            case 'M':castType = month; break;
            case 'y':case 'Y': castType = year; break;
            default:castType = day;
        }

        return ((double)timestamp.getTime() - System.currentTimeMillis()) / castType;
    }

    static public double getTimeFromNow(Date date, char type) {
        String time = date.toString() + " 00:00:00";
        Timestamp timestamp = Timestamp.valueOf(time);

        return getTimeFromNow(timestamp, type);
    }
}
