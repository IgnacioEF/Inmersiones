package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Buceadores;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BuceadoresController {
    
    public void AddBuceador(Buceadores c){
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
    
    public void deleteBuceador(int buceadoresid) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Buceadores b = (Buceadores) session.load(Buceadores.class, new Integer(buceadoresid));
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
    
    public void modifyBuceador(Buceadores c){
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
    
    public List<Buceadores> getBuceadores(){
        List<Buceadores> b = new ArrayList<Buceadores>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            b = session.createQuery("from Buceadores").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return b;
    }
    
    public static Buceadores getBuceadorById(int buceadoresid) {
        Buceadores buceador = null;
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            String queryString = "from Buceadores where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", buceadoresid);
            buceador = (Buceadores) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return buceador;
    }
}
