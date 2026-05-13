package Api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
public class ApiClient {

        public static String fetch(String url) throws Exception {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection(); // Obrir conexio
            con.setRequestMethod("GET"); //Diferents comandes
            BufferedReader read  = new BufferedReader(new InputStreamReader(con.getInputStream())); // e permite leer el JSON línea a línea para luego poder tratarlo.
            StringBuilder sb = new StringBuilder(); //Afegeix  cada linia en el string es com un += pero eficient
            String linea;
            while ((linea = read.readLine()) != null) sb.append(linea);
            return sb.toString();
        }



    /*
    * api/
    APIClient.java        → hace el fetch genérico
    Parser.java           → interfaz que cada API implementa
    rickandmorty/
    RickAndMortyParser.java   → parsea el JSON de esta API concreta
    PersonatgeDAO.java
    Personatge.java
    */
}
