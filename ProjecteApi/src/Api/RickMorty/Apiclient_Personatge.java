package Api.RickMorty;

import Api.ApiClientInterface;
import Model.rickMortyDB.Personatge;

import java.util.List;

public interface Apiclient_Personatge extends ApiClientInterface {
    List<Personatge> getAllPersonatge() throws Exception;


}
