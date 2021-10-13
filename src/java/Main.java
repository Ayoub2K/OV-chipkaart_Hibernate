import adres.Adres;
import adres.AdresDAOHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ovchipkaart.OvChipkaarDAOHibernate;
import product.ProductDAOHibernate;
import reiziger.Reiziger;
import reiziger.ReizigerDAOHibernate;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.SQLException;

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
        //testFetchAll();
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
            AdresDAOHibernate adao = new AdresDAOHibernate(getSession());
            OvChipkaarDAOHibernate ovdao = new OvChipkaarDAOHibernate(getSession());
            ProductDAOHibernate pdao = new ProductDAOHibernate(getSession());
            ReizigerDAOHibernate rdao = new ReizigerDAOHibernate(getSession());

            //create objecten
            String gbdatum = "2000-05-17";
            Reiziger Ayoub = new Reiziger(99,"A", "", "Aarkoub", java.sql.Date.valueOf(gbdatum));
            Adres adresAyoub = new Adres(989,"4545AS", "12", "KWWEG", "Gouda", Ayoub);


            // saves
            rdao.save(Ayoub);
            adao.save(adresAyoub);

            System.out.println(rdao.findAll());
            System.out.println(adao.findByReiziger(Ayoub));


            //delete everything

            adao.delete(adresAyoub);
            rdao.delete(Ayoub);

        } finally {
            session.close();
        }
    }
}
