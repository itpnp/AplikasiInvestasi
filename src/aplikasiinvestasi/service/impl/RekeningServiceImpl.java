/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service.impl;

import aplikasiinvestasi.dao.RekeningDao;
import aplikasiinvestasi.dao.impl.RekeningDaoImpl;
import aplikasiinvestasi.service.RekeningService;

/**
 *
 * @author Rizaldi Habibie
 */
public class RekeningServiceImpl implements RekeningService {

    private RekeningDao rekeningDao = new RekeningDaoImpl();
    
    @Override
    public boolean checkRekening(String kodeRekening) {
        return rekeningDao.checkRekening(kodeRekening);
    }
    
}
