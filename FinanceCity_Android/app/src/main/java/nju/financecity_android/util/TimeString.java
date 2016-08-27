package nju.financecity_android.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by coral on 16-8-26.
 */
public class TimeString {

    public static String getTimeByDate(Calendar calendar) {
        Date date = calendar.getTime();
        return getTimeByDate(date);
    }

    public static String getTimeByDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
