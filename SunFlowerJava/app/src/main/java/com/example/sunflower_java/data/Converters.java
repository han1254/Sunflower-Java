package com.example.sunflower_java.data;

import java.util.Calendar;

import androidx.room.TypeConverter;

/**
 * Time:2020/1/16 19:51
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class Converters {

    @TypeConverter
    public Long calendarToDatastamp(Calendar calendar) {
        return calendar.getTimeInMillis();
    }

    @TypeConverter
    public Calendar datestampToCalendar(long value) {
       Calendar calendar = Calendar.getInstance();
       calendar.setTimeInMillis(value);
       return calendar;
    }

}
