import Api.RickMorty.rickmortyclient;
import AppConfig.Appconfig;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     /*   Provider p  = ConfigLoader.getProvider("mysql");
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
/*
        PersonatgesParser parser= new PersonatgesParser();
        mysqlPersonatge dao = new mysqlPersonatge();
        try {
            String api = Api.ApiConnection.fetch("https://rickandmortyapi.com/api/character");

            List<Personatge> ll = parser.allPersonatges(api)   ;
          for(Personatge p : ll){
              System.out.println(p.getId_localtizacio());
          }
              dao.insertarTots(ll);

        }
        catch (Exception e ){
            System.out.println(e);
            System.out.println("Error: " + e.getMessage());
        }
*/
      //  rickmortyclient rm = new rickmortyclient();
      /*  try {
            rm.Arrencar();
        }
        catch (Exception e ){
            System.out.println(e);
        }*/
        Appconfig.personatgecontroller().copiaPersonatgeEndpoint();
    }
}