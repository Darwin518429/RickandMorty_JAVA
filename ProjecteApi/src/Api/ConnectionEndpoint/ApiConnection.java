package Api.ConnectionEndpoint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnection implements ConnectionApi {

        @Override
        public  String fetch(String url) throws Exception {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection(); // Obrir conexio
            con.setRequestMethod("GET"); //Diferents comandes
            BufferedReader read  = new BufferedReader(new InputStreamReader(con.getInputStream())); // e permite leer el JSON línea a línea para luego poder tratarlo.
            StringBuilder sb = new StringBuilder(); //Afegeix  cada linia en el string es com un += pero eficient
            String linea;



            while ((linea = read.readLine()) != null) sb.append(linea);
            return sb.toString();
        }

    @Override
    public String fetchFile(String ruta) throws Exception {
        File file = new File(ruta);
        if (!file.exists()) throw new Exception("Fitxer no trobat: " + ruta);

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = br.readLine()) != null) sb.append(linea);
        br.close();
        return sb.toString();

    }


        }



