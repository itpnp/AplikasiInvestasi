/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service;

import aplikasiinvestasi.model.MasterTerima;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface TerimaService {
    /**
     *
     * @param terima
     * @return
     */
    public boolean save(MasterTerima terima);
    /**
     *
     * @param month
     * @param year
     * @return
     */
    public List<MasterTerima> findByMonth(String month, String year);
    
    public List<MasterTerima> getAllData();
}
