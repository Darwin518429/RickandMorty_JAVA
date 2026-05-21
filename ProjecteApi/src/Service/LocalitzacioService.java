package Service;

import implementation.mysql.rickmorty.mysqlLocalitzacio;

public class LocalitzacioService {
    private mysqlLocalitzacio dao;

    public LocalitzacioService(mysqlLocalitzacio dao){
        this.dao = dao;
    }


}
