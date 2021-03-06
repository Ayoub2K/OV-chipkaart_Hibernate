package ovchipkaart;

import adres.Adres;
import org.hibernate.Session;
import org.hibernate.Transaction;
import product.Product;
import reiziger.Reiziger;
import reiziger.ReizigerDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OvChipkaarDAOHibernate implements OvChipkaartDAO{

    private Session session = null;

    public OvChipkaarDAOHibernate(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(OvChipkaart ovChipkaart){
        try{
            Transaction transaction = this.session.beginTransaction();
            session.save(ovChipkaart);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(OvChipkaart ovChipkaart)  {
        try{
            Transaction transaction = this.session.beginTransaction();
            session.update(ovChipkaart);
            transaction.commit();
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(OvChipkaart ovChipkaart) {
        try{
            Transaction transaction = this.session.beginTransaction();
            session.delete(ovChipkaart);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public OvChipkaart findByReiziger(Reiziger reiziger) {
        try {
            Transaction transaction = this.session.beginTransaction();
            OvChipkaart ovChipkaart = session.createQuery("FROM OvChipkaart WHERE reiziger.id = " + reiziger.id, OvChipkaart.class).getSingleResult();
            transaction.commit();
            return ovChipkaart;
        }catch (Exception e){

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<OvChipkaart> findByProduct(Product product) {
        try {
            Transaction transaction = this.session.beginTransaction();
            List<OvChipkaart> alleOvk = session.createQuery("FROM OvChipkaart ", OvChipkaart.class).getResultList();
            List<OvChipkaart> productOV = new ArrayList<>();
            for (OvChipkaart o : alleOvk) {
                if (o.getProducten().contains(product)) {
                    productOV.add(o);
                }
            }
            transaction.commit();
            return productOV;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<OvChipkaart> findAll(){
        try {
            Transaction transaction = this.session.beginTransaction();
            List<OvChipkaart> ovChipkaartList = session.createQuery("FROM OvChipkaart ").list();
            transaction.commit();
            return ovChipkaartList;
        }catch (Exception e){

            e.printStackTrace();
            return null;
        }
    }
}
