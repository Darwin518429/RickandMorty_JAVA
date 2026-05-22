package Controllers.Menus;

import AppConfig.Appconfig;
import View.Classes.Menus.MenuFontView;
import View.Classes.Menus.MenuLlistarView;

import java.util.Scanner;

public class MenuMostrarFont {

    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {

        int opcio;

        do {
            MenuFontView.mostrarMenu();

            while (!sc.hasNextInt()) {

                System.out.println("Introdueix un número vàlid");
                sc.nextLine();
            }

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {

                case 1:
                    Appconfig.personatgeController().mostrarPersonatgesApi();
                    break;

                case 2:
                    Appconfig.personatgeController().mostrarJsonArxiu();
                    break;

                case 0:

                    System.out.println("Tornant...");
                    break;

                default:

                    System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }
}
