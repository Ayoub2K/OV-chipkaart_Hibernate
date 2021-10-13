package product;


import ovchipkaart.OvChipkaart;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ProductDAO {
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Product product);
    List<Product> findByOVChipkaart(OvChipkaart ovChipkaart);
    List<Product> findAll();
}
