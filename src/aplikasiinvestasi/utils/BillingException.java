/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.utils;

/**
 *
 * @author Rizaldi Habibie
 */
public class BillingException {
    private static String[] listException;
    
    public static String[] getListException(){
        listException = new String[7];
        listException[0] = "1173.99";
        
        return listException;
    }
}
