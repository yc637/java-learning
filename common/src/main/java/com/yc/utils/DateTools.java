package com.yc.utils;

import org.apache.commons.lang3.time.FastDateFormat;
import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;

public class DateTools {


    public static void main(String[] args) throws Exception {
        Date date = new Date();
        DateTime dateTime = new DateTime(2020,3,3,17,52,33,123);
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


        Calendar calc = Calendar.getInstance();
        calc.add(Calendar.DAY_OF_MONTH, -30);
        System.out.println(calc.getTime());
        System.out.println(calc.getTimeInMillis() > dateTime.toDate().getTime());

        Date bizDate = getBusinessBeginTime(new Date(), "15:00", "19:58");
        System.out.println(bizDate);

        System.out.println(new DateTime((Object) null));


    }

    public static Date getBusinessBeginTime(Date currentTime, String bizStartTime, String bizEndTime){
        if ("00:00".equals(bizEndTime)) {
            bizEndTime = "24:00";
        }
        DateTime currentDateTime = new DateTime(currentTime);

        int currMinutes = currentDateTime.getHourOfDay() * 60 + currentDateTime.getMinuteOfHour();
        int startMinutes = time2Minutes(bizStartTime);
        int endMinutes = time2Minutes(bizEndTime);

        DateTime bizBeginTime = null;
        if (currMinutes <= endMinutes) {
            bizBeginTime = currentDateTime.withTime(0,0,0,0).plusMinutes(startMinutes);
        } else {
            bizBeginTime = currentDateTime.withTime(0,0,0,0).plusDays(1).plusMinutes(startMinutes);
        }

        return bizBeginTime.toDate();
    }

    public static int time2Minutes(String time) {
        String[] timeInfo = time.split(":");
        int hour = Integer.parseInt(timeInfo[0]);
        int minute = Integer.parseInt(timeInfo[1]);
        return hour * 60 + minute;
    }
}
