package dao;

import Model.rickMortyDB.Localitzacion;

import java.util.List;

public interface LocalitacionsDAO extends DAO<Localitzacion, Integer>{

    @Override
    Localitzacion get (Integer id) ;
    @Override
    List<Localitzacion> getAll();


}
