/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Dell
 */
public class DateConverter {

    public java.sql.Date currentDateToSat(java.sql.Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, Calendar.DAY_OF_WEEK-dayOfWeek);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date2 = java.sql.Date.valueOf(formatter.format(cal.getTime()));
        return date2;
    }
    public java.sql.Date sunToCurrentDate(java.sql.Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, -(dayOfWeek)+1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date2 = java.sql.Date.valueOf(formatter.format(cal.getTime()));
        return date2;
    }
//    public static void main(String[] args) {
//        DateConverter dc = new DateConverter();
//        String date = "2022-12-4";
//        Date from = dc.sunToCurrentDate(java.sql.Date.valueOf(date));
//        Date to = dc.currentDateToSat(java.sql.Date.valueOf(date));
//        System.out.println(from);
//        System.out.println(to);
//    }
}
