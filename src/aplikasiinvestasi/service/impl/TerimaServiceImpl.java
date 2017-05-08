/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service.impl;

import aplikasiinvestasi.dao.TerimaDao;
import aplikasiinvestasi.dao.impl.TerimaDaoImpl;
import aplikasiinvestasi.model.MasterTerima;
import aplikasiinvestasi.service.TerimaService;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public class TerimaServiceImpl implements TerimaService {

    private TerimaDao terimaDao = new TerimaDaoImpl();
    @Override
    public boolean save(MasterTerima terima) {
        return terimaDao.save(terima);
    }

    @Override
    public List<MasterTerima> findByMonth(String month, String year) {
        return terimaDao.findByMonth(month, year);
    }

    @Override
    public List<MasterTerima> getAllData() {
        return terimaDao.getAllData();
    }

    @Override
    public List<MasterTerima> findByYear(String year) {
        return terimaDao.findByYear(year);
    }
    
}
