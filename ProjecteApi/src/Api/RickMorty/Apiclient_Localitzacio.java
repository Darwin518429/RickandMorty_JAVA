package Api.RickMorty;

import Api.ApiClientInterface;
import Model.rickMortyDB.Localitzacion;
import Model.rickMortyDB.Personatge;

import java.util.List;

public interface Apiclient_Localitzacio extends ApiClientInterface {

    List<Localitzacion> getAllLocalitzacions() throws Exception;

    List<String> getJsons() throws Exception;
}
