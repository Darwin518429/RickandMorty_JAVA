package Api.RickMorty;

import Api.Parser;
import Model.rickMortyDB.Personatge;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;


public class PersonatgesParser implements Parser<Personatge> {
;
public PersonatgesParser(){ }

    @Override
    public List<Personatge> ElementperPage(String json ) {
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
                Integer idOrigen = originUrl.isEmpty() ? null :
                        Integer.parseInt(originUrl.substring(originUrl.lastIndexOf('/') + 1));

                Integer idLocation = locationUrl.isEmpty() ? null :
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


}

