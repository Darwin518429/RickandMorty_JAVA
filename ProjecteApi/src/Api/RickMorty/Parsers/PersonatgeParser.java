package Api.RickMorty.Parsers;

import Api.ParserTemplate.Parser;
import Model.rickMortyDB.Personatge;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;


public class PersonatgeParser implements Parser<Personatge> {
;
public PersonatgeParser(){ }

    @Override
    public List<Personatge> getAll(String json ) throws Exception {
        List<Personatge> llista = new ArrayList<>();
;

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root    = mapper.readTree(json);
            JsonNode results = root.get("results");

            for (JsonNode node : results) {

                String originUrl   = node.get("origin").get("url").asText();
                String locationUrl = node.get("location").get("url").asText();

                // Treure els ids
                int idOrigen = (originUrl == null || originUrl.isEmpty() )? 0 :
                        Integer.parseInt(originUrl.substring(originUrl.lastIndexOf('/') + 1));

                int idLocation = (originUrl == null || locationUrl.isEmpty() )? 0 :
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



        return llista;
    }




    public  Personatge getPersonatge(String json , int id )  throws Exception{

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
            JsonNode results = root.get("results");
            for (JsonNode node : results) {
                if(node.get("id").asInt() == id ) {
                    String originUrl = node.get("origin").get("url").asText();
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
                    return p;
                }
            }

        return null;
    }

    public Personatge getPersonatge(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);

        String originUrl   = node.get("origin").get("url").asText();
        String locationUrl = node.get("location").get("url").asText();

        Integer idOrigen = originUrl.isEmpty() ? 0 :
                Integer.parseInt(originUrl.substring(originUrl.lastIndexOf('/') + 1));
        Integer idLocation = locationUrl.isEmpty() ? 0 :
                Integer.parseInt(locationUrl.substring(locationUrl.lastIndexOf('/') + 1));

        return new Personatge(
                node.get("id").asInt(),
                node.get("name").asText(),
                node.get("status").asText(),
                node.get("species").asText(),
                node.get("type").asText(),
                node.get("gender").asText(),
                idOrigen,
                idLocation
        );
    }
    // OBTINDRE LES DIFERENTS BD
public String getNextUrl(String json  ) throws Exception{


        ObjectMapper mapper = new ObjectMapper(); // Declarar aquest objecte per utilitzar jacksson
        JsonNode root    = mapper.readTree(json); // Navegar el json amb rutes igual amb XPATH
        JsonNode next = root.get("info").get("next");

        if (next.isNull()) return null;
        return next.asText();


}

}

