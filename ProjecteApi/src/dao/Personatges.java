package dao;

import Model.rickMortyDB.Personatge;

import java.sql.SQLException;
import java.util.List;

public interface Personatges extends DAO<Personatge, Integer>{

    //void set (Integer id );

@Override
    Personatge get (Integer id) ;
@Override
    List<Personatge> getAll();

    void copiaTotal(List<Personatge> l ) ;
}
