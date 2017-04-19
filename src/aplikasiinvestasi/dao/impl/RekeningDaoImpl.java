/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.dao.RekeningDao;
import aplikasiinvestasi.model.MasterRekening;
import aplikasiinvestasi.utils.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rizaldi Habibie
 */
public class RekeningDaoImpl implements RekeningDao{
    
    private Session session;
    
    @Override
    public boolean checkRekening(String kodeRekening) {
        boolean success = false;
        MasterRekening rekening;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            rekening = (MasterRekening) session.createCriteria(MasterRekening.class)
                    .add(Restrictions.eq("noRekening", kodeRekening)).uniqueResult();
            if(rekening == null){
                success = false;
            }else{
                success = true;
            }
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database " +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return success;
    }
    
}
