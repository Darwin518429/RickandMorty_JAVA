package Controllers.Elements;
import Service.*;

import java.util.List;

public class personatgeControllers {
    private personatgeService service ;
    public personatgeControllers  (personatgeService service ){
         this.service =  service;

    }

    public void copiaPersonatgeEndpoint(){
        try {
            service.copiaPersonatge();
        }
        catch (Exception e ){
            System.out.println(e);
        }
    }


    public void mostrarJson(){
       try {
           List<String> l = service.getJson();

           for (String t : l) {
               System.out.println(t + "\n--------------------");
           }
       }catch (Exception e){
           System.out.println(e);
       }
    }

    public void mostrarJsonArxiu(){
        try {
            List<String> l = service.getJsonLocal();
            for(String t : l ){
                System.out.println(t + "\n------------------");
            }
        }
        catch (Exception e ){
            System.out.println(e);
        }

    }
}
