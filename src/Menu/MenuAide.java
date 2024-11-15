package Menu;

import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;

public class MenuAide {
    // Définition des codes de couleurs pour le texte dans la console (rouge et blanc par défaut)
    public static String COULEUR_ROUGE = "\u001B[31m";
    public static String COULEUR_PAR_DEFAUT = "\u001B[0m";
    public static String choix;
    public static void Aide(Scanner scanneur) {
        while (true) {
            System.out.println("---------------------");
            System.out.println("Aide");
            System.out.println("---------------------");
            System.out.println("1. Choisissez un chiffrement");
            System.out.println("2. Choisissez un hachage");
            System.out.println("3. Récupérer un nombre pseudo aléatoire");
            System.out.println("4. Descriptions des outils disponibles");
            System.out.println("5. Quitter");
            System.out.println("---------------------");
            System.out.print("Veuillez faire un choix entre 1 et 5 : ");

            choix = scanneur.next();
            switch (choix) {
                case "1" -> {
                    // Appel de la méthode pour le chiffrement
                    System.out.println("---------------------");
                    System.out.println("Chiffrement");

                }
                case "2" -> {
                    // Appel de la méthode
                    System.out.println("---------------------");
                    System.out.println("Hachage");
                }
                case "3" -> {
                    // Appel de la méthode
                    System.out.println("---------------------");
                    System.out.println("Récupérer un nombre pseudo aléatoire");
                }
                case "4" -> {
                    // Appel de la méthode
                    System.out.println("---------------------");
                    System.out.println("Descriptions des outils disponibles");
                }
                case "quitter" -> {
                    System.out.println("Sortie...");
                    break;
                }
                default -> {
                    // Message d'erreur pour les entrées invalides
                    System.out.println("---------------------");
                    System.out.println(COULEUR_ROUGE + "Merci de mettre un input correct" + COULEUR_PAR_DEFAUT);
                }


            }

        }
    }
    public static void MenuAideChiffrement(Scanner scanneur) throws NoSuchAlgorithmException {
        boolean retourMenuAide = false;
        choix = "";
        while  (!retourMenuAide) {
            // Affichage des options pour le menu de chiffrement
            System.out.println("---------------------");
            System.out.println("1. ROT(X)");
            System.out.println("2. Vigenère");
            System.out.println("3. Carré de Polybe");
            System.out.println("4. Enigma");
            System.out.println("5. Retour en arrière");
            System.out.println("6. Quitter");
            System.out.println("---------------------");
            System.out.print("Veuillez faire un choix entre 1 et 6 : ");

            choix = scanneur.next();
            switch(choix){
                case "1" -> {
                    // Menu d'explication du chiffrement ROT(X)
                    System.out.println("---------------------");
                    System.out.println("ROT(X)");
                }
                case "2" -> {
                    // Menu d'explication du chiffrement Vigenère
                    System.out.println("---------------------");
                    System.out.println("Vigenère");
                }
                case "3" -> {
                    // Menu d'explication du chiffrement Carré de Polybe
                    System.out.println("---------------------");
                    System.out.println("Carré de Polybe");
                }
                case "4" -> {
                    // Menu d'explication du chiffrement Enigma
                    System.out.println("---------------------");
                    System.out.println("Enigma");
                }
                case "5" -> {
                    // Retour au menu précédent
                    retourMenuAide = true;
                }
            }
        }

    }
}
