/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.view.IjinInvestPage;
import aplikasiinvestasi.view.MainPage;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.DesktopPaneUI;

/**
 *
 * @author Rizaldi Habibie
 */
public class MainPageController {
    private MainPage mainPage = new MainPage();
    private ViewLpbController viewLpb = new ViewLpbController();
    private ViewBskkController viewBskk = new ViewBskkController();
    private IjinInvestPageController invest;
    private AddNewInvestController add;
    private DetailInvestViewController detailInvest;
    private UserPageController userPage;
    
    public MainPageController(){
        invest = new IjinInvestPageController(this);
        add = new AddNewInvestController(this);
        userPage = new UserPageController();
        mainPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPage.getAddUserButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUserButtonActionPerformed(e);
            }
        });
        
        mainPage.getInvestButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                investButtonActionPerformed(e);
            }
        });
        mainPage.getLpbButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lpbButtonActionPerformed(e);
            }
        });
        mainPage.getBskkButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bskkButtonActionPerformed(e);
            }
        });
        mainPage.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
               if(invest.getIjinInvestPage().isVisible()){
                    invest.getIjinInvestPage().setSize(mainPage.getWorkBook().getSize());
                }
                if(add.getAddNewInvest().isVisible()){
                    add.getAddNewInvest().setSize(mainPage.getWorkBook().getSize());
                }
                if(userPage.getUserpage().isVisible()){
                    add.getAddNewInvest().setSize(mainPage.getWorkBook().getSize());
                }
                if(viewLpb.getLpb().isVisible()){
                    viewLpb.getLpb().setSize(mainPage.getWorkBook().getSize());
                }
            }
        });
        mainPage.setVisible(true);
    }
    private void investButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        mainPage.getWorkBook().removeAll();
        mainPage.getWorkBook().setUI(new DesktopPaneUI() {
            @Override
                public void installUI(JComponent c) {
                    // TODO Auto-generated method stub
                    try {
                        UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                    super.installUI(c);
                }   
            });
        mainPage.getWorkBook().add(invest.getIjinInvestPage());
        invest.getIjinInvestPage().setSize(mainPage.getWorkBook().getSize());
        invest.getAllData();
        invest.viewData();
        invest.getIjinInvestPage().setVisible(true);
    }    
    private void lpbButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        mainPage.getWorkBook().removeAll();
        mainPage.getWorkBook().add(viewLpb.getLpb(),java.awt.BorderLayout.NORTH);
        viewLpb.getLpb().setSize(mainPage.getWorkBook().getSize());
        viewLpb.getLpb().setVisible(true);
        mainPage.validate();
    }
    private void bskkButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        mainPage.getWorkBook().removeAll();
        mainPage.getWorkBook().add(viewBskk.getPage(),java.awt.BorderLayout.NORTH);
        viewBskk.getPage().setSize(mainPage.getWorkBook().getSize());
        viewBskk.getPage().setVisible(true);
        mainPage.validate();
    }
    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        mainPage.getWorkBook().removeAll();
        if(invest.getIjinInvestPage().isVisible()){
            invest.getIjinInvestPage().setVisible(false);
        }
        if(add.getAddNewInvest().isVisible()){
            add.getAddNewInvest().setVisible(false);
        }
        mainPage.getWorkBook().add(userPage.getUserpage());
        userPage.getAllData();
        userPage.viewDataOnTable();
        userPage.getUserpage().setVisible(true);
        userPage.getUserpage().setSize(mainPage.getWorkBook().getSize());
    }                                             
    public void addNewInvest(IjinInvestPage investPage){
        mainPage.getWorkBook().removeAll();
        if(invest.getIjinInvestPage().isVisible()){
            invest.getIjinInvestPage().setVisible(false);
        }
        if(userPage.getUserpage().isVisible()){
            userPage.getUserpage().setVisible(false);
        }
        mainPage.getWorkBook().add(add.getAddNewInvest());
        add.getAddNewInvest().setSize(mainPage.getWorkBook().getSize());
        add.getAddNewInvest().setVisible(true);
    }
    
    public void openInvestPage(Component comp){
        mainPage.getWorkBook().remove(comp);
        mainPage.getWorkBook().setUI(new DesktopPaneUI() {
            @Override
                public void installUI(JComponent c) {
                    // TODO Auto-generated method stub
                    try {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                    super.installUI(c);
                }   
            });
        mainPage.getWorkBook().add(invest.getIjinInvestPage());
        invest.getIjinInvestPage().setSize(mainPage.getWorkBook().getSize());
        invest.getAllData();
        invest.viewData();
        invest.getIjinInvestPage().setVisible(true);
        mainPage.getWorkBook().validate();
    }
    
    public void openDetailInvest(DetailInvestViewController detailInvest){
        mainPage.getWorkBook().removeAll();
        mainPage.getWorkBook().add(detailInvest.getDetailPage());
        detailInvest.getDetailPage().setSize(mainPage.getWorkBook().getSize());
        detailInvest.getDetailPage().setVisible(true);
    }
    
    public MainPage getParent(){
        return mainPage;
    }
}
