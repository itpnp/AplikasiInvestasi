/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

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
}
