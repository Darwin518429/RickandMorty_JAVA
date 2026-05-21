package Controllers.Elements;
import Model.DTO.personatgeDTO;
import Model.rickMortyDB.Personatge;
import Service.*;
import View.Classes.Messages;

import java.util.*;

public class personatgeControllers {
    private personatgeService service ;
    private static Scanner sc = new Scanner(System.in);
    public personatgeControllers  (personatgeService service ){
         this.service =  service;

    }

    public void copiaParcialPersonatgeEndpoint(){
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

public void actualitzarPersonatgeApi(){
        try{


            Messages.missatges("SELECCIONA ELS PERSONATGES");
            List<Personatge> pg = service.getPersonatgeall();
            for(Personatge p : pg){
                Messages.missatges(p.getId_personatge() + " " + p.getNom());
            }
            int id = sc.nextInt();
            sc.nextLine();
          //  Personatge confirmar = service.get
           // Personatge p = service.getPersonatgeApi(id);
          //  service.addPersonatge(p);


        }catch (Exception e ){
            Messages.M_exception(e);
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
