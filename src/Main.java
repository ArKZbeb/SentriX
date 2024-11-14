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
        scanner.nextLine(); // Consommer le retour à la ligne

        if (choix == 1) {
            chiffrerMenu(scanner);
        } else if (choix == 2) {
            dechiffrerMenu(scanner);
        } else {
            System.out.println("Choix invalide. Veuillez relancer le programme.");
        }

        scanner.close();
    }

    private static void chiffrerMenu(Scanner scanner) {
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
                System.out.print("Entrez le message à chiffrer avec le Carré de Polybe : ");
                String messagePolybe = scanner.nextLine();
                System.out.println("Message chiffré : " + CarreDePolybe.chiffrer(messagePolybe));
                break;
            case 3:
                System.out.print("Entrez le message à chiffrer avec Vigenère : ");
                String messageVigenere = scanner.nextLine();
                System.out.print("Entrez la clé pour Vigenère : ");
                String keyVigenere = scanner.nextLine();
                System.out.println("Message chiffré : " + VigenereCipher.chiffrer(messageVigenere, keyVigenere));
                break;
            default:
                System.out.println("Choix invalide. Veuillez relancer le programme.");
        }
    }

    private static void dechiffrerMenu(Scanner scanner) {
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
                System.out.print("Entrez le message à déchiffrer avec le Carré de Polybe : ");
                String messagePolybe = scanner.nextLine();
                System.out.println("Message déchiffré : " + CarreDePolybe.dechiffrer(messagePolybe));
                break;
            case 3:
                System.out.print("Entrez le message à déchiffrer avec Vigenère : ");
                String messageVigenere = scanner.nextLine();
                System.out.print("Entrez la clé pour Vigenère : ");
                String keyVigenere = scanner.nextLine();
                System.out.println("Message déchiffré : " + VigenereCipher.dechiffrer(messageVigenere, keyVigenere));
                break;
            default:
                System.out.println("Choix invalide. Veuillez relancer le programme.");
        }
    }
}
