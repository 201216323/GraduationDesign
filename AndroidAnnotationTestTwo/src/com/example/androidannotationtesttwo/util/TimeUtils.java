
package com.example.androidannotationtesttwo.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.text.format.DateFormat;

public class TimeUtils {
    public static String dateToWeek(int position) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date currentDate = new Date();
        int b = currentDate.getDay();
        Date fdate;
        List<String> list = new ArrayList<String>();
        Long fTime = currentDate.getTime();
        for (int a = 0; a < 7; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            list.add(sdf.format(fdate));
        }
        return list.get(position);
    }

    /**
     * 返回当前时间格式是 2016年04月8日
     * @return
     */
    public static String getCurrentTime() {
        return getFormatDateTime(new Date(), "yyyy年MM月dd日");
    }

    public static String getFormatDateTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        return sdf.format(date);
    }

    public static String getLocalTime(Context context, String time) {
        // 取出年月日来，比较字符串即可
        String str_curTime = DateFormat.format("yyyy-MM-dd", new Date()).toString();
        int result = str_curTime.compareTo(time.substring(0, time.indexOf(" ")));
        if (result > 0) {
            return "昨天"
                    + time.substring(time.indexOf(" "), time.lastIndexOf(":"));
        } else if (result == 0) {
            return "今天"
                    + time.substring(time.indexOf(" "), time.lastIndexOf(":"));
        } else {
            return time;
        }
    }
}
