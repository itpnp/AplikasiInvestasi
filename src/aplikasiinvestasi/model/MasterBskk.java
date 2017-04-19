/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Rizaldi Habibie
 */
@Entity
@Table(name="master_bskk")
public class MasterBskk implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="id_bskk")
    private int idBskk;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="invest", nullable=true)
    private MasterInvest masterInvest;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="departemen", nullable=true)
    private MasterDepartemen masterDepartemen;
    
    @Column(name = "tanggal")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggal;
    
    @Column(name="keterangan")
    private String keterangan;
    
    @Column(name="no_bpkk")
    private String noBskk;
    
    @Column(name="debet")
    private long debet;
    
    @Column(name="kode_rekening")
    private String kodeRekening;

    public MasterBskk(int idBskk, MasterInvest masterInvest, MasterDepartemen masterDepartemen, Date tanggal, String keterangan, String noBskk, long debet, String kodeRekening) {
        this.idBskk = idBskk;
        this.masterInvest = masterInvest;
        this.masterDepartemen = masterDepartemen;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.noBskk = noBskk;
        this.debet = debet;
        this.kodeRekening = kodeRekening;
    }

    public MasterBskk() {
    }

    public int getIdBskk() {
        return idBskk;
    }

    public void setIdBskk(int idBskk) {
        this.idBskk = idBskk;
    }

    public MasterInvest getMasterInvest() {
        return masterInvest;
    }

    public void setMasterInvest(MasterInvest masterInvest) {
        this.masterInvest = masterInvest;
    }

    public MasterDepartemen getMasterDepartemen() {
        return masterDepartemen;
    }

    public void setMasterDepartemen(MasterDepartemen masterDepartemen) {
        this.masterDepartemen = masterDepartemen;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNoBskk() {
        return noBskk;
    }

    public void setNoBskk(String noBskk) {
        this.noBskk = noBskk;
    }

    public long getDebet() {
        return debet;
    }

    public void setDebet(long debet) {
        this.debet = debet;
    }

    public String getKodeRekening() {
        return kodeRekening;
    }

    public void setKodeRekening(String kodeRekening) {
        this.kodeRekening = kodeRekening;
    }
    
}
