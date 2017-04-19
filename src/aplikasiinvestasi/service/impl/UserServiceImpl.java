/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service.impl;

import aplikasiinvestasi.dao.CredentialDao;
import aplikasiinvestasi.dao.impl.CredentialDaoImpl;
import aplikasiinvestasi.model.MasterCredential;
import aplikasiinvestasi.service.UserService;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public class UserServiceImpl implements UserService {

    private CredentialDao credentialDao = new CredentialDaoImpl();
    
    @Override
    public void addCredential(MasterCredential credential) {
        credentialDao.addCredential(credential);
    }

    @Override
    public List<MasterCredential> viewAllUser() {
        return credentialDao.viewAllUser();
    }

    @Override
    public MasterCredential login(String username, String password) {
        return credentialDao.login(username, password);
    }

    @Override
    public boolean checkConnection() {
        return credentialDao.checkConnection();
    }

    @Override
    public String generateUserId() {
        return credentialDao.generateUserId();
    }

    @Override
    public void update(MasterCredential credential) {
        credentialDao.update(credential);
    }
    
}
