package Service;

import Api.ApiClientGeneric;
import Api.RickMorty.rickmortyclient;
import Model.rickMortyDB.Localitzacion;
import Model.rickMortyDB.Personatge;
import implementation.mysql.rickmorty.mysqlLocalitzacion;
import implementation.mysql.rickmorty.mysqlPersonatge;

import java.util.ArrayList;
import java.util.List;
import Model.DTO.*;
public class personatgeService {
    private mysqlPersonatge  personatgedao;
    private mysqlLocalitzacion localitzaciodao;
    private rickmortyclient api;
    public personatgeService(mysqlPersonatge personatgedao, ApiClientGeneric api, mysqlLocalitzacion l){
        this.localitzaciodao = l;
        this.personatgedao = personatgedao;
    this.api = (rickmortyclient) api;
    }
public void copiaParcial() throws Exception{
    List<Personatge> personatges = api.getAllPersonatge();
    personatgedao.copiaParcial(personatges);

}


public List<personatgeDTO> getAllPersonatgeDTO()throws Exception{
    List<Personatge> lp = personatgedao.getAll();
    List<personatgeDTO> pdto = new ArrayList<>();
    for(Personatge p : lp ){

        Localitzacion origen     =  localitzaciodao.get(p.getId_origen());
        Localitzacion actualitat =  localitzaciodao.get(p.getId_localtizacio()) ;

        pdto.add(new personatgeDTO(
                p.getNom(),
                p.getStatus(),
                p.getSpecies(),
                p.getTipus(),
                p.getGenere(),
                origen     != null ? origen.getNom()     : "localitzacions que no exsiteixen",
                actualitat != null ? actualitat.getNom() : "localitzacions que no exsiteixen"
        ));
    }
    return pdto;
    }


public List<Personatge> getPersonatgeall() throws Exception{
        List<Personatge> lp = personatgedao.getAll();
        if(lp.isEmpty()) throw new Exception("Error");
        return lp;
}

public List<personatgeDTO> getPersonatgeStatusDTO(String tipus ) throws Exception{
        if(tipus.isBlank()) throw new Exception("ERROR");
        if(!tipus.equals("Alive") && !tipus.equals("unknown") && !tipus.equals("Dead")) throw new Exception("Error no existeix el tipus ");
        List<Personatge> ps = personatgedao.getStatus(tipus);

        List<personatgeDTO> pdto = new ArrayList<>();
        for(Personatge p : ps){

            Localitzacion origen     =  localitzaciodao.get(p.getId_origen());
            Localitzacion actualitat =  localitzaciodao.get(p.getId_localtizacio()) ;

            pdto.add(new personatgeDTO(
                p.getNom(),
                p.getStatus(),
                p.getSpecies(),
                p.getTipus(),
                p.getGenere(),
                origen     != null ? origen.getNom()     : "localitzacions que no exsiteixen",
                actualitat != null ? actualitat.getNom() : "localitzacions que no exsiteixen"
        ));
    }
        return pdto;
}


    public void addPersonatge(Personatge p ){
        personatgedao.addPersonatge(p);
    }

    public void updatePersonatge(Personatge p ) throws  Exception{
        if(p == null) throw  new Exception("Error ");
        personatgedao.updatePersonatge(p);

    }

// VIA ENDPOINT
    public List<String> getJson() throws Exception{
          return   api.getJsonsPersonatge();

    }

    public Personatge getPersonatgeApi(int id ) throws Exception{
        if(id < 0 ) throw new Exception("Error");
        Personatge p = api.getPersonatgeApi(id);
        return p;
    }




// VIA LOCAL
    public List<String> getJsonLocal() throws Exception{
        return api.jsonLocalAllPersonatge();
    }

    public Personatge getPersonatgeLocal(int id) throws  Exception{
        if(id < 0 ) throw new Exception("Error");
        Personatge p = api.getPersonatgeLocal(id);
        return p;
    }
    }




