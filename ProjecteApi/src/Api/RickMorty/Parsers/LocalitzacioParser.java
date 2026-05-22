package Api.RickMorty.Parsers;

import Api.ParserTemplate.Parser;
import Model.rickMortyDB.Localitzacio;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class LocalitzacioParser implements Parser<Localitzacio> {
    public LocalitzacioParser(){}

    @Override
    public List<Localitzacio> getAll(String json ) throws Exception{
        List<Localitzacio> llista = new ArrayList<>();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root    = mapper.readTree(json);
            JsonNode results = root.get("results");

            for (JsonNode node : results) {

           Localitzacio l  = new Localitzacio(
                   node.get("id").asInt(),
                   node.get("name").asText(),
                   node.get("type").asText()
           );

           llista.add(l);
            }



        return llista;
    }


    public String getNextUrl(String json  ) throws Exception{

            ObjectMapper mapper = new ObjectMapper(); // Declarar aquest objecte per utilitzar jacksson
            JsonNode root    = mapper.readTree(json); // Navegar el json amb rutes igual amb XPATH
            JsonNode next = root.get("info").get("next");

            if (next.isNull()) return null;
            return next.asText();

    }
}
