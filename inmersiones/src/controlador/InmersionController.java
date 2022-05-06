package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Buceadores;
import modelo.Inmersion;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

public class InmersionController {
    
    public void AddInmersion(Inmersion c){
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
    
    public void deleteInmersion(int inmersionid) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Inmersion b = (Inmersion) session.load(Inmersion.class, new Integer(inmersionid));
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
    
    public void modifyInmersion(Inmersion c){
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
    
    public List<Inmersion> getInmersiones(){
        List<Inmersion> b = new ArrayList<Inmersion>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            b = session.createQuery("from Inmersion").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return b;
    }
    
    public static Inmersion getInmersionById(int inmersionid) {
        Inmersion inmersion = null;
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            String queryString = "from Inmersion where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", inmersionid);
            inmersion = (Inmersion) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return inmersion;
    }
    
    public static void NM(int idB, int idI){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List buceadores = session.createCriteria(Buceadores.class)
        .add( Restrictions.like("id", idB ) )
        .list();

        Iterator itB = buceadores.iterator();
        Buceadores temp =(Buceadores) itB.next();
        
        List inmersiones = session.createCriteria(Inmersion.class)
        .add( Restrictions.like("id", idI ) )
        .list();

        Iterator itI = inmersiones.iterator();
        Inmersion temp1 =(Inmersion) itI.next();
        
        
        System.out.println("id buc: " + temp.getId() + "id inm: " + temp1.getId());
        
        temp.getInmersions().add(temp1);
        temp1.getBuceadoreses().add(temp);
        
        session.save(temp);
        session.save(temp1);
        
        session.getTransaction().commit();
        
        session.close();
        
    }
}
