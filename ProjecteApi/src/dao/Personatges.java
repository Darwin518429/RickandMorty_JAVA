package dao;

import Model.rickMortyDB.Personatge;

import java.util.List;

public interface Personatges extends DAO<Personatge, Integer>{

    //void set (Integer id );

@Override
    Personatge get (Integer id) ;
@Override
    List<Personatge> getAll();


    void copiaParcial(List<Personatge> l ) ;
}
