package Api.ConnectionEndpoint;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileReader implements  ConnectionApi {

    @Override
    public String fetch(String ruta) throws Exception {
        Gson gson = new Gson();
      //  BrawlersWrapper wrapper = gson.fromJson(reader, BrawlersWrapper.class);
        /*
        *  try (FileReader reader = new FileReader("nous_brawlers.json")) {


            for (Brawler b : wrapper.getBrawlers()) {
                System.out.println("Nom: " + b.getNom());
                System.out.println("Raritat: " + b.getRaritat());
                System.out.println("Vida: " + b.getVida());
                System.out.println("Atac: " + b.getAtac());
                System.out.println("-----------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        * */
        return "";
    }
}
