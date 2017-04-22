/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterCredential;
import aplikasiinvestasi.service.UserService;
import aplikasiinvestasi.service.impl.UserServiceImpl;
import aplikasiinvestasi.utils.ButtonColumns;
import aplikasiinvestasi.utils.Privilege;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.UserPage;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rizaldi Habibie
 */
public class UserPageController {
    private UserPage userPage;
    private UserService userService;
    private List<MasterCredential> listCredential;
    
    public UserPageController(){
        userPage = new UserPage();
        userService = new UserServiceImpl();
        userPage.getAksesField().setModel(new DefaultComboBoxModel(Privilege.hakAkses()));
        userPage.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveButton(e);
            }
        });
    }
    
    public UserPage getUserpage(){
        userPage.setTitle("Halaman Pengguna");
        return userPage;
    }
    public void saveButton(java.awt.event.ActionEvent e){
        MasterCredential masterCredential = new MasterCredential();
        masterCredential.setPrivilegeCode("ADM"+userService.generateUserId());
        masterCredential.setUsername(userPage.getUsernameField().getText());
        masterCredential.setPassword(userPage.getPassField().getText());
        masterCredential.setPrivilege(userPage.getAksesField().getSelectedItem().toString());
        userService.addCredential(masterCredential);
        listCredential = userService.viewAllUser();
        viewDataOnTable();
    }
    
    public void viewDataOnTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode User");
        model.addColumn("Username");
        model.addColumn("Hak Akses");
        model.addColumn("Status");
        model.addColumn("Action");
        for(MasterCredential master : listCredential){
            Object[] obj = new Object[5];
            obj[0] = master.getPrivilegeCode();
            obj[1] = master.getUsername();
            obj[2] = master.getPrivilege();
            obj[3] = master.getStatus();
            if(master.getStatus().equals("AKTIF")){
                obj[4] = "Non Aktifkan";
            }else{
                obj[4] = "Aktifkan";
            }
               model.addRow(obj);
        }
        userPage.getViewTable().setModel(model);
        JTableHeader jheader = userPage.getViewTable().getTableHeader();
        jheader.setDefaultRenderer(new TableHeaderRenderer());
        Action changeStatus = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                changeStatus(listCredential.get(modelRow));
                getAllData();
                viewDataOnTable();
            }
        };
        
       ButtonColumns statusButton = new ButtonColumns(userPage.getViewTable(), changeStatus, 4);
       statusButton.setMnemonic(KeyEvent.VK_D);
    }
    
    public void getAllData(){
        listCredential = userService.viewAllUser();
    }
    
    public void changeStatus(MasterCredential user){
        if(user.getStatus().equals("AKTIF")){
            user.setStatus("NON AKTIF");
        }else{
            user.setStatus("AKTIF");
        }
        userService.update(user);
    }

}
