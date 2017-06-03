/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service;

import aplikasiinvestasi.model.MasterKeluarBskk;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface KeluarService {
    public boolean save(MasterKeluarBskk keluar);
    public List<MasterKeluarBskk> getAllData();
    public List<MasterKeluarBskk> findByMonthAndYear(String month, String year);
}
