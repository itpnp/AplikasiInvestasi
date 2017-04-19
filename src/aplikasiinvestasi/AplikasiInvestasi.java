/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi;

import aplikasiinvestasi.controller.LoginPageController;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rizaldi Habibie
 */
public class AplikasiInvestasi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
             UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
             e.printStackTrace();
         }
        LoginPageController login = new LoginPageController();
    }
}
