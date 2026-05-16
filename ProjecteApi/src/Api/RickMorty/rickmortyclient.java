package Api.RickMorty;

import Api.ApiClientGeneric;
import Api.ApiClientInterface;
import Api.ConnectionApi;
import Model.rickMortyDB.Personatge;

import java.util.ArrayList;
import java.util.List;

public class rickmortyclient  extends ApiClientGeneric implements ApiClientInterface, Apiclient_Personatge{
    private ConnectionApi api ;
    private String url;
    //OBJECTES PROPIS DEL RICKMORTY
    PersonatgesParser parse = new PersonatgesParser();

    public  rickmortyclient(ConnectionApi api , String url ){
    super(api,url);
       // this.api = api;
    //this.url = url;

    }


@Override
public List<Personatge> getAll() throws Exception {
    List<Personatge> p = new ArrayList<>();
    String json = api.fetch(url);
    System.out.println("SE COMUNICA ");
    // parser.getnextUrlP();

    return p;
}
}
