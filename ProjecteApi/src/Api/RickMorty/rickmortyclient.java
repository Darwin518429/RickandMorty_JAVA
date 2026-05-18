package Api.RickMorty;

import Api.ApiClientGeneric;
import Api.ApiClientInterface;
import Api.ConnectionEndpoint.ConnectionApi;
import Api.RickMorty.Parsers.PersonatgesParser;
import Model.rickMortyDB.Personatge;

import java.util.ArrayList;
import java.util.List;

public class rickmortyclient  extends ApiClientGeneric implements ApiClientInterface, Apiclient_Personatge{

    //OBJECTES PROPIS DEL RICKMORTY
    PersonatgesParser parser = new PersonatgesParser();

    public  rickmortyclient(ConnectionApi api , String url ){
    super(api,url);
       // this.api = api;
    //this.url = url;

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

@Override
    public List<String> getJsons() throws Exception{
        List<String> l = new ArrayList<>();

    String urlCanviat = url;

    while (urlCanviat != null && !urlCanviat.isBlank()) {
        String json = api.fetch(urlCanviat);           // fetch pagina actual
        l.add(json);
        urlCanviat = parser.getNextUrl(json);

        // termina fins estar buit
        System.out.println("pagina llegida");
        Thread.sleep(500); // FER UNA PAUSA PER CADA PAGINA
    }
    return  l;
}
}
