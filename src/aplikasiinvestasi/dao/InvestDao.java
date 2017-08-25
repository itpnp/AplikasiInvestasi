/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao;

import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface InvestDao {
    
    public boolean saveData(MasterInvest masterInvest);
    public List<MasterInvest> getAllData();
    public MasterInvest update(MasterInvest masterInvest);
    public List<MasterInvest> findByYear(String year);
    public List<MasterInvest> findByMonth(String month);
    public List<MasterInvest> findByMonthAndYear(String month, String year);
    public void exportAllToExcel(String bulan, String tahun);
    public void exportToExcel(MasterInvest masterInvest, List<MasterLpb> listLpb, List<MasterBskk> listBskk);
    public Double[] countDebet(MasterInvest masterInvest);

}
