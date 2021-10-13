package reiziger;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO{

    private Session session = null;

    public ReizigerDAOHibernate(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Reiziger reiziger) {
        try{
            Transaction transaction = this.session.beginTransaction();
            session.save(reiziger);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Reiziger reiziger) {
        try{
            Transaction transaction = this.session.beginTransaction();
            session.update(reiziger);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        try{
            Transaction transaction = this.session.beginTransaction();
            session.delete(reiziger);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Reiziger> findByGbdatum(String datum) {
        try {
            Transaction transaction = this.session.beginTransaction();
            List<Reiziger> reizigers = session.createQuery("FROM Reiziger WHERE geboortedatum = " + datum).list();
            transaction.commit();
            return reizigers;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Reiziger> findAll() {
        try {
            Transaction transaction = this.session.beginTransaction();
            List<Reiziger> reizigers = session.createQuery("FROM Reiziger").list();
            transaction.commit();
            return reizigers;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }
}
