package Api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ApiClient  {

        public  static String fetch(String url) throws Exception {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection(); // Obrir conexio
            con.setRequestMethod("GET"); //Diferents comandes
            BufferedReader read  = new BufferedReader(new InputStreamReader(con.getInputStream())); // e permite leer el JSON línea a línea para luego poder tratarlo.
            StringBuilder sb = new StringBuilder(); //Afegeix  cada linia en el string es com un += pero eficient
            String linea;
            while ((linea = read.readLine()) != null) sb.append(linea);
            return sb.toString();
        }


    public static List<String> fecthall(String baseUrl , Function<String, String> nextUrlExtractor) throws Exception{
        List<String> jsons = new ArrayList<>();

        String url = baseUrl;

        while (url != null) {
            String json = fetch(url);
            jsons.add(json);
            url = nextUrlExtractor.apply(json); // cada uno sabe cómo sacar la siguiente URL
        }

        return jsons;
    }


        }



