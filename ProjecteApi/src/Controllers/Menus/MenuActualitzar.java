package Controllers.Menus;

import AppConfig.Appconfig;
import View.Classes.Menus.MenuActualitzarView;
import View.Classes.Menus.MenuLlistarView;

import java.util.Scanner;

public class MenuActualitzar {
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {

        int opcio;

        do {
            MenuActualitzarView.mostrarMenu();

            while (!sc.hasNextInt()) {

                System.out.println("Introdueix un número vàlid");
                sc.nextLine();
            }

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {

                case 1:
                    Appconfig.personatgeController().actualitzarPersonatgeApi();
                    break;

                case 2:
                    Appconfig.personatgeController().actualitzarPersonatgeFile();
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
