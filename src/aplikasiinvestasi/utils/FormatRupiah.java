/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.utils;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 *
 * @author Rizaldi Habibie
 */
public class FormatRupiah {
    private static String belakang, format, nominal;
    private static DecimalFormat df =new DecimalFormat("0.00");;

    public static String convert(String number){
        try{
            String formate = df.format(Double.valueOf(number)); 
            double finalValue = Double.parseDouble(""+df.parse(formate));
            nominal = String.format("%.2f", finalValue);
            nominal = nominal.replace(",", ".");
            String[] separate = nominal.split("\\.");
            if(separate.length>1){
                belakang = ","+separate[1];
            }else{
                belakang =", 00";
            }
            format = separate[0];
            String satuan = "Rp. ";
            if(number.length()== 1){
                format = "Rp. "+format+""+belakang;
            }else if(format.length()== 2){
                format = "Rp. "+format+""+belakang;
            }else if(format.length()== 3){
                format = "Rp. "+format+""+belakang;
            }else if(format.length()== 4){
                format = "Rp. "+format.substring(0,1)+"."+format.substring(1,format.length())+""+belakang;
            }else if(format.length()== 5){
                format = "Rp. "+format.substring(0,2)+"."+format.substring(2,format.length())+""+belakang;
            }else if(format.length()==6){
                format= "Rp. "+format.substring(0,3)+"."+format.substring(3,format.length())+""+belakang;
            }else if(format.length()==7){
                format = "Rp. "+format.substring(0,1)+"."+format.substring(1,4)+"."+format.substring(4,format.length())+""+belakang;
            }else if(format.length()==8){
                format = "Rp. "+format.substring(0,2)+"."+format.substring(2,5)+"."+format.substring(5,format.length())+""+belakang;
            }else if(format.length()==9){
                format = "Rp. "+format.substring(0,3)+"."+format.substring(3,6)+"."+format.substring(6,format.length())+""+belakang;
            }else if(format.length()==10){
                format = "Rp. "+format.substring(0,1)+"."+format.substring(1,4)+"."+format.substring(4,7)+"."+format.substring(7,format.length())+""+belakang;
            }else if(format.length()==11){
                format = "Rp. "+format.substring(0,2)+"."+format.substring(2,5)+"."+format.substring(5,8)+"."+format.substring(8,format.length())+""+belakang;
            }else if(format.length()==12){
                format = "Rp. "+format.substring(0,3)+"."+format.substring(3,6)+"."+format.substring(6,9)+"."+format.substring(9,format.length())+""+belakang;
            }
        }catch(ParseException | NumberFormatException e){
            e.printStackTrace();
        }
        return format;
    }
    
    public static String convertFromRupiah(String rupiah){
        String number = null;
        int length = rupiah.length();
        number = rupiah.substring(0,length-3);
        System.out.println(number);
        number = number.substring(3);
        System.out.println(number);
        number = number.replace(".", "");
        System.out.println(number);
        return number;
    }
    
}
