package AppConfig;
import Controllers.Elements.personatgeControllers;
import Model.rickMortyDB.Personatge;
import Service.personatgeService;
import dbconfig.BDC.ConfigLoader;
import dbconfig.BDC.Provider;
import implementation.mysql.rickmorty.*;

import java.sql.Connection;

public class Appconfig {

 //BD CONFIG
 private static String bd = "mysql"; //EL TIPO DE BD O  E NMBRE DE AL BD QUE QUEIR
 private static Provider provider = ConfigLoader.getProvider(bd); // EN EL PROVIDER DEVOLVERA UN OBJETO QUE CONTENDRA LAS CREDENCIALES

 //APIS


    //DAOS
 private static final  mysqlPersonatge personatgeDAO = DAOLoader.getmysqlPersonatge(bd,provider) ;

    //SERVICES
private static final personatgeService personatgeService = new personatgeService(personatgeDAO);

    //CONTROLLERS desde aqiu se llamn

    private static personatgeControllers personatgecontroller = new personatgeControllers(personatgeService);

    public static personatgeControllers personatgecontroller(){
        return personatgecontroller;
    }
}
