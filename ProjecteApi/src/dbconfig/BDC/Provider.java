package dbconfig.BDC;

import java.sql.Connection;
import java.sql.SQLException;

public interface Provider  {
    Connection getConnection () throws SQLException;
}
