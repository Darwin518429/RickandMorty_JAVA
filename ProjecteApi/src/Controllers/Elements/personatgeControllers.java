package Controllers.Elements;
import Model.DTO.personatgeDTO;
import Model.rickMortyDB.Localitzacio;
import Model.rickMortyDB.Personatge;
import Service.*;
import View.Classes.Messages;

import java.util.*;

public class personatgeControllers {
    private personatgeService service ;
    private LocalitzacioService localitzacioService;
    private static Scanner sc = new Scanner(System.in);
    public personatgeControllers  (personatgeService service , LocalitzacioService serviceLocalitzacio){
         this.service =  service;
         this.localitzacioService = serviceLocalitzacio;
    }

    public void copiaParcialPersonatgeEndpoint(){
        try {
            localitzacioService.addLocalitzacioApi();
            service.copiaParcialApi();
        }
        catch (Exception e ){
            System.out.println(e);
        }
    }

public void copiaParcialPerosonatgeLocal(){
        try{
            localitzacioService.addLocalitzacioLocal();
            service.copiaParcialFile();
        }catch (Exception e ){
            Messages.M_exception(e);
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

            boolean isnull = service.getPersonatge(id) == null ? true : false;

            if(isnull) Messages.missatges("No existeix en la bd  ");
          else {
                Messages.missatges("S'esta carregant... ");
                Personatge personatge = service.getPersonatgeApi(id);

                Messages.missatges("Registre:\n" + service.mostrarPersonatgedto(personatge)+ "\n Vols actualitzar el registre? \n 1.Si \n 2.No " );
              int r = sc.nextInt();
              if(r == 1) {service.updatePersonatge(personatge);
              Messages.missatges("S'ha actualitzat correctament");}
              Messages.missatges("S'ha sortit");
          }

        }catch (Exception e ){
            Messages.M_exception(e);
        }
}

public void actualitzarPersonatgeFile(){
    try{
        Messages.missatges("SELECCIONA ELS PERSONATGES");
        List<Personatge> pg = service.getPersonatgeall();
        for(Personatge p : pg){
            Messages.missatges(p.getId_personatge() + " " + p.getNom());
        }
        int id = sc.nextInt();
        sc.nextLine();
        Messages.missatges("S'esta carregant... ");
        Personatge personatge = service.getPersonatgeLocal(id);

        boolean isnull = personatge == null ? true : false;
        if(isnull) Messages.missatges("No existeix en el JSON arxiu ");

        else {
            Messages.missatges("Registre:\n" + service.mostrarPersonatgedto(personatge)+ "\n Vols actualitzar el registre? \n 1.Si \n 2.No " );
            int r = sc.nextInt();
            if(r == 1) {
                service.updatePersonatge(personatge);
                Messages.missatges("S'ha actualitzat correctament");}
                Messages.missatges("S'ha sortit");
        }

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
            Messages.M_exception(e);
        }
    }

    public void copiaTotal(){
        try{
        Messages.missatges("Copia total\n1.Arxiu\n2.Api Endpoint");
        int opcio = sc.nextInt();
        sc.nextLine();
            Messages.missatges("Carregant Localitzacio...");
        localitzacioService.addLocalitzacioApi();
        switch (opcio){
            case 1 :
                service.copiaTotalFile();
                break;
            case 2 :
                Messages.missatges("Carregant Api...");
                service.copiaTotalApi();
                break;
            default:
                Messages.missatges("Error");
        }
        }catch (Exception e ){
            Messages.M_exception(e);
        }
    }

    public void copiaParcial(){
        try{
            Messages.missatges("Copia Parcial\n1.Arxiu\n2.Api Endpoint");
            int opcio = sc.nextInt();
            sc.nextLine();
            switch (opcio){
                case 1 :
                    service.copiaParcialFile();
                    break;
                case 2 :
                    service.copiaParcialApi();
                    break;
                default:
                    Messages.missatges("Error");
            }
        }catch (Exception e ){
            Messages.M_exception(e);
        }
    }
}
