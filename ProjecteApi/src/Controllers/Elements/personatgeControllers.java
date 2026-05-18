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
        List<String> l = service.getJson();

        for(String t : l){
            System.out.println(t+ "\n--------------------");
        }
    }
}
