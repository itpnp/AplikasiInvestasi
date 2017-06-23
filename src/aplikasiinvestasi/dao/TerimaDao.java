/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao;

import aplikasiinvestasi.model.MasterTerima;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface TerimaDao {
    public boolean save(MasterTerima terima);
    public boolean update(MasterTerima terima);
    public List<MasterTerima> getAllData();
    public List<MasterTerima> findByMonth(String month, String year);
    public List<MasterTerima> findByYear(String year);
}
