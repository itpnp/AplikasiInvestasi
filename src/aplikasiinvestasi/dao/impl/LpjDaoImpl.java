/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.dao.LpjDao;
import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpj;
import aplikasiinvestasi.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rizaldi Habibie
 */
public class LpjDaoImpl implements LpjDao {

    private Session session;
    
    @Override
    public boolean saveData(MasterLpj masterLpj) {
        boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(masterLpj);
            session.getTransaction().commit();
            success = true;
        }catch(  HibernateException | ExceptionInInitializerError e){
            success = false;
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
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
    public List<MasterLpj> getAllData() {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createCriteria(MasterLpj.class).list();
            for(MasterLpj lpj : listLpj){
                if(lpj.getMasterInvest() != null){
                    Hibernate.initialize(lpj.getMasterInvest());
                }
                Hibernate.initialize(lpj.getMasterDepartemen());
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listLpj;
    }

    @Override
    public List<MasterLpj> getAllDataByMonthAndYear(String month, String year) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createQuery("from MasterLpj where MONTH(tanggal) = '"+month+"' and YEAR(tanggal) = '"+year+"' order by kode_rekening").list();
            if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
                    }
                }
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listLpj;
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumber(String investNumber) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createCriteria(MasterLpj.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber)).list();
             if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
                    }
                }
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listLpj;
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumberAndYear(String investNumber, String year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumberAndMonth(String investNumber, String month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumberAndYearAndMonth(String investNumber, String year, String month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TotalKredit> countAllCredit() {
        List<TotalKredit> listCredit = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("SELECT kode_rekening, MONTHNAME( tanggal ) as bulan , YEAR( tanggal ) as tahun, SUM( debet ) as kredit " 
                                        +"FROM master_lpj "
                                        +"GROUP BY kode_rekening, MONTHNAME( tanggal ) , YEAR( tanggal ) ");
            List<Object[]> rows = query.list();
            for(Object[] obj : rows){
                TotalKredit kredit = new TotalKredit();
                kredit.setKodeRekening(obj[0].toString());
                kredit.setBulan(obj[1].toString());
                kredit.setTahun(obj[2].toString());
                kredit.setKredit(Long.parseLong(obj[3].toString()));
                listCredit.add(kredit);
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listCredit;
    }

    @Override
    public List<TotalKredit> countCreditByMonthAndYear(String month, String year) {
        List<TotalKredit> listCredit = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("SELECT kode_rekening, MONTHNAME( tanggal ) as bulan , YEAR( tanggal ) as tahun, SUM( debet ) as kredit " 
                                        +"FROM master_lpj where MONTH(tanggal) = '"+month+"' and YEAR(tanggal)='"+year+"'"
                                        +"GROUP BY kode_rekening, MONTHNAME( tanggal ) , YEAR( tanggal ) ");
            List<Object[]> rows = query.list();
            for(Object[] obj : rows){
                TotalKredit kredit = new TotalKredit();
                kredit.setKodeRekening(obj[0].toString());
                kredit.setBulan(obj[1].toString());
                kredit.setTahun(obj[2].toString());
                kredit.setKredit(Long.parseLong(obj[3].toString()));
                listCredit.add(kredit);
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listCredit;
    }

    @Override
    public Long countDebet(MasterInvest masterInvest) {
        Long totalDebet = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("select SUM(debet) as total from master_lpj where kode_invest = '"+masterInvest.getKodeInvest()+"'");
            if(query.uniqueResult()!= null){
                totalDebet = Long.parseLong(""+query.uniqueResult());
            }else{
                totalDebet = Long.parseLong("0");
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return totalDebet;
    }

    @Override
    public void updateData(MasterLpj masterLpj) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(masterLpj);
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Suuccess", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database " +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
    }

    @Override
    public List<MasterLpj> getAllDataByMonth(String month) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createQuery("from MasterLpj where MONTH(tanggal) = '"+month+"' order by kode_rekening").list();
            if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
                    }
                }
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listLpj;
    }

    @Override
    public List<MasterLpj> getAllDataByYear(String year) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createQuery("from MasterLpj where YEAR(tanggal) = '"+year+"' order by kode_rekening").list();
            if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
                    }
                }
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listLpj;
    }

    @Override
    public boolean saveInBatch(List<MasterLpj> listMaster) {
        boolean success = false;
         for(MasterLpj lpj : listMaster){
             if(saveData(lpj)){
                 success = true;
             }else{
                 success = false;
                 break;
             }
         }
         if(success){
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Suuccess", JOptionPane.INFORMATION_MESSAGE, null);
         }else{
            JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
         }
         return success;
    }

    @Override
    public List<MasterLpj> findByYearMonthRekening(String year, String month, String rekening) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createCriteria(MasterLpj.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.sqlRestriction("MONTH(tanggal) = '"+month+"'"))
                    .add(Restrictions.sqlRestriction("Year(tanggal) = '"+year+"'"))
                    .add(Restrictions.eq("kodeRekening",rekening)).list();
             if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
                    }
                }
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listLpj;
    }
    
}
