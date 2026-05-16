package AppConfig;
import Api.ApiFactory;
import Api.RickMorty.rickmortyclient;
import Controllers.Elements.personatgeControllers;
import Service.personatgeService;
import dbconfig.BDC.ConfigLoader;
import dbconfig.BDC.Provider;
import implementation.mysql.rickmorty.*;

public class Appconfig {

 //BD CONFIG
 private static String bd = "mysql"; //EL TIPO DE BD O  E NMBRE DE AL BD QUE QUEIR
 private static Provider provider = ConfigLoader.getProvider(bd); // EN EL PROVIDER DEVOLVERA UN OBJETO QUE CONTENDRA LAS CREDENCIALES

 //APIS Config

    private static final rickmortyclient rickmorty = (rickmortyclient) ApiFactory.getApi("rickmorty");


    //DAOS
 private static final  mysqlPersonatge personatgeDAO = DAOLoader.getmysqlPersonatge(bd,provider) ;

    //SERVICES
private static final personatgeService personatgeService = new personatgeService(personatgeDAO,rickmorty);

    //CONTROLLERS

    private static personatgeControllers personatgecontroller = new personatgeControllers(personatgeService);

    public static personatgeControllers personatgecontroller(){
        return personatgecontroller;
    }
}
