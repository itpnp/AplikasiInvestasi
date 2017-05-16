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
@Table(name="master_lpj")
public class MasterLpj implements Serializable {
    
    @Id
    @Column(name="id_lpj")
    private int idLpj;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="kode_invest", nullable=true)
    private MasterInvest masterInvest;
    
    @Column(name="alokasi_biaya")
    private String alokasiBiaya;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="kode_departemen", nullable=true)
    private MasterDepartemen masterDepartemen;
    
    @Column(name="tanggal")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggal;
    
    @Column(name="keterangan")
    private String keterangan;
    
    @Column(name="no_lpj_internal")
    private String noIpbInternal;
    
    @Column(name="no_lpj_eksternal")
    private String noIpbEksternal;
    
    @Column(name="jumlah")
    private double jumlah;
    
    @Column(name="satuan")
    private String satuan;
    
    @Column(name="harga_satuan")
    private Double hargaSatuan;
    
    @Column(name="debet")
    private Double debet;

    @Column(name="kode_rekening")
    private String kodeRekening;
    
    @Column(name="status")
    private String status;
    
    @Column(name="active_status")
    private String activeStatus;
  
    public MasterLpj(int idLpj, MasterInvest masterInvest, String alokasiBiaya, MasterDepartemen masterDepartemen, Date tanggal, 
            String keterangan, String noIpbInternal, String noIpbEksternal, double jumlah, String satuan, Double hargaSatuan, Double debet, 
            String kodeRekening, String status, String activeStatus) {
        this.idLpj = idLpj;
        this.masterInvest = masterInvest;
        this.alokasiBiaya = alokasiBiaya;
        this.masterDepartemen = masterDepartemen;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.noIpbInternal = noIpbInternal;
        this.noIpbEksternal = noIpbEksternal;
        this.jumlah = jumlah;
        this.satuan = satuan;
        this.hargaSatuan = hargaSatuan;
        this.debet = debet;
        this.kodeRekening = kodeRekening;
        this.status = status;
        this.activeStatus = activeStatus;
    }
    
    public MasterLpj() {
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKodeRekening() {
        return kodeRekening;
    }

    public void setKodeRekening(String kodeRekening) {
        this.kodeRekening = kodeRekening;
    }

    public int getIdLpj() {
        return idLpj;
    }

    public void setIdLpj(int idLpj) {
        this.idLpj = idLpj;
    }

    public MasterInvest getMasterInvest() {
        return masterInvest;
    }

    public void setMasterInvest(MasterInvest masterInvest) {
        this.masterInvest = masterInvest;
    }

    public String getAlokasiBiaya() {
        return alokasiBiaya;
    }

    public void setAlokasiBiaya(String alokasiBiaya) {
        this.alokasiBiaya = alokasiBiaya;
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

    public String getNoIpbInternal() {
        return noIpbInternal;
    }

    public void setNoIpbInternal(String noIpbInternal) {
        this.noIpbInternal = noIpbInternal;
    }

    public String getNoIpbEksternal() {
        return noIpbEksternal;
    }

    public void setNoIpbEksternal(String noIpbEksternal) {
        this.noIpbEksternal = noIpbEksternal;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(Double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public Double getDebet() {
        return debet;
    }

    public void setDebet(Double debet) {
        this.debet = debet;
    }
}
