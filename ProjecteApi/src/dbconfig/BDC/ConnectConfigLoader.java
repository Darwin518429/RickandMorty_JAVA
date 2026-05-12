package dbconfig.BDC;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectConfigLoader {

    private static final Map<String, Provider> providers = new HashMap<>();

    static {
        try {
            InputStream input = ConnectConfigLoader.class
                    .getClassLoader()
                    .getResourceAsStream("resources/db.properties");

            if (input == null) {
                throw new RuntimeException("No se ha trobat l'arxiu on es carregara les dades ");
            }

            Properties prop = new Properties();
            prop.load(input);

            // MYSQL aqui añadimos la base de datos msql en el map para cuando queramos usarla
            providers.put("mysql", new MySQL_DB_Credentials(
                    prop.getProperty("db.mysql.url"),
                    prop.getProperty("db.mysql.user"),
                    prop.getProperty("db.mysql.password")
            ));


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error cargando configuración de BD");
        }
    }

    //Este es el metodo que cuando utilizemos la interfaz ConnectionProvider nos dejara elegir cual base de datos queremos usar
    /**
     * @param type String  indicamos la tecnologia/SGBD que queramos acceder
     * @return Devuelve el objeto ConnectionProvider
     **/
    public static Provider getProvider(String type) {

        Provider provider = providers.get(type);  // Aqui le metemos del map los credenciales escogidos

        if (provider == null) {
            throw new RuntimeException("Tipo de BD no soportado: " + type); //en caso que no los encuentre o no esten implementados salta este error
        }

        return provider; // devolvemos el provedor que usara el provider para hacer la conexion
    }
}

