/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao;

import aplikasiinvestasi.model.MasterCredential;
import java.util.List;

/**
 *
 * @author Rizaldi Habibie
 */
public interface CredentialDao {
    
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
     * @param password
     * @param key
     * @return
     */
    public String securePassword(String password, byte[] key);
    
    /**
     * 
     * @return 
     */
    public byte[] generateKey();
    
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
