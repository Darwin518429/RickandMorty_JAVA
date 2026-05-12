import dbconfig.BDC.ConnectConfigLoader;
import dbconfig.BDC.Provider;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Provider p  = ConnectConfigLoader.getProvider("mysql");
        try(
        Connection c = p.getConnection()
        ){
            System.out.println("Funciona");

        }
        catch ( SQLException e ){
            System.out.println("Error");
            System.out.println("Error SQL: " + e.getMessage());
            System.out.println("Código de error: " + e.getErrorCode());
            System.out.println("SQLState: " + e.getSQLState());
        }
    }
}