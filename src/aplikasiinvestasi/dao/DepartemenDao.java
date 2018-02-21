/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao;

import aplikasiinvestasi.model.MasterDepartemen;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface DepartemenDao {
    
    public List<MasterDepartemen> getAllData();
    public List<MasterDepartemen> getDataByUnit(String unit);
    public MasterDepartemen findByCode(String code);
}
