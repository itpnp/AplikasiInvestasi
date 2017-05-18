/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service.impl;

import aplikasiinvestasi.dao.BskkDao;
import aplikasiinvestasi.dao.DepartemenDao;
import aplikasiinvestasi.dao.InvestDao;
import aplikasiinvestasi.dao.impl.BskkDaoImpl;
import aplikasiinvestasi.dao.impl.DepartemenDaoImpl;
import aplikasiinvestasi.dao.impl.InvestDaoImpl;
import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterTerima;
import aplikasiinvestasi.service.BskkService;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Rizaldi Habibie
 */
public class BskkServiceImpl implements BskkService{

    private BskkDao bskkDao = new BskkDaoImpl();
    private DepartemenDao departemenDao = new DepartemenDaoImpl();
    private InvestDao investDao = new InvestDaoImpl();
    
    @Override
    public List<MasterBskk> getAllData() {
        return bskkDao.getAllData();
    }

    @Override
    public boolean saveData(MasterBskk masterBskk) {
        return bskkDao.saveData(masterBskk);
    }

    @Override
    public void updateData(MasterBskk masterBskk) {
        bskkDao.updateData(masterBskk);
    }

    @Override
    public List<MasterBskk> getDataByMonthAndYear(String month, String year) {
        return bskkDao.getDataByMonthAndYear(month, year);
    }

    @Override
    public List<MasterBskk> getDataByYear(String year) {
        return bskkDao.getDataByYear(year);
    }

    @Override
    public List<MasterBskk> getDataByInvestNumber(String investNumber) {
        return bskkDao.getDataByInvestNumber(investNumber);
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
    public void exportToExcel(String bulan, String tahun, List<MasterTerima> listTerima) {
        bskkDao.exportToExcel(bulan, tahun,listTerima);
    }

    @Override
    public List<MasterBskk> getDataByMonthAndYearAndInvestNumber(String month, String year, String investNumber) {
        return bskkDao.getDataByMonthAndYearAndInvestNumber(month, year, investNumber);
    }

    @Override
    public void saveInBatch(List<MasterBskk> listBskk) {
        bskkDao.saveInBatch(listBskk);
    }

    @Override
    public List<MasterBskk> getDataByBpkk(String bpkkNumber) {
        return bskkDao.getDataByBpkk(bpkkNumber);
    }

    @Override
    public void exportToExcelSheet2(HSSFWorkbook workbook, HSSFSheet sheet, List<MasterTerima> listTerima) {
        bskkDao.exportToExcelSheet2(workbook, sheet, listTerima);
    }

    @Override
    public Long countDebetByDate(String startDate, String endDate) {
        return bskkDao.countDebetByDate(startDate, endDate);
    }

    @Override
    public List<MasterBskk> getDataByMonthAndYearAndKodeRekening(String month, String year, String kodeRekening) {
        return bskkDao.getDataByMonthAndYearAndKodeRekening(month, year, kodeRekening);
    }

    @Override
    public List<MasterBskk> getDataByKodeRekening(String kodeRekening) {
        return bskkDao.getDataByKodeRekening(kodeRekening);
    }

    @Override
    public List<MasterBskk> getDataByBpkkAndKodeRekening(String bpkk, String kodeRekening) {
        return bskkDao.getDataByBpkkAndKodeRekening(bpkk, kodeRekening);
    }

    @Override
    public List<MasterBskk> getDataByAllParameter(String month, String year, String nomorBpkk, String kodeRekening) {
        return bskkDao.getDataByAllParameter(month, year, nomorBpkk, kodeRekening);
    }

    @Override
    public List<MasterBskk> getDataByYearAndKodeRekening(String year, String kodeRekening) {
        return bskkDao.getDataByYearAndKodeRekening(year, kodeRekening);
    }

    @Override
    public List<MasterBskk> getDataByMonthAndYearAndBpkk(String month, String year, String nomorBpkk) {
        return bskkDao.getDataByMonthAndYearAndBpkk(month, year, nomorBpkk);
    }


    
}
