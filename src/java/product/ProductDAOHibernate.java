package product;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ovchipkaart.OvChipkaart;
import ovchipkaart.OvChipkaartDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ProductDAOHibernate implements ProductDAO{

    private Session session = null;

    public ProductDAOHibernate(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Product product){
        try{
            Transaction transaction = this.session.beginTransaction();
            session.save(product);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        try{
            Transaction transaction = this.session.beginTransaction();
            session.update(product);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Product product){
        try{
            Transaction transaction = this.session.beginTransaction();
            session.delete(product);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Product> findByOVChipkaart(OvChipkaart ovChipkaart) {
        try {
            Transaction transaction = this.session.beginTransaction();
            List<Product> producten = session.createQuery("FROM Product where OvChipkaarten = " + ovChipkaart).list();
            transaction.commit();
            return producten;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Product> findAll(){
        try {
            Transaction transaction = this.session.beginTransaction();
            List<Product> producten = session.createQuery("FROM Product ").list();
            transaction.commit();
            return producten;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }
}
