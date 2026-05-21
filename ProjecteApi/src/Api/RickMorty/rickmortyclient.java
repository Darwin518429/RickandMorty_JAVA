package Api.RickMorty;

import Api.ApiClientGeneric;
import Api.ApiClientInterface;
import Api.ConnectionEndpoint.ConnectionApi;
import Api.RickMorty.Parsers.LocalitzacioParser;
import Api.RickMorty.Parsers.PersonatgeParser;
import Model.rickMortyDB.Localitzacion;
import Model.rickMortyDB.Personatge;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

//Personatges


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


    public List<String> getJsonsPersonatge() throws Exception{
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
public Personatge getPersonatgeApi(int id ) throws Exception{

    List<String> json =  getJsonsPersonatge();
        for(String j : json){

            Personatge  p = parserP.getPersonatge(j,id);
            if(p != null) return p;
        }
        return null;
}
// VIA JSON ARXIU Personatge
public List<String> jsonLocalAllPersonatge() throws Exception{
        List<File> personatges = Arrays.stream(rutes)
                .filter(rutes -> rutes.getName().matches("character+"))
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
    public List<Localitzacion> getAllLocalitzacionsApi() throws Exception{
        List<Localitzacion> l  =  new ArrayList<>();
    String urlCanviat = urlLocation;

    while (urlCanviat != null && !urlCanviat.isBlank()) {
        String json = api.fetch(urlCanviat);           // fetch pagina actual
        l.addAll(parserL.getAll(json)); //  afegir els  20 de les pagines
        urlCanviat = parserL.getNextUrl(json);     // termina fins estar buit
        Thread.sleep(500); // FER UNA PAUSA PER CADA PAGINA
    }
        return l;
}



@Override
    public List<String>  getJsonsLocalitacio() throws Exception{
    List<String> txt = new ArrayList<>();
    return txt;
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
