/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service;

import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterTerima;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Rizaldi Habibie
 */
public interface BskkService {
    public List<MasterBskk> getAllData();
    public boolean saveData(MasterBskk masterBskk);
    public void updateData(MasterBskk masterBskk);
    public List<MasterBskk> getDataByMonthAndYear(String month, String year);
    public List<MasterBskk> getDataByYear(String year);
    public List<MasterBskk> getDataByInvestNumber(String investNumber);
    public List<MasterDepartemen> getDepartemenByUnit(String unit);
    public List<MasterInvest> getAllInvestData();
    public void exportToExcel(String bulan, String tahun, List<MasterTerima> listTerima);
    public void saveInBatch(List<MasterBskk> listBskk);
    public List<MasterBskk> getDataByMonthAndYearAndInvestNumber(String month, String year,String investNumber);
    public List<MasterBskk> getDataByMonthAndYearAndKodeRekening(String month, String year,String kodeRekening);
    public List<MasterBskk> getDataByKodeRekening(String kodeRekening);
    public List<MasterBskk> getDataByAllParameter(String month, String year,String nomorBpkk,String kodeRekening);
    public List<MasterBskk> getDataByBpkk(String bpkkNumber);
    public void exportToExcelSheet2(HSSFWorkbook workbook, HSSFSheet sheet, List<MasterTerima> listTerima);
    public Long countDebetByDate(String startDate, String endDate);
    public List<MasterBskk> getDataByYearAndKodeRekening(String year, String kodeRekening);
    public List<MasterBskk> getDataByMonthAndYearAndBpkk(String month, String year,String nomorBpkk);
    public List<MasterBskk> getDataByBpkkAndKodeRekening(String noBpkk,String kodeRekening);
   }
