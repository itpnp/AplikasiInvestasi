/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Rizaldi Habibie
 */
@Entity
@Table(name="master_terima_bskk")
public class MasterTerima implements Serializable {
    
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="jenis")
    private String jenis;
    
    @Column(name="jumlah")
    private Long jumlah;
    
    @Column(name="tanggal")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggal;

    public MasterTerima() {
    }

    public MasterTerima(int id, String jenis, Long jumlah, Date tanggal) {
        this.id = id;
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
}
