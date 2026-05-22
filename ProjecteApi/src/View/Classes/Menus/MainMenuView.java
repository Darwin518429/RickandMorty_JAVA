package View.Classes.Menus;

public class MainMenuView {

       private static final String MENU_PRINCIPAL = """
            
            ╔══════════════════════════════════════════════╗
            ║                                              ║
            ║       CONSULTAR RICK MORTY API  O ARXIU      ║
            ║                                              ║
            ╠══════════════════════════════════════════════╣
            ║                                              ║
            ║   1. Llistar Personatges Bds                 ║
            ║   2. Mostrar dades font externa              ║
            ║   3. Actualitzar personatge                  ║
            ║   4. Sincronitzar dades                      ║
            ║                                              ║
            ║                                              ║
            ║                                              ║
            ║   0. Sortir                                  ║
            ║                                              ║
            ╚══════════════════════════════════════════════╝
            
            Selecciona una opció:
            """;

       public static void mostrarMenu() {
           System.out.println(MENU_PRINCIPAL);
       }
   }

