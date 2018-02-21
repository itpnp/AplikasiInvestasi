/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service.impl;

import aplikasiinvestasi.dao.DepartemenDao;
import aplikasiinvestasi.dao.InvestDao;
import aplikasiinvestasi.dao.LpbDao;
import aplikasiinvestasi.dao.impl.DepartemenDaoImpl;
import aplikasiinvestasi.dao.impl.InvestDaoImpl;
import aplikasiinvestasi.dao.impl.LpbDaoImpl;
import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.service.LpbService;
import java.awt.Component;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public class LpbServiceImpl implements LpbService{

    private LpbDao lpbDao = new LpbDaoImpl();
    private DepartemenDao departemenDao = new DepartemenDaoImpl();
    private InvestDao investDao = new InvestDaoImpl();
    
    @Override
    public boolean saveData(MasterLpb masterLpb) {
       return lpbDao.saveData(masterLpb);
    }

    @Override
    public List<MasterLpb> getAllData() {
        return lpbDao.getAllData();
    }

    @Override
    public List<MasterLpb> getAllDataByMonthAndYear(String month, String year) {
        return lpbDao.getAllDataByMonthAndYear(month, year);
    }

    @Override
    public List<MasterLpb> getAllDataByInvestNumber(String investNumber) {
        return lpbDao.getAllDataByInvestNumber(investNumber);
    }

    @Override
    public List<MasterDepartemen> getDepartemenByUnit(String unit) {
        return departemenDao.getDataByUnit(unit);
    }

    @Override
        public void printToExcel(String bulan,String tahun, String kodeInvest, Component parent){
        lpbDao.printToExcel(bulan, tahun,  kodeInvest, parent);
    }

    @Override
    public List<TotalKredit> countAllCredit() {
        return lpbDao.countAllCredit();
    }

    @Override
    public List<TotalKredit> countCreditByMonthAndYear(String month, String year) {
        return lpbDao.countCreditByMonthAndYear(month, year);
    }

    @Override
    public List<MasterInvest> getAllInvestData() {
        return  investDao.getAllData();
    }


    @Override
    public void updateData(MasterLpb masterLpb) {
        lpbDao.updateData(masterLpb);
    }

    @Override
    public List<MasterLpb> getAllDataByMonth(String month) {
        return lpbDao.getAllDataByMonth(month);
    }

    @Override
    public List<MasterLpb> getAllDataByYear(String year) {
        return lpbDao.getAllDataByYear(year);
    }

    @Override
    public List<MasterLpb> getAllDataByInvestNumberAndYearAndMonth(String investNumber, String year, String month) {
        return lpbDao.getAllDataByInvestNumberAndYearAndMonth(investNumber, year, month);
    }

    @Override
    public List<MasterLpb> getAllDataByInvestNumberAndYear(String investNumber, String year) {
        return lpbDao.getAllDataByInvestNumberAndYear(investNumber, year);
    }

    @Override
    public boolean saveInBatch(List<MasterLpb> listMaster) {
        return lpbDao.saveInBatch(listMaster);
    }

    @Override
    public List<MasterLpb> findByYearMonthRekening(String year, String month, String rekening) {
        return lpbDao.findByYearMonthRekening(year, month, rekening);
    }

    @Override
    public List<MasterLpb> importFile() {
        return lpbDao.importFile();
    }

    
}
