package Controllers.Elements;
import Model.DTO.personatgeDTO;
import Service.*;

import java.util.List;

public class personatgeControllers {
    private personatgeService service ;
    public personatgeControllers  (personatgeService service ){
         this.service =  service;

    }

    public void copiaPersonatgeEndpoint(){
        try {
            service.copiaParcial();
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

    public void mostrarPersonatgesStatus(String p){
        try{
           List<personatgeDTO> pdto =  service.getPersonatgeStatusDTO(p);
           for(personatgeDTO dto : pdto){
               System.out.println(dto);
           }
        }catch (Exception e ){
            System.out.println(e);
        }
    }



    public void LlistarPersonatgesBd() {
        try {
            List<personatgeDTO> pdto = service.getAllPersonatgeDTO();

            for(personatgeDTO dto : pdto){
                System.out.println(dto);
            }

        }catch (Exception e ){
            System.out.println(e);
        }
    }
}
