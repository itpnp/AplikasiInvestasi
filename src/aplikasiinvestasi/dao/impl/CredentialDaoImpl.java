/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.dao.CredentialDao;
import aplikasiinvestasi.model.MasterCredential;
import aplikasiinvestasi.utils.HibernateUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rizaldi Habibie
 */
public class CredentialDaoImpl implements CredentialDao {

    private Session session;
    @Override
    public void addCredential(MasterCredential credential) {
        try{
            System.out.println(credential.getPrivilegeCode());
            session = HibernateUtil.getSessionFactory().openSession();
            byte[] key = generateKey();
            credential.setSaltKey(key);
            credential.setPassword(securePassword(credential.getPassword(), key));
            session.beginTransaction();
            session.save(credential);
            session.getTransaction().commit();
            session.flush();
           JOptionPane.showMessageDialog(null,"Data Berhasil Ditambah", "Success", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(HibernateException e){
           JOptionPane.showMessageDialog(null,"Error Check Database \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
    }

    @Override
    public List<MasterCredential> viewAllUser() {
        List<MasterCredential> listCredential = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listCredential = session.createCriteria(MasterCredential.class).list();
            session.flush();
        }catch(HibernateException e){
           JOptionPane.showMessageDialog(null,"Error Check Database \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listCredential;
    }

    @Override
    public String securePassword(String password, byte[] key) {
        String secured = "";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key);
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< hash.length; i++){
                sb.append(Integer.toString((hash[i]&0xff)+0x100,16));
            }
            secured = sb.toString();
        }catch(Exception e){
            
        }
        return secured;
    }

    @Override
    public byte[] generateKey() {
        byte[] key = new byte[16];
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
            sr.nextBytes(key);
        } catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
            ex.printStackTrace();
        }
        return key;
    }

    @Override
    public MasterCredential login(String username, String password) {
        MasterCredential credential = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            credential = (MasterCredential)session.createCriteria(MasterCredential.class).add(Restrictions.eq("username", username)).uniqueResult();
            if(credential == null){
                JOptionPane.showMessageDialog(null,"Wrong Username or Password", "Error", JOptionPane.ERROR_MESSAGE, null);
            }else{
                if(credential.getPassword().equals(securePassword(password, credential.getSaltKey()))){
                    if(credential.getStatus().equals("NON AKTIF")){
                        JOptionPane.showMessageDialog(null,"Access Denied", "Sorry :(", JOptionPane.ERROR_MESSAGE, null);
                        credential = null;
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Wrong Username or Password", "Error", JOptionPane.ERROR_MESSAGE, null);
                    credential = null;
                }
            }
           session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
           JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return credential;
    }

    @Override
    public boolean checkConnection() {
        boolean connected = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            connected = true;
        }catch(HibernateException e){
            connected = false;
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }    
        return connected;
    }

    @Override
    public String generateUserId() {
        String code = null;
        MasterCredential masterCredential;
        try{
           session = HibernateUtil.getSessionFactory().openSession();
           masterCredential = (MasterCredential)session.createQuery("from MasterCredential order by privilege_code desc limit 1").uniqueResult();
           int numerator = Integer.valueOf(masterCredential.getPrivilegeCode().substring(3, 6));
           numerator++;
           if(numerator <10){
               code = "00"+numerator;
           }else if(numerator >=10 && numerator<100){
               code = "0"+numerator;
           }else if(numerator >=100 && numerator<1000){
               code = ""+numerator;
           }
           session.flush();
        }catch(HibernateException e){
           JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }    
        return code;
    }

    @Override
    public void update(MasterCredential credential) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(credential);
            session.getTransaction().commit();
            session.flush();
           JOptionPane.showMessageDialog(null,"Data Berhasil Diubah", "Success", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(HibernateException e){
           JOptionPane.showMessageDialog(null,"Error Check Database \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
    }
  

    
}
