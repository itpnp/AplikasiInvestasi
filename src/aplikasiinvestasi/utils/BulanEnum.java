/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.utils;

/**
 *
 * @author Rizaldi Habibie
 */
public class BulanEnum {
    private static String[] daftarBulan, tahun;
    public static String[] namaBulan(){
        daftarBulan = new String[13];
        daftarBulan[0] = "--- Pilih Bulan ---";
        daftarBulan[1] = "Januari";
        daftarBulan[2] = "Februari";
        daftarBulan[3] = "Maret";
        daftarBulan[4] = "April";
        daftarBulan[5] = "Mei";
        daftarBulan[6] = "Juni";
        daftarBulan[7] = "Juli";
        daftarBulan[8] = "Agustus";
        daftarBulan[9] = "September";
        daftarBulan[10] = "Oktober";
        daftarBulan[11] = "November";
        daftarBulan[12] = "Desember";
        return daftarBulan;
    }
    
    public static String[] tahun(){
        tahun = new String[13];
        daftarBulan[0] = "--- Pilih Tahun ---";
        daftarBulan[1] = "2014";
        daftarBulan[2] = "2015";
        daftarBulan[3] = "2016";
        daftarBulan[4] = "2017";
        daftarBulan[5] = "2018";
        daftarBulan[6] = "2019";
        daftarBulan[7] = "2020";
        daftarBulan[8] = "2021";
        daftarBulan[9] = "2022";
        daftarBulan[10] = "2023";
        daftarBulan[11] = "2024";
        daftarBulan[12] = "2025";
        return daftarBulan;
    }
}
