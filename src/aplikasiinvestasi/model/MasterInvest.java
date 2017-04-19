/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="master_invest")
public class MasterInvest {
    
    @Id
    @Column(name="kode_invest")
    private String kodeInvest;
    
    @Column(name="nomor_ijin_invest")
    private String nomorIjin;
    
    @Column(name="jenis_invest")
    private String jenisInvest;
    
    @Column(name="jumlah")
    private int jumlah;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="diajukan_oleh", nullable=false)
    private MasterDepartemen departemenPengajuan;
    
    @Column(name="rencana_biaya")
    private long rencanaBiaya;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pemohon", nullable=false)
    private MasterDepartemen departemenPemohon;
    
    @Column(name="tanggal_ijin_invest")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalIjinInvest;

    public MasterInvest(String kodeInvest, String nomorIjin, String jenisInvest, int jumlah, MasterDepartemen departemenPengajuan, long rencanaBiaya, MasterDepartemen departemenPemohon, Date tanggalIjinInvest) {
        this.kodeInvest = kodeInvest;
        this.nomorIjin = nomorIjin;
        this.jenisInvest = jenisInvest;
        this.jumlah = jumlah;
        this.departemenPengajuan = departemenPengajuan;
        this.rencanaBiaya = rencanaBiaya;
        this.departemenPemohon = departemenPemohon;
        this.tanggalIjinInvest = tanggalIjinInvest;
    }

    public MasterInvest() {
    }

    public String getKodeInvest() {
        return kodeInvest;
    }

    public void setKodeInvest(String kodeInvest) {
        this.kodeInvest = kodeInvest;
    }

    public String getNomorIjin() {
        return nomorIjin;
    }

    public void setNomorIjin(String nomorIjin) {
        this.nomorIjin = nomorIjin;
    }

    public String getJenisInvest() {
        return jenisInvest;
    }

    public void setJenisInvest(String jenisInvest) {
        this.jenisInvest = jenisInvest;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public MasterDepartemen getDepartemenPengajuan() {
        return departemenPengajuan;
    }

    public void setDepartemenPengajuan(MasterDepartemen departemenPengajuan) {
        this.departemenPengajuan = departemenPengajuan;
    }

    public long getRencanaBiaya() {
        return rencanaBiaya;
    }

    public void setRencanaBiaya(long rencanaBiaya) {
        this.rencanaBiaya = rencanaBiaya;
    }

    public MasterDepartemen getDepartemenPemohon() {
        return departemenPemohon;
    }

    public void setDepartemenPemohon(MasterDepartemen departemenPemohon) {
        this.departemenPemohon = departemenPemohon;
    }

    public Date getTanggalIjinInvest() {
        return tanggalIjinInvest;
    }

    public void setTanggalIjinInvest(Date tanggalIjinInvest) {
        this.tanggalIjinInvest = tanggalIjinInvest;
    }
    
    
}
