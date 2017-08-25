/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service;

import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface InvestPageService {
     public List<MasterInvest> getAllData();
     public List<MasterDepartemen> getAllDepartemenData();
     public boolean saveData(MasterInvest masterInvest);
     public List<MasterDepartemen> getDataByUnit(String unit);
     public List<MasterLpb> getAllDataByInvestNumber(String investNumber);
     public Double[] countDebet(MasterInvest masterInvest);
     public MasterInvest update(MasterInvest masterInvest);
     public List<MasterInvest> findByYear(String year);
     public List<MasterInvest> findByMonth(String month);
     public List<MasterInvest> findByMonthAndYear(String month, String year);
     public void exportAllToExcel(String bulan, String tahun);
    public void exportToExcel(MasterInvest masterInvest, List<MasterLpb> listLpb, List<MasterBskk> listBskk);
     public List<MasterBskk> getDataByInvestNumber(String investNumber);

}
