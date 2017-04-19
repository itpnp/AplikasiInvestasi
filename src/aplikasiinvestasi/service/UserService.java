/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.service;

import aplikasiinvestasi.model.MasterCredential;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface UserService {
     /**
     * 
     * @param credential 
     */
    public void addCredential(MasterCredential credential);
    
    /**
     * 
     * @return 
     */
    public List<MasterCredential> viewAllUser();
   
    /**
     * 
     * @param username
     * @param password
     * @return 
     */
    public MasterCredential login(String username, String password);
    
    /**
     * 
     */
    public boolean checkConnection();
    
    /**
     * 
     * @return String
     */
    public String generateUserId();
    
    /**
     * 
     * @param credential 
     */
    public void update(MasterCredential credential);
}
