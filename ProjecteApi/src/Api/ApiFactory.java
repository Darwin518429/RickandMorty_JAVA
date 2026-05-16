package Api;

import Api.RickMorty.rickmortyclient;
import dbconfig.BDC.ConfigLoader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ApiFactory {
//Aqui es donde especificamos cual quereos acceder
private static final Map<String, ApiClientInterface> clients = new HashMap<>();
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

            // MYSQL aqui añadimos la base de datos msql en el map para cuando queramos usarla
            clients.put(prop.getProperty("api.rickmorty.nom"), new rickmortyclient(api, prop.getProperty("api.rickmorty.url"))) ;


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error cargando configuración de BD");
        }
    }

    /**
     * @param type String  indicamos la tecnologia/SGBD que queramos acceder
     * @return Devuelve el objeto ConnectionProvider
     **/
    public static ApiClientInterface getApi(String type) {

      ApiClientInterface client = clients.get(type);
        if (client  == null) {
            throw new RuntimeException("API : " +" "+ type);
        }

        return client ; // devolvemos el provedor que usara el provider para hacer la conexion
    }


 /*   private static ConnectionApi api  = new ApiConnection();
    static {
        clients.put("rickmorty", new rickmortyclient(api , "https://rickandmortyapi.com/api/character"));
        // clients.put("pokemon", new pokemonClient(apiClient, "https://pokeapi.co/api/v2/pokemon"));
    }
    public static ApiClientInterface getApi(String api ) {
        return clients.get(api);
    }*/
/*private void introduir_comrprovar(String key, ) throws  Exception {
    clients.put("rickmorty", new rickmortyclient(apiClient, "https://rickandmortyapi.com/api/character"));
}*/
}
