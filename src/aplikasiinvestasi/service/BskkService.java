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
    public List<MasterBskk> getDataByBpkk(String bpkkNumber);
    public void exportToExcelSheet2(HSSFWorkbook workbook, HSSFSheet sheet, List<MasterTerima> listTerima);

    
}
