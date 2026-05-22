import Api.RickMorty.rickmortyclient;
import AppConfig.Appconfig;
import Controllers.Menus.MenuMain;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      //  rickmortyclient rm = new rickmortyclient();
      /*  try {
            rm.Arrencar();
        }
        catch (Exception e ){
            System.out.println(e);
        }*/
        //  Appconfig.personatgecontroller().copiaPersonatgeEndpoint();
       // Appconfig.personatgeController().copiaParcialPersonatgeEndpoint();
        // Appconfig.personatgeController().mostrarJson();
        //  Appconfig.personatgecontroller().mostrarJsonArxiu();
      //  Appconfig.personatgeController().LlistarPersonatgesBd();
//Appconfig.personatgeController().mostrarJsonArxiu();
      //  Appconfig.personatgeController().mostrarPersonatgesApi();
       // Appconfig.personatgeController().mostrarPersonatgesStatus();
       // Appconfig.personatgeController().actualitzarPersonatgeApi();
      //  Appconfig.personatgeController().actualitzarPersonatgeFile();
       // Appconfig.personatgeController().copiaTotal();
      // Appconfig.personatgeController().copiaParcialPerosonatgeLocal();

         MenuMain menu = new MenuMain();
        menu.iniciar();
    }
}