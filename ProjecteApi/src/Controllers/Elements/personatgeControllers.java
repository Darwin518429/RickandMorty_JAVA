package Controllers.Elements;
import Service.*;
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
}
