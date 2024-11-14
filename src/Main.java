import java.util.Scanner;
import Chiffrement.CarreDePolybe;
import Chiffrement.Enigma;
import Chiffrement.VigenereCipher;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le programme de chiffrement !");
        System.out.println("Veuillez choisir une option :");
        System.out.println("1 - Chiffrer un message");
        System.out.println("2 - Déchiffrer un message");
        System.out.print("Votre choix : ");
        
        int choix = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne après le choix

        if (choix == 1) {
            executerChiffrement(scanner);
        } else if (choix == 2) {
            executerDechiffrement(scanner);
        } else {
            System.out.println("Choix invalide. Veuillez relancer le programme.");
        }

        scanner.close();
    }

    private static void executerChiffrement(Scanner scanner) {
        System.out.println("Choisissez le type de chiffrement :");
        System.out.println("1 - Enigma");
        System.out.println("2 - Carré de Polybe");
        System.out.println("3 - Vigenère");
        System.out.print("Votre choix : ");
        
        int choixChiffrement = scanner.nextInt();
        scanner.nextLine();

        switch (choixChiffrement) {
            case 1:
                Enigma.enigmaChiffrer(scanner);
                break;
            case 2:
                CarreDePolybe.chiffrer(scanner);
                break;
            case 3:
                VigenereCipher.chiffrer(scanner);
                break;
            default:
                System.out.println("Choix invalide.");
                break;
        }
    }

    private static void executerDechiffrement(Scanner scanner) {
        System.out.println("Choisissez le type de déchiffrement :");
        System.out.println("1 - Enigma");
        System.out.println("2 - Carré de Polybe");
        System.out.println("3 - Vigenère");
        System.out.print("Votre choix : ");
        
        int choixDechiffrement = scanner.nextInt();
        scanner.nextLine();

        switch (choixDechiffrement) {
            case 1:
                Enigma.enigmaDechiffrer(scanner);
                break;
            case 2:
                CarreDePolybe.dechiffrer(scanner);
                break;
            case 3:
                VigenereCipher.dechiffrer(scanner);
                break;
            default:
                System.out.println("Choix invalide.");
                break;
        }
    }
}
