/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterCredential;
import aplikasiinvestasi.service.UserService;
import aplikasiinvestasi.service.impl.UserServiceImpl;
import aplikasiinvestasi.view.LoginPage;
import java.awt.event.ActionEvent;

/**
 *
 * @author Rizaldi Habibie
 */
public class LoginPageController {
    private LoginPage loginPage = new LoginPage(null, true);
    private UserService userService = new UserServiceImpl();
    
    public LoginPageController(){
        loginPage.getLoginButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonActionPerformed(e);
            }
        });
        
        loginPage.getPasswordField().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonActionPerformed(e);
            }
        });
        loginPage.setVisible(true);
    }
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
//        try{
        MasterCredential user;
        user = userService.login(loginPage.getUsernameField().getText(), loginPage.getPasswordField().getText());
        if(user != null && !user.getStatus().equals("NON AKTIF")){
            switch (user.getPrivilege()) {
                case "KABAG":
                    {
                        loginPage.dispose();
                        MainPageController main = new MainPageController();
                        break;
                    }
                case "LPB":
                    {
                        loginPage.dispose();
                        MainPageLpbController main = new MainPageLpbController();
                        break;
                    }
                case "BSKK":
                    {
                        loginPage.dispose();
                        MainPageBskkController main = new MainPageBskkController();
                        main.getAllData();
                        main.viewDataOnTable();
                        break;
                    }
            }
        }else{
           loginPage.getPasswordField().setText("");
           loginPage.getPasswordField().requestFocus();
        }
    }                      
}
