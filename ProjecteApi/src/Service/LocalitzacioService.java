package Service;

import implementation.mysql.rickmorty.mysqlLocalitzacion;

public class LocalitzacioService {
    private mysqlLocalitzacion dao;

    public LocalitzacioService(mysqlLocalitzacion dao){
        this.dao = dao;
    }


}
