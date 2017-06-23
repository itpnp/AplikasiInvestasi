/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.dao.KeluarDao;
import aplikasiinvestasi.model.MasterKeluarBskk;
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
public class KeluarDaoImpl implements KeluarDao {
    private Session session;

    @Override
    public boolean save(MasterKeluarBskk keluar) {
        boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(keluar);
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
    public List<MasterKeluarBskk> getAllData() {
        List<MasterKeluarBskk> listKeluar = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listKeluar= session.createCriteria(MasterKeluarBskk.class,"keluar")
            .addOrder(Order.desc("keluar.idKeluar")).list();
            
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
        return listKeluar;
    }

    @Override
    public List<MasterKeluarBskk> findByMonthAndYear(String month, String year) {
        List<MasterKeluarBskk> listKeluar= new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listKeluar = session.createCriteria(MasterKeluarBskk.class, "keluar")
                    .add(Restrictions.eq("keluar.bulan", month))
                    .add(Restrictions.eq("keluar.tahun", year))
                    .addOrder(Order.desc("keluar.idKeluar")).list();
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
        return listKeluar;
    }

    @Override
    public boolean update(MasterKeluarBskk keluar) {
        boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(keluar);
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
