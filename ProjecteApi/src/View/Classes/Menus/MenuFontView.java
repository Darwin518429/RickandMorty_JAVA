package View.Classes.Menus;

public class MenuFontView {
    private static final String MENU_FONT = """
            
            ╔══════════════════════════════════════════════╗
            ║                                              ║
            ║         Mostrar dades d’una font externa     ║
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
        System.out.println(MENU_FONT);
    }
}
