/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service;

import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import java.awt.Component;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface LpbService {
     /**
     *
     * @param masterLpb
     * @return
     */
    public boolean saveData(MasterLpb masterLpb);
    
    /**
     *
     * @return
     */
    public List<MasterLpb> getAllData();
    public List<MasterLpb> getAllDataByMonthAndYear(String month, String year);
    public List<MasterLpb> getAllDataByInvestNumber(String investNumber);
    public List<MasterDepartemen> getDepartemenByUnit(String unit);
    public void printToExcel(String bulan,String tahun, String kodeInvest, Component parent);
    public List<TotalKredit> countAllCredit();
    public List<TotalKredit> countCreditByMonthAndYear(String month, String year);
    public List<MasterInvest> getAllInvestData();
    public void updateData(MasterLpb masterLpb);
    public List<MasterLpb> getAllDataByMonth(String month);
    public List<MasterLpb> getAllDataByYear(String year);
    public List<MasterLpb> getAllDataByInvestNumberAndYearAndMonth(String investNumber,String year,String month);
    public List<MasterLpb> getAllDataByInvestNumberAndYear(String investNumber,String year);
    public boolean saveInBatch(List<MasterLpb> listMaster);
    public List<MasterLpb> findByYearMonthRekening(String year,String month, String rekening);
}
