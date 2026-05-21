package Api.RickMorty.Parsers;

import Api.Parser;
import Model.rickMortyDB.Localitzacion;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class LocalitzacioParser implements Parser<Localitzacion> {
    public LocalitzacioParser(){}

    @Override
    public List<Localitzacion> getAll(String json ){
        List<Localitzacion> llista = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root    = mapper.readTree(json);
            JsonNode results = root.get("results");

            for (JsonNode node : results) {

           Localitzacion l  = new Localitzacion(
                   node.get("id_localitzacions").asInt(),
                   node.get("nom").asText(),
                   node.get("tipus").asText()
           );

           llista.add(l);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return llista;
    }

}
