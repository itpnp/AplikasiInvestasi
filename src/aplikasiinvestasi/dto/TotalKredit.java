/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dto;

/**
 *
 * @author Rizaldi Habibie
 */
public class TotalKredit {
    
    private String kodeRekening;
    private String bulan;
    private String Tahun;
    private Double kredit;

    public TotalKredit(String kodeRekening, String bulan, String Tahun, Double kredit) {
        this.kodeRekening = kodeRekening;
        this.bulan = bulan;
        this.Tahun = Tahun;
        this.kredit = kredit;
    }

    public TotalKredit() {
    }

    public String getKodeRekening() {
        return kodeRekening;
    }

    public void setKodeRekening(String kodeRekening) {
        this.kodeRekening = kodeRekening;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getTahun() {
        return Tahun;
    }

    public void setTahun(String Tahun) {
        this.Tahun = Tahun;
    }

    public Double getKredit() {
        return kredit;
    }

    public void setKredit(Double kredit) {
        this.kredit = kredit;
    }
    
}
