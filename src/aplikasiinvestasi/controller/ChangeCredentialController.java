/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterCredential;
import aplikasiinvestasi.service.UserService;
import aplikasiinvestasi.service.impl.UserServiceImpl;
import aplikasiinvestasi.view.ChangeCredentialPage;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Rizaldi Habibie
 */
public class ChangeCredentialController {
    private MasterCredential user;
    private ChangeCredentialPage credentialPage;
    private UserService userService;
    private MainPageBskkController bskk;
    private MainPageLpbController lpb;
    private MainPageController kabag;
    private String username,passwordLama,passwordBaru,confirmPasswordBaru;
    
    //Constructor for BSKK
    public ChangeCredentialController(MasterCredential user, MainPageBskkController bskk){
        this.user = user;
        this.userService = new UserServiceImpl();
        this.bskk = bskk;
        this.credentialPage = new ChangeCredentialPage(bskk.getParent(),true);
        this.credentialPage.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
    }
    
    //Constructor for LPB
    public ChangeCredentialController(MasterCredential user, MainPageLpbController lpb){
        this.user = user;
        this.userService = new UserServiceImpl();
        this.lpb = lpb;
        this.credentialPage = new ChangeCredentialPage(lpb.getMainPage(),true);
        this.credentialPage.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
    }
    
    //Constructor for KABAG
    public ChangeCredentialController(MasterCredential user, MainPageController kabag){
        this.user = user;
        this.userService = new UserServiceImpl();
        this.kabag = kabag;
        this.credentialPage = new ChangeCredentialPage(kabag.getParent(),true);
        this.credentialPage.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
    }
    
    public ChangeCredentialPage openPage(){
        return credentialPage;
    }
    
    public void save(java.awt.event.ActionEvent e){
        username = credentialPage.getUsernameField().getText();
        passwordLama = credentialPage.getPasswordLama().getText();
        passwordBaru = credentialPage.getPasswordBaru().getText();
        confirmPasswordBaru = credentialPage.getConfirmPasswordBaru().getText();
        if(!passwordLama.equals("") || !passwordLama.isEmpty()||!passwordBaru.equals("") || !passwordBaru.isEmpty()){
            
        if(passwordBaru.equals(confirmPasswordBaru)){
            
            user = userService.login(user.getUsername(), passwordLama);
            if(user != null && !user.getStatus().equals("NON AKTIF")){
                if(!username.equals("") || !username.isEmpty()){
                    user.setUsername(username);
                }
                if(!passwordBaru.equals("") || !passwordBaru.isEmpty()){
                    user.setPassword(passwordBaru);
                }
                
                if(userService.update(user)){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "SUKSES !!", JOptionPane.INFORMATION_MESSAGE);
                    credentialPage.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Data Gagal Diubah", "PERHATIAN !!", JOptionPane.ERROR_MESSAGE);

                }
            }else{
                credentialPage.getPasswordLama().requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Password Baru dan Confirm Password Tidak Cocok", "PERHATIAN !!", JOptionPane.ERROR_MESSAGE);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Mohon Isi Password Lama", "PERHATIAN !!", JOptionPane.ERROR_MESSAGE);
            credentialPage.getPasswordLama().requestFocus();
        }
    }
    
}
