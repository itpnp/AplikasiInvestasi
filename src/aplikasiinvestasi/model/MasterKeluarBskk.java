/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rizaldi Habibie
 */
@Entity
@Table(name="master_keluar_bskk")
public class MasterKeluarBskk {
    @Id
    @Column(name="id_keluar")
    private Long idKeluar;
    
    @Column(name="keterangan")
    private String keterangan;
    
    @Column(name="bulan")
    private String bulan;
            
    @Column(name="tahun")
    private String tahun;
    
    @Column(name="jumlah")
    private Long nominal;

    public String getKeterangan() {
        return keterangan;
    }

    public MasterKeluarBskk(Long idKeluar, String keterangan, String bulan, String tahun, Long nominal) {
        this.idKeluar = idKeluar;
        this.keterangan = keterangan;
        this.bulan = bulan;
        this.tahun = tahun;
        this.nominal = nominal;
    }

    public MasterKeluarBskk() {
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }
    
    public Long getIdKeluar() {
        return idKeluar;
    }

    public void setIdKeluar(Long idKeluar) {
        this.idKeluar = idKeluar;
    }
    
}
