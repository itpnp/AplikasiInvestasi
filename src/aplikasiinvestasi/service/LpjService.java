/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service;

import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpj;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface LpjService {
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
}
