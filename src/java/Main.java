import adres.Adres;
import adres.AdresDAO;
import adres.AdresDAOHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ovchipkaart.OvChipkaarDAOHibernate;
import ovchipkaart.OvChipkaart;
import ovchipkaart.OvChipkaartDAO;
import product.Product;
import product.ProductDAO;
import product.ProductDAOHibernate;
import reiziger.Reiziger;
import reiziger.ReizigerDAO;
import reiziger.ReizigerDAOHibernate;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.SQLException;
import java.util.List;

/**
 * Testklasse - deze klasse test alle andere klassen in deze package.
 *
 * System.out.println() is alleen in deze klasse toegestaan (behalve voor exceptions).
 *
 * @author tijmen.muller@hu.nl
 */
public class Main {
    // Creëer een factory voor Hibernate sessions.
    private static final SessionFactory factory;

    static {
        try {
            // Create a Hibernate session factory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retouneer een Hibernate session.
     *
     * @return Hibernate session
     * @throws HibernateException
     */
    private static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) throws SQLException {
        Session session = Main.getSession();
        testFetchAll();
        testDAOHibernate();

    }

    /**
     * P6. Haal alle (geannoteerde) entiteiten uit de database.
     */
    private static void testFetchAll() {
        Session session = getSession();
        try {
            Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                Query query = session.createQuery("from " + entityType.getName());

                System.out.println("[Test] Alle objecten van type " + entityType.getName() + " uit database:");
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                System.out.println();
            }
        } finally {
            session.close();
        }
    }

    private static void testDAOHibernate() {
        Session session = getSession();
        try {
            System.out.println("testDAOHibernate()");
            AdresDAOHibernate adao = new AdresDAOHibernate(session);
            OvChipkaarDAOHibernate ovdao = new OvChipkaarDAOHibernate(session);
            ProductDAOHibernate pdao = new ProductDAOHibernate(session);
            ReizigerDAOHibernate rdao = new ReizigerDAOHibernate(session);

            //create objecten
            String gbdatum = "2000-05-17";
            Reiziger Ayoub = new Reiziger(99,"A", "", "Aarkoub", java.sql.Date.valueOf(gbdatum));
            Adres adresAyoub = new Adres(989,"4545AS", "12", "KWWEG", "Gouda", Ayoub);
            String okdatum = "2000-05-17";
            OvChipkaart ovChipkaart = new OvChipkaart(165, java.sql.Date.valueOf(okdatum), 1, 30, Ayoub);
            Product testProduct = new Product(16885, "naam van product", "beschrijving", 22 );
            //delete
            ovdao.delete(ovChipkaart);
            pdao.delete(testProduct);
            adao.delete(adresAyoub);
            rdao.delete(Ayoub);

            //CREATE
            rdao.save(Ayoub);
            adao.save(adresAyoub);
            ovdao.save(ovChipkaart);
            pdao.save(testProduct);


            //UPDATE
            Ayoub.setTussenvoegsel("van der");
            rdao.update(Ayoub);

            ovChipkaart.setKlasse(2);

            System.out.println("ov pre producten:" + ovChipkaart.getProducten());
            ovChipkaart.addProduct(testProduct);
            System.out.println("na adden producten;" + ovChipkaart.getProducten());
            ovdao.update(ovChipkaart);
            System.out.println(            ovdao.update(ovChipkaart));
            System.out.println("na adden producten;" + ovChipkaart.getProducten());

            testProduct.setPrijs(50);

            testProduct.addOvChipkaarten(ovChipkaart);
            pdao.update(testProduct);

            adresAyoub.setHuisnummer("55a");
            adao.update(adresAyoub);


            //READ
            for (Reiziger r : rdao.findAll()){
                System.out.println(r);
            }
            for (Adres a : adao.findAll()){
                System.out.println(a);
            }

            System.out.println(adao.findByReiziger(Ayoub));
            System.out.println(ovdao.findByReiziger(Ayoub));
            for (Product p : pdao.findAll()){
                System.out.println(p);
            }

            System.out.println(ovdao.findByProduct(testProduct));

            System.out.println(pdao.findByOVChipkaart(ovChipkaart));

            //DElETE

            ovdao.delete(ovChipkaart);
            pdao.delete(testProduct);
            adao.delete(adresAyoub);
            rdao.delete(Ayoub);

        } finally {
            session.close();
        }
    }
}
