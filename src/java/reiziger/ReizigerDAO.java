package reiziger;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ReizigerDAO {
    boolean save(Reiziger reiziger);
    boolean update(Reiziger reiziger);
    boolean delete(Reiziger reiziger);
    List<Reiziger> findByGbdatum(String datum);
    List<Reiziger> findAll();

}
