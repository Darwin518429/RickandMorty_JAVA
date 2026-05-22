package Api.RickMorty;

import Api.ApiTemplate.ApiClientInterface;
import Model.rickMortyDB.Localitzacio;

import java.util.List;

public interface Apiclient_Localitzacio extends ApiClientInterface {

    List<Localitzacio> getAllLocalitzacionsApi() throws Exception;

    List<String> getJsonsLocalitzacioFile() throws Exception;
}
