package Service;

import Api.ApiTemplate.ApiClientGeneric;
import Api.RickMorty.rickmortyclient;
import Model.rickMortyDB.Localitzacio;
import Model.rickMortyDB.Personatge;
import implementation.mysql.rickmorty.mysqlLocalitzacio;
import implementation.mysql.rickmorty.mysqlPersonatge;

import java.util.ArrayList;
import java.util.List;
import Model.DTO.*;
public class personatgeService {
    private mysqlPersonatge  personatgedao;
    private mysqlLocalitzacio localitzaciodao;
    private rickmortyclient api;
    public personatgeService(mysqlPersonatge personatgedao, ApiClientGeneric api, mysqlLocalitzacio l){
        this.localitzaciodao = l;
        this.personatgedao = personatgedao;
    this.api = (rickmortyclient) api;
    }
public void copiaParcialApi() throws Exception{
    List<Personatge> personatges = api.getAllPersonatgeApi();
    personatgedao.copiaParcial(personatges);
    localitzaciodao.insertDesconegut();
    isNotValidId(personatges);
}
public void copiaParcialFile() throws  Exception{
        List<Personatge> personatges = api.getPersonatgesAllLocal();

        /*for(Personatge p: personatges){
            if(p.getId_origen() && p.getId_localtizacio()){

            }
        }*/
    localitzaciodao.insertDesconegut();
    isNotValidId(personatges);
    System.out.println("Size: " + personatges.size());
        personatgedao.copiaParcial(personatges);
}

public void copiaTotalApi()throws Exception {
    List<Personatge> personatges = api.getAllPersonatgeApi();
    localitzaciodao.insertDesconegut();
    isNotValidId(personatges);
    personatgedao.copiaTotal(personatges);
}

public void copiaTotalFile()throws Exception{
    List<Personatge> personatges = api.getPersonatgesAllLocal();
    localitzaciodao.insertDesconegut();
    isNotValidId(personatges);
    personatgedao.copiaTotal(personatges);
}
public List<personatgeDTO> getAllPersonatgeDTO()throws Exception{
    List<Personatge> lp = personatgedao.getAll();
    List<personatgeDTO> pdto = new ArrayList<>();
    for(Personatge p : lp ){

        Localitzacio origen     =  localitzaciodao.get(p.getId_origen());
        Localitzacio actualitat =  localitzaciodao.get(p.getId_localtizacio()) ;

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

            Localitzacio origen     =  localitzaciodao.get(p.getId_origen());
            Localitzacio actualitat =  localitzaciodao.get(p.getId_localtizacio()) ;

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

    public personatgeDTO mostrarPersonatgedto(Personatge p ) throws Exception{
        if(p == null) throw new Exception("Error");

        Localitzacio origen     =  localitzaciodao.get(p.getId_origen());
        Localitzacio actualitat =  localitzaciodao.get(p.getId_localtizacio()) ;

        return new personatgeDTO(
                    p.getNom(),
                    p.getStatus(),
                    p.getSpecies(),
                    p.getTipus(),
                    p.getGenere(),
                    origen     != null ? origen.getNom()     : "localitzacions que no exsiteixen",
                    actualitat != null ? actualitat.getNom() : "localitzacions que no exsiteixen"
            );

    }

    public Personatge getPersonatge(int id ) throws Exception{
        if(id < 0 ) throw  new Exception("Error");
        return personatgedao.get(id);
    }
// VIA ENDPOINT MOLSTRAR
    public List<Personatge> getJsonFontApi() throws Exception{
        return   api.getFontpi().isEmpty() ? null : api.getFontpi();
    }
//Via File
    public List<Personatge> getJsonFontFile() throws Exception{
        return   api.getFontFile().isEmpty() ? null : api.getFontFile();
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


    private void isNotValidId(List<Personatge> p ){
       // List<Localitzacio> local = localitzaciodao.getAll();

        for (Personatge personatge:  p ){
       personatge.setId_origen(   localitzaciodao.searchcalitzacio(personatge.getId_origen()) == null ? 0 :
                localitzaciodao.searchcalitzacio(personatge.getId_origen()).getId_localitzacions());

       personatge.setId_localtizacio( localitzaciodao.searchcalitzacio(personatge.getId_localtizacio()) == null ? 0 :
               localitzaciodao.searchcalitzacio(personatge.getId_localtizacio()).getId_localitzacions());
        }
    }
    }




