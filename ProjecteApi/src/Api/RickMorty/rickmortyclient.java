package Api.RickMorty;

import Api.ApiClient;

public class rickmortyclient {
public  rickmortyclient(){}

String urlBase =  "https://rickandmortyapi.com/api/character";
public  void getAllPersonatges() throws Exception{
    String json = ApiClient.fetch(urlBase);
    RickMortyParser apis = new RickMortyParser(json);
     //apis.getnextUrlP();


}

}
