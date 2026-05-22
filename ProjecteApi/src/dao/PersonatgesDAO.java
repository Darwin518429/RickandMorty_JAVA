package dao;

import Model.rickMortyDB.Personatge;

import java.util.List;

public interface PersonatgesDAO extends DAO<Personatge, Integer>{

@Override
    Personatge get (Integer id) ;
@Override
    List<Personatge> getAll();

List<Personatge> getStatus(String status);
void copiaParcial(List<Personatge> l );
void copiaTotal(List<Personatge> l );
void addPersonatge(Personatge p );
void updatePersonatge(Personatge p );
List<String> getStatusPersonatge();
}
