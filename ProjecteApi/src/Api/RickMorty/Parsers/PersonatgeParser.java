package Api.RickMorty.Parsers;

import Api.Parser;
import Model.rickMortyDB.Personatge;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;


public class PersonatgeParser implements Parser<Personatge> {
;
public PersonatgeParser(){ }

    @Override
    public List<Personatge> get(String json ) {
        List<Personatge> llista = new ArrayList<>();
;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root    = mapper.readTree(json);
            JsonNode results = root.get("results");

            for (JsonNode node : results) {

                String originUrl   = node.get("origin").get("url").asText();
                String locationUrl = node.get("location").get("url").asText();

                // Sacas los IDs del final de cada URL
                Integer idOrigen = originUrl.isEmpty() ? 0 :
                        Integer.parseInt(originUrl.substring(originUrl.lastIndexOf('/') + 1));

                Integer idLocation = locationUrl.isEmpty() ? 0 :
                        Integer.parseInt(locationUrl.substring(locationUrl.lastIndexOf('/') + 1));

                Personatge p = new Personatge(
                        node.get("id").asInt(),
                        node.get("name").asText(),
                        node.get("status").asText(),
                        node.get("species").asText(),
                        node.get("type").asText(),
                        node.get("gender").asText(),
                        idOrigen,
                        idLocation
                );
                llista.add(p);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return llista;
    }

public String getNextUrl(String json  ){

    try {
        ObjectMapper mapper = new ObjectMapper(); // Declarar aquest objecte per utilitzar jacksson
        JsonNode root    = mapper.readTree(json); // Navegar el json amb rutes igual amb XPATH
        JsonNode next = root.get("info").get("next");

        if (next.isNull()) return null;
        return next.asText();
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        return null;
    }

}

    public String getPrevUrl(String json){

        try {
            ObjectMapper mapper = new ObjectMapper(); // Declarar aquest objecte per utilitzar jacksson
            JsonNode root    = mapper.readTree(json); // Navegar el json amb rutes igual amb XPATH

            return  root.get("info").get("next").asText();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }
}

