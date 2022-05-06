package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Monitor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MonitorController {
    
    public void AddMonitor(Monitor c){
        Transaction trans = null;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        try{
            trans = session.beginTransaction();
            session.save(c);
            trans.commit();
        }catch(RuntimeException e){
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally{
            session.close();
        }
    }
    
    public void deleteMonitor(int monitorid) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Monitor b = (Monitor) session.load(Monitor.class, new Integer(monitorid));
            session.delete(b);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public void modifyMonitor(Monitor c){
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(c);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public List<Monitor> getMonitor(){
        List<Monitor> b = new ArrayList<Monitor>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            b = session.createQuery("from Monitor").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return b;
    }
    
    public Monitor getMonitorById(int monitorid) {
        Monitor monitor = null;
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            String queryString = "from Monitor where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", monitorid);
            monitor = (Monitor) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return monitor;
    }
}
