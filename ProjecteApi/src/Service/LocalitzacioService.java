package Service;

import Api.RickMorty.rickmortyclient;
import Model.rickMortyDB.Localitzacio;
import View.Classes.Messages;
import implementation.mysql.rickmorty.mysqlLocalitzacio;

import java.util.ArrayList;
import java.util.List;

public class LocalitzacioService {
    private mysqlLocalitzacio dao;
    private rickmortyclient  api;
    public LocalitzacioService(mysqlLocalitzacio dao, rickmortyclient api){
        this.dao = dao;
        this.api = api;
    }

public void addLocalitzacioApi( ) throws  Exception{
    Messages.missatges("Carregant Localitzacio...");
        List<Localitzacio> l = api.getAllLocalitzacionsApi();
        for(Localitzacio local : l){
            dao.addLocalitzacio(local);
        }
}

public void addLocalitzacioLocal() throws Exception{
    List<Localitzacio> l = api.getAllLocalitzacionsLocal();
    System.out.println("Total a insertar: " + l.size());
    for(Localitzacio local : l){
        dao.addLocalitzacio(local);
    }
}
}
