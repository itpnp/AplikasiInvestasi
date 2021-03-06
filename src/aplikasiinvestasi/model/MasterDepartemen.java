package aplikasiinvestasi.model;
// Generated Nov 10, 2016 8:57:29 AM by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * MasterDepartemen generated by hbm2java
 */
@Entity
@Table(name="master_departemen")
public class MasterDepartemen  implements java.io.Serializable {

     @Id
     @Column(name="id_departement")
     private Integer idDepartement;
     
     @Column(name="kode_departement")
     private String kodeDepartement;
     
     @Column(name="nama_departement")
     private String namaDepartment;
     
     @Column(name="kabag_departement")
     private String kabagDepartment;
     
     @Column(name="unit")
     private String unit;
     
     @Column(name="alokasi")
     private String alokasi;

    public MasterDepartemen() {
    }

    public MasterDepartemen(String kodeDepartemen, String namaDepartment, String kabagDepartment, String alokasi) {
       this.kodeDepartement = kodeDepartemen;
       this.namaDepartment = namaDepartment;
       this.kabagDepartment = kabagDepartment;
       this.alokasi = alokasi;
    }

    public String getKodeDepartement() {
        return kodeDepartement;
    }

    public void setKodeDepartement(String kodeDepartement) {
        this.kodeDepartement = kodeDepartement;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAlokasi() {
        return alokasi;
    }

    public void setAlokasi(String alokasi) {
        this.alokasi = alokasi;
    }
   
    public Integer getIdDepartement() {
        return this.idDepartement;
    }
    
    public void setIdDepartement(Integer idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getNamaDepartment() {
        return this.namaDepartment;
    }
    
    public void setNamaDepartment(String namaDepartment) {
        this.namaDepartment = namaDepartment;
    }
    public String getKabagDepartment() {
        return this.kabagDepartment;
    }
    
    public void setKabagDepartment(String kabagDepartment) {
        this.kabagDepartment = kabagDepartment;
    }




}


