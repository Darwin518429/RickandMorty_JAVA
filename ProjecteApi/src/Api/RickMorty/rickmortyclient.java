package Api.RickMorty;

import Api.ApiClientGeneric;
import Api.ApiClientInterface;
import Api.ConnectionEndpoint.ConnectionApi;
import Api.RickMorty.Parsers.PersonatgesParser;
import Model.rickMortyDB.Personatge;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class rickmortyclient  extends ApiClientGeneric implements ApiClientInterface, Apiclient_Personatge{
//CARPETA
    File carpeta = new File("./src/resources/Json");
    File rutes[] = carpeta.listFiles();
    //OBJECTES PROPIS DEL RICKMORTY
    PersonatgesParser parser = new PersonatgesParser();

    public  rickmortyclient(ConnectionApi api , String url ){
    super(api,url);
    }


@Override
public List<Personatge>  getAllPersonatge() throws Exception {
    List<Personatge> tots = new ArrayList<>();

String urlCanviat = url;

    while (urlCanviat != null && !urlCanviat.isBlank()) {
        String json = api.fetch(urlCanviat);           // fetch pagina actual
        tots.addAll(parser.get(json)); //  afegir els  20 de les pagines
        urlCanviat = parser.getNextUrl(json);     // termina fins estar buit
        System.out.println("pagina llegida");
        Thread.sleep(500); // FER UNA PAUSA PER CADA PAGINA
    }


    return tots;
}
//VIA ENPOINT MOSTRAR TOT EL JSON
@Override
    public List<String> getJsons() throws Exception{
        List<String> l = new ArrayList<>();

    String urlCanviat = url;

    while (urlCanviat != null && !urlCanviat.isBlank()) {
        String json = api.fetch(urlCanviat);           // fetch pagina actual
        String format = formatJson(json);
        l.add(format);
        urlCanviat = parser.getNextUrl(json);

        // termina fins estar buit
       // System.out.println("pagina llegida");
        Thread.sleep(500); // FER UNA PAUSA PER CADA PAGINA AIXO EL FEM PERQUE EL PROVEIDOR POT BLOQUEHAR SI DETECTA MOLTS PETICIONS


    }
    return  l;
}
public List<String>  jsonLocalAll() throws Exception{
List<String> l = new ArrayList<>();
for(File r : rutes) {
    String json = formatJson(api.fetchFile(r.getPath()));

    l.add(json);
}

return l;
}

private String formatJson(String json){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Object jsonObject = objectMapper.readValue(json, Object.class);
            String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
            return prettyJson;
        } catch ( JsonProcessingException e) {
            throw new RuntimeException(e);
        }
}
}
