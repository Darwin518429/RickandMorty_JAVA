package dao;

import java.util.List;

public interface DAO <C,K>{
  // DAO<...>  es como un parametro de un funcion nos sirve para reutilizar los metodos para diferentes classes(C) y PKs(K) los tipos de datos
        // NO HACE FATLA PONER PUBLIC ENTEORIA
        void set (K o);
        List<C> getAll();
        C get (K id);
}
