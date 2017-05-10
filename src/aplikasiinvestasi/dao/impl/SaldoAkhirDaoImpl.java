/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.dao.SaldoAkhirDao;
import aplikasiinvestasi.model.SaldoAkhir;
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
public class SaldoAkhirDaoImpl implements SaldoAkhirDao {
    private Session session;

    @Override
    public boolean save(SaldoAkhir saldo) {
        boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(saldo);
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
    public List<SaldoAkhir> getAllData() {
        List<SaldoAkhir> listSaldo = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listSaldo = session.createCriteria(SaldoAkhir.class,"terima")
            .addOrder(Order.asc("terima.id")).list();
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
        return listSaldo;
    }

    @Override
    public List<SaldoAkhir> findByMonthAndYear(String month, String year) {
        List<SaldoAkhir> listSaldo= new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listSaldo = session.createCriteria(SaldoAkhir.class, "terima")
                    .add(Restrictions.eq("terima.bulan", month))
                    .add(Restrictions.eq("terima.tahun", year))
                    .addOrder(Order.asc("terima.id")).list();
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
        return listSaldo;        
    }
    
}
