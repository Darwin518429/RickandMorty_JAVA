package Api.RickMorty;

import Api.Parser;
import Model.rickMortyDB.Personatges;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;


public class RickMortyParser implements Parser<Personatges> {
public RickMortyParser (){}
    @Override
    public List<Personatges> allPersonatges(String json) {
        List<Personatges> llista = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root    = mapper.readTree(json);
            JsonNode results = root.get("results");

            for (JsonNode node : results) {

                String originUrl   = node.get("origin").get("url").asText();
                String locationUrl = node.get("location").get("url").asText();

                // Sacas los IDs del final de cada URL
                int idOrigen = originUrl.isEmpty() ? null :
                        Integer.parseInt(originUrl.substring(originUrl.lastIndexOf('/') + 1));

                int idLocation = locationUrl.isEmpty() ? null :
                        Integer.parseInt(locationUrl.substring(locationUrl.lastIndexOf('/') + 1));

                Personatges p = new Personatges(
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
    /*
@Override
public  List<Personatges> allPersonatges(String json  ){
    json = json.replace("{", "").replace("}", "").trim();
       List<Personatges> pr = new ArrayList<>();
    //RETALLA EL COMIENZO
    String txt = "\"results\":[";
    int start = json.indexOf(txt) + txt.length() ;
    int end   = json.lastIndexOf(']');
    String results = json.substring(start, end);

    // 2. Separamos cada personaje en un String individual
    String[] objectes = results.split("\\},\\{");
    System.out.println(objectes[3]);

    // 3. Recorremos cada personaje
    for (String obj : objectes) {
        Personatges p = new Personatges(Integer.parseInt(extraer(obj, "\"id\":")),
                extraerStr(obj, "\"name\":"),
                extraerStr(obj, "\"status\":"),
                extraerStr(obj, "\"species\":"),
                extraerStr(obj, "\"type\":"),
                extraerStr(obj, "\"gender\":"),
               Integer.parseInt( extraerStrAnidado(obj,"\"origin\":")),
                Integer.parseInt( extraerStrAnidado(obj,"\"location\":"))


        );


        pr.add(p);
    }

    return pr;
}*/
/**
@Override
public Personatges getPersonatge(int id ){

}*/
private String extraer(String obj, String key) {
    int i = obj.indexOf(key);
    if (i < 0) return "0";
    int inicio = i + key.length();
    int fin    = obj.indexOf(',', inicio);
    if (fin < 0) fin = obj.length();
    return obj.substring(inicio, fin).trim().replaceAll("\"", "");
}

    private String extraerStr(String obj, String key) {
        int i = obj.indexOf(key);
        if (i < 0) return "";
        int inicio = obj.indexOf('"', i + key.length()) + 1;
        int fin    = obj.indexOf('"', inicio);
        return obj.substring(inicio, fin);
    }

    private String extraerStrAnidado(String obj, String key) {
        int i = obj.indexOf(key);
        if (i < 0) return "";
        int nameIdx = obj.indexOf("\"name\":", i);
        if (nameIdx < 0) return "";
        int inicio = obj.indexOf('"', nameIdx + 7) + 1;
        int fin    = obj.indexOf('"', inicio);
        return obj.substring(inicio, fin);
    }
}

