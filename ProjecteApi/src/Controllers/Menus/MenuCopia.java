package Controllers.Menus;

import AppConfig.Appconfig;
import View.Classes.Menus.MenuActualitzarView;
import View.Classes.Menus.MenuCopiaView;

import java.util.Scanner;

public class MenuCopia {
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {

        int opcio;

        do {
            MenuCopiaView.mostrarMenu();

            while (!sc.hasNextInt()) {

                System.out.println("Introdueix un número vàlid");
                sc.nextLine();
            }

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {

                case 1:
                    Appconfig.personatgeController().copiaTotal();
                    break;

                case 2:
                    Appconfig.personatgeController().copiaParcial();
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
