package dao;

import Model.rickMortyDB.Personatge;

import java.util.List;

public interface Personatges extends DAO<Personatge, Integer>{

    void set (Integer id );

    List<Personatge> getAll();

    Personatge get (Integer id);
}
