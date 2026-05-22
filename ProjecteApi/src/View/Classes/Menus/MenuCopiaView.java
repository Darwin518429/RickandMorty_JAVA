package View.Classes.Menus;

public class MenuCopiaView {

    private static final String MENU_COPIA = """
            
            ╔══════════════════════════════════════════════╗
            ║                                              ║
            ║         COPIA COMPLETA O PARCIAL             ║
            ║                                              ║
            ╠══════════════════════════════════════════════╣
            ║                                              ║
            ║   1. Copia Completa                          ║
            ║   2. Copia Parcial                           ║
            ║                                              ║
            ║                                              ║
            ║                                              ║
            ║   0. Sortir                                  ║
            ║                                              ║
            ╚══════════════════════════════════════════════╝
            
            Selecciona una opció:
            """;

    public static void mostrarMenu() {
        System.out.println(MENU_COPIA);
    }
}
