package com.yc.utils;

import org.apache.commons.lang3.time.FastDateFormat;
import org.joda.time.DateTime;

import java.util.Date;

public class DateTools {


    public static void main(String[] args) throws Exception {
        Date date = new Date();
        DateTime dateTime = new DateTime(2020,2,20,13,12,33,123);
        DateTime dateTime2 = new DateTime(2020,2,20,0,0,0,0);
//        DateTime tmpBatchStartTime = dateTime.withTime(dateTime.getHourOfDay(),0,0,0);
//        dateTime = dateTime.withSecondOfMinute(0).withMillisOfSecond(0);
////        System.out.println(dateTime);
        int curTimeMinutes = dateTime.getHourOfDay() * 60 + dateTime.getMinuteOfHour();
        System.out.println(dateTime.getHourOfDay());
        System.out.println(dateTime.getMinuteOfHour());
        System.out.println(curTimeMinutes);
        System.out.println(dateTime.withTime(0,0,0,0));

        DateTime codDateTime = new DateTime(date);
        System.out.println(codDateTime);

        DateTime dateTime3 = new DateTime(dateTime2).withTime(0,0,0,0);
        System.out.println(dateTime2 == dateTime3);

        date = dateTime2.toDate();
        System.out.println(date.getTime());
        System.out.println(dateTime2.getMillis());
        System.out.println(new DateTime("2019-12-12").toDate());
        System.out.println(new DateTime("2019-12-12T13:14:59").toDate());

        DateTime currentDate = new DateTime(new Date()).withTime(0,0,0,0);
        System.out.println(dateTime2.isEqual(currentDate));
        System.out.println(dateTime.toString("HH:mm"));

        FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");
        FastDateFormat DATE_FORMAT2 = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        System.out.println(DATE_FORMAT.parse("2019-12-14"));
        System.out.println(DATE_FORMAT.parse("2019-12-14 23:58:59"));


    }
}
