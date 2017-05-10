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
@Table(name="saldo_akhir_bskk")
public class SaldoAkhir implements Serializable {
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="bulan")
    private String bulan;
    
    @Column(name="tahun")
    private String tahun;
    
    @Column(name="saldo")
    private Long saldo;

    public SaldoAkhir(int id, String tahun, String bulan, Long saldo) {
        this.id = id;
        this.tahun = tahun;
        this.bulan = bulan;
        this.saldo = saldo;
    }

    public SaldoAkhir() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }
    
    
}
