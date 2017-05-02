/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service.impl;

import aplikasiinvestasi.dao.DepartemenDao;
import aplikasiinvestasi.dao.InvestDao;
import aplikasiinvestasi.dao.LpjDao;
import aplikasiinvestasi.dao.impl.DepartemenDaoImpl;
import aplikasiinvestasi.dao.impl.InvestDaoImpl;
import aplikasiinvestasi.dao.impl.LpjDaoImpl;
import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpj;
import aplikasiinvestasi.service.LpjService;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public class LpjServiceImpl implements LpjService {
    
    private LpjDao lpjDao = new LpjDaoImpl();
    private DepartemenDao departemenDao = new DepartemenDaoImpl();
    private InvestDao investDao = new InvestDaoImpl();
    
    @Override
    public boolean saveData(MasterLpj masterLpj) {
        return lpjDao.saveData(masterLpj);
    }

    @Override
    public List<MasterLpj> getAllData() {
        return lpjDao.getAllData();
    }

    @Override
    public List<MasterLpj> getAllDataByMonthAndYear(String month, String year) {
        return lpjDao.getAllDataByMonthAndYear(month, year);
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumber(String investNumber) {
        return lpjDao.getAllDataByInvestNumber(investNumber);
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumberAndYear(String investNumber, String year) {
        return lpjDao.getAllDataByInvestNumberAndYear(investNumber, year);
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumberAndMonth(String investNumber, String month) {
        return lpjDao.getAllDataByInvestNumberAndMonth(investNumber, month);
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumberAndYearAndMonth(String investNumber, String year, String month) {
        return lpjDao.getAllDataByInvestNumberAndYearAndMonth(investNumber, year, month);
    }

    @Override
    public List<TotalKredit> countAllCredit() {
        return lpjDao.countAllCredit();
    }

    @Override
    public List<TotalKredit> countCreditByMonthAndYear(String month, String year) {
        return lpjDao.countCreditByMonthAndYear(month, year);
    }

    @Override
    public Long countDebet(MasterInvest masterInvest) {
        return lpjDao.countDebet(masterInvest);
    }

    @Override
    public void updateData(MasterLpj masterLpj) {
        lpjDao.updateData(masterLpj);
    }

    @Override
    public List<MasterLpj> getAllDataByMonth(String month) {
        return lpjDao.getAllDataByMonth(month);
    }

    @Override
    public List<MasterLpj> getAllDataByYear(String year) {
        return lpjDao.getAllDataByYear(year);
    }

    @Override
    public boolean saveInBatch(List<MasterLpj> listMaster) {
        return lpjDao.saveInBatch(listMaster);
    }

    @Override
    public List<MasterDepartemen> getDepartemenByUnit(String unit) {
        return departemenDao.getDataByUnit(unit);
    }

    @Override
    public List<MasterInvest> getAllInvestData() {
        return investDao.getAllData();
    }

    @Override
    public List<MasterLpj> findByYearMonthRekening(String year, String month, String rekening) {
        return lpjDao.findByYearMonthRekening(year, month, rekening);
    }
    
}
