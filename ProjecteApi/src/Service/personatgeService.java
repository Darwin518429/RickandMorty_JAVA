package Service;

import Api.ApiClientGeneric;
import Api.RickMorty.rickmortyclient;
import Model.rickMortyDB.Personatge;
import implementation.mysql.rickmorty.mysqlPersonatge;

import java.util.List;

public class personatgeService {
    private mysqlPersonatge  personatgedao;
    private rickmortyclient api;
    public personatgeService(mysqlPersonatge personatgedao, ApiClientGeneric api ){
    this.personatgedao = personatgedao;
    this.api = (rickmortyclient) api;
    }
public void copiaPersonatge () throws Exception{
    List<Personatge> personatges = api.getAllPersonatge();
    personatgedao.insertPersonatges(personatges);


}
}
