package Api.ApiTemplate;

import Api.ConnectionEndpoint.ApiConnection;
import Api.ConnectionEndpoint.ConnectionApi;
import Api.RickMorty.rickmortyclient;
import dbconfig.BDC.ConfigLoader;

import java.io.InputStream;
import java.util.*;


public class ApiFactory {
//Aqui es donde especificamos cual quereos acceder
private static final Map<String, ApiClientGeneric> clients = new HashMap<>();
//API CLIENTS
private static ConnectionApi api = new ApiConnection();

    static {
        try {
            InputStream input = ConfigLoader.class
                    .getClassLoader()
                    .getResourceAsStream("resources/api.properties");

            if (input == null) {
                throw new RuntimeException("No se ha trobat l'arxiu on es carregara les dades ");
            }

            Properties prop = new Properties();
            prop.load(input);

            //Afegim api
            clients.put(prop.getProperty("api.rickmorty.nom"),
                    new rickmortyclient(api,
                    prop.getProperty("api.rickmorty.url.character"),
                    prop.getProperty("api.rickmorty.url.location"),
                    prop.getProperty("api.rickmorty.url.episode")
                    )
            );
            for (ApiClientGeneric client : clients.values()) {
                for (int i = 0; i < client.lengthUrl(); i++) {
                    //System.out.println("DEBUG URL: " + client.getUrl(i));
                    isUrl(client.getUrl(i));
                }
            }

        } catch (Exception e) {
           // e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            System.exit(1); // ← tanca el programa net
        }
    }

    /**
     * @param type String  acceidr la api que volem
     * @return ApiClientGeneric
     **/
    public static ApiClientGeneric getApi(String type) {

      ApiClientGeneric client = clients.get(type);
        if (client  == null) {
            throw new RuntimeException("API:  " + type);
        }

        return client ; // devolvemos el provedor que usara el provider para hacer la conexion
    }


    private static void isUrl(String nom ) throws Exception{
        if(!nom.matches("^https://[A-Za-z0-9._-]+(/.*)?$")) throw new Exception("ERROR de la url sintaxis ");
    }
}
