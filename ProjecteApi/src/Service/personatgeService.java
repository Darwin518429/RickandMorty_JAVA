package Service;

import Api.ApiClientGeneric;
import Api.RickMorty.rickmortyclient;
import implementation.mysql.rickmorty.mysqlPersonatge;

public class personatgeService {
    private mysqlPersonatge  personatgedao;
    private rickmortyclient api;
    public personatgeService(mysqlPersonatge personatgedao, ApiClientGeneric api ){
    this.personatgedao = personatgedao;
    this.api = (rickmortyclient) api;
    }
public void p (){

}
}
