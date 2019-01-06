package com.example.rathana.adapter_demo.util;

import java.util.Calendar;
import java.util.Date;

public class CurrentDateTimeHelper {

     public static Date getCurrentDate(){
        return Calendar.getInstance().getTime();
    }
}
