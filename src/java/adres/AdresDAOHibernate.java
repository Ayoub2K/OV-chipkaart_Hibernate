package adres;

import org.hibernate.Session;
import org.hibernate.Transaction;
import reiziger.Reiziger;
import reiziger.ReizigerDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class AdresDAOHibernate implements AdresDAO{

    private Session session = null;

    public AdresDAOHibernate(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Adres adres) {
        try{
            Transaction transaction = this.session.beginTransaction();
            session.save(adres);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Adres adres){
        try{
            Transaction transaction = this.session.beginTransaction();
            session.update(adres);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Adres adres){
        try{
            Transaction transaction = this.session.beginTransaction();
            session.delete(adres);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        try {
            Transaction transaction = this.session.beginTransaction();
            Adres adres = session.createQuery("FROM Adres WHERE reiziger.id = " + reiziger.id, Adres.class).getSingleResult();
            transaction.commit();
            return adres;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Adres> findAll(){
        try {
            Transaction transaction = this.session.beginTransaction();
            List<Adres> adressen = session.createQuery("FROM Adres").list();
            transaction.commit();
            return adressen;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }
}
