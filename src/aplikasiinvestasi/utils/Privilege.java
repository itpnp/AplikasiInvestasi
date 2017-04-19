/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.utils;

/**
 *
 * @author Rizaldi Habibie
 */
public class Privilege {
    private static String[] priv;
    
    public static String[] hakAkses(){
        priv = new String[4];
        priv[0] = "- Pilih Hak Akses -";
        priv[1] = "KABAG";
        priv[2] = "LPB";
        priv[3] = "BSKK";
        
        return priv;
    }
}
