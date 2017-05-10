/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao;

import aplikasiinvestasi.model.SaldoAkhir;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface SaldoAkhirDao {
    public boolean save(SaldoAkhir saldo);
    public List<SaldoAkhir> getAllData();
    public List<SaldoAkhir> findByMonthAndYear(String month, String year);
}
