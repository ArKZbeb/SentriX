import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static Menu.MenuClass.MenuDemarage;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Initialiser le scanneur
        Scanner scanneur = new Scanner(System.in);

        // Lancer le menu de démarrage
        MenuDemarage(scanneur);

        // Fermer le scanneur à la fin
        scanneur.close();
    }
}