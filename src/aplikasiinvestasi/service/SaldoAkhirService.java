/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service;

import aplikasiinvestasi.model.SaldoAkhir;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface SaldoAkhirService {
    public boolean save(SaldoAkhir saldo);
    public List<SaldoAkhir> getAllData();
    public List<SaldoAkhir> findByMonthAndYear(String month, String year);
}
