package com.qianjin.java.soa.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {

    public static void main(String[] args) {
        final String TWITTER = "EEE MMM dd HH:mm:ss zzz yyyy";
        String createDateTime="Mon Aug 21 16:20:30 ADT 2017";
        SimpleDateFormat dt = new SimpleDateFormat(TWITTER);
        Date date;
        try {
            date = dt.parse(createDateTime);
            SimpleDateFormat dt1  = new SimpleDateFormat("yyyyMMddHHmmss");
            String finalDateTime=dt1.format(date);
            System.out.println(finalDateTime);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
