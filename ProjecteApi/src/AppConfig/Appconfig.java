package AppConfig;
import Api.ApiTemplate.ApiFactory;
import Api.RickMorty.rickmortyclient;
import Controllers.Elements.LocalitzacioControllers;
import Controllers.Elements.personatgeControllers;
import Service.LocalitzacioService;
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
private static final mysqlLocalitzacio localitzacioDAO = DAOLoader.getmysqllocalitzacio(bd,provider);

//SERVICES
private static final personatgeService personatgeService = new personatgeService(personatgeDAO,rickmorty,localitzacioDAO);
private static final LocalitzacioService localitzacioService = new LocalitzacioService(localitzacioDAO,rickmorty);
    //CONTROLLERS
    private static personatgeControllers personatgecontroller = new personatgeControllers(personatgeService,localitzacioService);
    private static LocalitzacioControllers localitzaciocontroller = new LocalitzacioControllers(localitzacioService);

   //METODES PER PODR UTILITZAR
    public static personatgeControllers personatgeController(){
        return personatgecontroller;
    }

    public static LocalitzacioControllers localitzacioController(){return localitzaciocontroller;}



}
