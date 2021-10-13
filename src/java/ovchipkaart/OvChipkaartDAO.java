package ovchipkaart;

import product.Product;
import reiziger.Reiziger;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface OvChipkaartDAO {

    boolean save(OvChipkaart ovChipkaart);
    boolean update(OvChipkaart ovChipkaart);
    boolean delete(OvChipkaart ovChipkaart);
    OvChipkaart findByReiziger(Reiziger reiziger);
    List<OvChipkaart> findByProduct(Product product);
    List<OvChipkaart> findAll();
}
