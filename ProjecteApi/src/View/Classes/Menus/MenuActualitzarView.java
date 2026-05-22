package View.Classes.Menus;

public class MenuActualitzarView {
    private static final String MENU_UPDATE = """
            
            ╔══════════════════════════════════════════════╗
            ║                                              ║
            ║           Actualitzar personatge             ║
            ║                                              ║
            ╠══════════════════════════════════════════════╣
            ║                                              ║
            ║   1. Api Endpoint                            ║
            ║   2. Arxiu                                   ║
            ║                                              ║
            ║                                              ║
            ║                                              ║
            ║   0. Sortir                                  ║
            ║                                              ║
            ╚══════════════════════════════════════════════╝
            
            Selecciona una opció:
            """;

    public static void mostrarMenu() {
        System.out.println(MENU_UPDATE);
    }
}
