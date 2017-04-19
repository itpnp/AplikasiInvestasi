/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rizaldi Habibie
 */
@Entity
@Table(name="master_rekening")
public class MasterRekening implements Serializable {
    
    @Id
    @Column(name="no")
    private int no;
    
    @Column(name="no_rekening")
    private String noRekening;
    
    @Column(name="keterangan")
    private String keterangan;

    public MasterRekening(int no, String noRekening, String keterangan) {
        this.no = no;
        this.noRekening = noRekening;
        this.keterangan = keterangan;
    }

    public MasterRekening() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    
}
