package View.Classes.Menus;

public class MenuLlistarView {

    private static final String MENU_LLISTAR = """
            
            ╔══════════════════════════════════════════════╗
            ║                                              ║
            ║               LLISTAR USUARIS                ║
            ║                                              ║
            ╠══════════════════════════════════════════════╣
            ║                                              ║
            ║   1. Llistar tots                            ║
            ║   2. Llistar per status                      ║
            ║                                              ║
            ║                                              ║
            ║                                              ║
            ║   0. Sortir                                  ║
            ║                                              ║
            ╚══════════════════════════════════════════════╝
            
            Selecciona una opció:
            """;

    public static void mostrarMenu() {
        System.out.println(MENU_LLISTAR);
    }
}
