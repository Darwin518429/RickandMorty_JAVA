package Controllers.Menus;

import View.Classes.Menus.MainMenuView;

import java.util.Scanner;

public class MenuMain {
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {

        int opcio;

        do {

            MainMenuView.mostrarMenu();

            while (!sc.hasNextInt()) {

                System.out.println("Introdueix un número vàlid");
                sc.nextLine();
            }

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {

                case 1:
                    new MenuLlistar().iniciar();
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;


                case 0:
                    System.out.println("Sortint...");
                    break;

                default:
                    System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }
}
