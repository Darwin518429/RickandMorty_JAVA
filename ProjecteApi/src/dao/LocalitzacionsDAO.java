package dao;

import Model.rickMortyDB.Localitzacion;

import java.util.List;

public interface LocalitzacionsDAO extends DAO<Localitzacion, Integer>{

    @Override
    Localitzacion get (Integer id) ;
    @Override
    List<Localitzacion> getAll();

    void addLocalitzacio( Localitzacion l  );

}
