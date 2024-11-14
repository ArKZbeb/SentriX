import java.util.Scanner;

import static Menu.MenuClass.MenuDemarage;

public class Main {
    public static void main(String[] args) {
        // Initialiser le scanner
        Scanner scanner = new Scanner(System.in);

        // Lancer le menu de démarrage
        MenuDemarage(scanner);

        // Fermer le scanner à la fin
        scanner.close();
    }
}