/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao;

import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.model.MasterLpj;
import java.awt.Component;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Rizaldi Habibie
 */
public interface LpbDao {
    
    public boolean saveData(MasterLpb masterLpb);
    public List<MasterLpb> getAllData();
    public List<MasterLpb> getAllDataByMonthAndYear(String month, String year);
    public List<MasterLpb> getAllDataByInvestNumber(String investNumber);
    public List<MasterLpb> getAllDataByInvestNumberAndYear(String investNumber,String year);
    public List<MasterLpb> getAllDataByInvestNumberAndMonth(String investNumber,String month);
    public List<MasterLpb> getAllDataByInvestNumberAndYearAndMonth(String investNumber,String year,String month);
    public void templateExcel(HSSFWorkbook workbook,String sheetTitle,List<MasterLpb> masterLpb, List<MasterLpj> masterLpj);
    public void printToExcel(String bulan,String tahun, String kodeInvest, Component parent);
    public String[] fillData(HSSFRow rowData, HSSFCell cell, HSSFCellStyle cellStyle2, HSSFCellStyle cellStyle12,HSSFCellStyle cellStyle13, MasterLpb lpb);
    public String fillDataLPJ(HSSFRow rowData, HSSFCell cell, HSSFCellStyle cellStyle2, HSSFCellStyle cellStyle12, HSSFCellStyle cellStyle13, MasterLpj lpj);
    public List<TotalKredit> countAllCredit();
    public List<TotalKredit> countCreditByMonthAndYear(String month, String year);
    public Long countDebet(MasterInvest masterInvest);
    public void updateData(MasterLpb masterLpb);
    public List<MasterLpb> getAllDataByMonth(String month);
    public List<MasterLpb> getAllDataByYear(String year);
    public boolean saveInBatch(List<MasterLpb> listMaster);
    public List<MasterLpb> findByYearMonthRekening(String year,String month, String rekening);

    
}
