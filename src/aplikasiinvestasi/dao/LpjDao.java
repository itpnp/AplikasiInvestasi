/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao;

import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpj;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Rizaldi Habibie
 */
public interface LpjDao {
    public boolean saveData(MasterLpj masterLpj);
    public List<MasterLpj> getAllData();
    public List<MasterLpj> getAllDataByMonthAndYear(String month, String year);
    public List<MasterLpj> getAllDataByInvestNumber(String investNumber);
    public List<MasterLpj> getAllDataByInvestNumberAndYear(String investNumber,String year);
    public List<MasterLpj> getAllDataByInvestNumberAndMonth(String investNumber,String month);
    public List<MasterLpj> getAllDataByInvestNumberAndYearAndMonth(String investNumber,String year,String month);
    public List<TotalKredit> countAllCredit();
    public List<TotalKredit> countCreditByMonthAndYear(String month, String year);
    public Long countDebet(MasterInvest masterInvest);
    public void updateData(MasterLpj masterLpj);
    public List<MasterLpj> getAllDataByMonth(String month);
    public List<MasterLpj> getAllDataByYear(String year);
    public boolean saveInBatch(List<MasterLpj> listMaster);   
    public List<MasterLpj> findByYearMonthRekening(String year,String month, String rekening);
    public void directPrint(JTable viewTable, String ppn, String title);

}
