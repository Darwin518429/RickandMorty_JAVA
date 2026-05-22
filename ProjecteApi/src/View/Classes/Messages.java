package View.Classes;

import Model.DTO.personatgeDTO;


public class Messages {

    public static void missatges(String txt ){
        System.out.println(txt);
    }
    public static void missatges(personatgeDTO txt ){
        System.out.println(txt);
    }
    public static void M_exception (Exception txt ){
        System.out.println(txt);
    }
}
