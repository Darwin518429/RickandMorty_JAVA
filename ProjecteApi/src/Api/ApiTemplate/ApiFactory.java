package Api.ApiTemplate;

import Api.ConnectionEndpoint.ApiConnection;
import Api.ConnectionEndpoint.ConnectionApi;
import Api.RickMorty.rickmortyclient;
import dbconfig.BDC.ConfigLoader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


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


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error de posar");
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
}
