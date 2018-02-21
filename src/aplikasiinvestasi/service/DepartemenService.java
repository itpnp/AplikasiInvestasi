/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service;

import aplikasiinvestasi.model.MasterDepartemen;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface DepartemenService {
    public List<MasterDepartemen> getDepartemenByUnit(String unit);
    public MasterDepartemen findByCode(String code);

}
