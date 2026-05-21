package Api.RickMorty;

import Api.ApiClientInterface;
import Model.rickMortyDB.Localitzacion;

import java.util.List;

public interface Apiclient_Localitzacio extends ApiClientInterface {

    List<Localitzacion> getAllLocalitzacionsApi() throws Exception;

    List<String> getJsonsLocalitacio() throws Exception;
}
