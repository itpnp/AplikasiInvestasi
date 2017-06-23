/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.dao.TerimaDao;
import aplikasiinvestasi.model.MasterTerima;
import aplikasiinvestasi.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rizaldi Habibie
 */
public class TerimaDaoImpl implements TerimaDao {

    private Session session;
    
    @Override
    public boolean save(MasterTerima terima) {
        boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(terima);
            session.getTransaction().commit();
            success = true;
            session.flush();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Error", JOptionPane.ERROR_MESSAGE, null);
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

    @Override
    public List<MasterTerima> findByMonth(String month, String year) {
        List<MasterTerima> listTerima= new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listTerima = session.createCriteria(MasterTerima.class, "terima")
                    .add(Restrictions.sqlRestriction("MONTH(tanggal) = '"+month+"' and YEAR(tanggal) = '"+year+"'"))
                    .addOrder(Order.desc("terima.tanggal")).list();
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listTerima;
    }

    @Override
    public List<MasterTerima> getAllData() {
        List<MasterTerima> listTerima = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listTerima= session.createCriteria(MasterTerima.class,"terima")
            .addOrder(Order.desc("terima.tanggal")).list();
            
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listTerima;
    }

    @Override
    public List<MasterTerima> findByYear(String year) {
        List<MasterTerima> listTerima= new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listTerima = session.createCriteria(MasterTerima.class, "terima")
                    .add(Restrictions.sqlRestriction("YEAR(tanggal) = '"+year+"'"))
                    .addOrder(Order.desc("terima.tanggal")).list();
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listTerima;
    }

    @Override
    public boolean update(MasterTerima terima) {
         boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(terima);
            session.getTransaction().commit();
            success = true;
            session.flush();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Error", JOptionPane.ERROR_MESSAGE, null);
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
