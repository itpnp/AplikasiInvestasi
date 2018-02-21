/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.dao.DepartemenDao;
import aplikasiinvestasi.model.MasterCredential;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.utils.HibernateUtil;
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
public class DepartemenDaoImpl implements DepartemenDao{

    private Session session;
    @Override
    public List<MasterDepartemen> getAllData() {
        List<MasterDepartemen> listDepartemen = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listDepartemen = session.createCriteria(MasterDepartemen.class).list();
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }catch(ExceptionInInitializerError e){
           JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listDepartemen;
    }

    @Override
    public List<MasterDepartemen> getDataByUnit(String unit) {
        List<MasterDepartemen> listDepartemen = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listDepartemen = session.createCriteria(MasterDepartemen.class).add(Restrictions.eq("unit", unit)).list();
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }catch(ExceptionInInitializerError e){
           JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listDepartemen;
    }

    @Override
    public MasterDepartemen findByCode(String code) {
        MasterDepartemen departemen = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            departemen = (MasterDepartemen)session.createCriteria(MasterDepartemen.class).add(Restrictions.eq("kodeDepartement", code)).uniqueResult();
           session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return departemen;
    }
    
}
