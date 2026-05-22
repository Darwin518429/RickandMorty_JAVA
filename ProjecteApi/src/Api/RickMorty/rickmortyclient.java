package Api.RickMorty;

import Api.ApiTemplate.ApiClientGeneric;
import Api.ApiTemplate.ApiClientInterface;
import Api.ConnectionEndpoint.ConnectionApi;
import Api.RickMorty.Parsers.LocalitzacioParser;
import Api.RickMorty.Parsers.PersonatgeParser;
import Model.rickMortyDB.Localitzacio;
import Model.rickMortyDB.Personatge;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class rickmortyclient  extends ApiClientGeneric implements ApiClientInterface, Apiclient_Personatge,Apiclient_Localitzacio{
//CARPETA
    File carpeta = new File("./src/resources/Json");
    File[] rutes = carpeta.listFiles();
   //CLIENT
    /*
     0=https://rickandmortyapi.com/api/character
     1=https://rickandmortyapi.com/api/location
     2=https://rickandmortyapi.com/api/episode
    */
String urlPersonatge = url[0];
String urlLocation = url[1];
String urlEpisode = url[2];

    //OBJECTES PROPIS DEL RICKMORTY
    PersonatgeParser parserP = new PersonatgeParser();
    LocalitzacioParser parserL = new LocalitzacioParser();
    public  rickmortyclient(ConnectionApi api , String ...url ){
        super(api,url);
    }



//VIA ENPOINT Personatge
    @Override
    public List<Personatge> getAllPersonatgeApi() throws Exception {
        List<Personatge> tots = new ArrayList<>();

        String urlCanviat = urlPersonatge;

        while (urlCanviat != null && !urlCanviat.isBlank()) {
            String json = api.fetch(urlCanviat);           // fetch pagina actual
            tots.addAll(parserP.getAll(json)); //  afegir els  20 de les pagines
            urlCanviat = parserP.getNextUrl(json);     // termina fins estar buit
            Thread.sleep(500); // FER UNA PAUSA PER CADA PAGINA
        }


        return tots;
    }



public Personatge getPersonatgeApi(int id ) throws Exception{

        String url = urlPersonatge + "/" + id;
        String json = api.fetch(url);
        return parserP.getPersonatge(json); // parser per un sol personatge

}

//Mostrar contingut fonts
    public List<Personatge>  getFontpi() throws Exception{
        List<Personatge> p = new ArrayList<>();
        List<String> jsons  = getJsonsPersonatgeApi();
        for(String j : jsons){
            p.addAll(parserP.getAll(j));
        }
        return  p;

    }

    public List<Personatge> getFontFile() throws Exception{
        List<Personatge> p = new ArrayList<>();
        List<String> json = jsonLocalAllPersonatge();
       for(String jsons : json){
            p.addAll(parserP.getAll(jsons));
        }

        return p;
    }


// VIA JSON ARXIU Personatge
public List<String> jsonLocalAllPersonatge() throws Exception{
        List<File> personatges = Arrays.stream(rutes)
                .filter(rutes -> rutes.getName().startsWith("character"))
                .toList();
List<String> l = new ArrayList<>();
for(File r : personatges) {
    String json = formatJson(api.fetchFile(r.getPath()));

    l.add(json);
}

return l;
}

public List<Personatge> getPersonatgesAllLocal() throws Exception{
        List<Personatge> p  = new ArrayList<>();
        List<String> local = jsonLocalAllPersonatge();
       for(String txt  : local){
               List<Personatge> pl = parserP.getAll(txt);
               p.addAll(pl);
       }
        return p;
}
public Personatge getPersonatgeLocal(int id ) throws Exception{
        List<String> json =  jsonLocalAllPersonatge();
        for(String j : json){
            Personatge  p = parserP.getPersonatge(j,id);
            if(p != null) return p;
        }
        return null;
    }

//METODES PER OBTENIR LOCALITZACIONS PER  LES FONTS DE DADES
@Override
    public List<Localitzacio> getAllLocalitzacionsApi() throws Exception{
        List<Localitzacio> l  =  new ArrayList<>();
    String urlCanviat = urlLocation;

    while (urlCanviat != null && !urlCanviat.isBlank()) {
        String json = api.fetch(urlCanviat);           // fetch pagina actual
        l.addAll(parserL.getAll(json)); //  afegir els  20 de les pagines
        urlCanviat = parserL.getNextUrl(json);     // termina fins estar buit
        Thread.sleep(500); // FER UNA PAUSA PER CADA PAGINA
    }
        return l;
}

public List<String> getJsonsLocalitzacioFile() throws Exception{
    List<File> personatges = Arrays.stream(rutes)
            .filter(r -> r.getName().startsWith("location"))
            .toList();

    List<String> l = new ArrayList<>();
    for(File r : personatges) {
        String json = api.fetchFile(r.getPath());
        l.add(json);
    }
    return l;

    }
public List<Localitzacio> getAllLocalitzacionsLocal() throws  Exception{
    List<Localitzacio> p  = new ArrayList<>();

    List<String> local = getJsonsLocalitzacioFile();
    for(String txt  : local){
        List<Localitzacio> pl = parserL.getAll(txt);
        p.addAll(pl);
    }
    return p;
}

    private List<String> getJsonsPersonatgeApi() throws Exception{
        List<String> l = new ArrayList<>();

        String urlCanviat = urlPersonatge;

        while (urlCanviat != null && !urlCanviat.isBlank()) {
            String json = api.fetch(urlCanviat);           // fetch pagina actual
            String format = formatJson(json);
            l.add(format);
            urlCanviat = parserP.getNextUrl(json);

            // termina fins estar buit

            Thread.sleep(500); // FER UNA PAUSA PER CADA PAGINA AIXO EL FEM PERQUE EL PROVEIDOR POT BLOQUEHAR SI DETECTA MOLTS PETICIONS

        }
        return  l;
    }

// FORMAT DE JSON
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
