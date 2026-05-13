import Api.ApiClient;
import Api.RickMorty.RickMortyParser;
import Model.rickMortyDB.Personatges;
import dbconfig.BDC.ConnectConfigLoader;
import dbconfig.BDC.Provider;
import implementation.mysql.rickmorty.mysql_impl_rm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     /*   Provider p  = ConnectConfigLoader.getProvider("mysql");
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
        }*/

        RickMortyParser parser= new RickMortyParser();
        mysql_impl_rm dao = new mysql_impl_rm();
        try {
            String api = Api.ApiClient.fetch("https://rickandmortyapi.com/api/character");

            List<Personatges> ll = parser.allPersonatges(api)   ;
          for(Personatges p : ll){
              System.out.println(p.getId_localtizacio());
          }
              dao.insertarTots(ll);

        }
        catch (Exception e ){
            System.out.println(e);
            System.out.println("Error: " + e.getMessage());
        }

    }
}