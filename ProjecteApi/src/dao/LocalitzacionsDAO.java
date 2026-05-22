package dao;

import Model.rickMortyDB.Localitzacio;

import java.util.List;

public interface LocalitzacionsDAO extends DAO<Localitzacio, Integer>{

    @Override
    Localitzacio get (Integer id) ;
    @Override
    List<Localitzacio> getAll();
    Localitzacio searchcalitzacio(Integer id);
    void addLocalitzacio( Localitzacio l  );
    void insertDesconegut();
}
