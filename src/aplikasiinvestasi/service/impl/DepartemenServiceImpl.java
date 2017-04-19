/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service.impl;

import aplikasiinvestasi.dao.DepartemenDao;
import aplikasiinvestasi.dao.impl.DepartemenDaoImpl;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.service.DepartemenService;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public class DepartemenServiceImpl implements DepartemenService {

    private DepartemenDao departemenDao = new DepartemenDaoImpl();
    
    @Override
    public List<MasterDepartemen> getDepartemenByUnit(String unit) {
        return departemenDao.getDataByUnit(unit);
    }
    
}
