/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service.impl;

import aplikasiinvestasi.dao.SaldoAkhirDao;
import aplikasiinvestasi.dao.impl.SaldoAkhirDaoImpl;
import aplikasiinvestasi.model.SaldoAkhir;
import aplikasiinvestasi.service.SaldoAkhirService;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public class SaldoAkhirServiceImpl implements SaldoAkhirService {
    
    private SaldoAkhirDao saldoAkhirDao = new SaldoAkhirDaoImpl();

    @Override
    public boolean save(SaldoAkhir saldo) {
        return saldoAkhirDao.save(saldo);
    }

    @Override
    public List<SaldoAkhir> getAllData() {
        return saldoAkhirDao.getAllData();
    }

    @Override
    public List<SaldoAkhir> findByMonthAndYear(String month, String year) {
        return saldoAkhirDao.findByMonthAndYear(month, year);
    }
    
}
