/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Rizaldi Habibie
 */
public class FormatDate {
    
    public static String convert(Date date){
        String formatedDate = null;
        java.text.DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        formatedDate= dateFormat.format(date);
        return formatedDate;
    }
    
    public static int totalDays(int month, int year){
        Calendar monthStart = new GregorianCalendar(year, month, 1);
        return monthStart.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    public static String convertNumber(Date date){
        String formatedDate = null;
        java.text.DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        formatedDate= dateFormat.format(date);
        return formatedDate;
    }
}
