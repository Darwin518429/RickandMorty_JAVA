package AppConfig;
import dbconfig.BDC.Provider;
import implementation.mysql.rickmorty.*;
//Aqui es on careguem els daos especifics
public class DAOLoader {
    public static mysqlPersonatge  getmysqlPersonatge(String dbType, Provider provider) {
        switch (dbType) {

            case "mysql":
                return new mysqlPersonatge(provider);

            case "mongodb":
                throw new RuntimeException("mongodb no implementat");

            default:
                throw new RuntimeException("BD no soportada: " + dbType);
        }
    }

    public static mysqlLocalitzacion getmysqllocalitzacio(String dbType, Provider provider) {
        switch (dbType) {

            case "mysql":
                return new mysqlLocalitzacion(provider);

            case "mongodb":
                throw new RuntimeException("mongodb no implementat");

            default:
                throw new RuntimeException("Bd no soportada  " + dbType);
        }
    }

}
