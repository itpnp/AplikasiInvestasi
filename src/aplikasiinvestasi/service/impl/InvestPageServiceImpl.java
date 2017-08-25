/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service.impl;

import aplikasiinvestasi.dao.BskkDao;
import aplikasiinvestasi.dao.DepartemenDao;
import aplikasiinvestasi.dao.InvestDao;
import aplikasiinvestasi.dao.LpbDao;
import aplikasiinvestasi.dao.impl.BskkDaoImpl;
import aplikasiinvestasi.dao.impl.DepartemenDaoImpl;
import aplikasiinvestasi.dao.impl.InvestDaoImpl;
import aplikasiinvestasi.dao.impl.LpbDaoImpl;
import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.service.InvestPageService;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public class InvestPageServiceImpl implements InvestPageService {
    private InvestDao investDao = new InvestDaoImpl();
    private DepartemenDao departemenDao = new DepartemenDaoImpl();
    private LpbDao lpbDao = new LpbDaoImpl();
    private BskkDao bskkDao = new BskkDaoImpl();
    
    @Override
    public List<MasterInvest> getAllData() {
        return investDao.getAllData();
    }
     @Override
    public List<MasterDepartemen> getAllDepartemenData() {
        return departemenDao.getAllData();
    }

    @Override
    public boolean saveData(MasterInvest masterInvest) {
        return investDao.saveData(masterInvest);
    }

    @Override
    public List<MasterDepartemen> getDataByUnit(String unit) {
        return departemenDao.getDataByUnit(unit);
    }

    @Override
    public List<MasterLpb> getAllDataByInvestNumber(String investNumber) {
        return lpbDao.getAllDataByInvestNumber(investNumber);
    }

    @Override
    public Double[] countDebet(MasterInvest masterInvest) {
        return investDao.countDebet(masterInvest);
    }

    @Override
    public MasterInvest update(MasterInvest masterInvest) {
        return investDao.update(masterInvest);
    }

    @Override
    public List<MasterInvest> findByYear(String year) {
        return investDao.findByYear(year);
    }

    @Override
    public List<MasterInvest> findByMonth(String month) {
        return investDao.findByMonth(month);
    }

    @Override
    public List<MasterInvest> findByMonthAndYear(String month, String year) {
        return investDao.findByMonthAndYear(month, year);
    }

    @Override
    public void exportAllToExcel(String bulan, String tahun) {
        investDao.exportAllToExcel(bulan, tahun);
    }

    @Override
    public List<MasterBskk> getDataByInvestNumber(String investNumber) {
        return bskkDao.getDataByInvestNumber(investNumber);
    }

    @Override
    public void exportToExcel(MasterInvest masterInvest, List<MasterLpb> listLpb, List<MasterBskk> listBskk) {
        investDao.exportToExcel(masterInvest, listLpb, listBskk);
    }
}
