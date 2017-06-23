/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service.impl;

import aplikasiinvestasi.dao.KeluarDao;
import aplikasiinvestasi.dao.impl.KeluarDaoImpl;
import aplikasiinvestasi.model.MasterKeluarBskk;
import aplikasiinvestasi.service.KeluarService;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public class KeluarServiceImpl implements KeluarService{

    private KeluarDao keluarDao = new KeluarDaoImpl();
    
    @Override
    public boolean save(MasterKeluarBskk keluar) {
        return keluarDao.save(keluar);
    }

    @Override
    public List<MasterKeluarBskk> getAllData() {
        return keluarDao.getAllData();
    }

    @Override
    public List<MasterKeluarBskk> findByMonthAndYear(String month, String year) {
        return keluarDao.findByMonthAndYear(month, year);
    }

    @Override
    public boolean update(MasterKeluarBskk keluar) {
        return keluarDao.update(keluar);
    }
    
}
