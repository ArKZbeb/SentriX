package Menu;


import Chiffrement.Rc4;


import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static Chiffrement.CarreDePolybeClass.GlobaleCarreDePolybeManageur;
import static Chiffrement.EnigmaClass.enigmaChiffrer;
import static Chiffrement.EnigmaClass.enigmaDechiffrer;
import static Chiffrement.ROTClass.*;
import static Chiffrement.VigenereCipherClass.GlobaleVigenereManageur;
import static Common.CommonClass.*;
import static Doc.DocumentationClass.AfficherDocumentation;
import static Hash.HachageClass.Hachage256;
import static Hash.HachageClass.HachageMD5;
import static lfsr.LfsrClass.*;

public class MenuClass {
    // Définition des codes de couleurs pour le texte dans la console (rouge et blanc par défaut)
    public static String COULEUR_ROUGE = "\u001B[31m";
    public static String COULEUR_PAR_DEFAUT = "\u001B[0m";

    // Méthode pour afficher et gérer le menu principal de démarrage
    public static void MenuDemarage(Scanner scanneur) throws NoSuchAlgorithmException {
        // Variable pour contrôler la boucle d'exécution de l'application
        boolean stopApplication = false;

        // Boucle pour afficher le menu jusqu'à ce que l'utilisateur décide de quitter
        while (!stopApplication) {
            NettoyageConsole();  // Nettoyer la console avant d'afficher le menu

            // Affichage des options du menu principal
            System.out.println("---------------------");
            System.out.println("Bienvenue sur SentriX");
            System.out.println("---------------------");
            System.out.println("1. Choisissez un chiffrement");
            System.out.println("2. Choisissez un hachage");
            System.out.println("3. Récupérer un nombre pseudo aléatoire");
            System.out.println("4. Descriptions des outils disponibles");
            System.out.println("5. Quitter");
            System.out.println("---------------------");
            System.out.print("Veuillez faire un choix entre 1 et 5 : ");

            // Lire le choix de l'utilisateur
            String choix = scanneur.next();

            // Gestion des différentes options de menu en fonction du choix de l'utilisateur
            switch (choix) {
                case "1" ->
                    // Menu pour les différents chiffrements possibles
                        MenuChoixChiffrement(scanneur);
                case "2" ->
                    // Menu pour les différents hachages possibles
                        MenuChoixHachage(scanneur);
                case "3" ->
                    // Appel de la fonction pour générer un nombre aléatoire
                        LFSR(scanneur);
                case "4" ->
                    // Menu pour les différentes documentations
                        AfficherDocumentation(scanneur);
                case "5", "quitter" ->
                    // Sortir de la boucle et quitter l'application
                        stopApplication = true;
                default -> {
                    // Message d'erreur pour les entrées invalides
                    System.out.println("---------------------");
                    System.out.println(COULEUR_ROUGE + "Merci de mettre un input correct" + COULEUR_PAR_DEFAUT);
                }
            }
        }

        System.out.println("Fermeture de l'application...");  // Message de fermeture de l'application
    }

    // Méthode pour afficher et gérer les options de chiffrement
    public static void MenuChoixChiffrement(Scanner scanneur) {
        boolean retourMenuDemarage = false;

        while (!retourMenuDemarage) {
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

            // Lire et vérifier l'entrée de l'utilisateur
            String entree = VerificationEntree(scanneur, 1, 6);
            switch (entree) {

                case "1" -> {
                    System.out.println("---------------------");
                    MenuROT(scanneur);
                }
                case "2" -> {
                    System.out.println("---------------------");
                    MenuVigenere(scanneur);
                }
                case "3" -> {
                    System.out.println("---------------------");
                    MenuCarreDePolybe(scanneur);
                }
                case "4" -> {
                    System.out.println("---------------------");
                    MenuEnigma(scanneur);
                }
                case "5" ->
                    // Retour au menu principal
                        retourMenuDemarage = true;
                case "6", "quitter" ->
                    // Quitter l'application
                        ArretApplication();
                default -> {
                }
            }
        }
    }

    // Méthode pour afficher et gérer les options de hachage
    public static void MenuChoixHachage(Scanner scanneur) throws NoSuchAlgorithmException {
        boolean retourMenuDemarage = false;

        while (!retourMenuDemarage) {
            // Affichage des options pour le menu de hachage
            System.out.println("---------------------");
            System.out.println("1. RC4");
            System.out.println("2. SHA-256");
            System.out.println("3. MD5");
            System.out.println("4. Retour en arrière");
            System.out.println("5. Quitter");
            System.out.println("---------------------");
            System.out.print("Veuillez faire un choix entre 1 et 5 : ");

            // Lire et vérifier l'entrée de l'utilisateur
            String entree = VerificationEntree(scanneur, 1, 5);
            switch (entree) {
                case "1" -> {
                    System.out.println("---------------------");
                    System.out.println("Option RC4 sélectionnée");
                    MenuRC4(scanneur);
                }
                case "2" -> {
                    System.out.println("---------------------");
                    Hachage256(scanneur);
                }
                case "3" -> {
                    System.out.println("---------------------");
                    HachageMD5(scanneur);
                }
                case "4" ->
                    // Retour au menu principal
                        retourMenuDemarage = true;
                case "5", "quitter" ->
                    // Quitter l'application
                        ArretApplication();
                default -> {
                }
            }
        }
    }

    public static void MenuEnigma(Scanner scanneur) {

        boolean continuer = true;

        while (continuer) {
            String choix = Selection(scanneur);

            switch (choix) {
                case "1" -> enigmaChiffrer(scanneur);
                case "2" -> enigmaDechiffrer(scanneur);
                case "3" -> {
                    System.out.println("---------------------");
                    System.out.println("Retour au menu principal.");
                    continuer = false;
                }
                default -> {
                    System.out.println("---------------------");
                    System.out.println(COULEUR_ROUGE + "Choix invalide, veuillez réessayer." + COULEUR_PAR_DEFAUT);
                    System.out.println("---------------------");
                }
            }
        }
    }

    public static void MenuCarreDePolybe(Scanner scanneur) {

        boolean continuer = true;

        while (continuer) {
            String choix = Selection(scanneur);

            switch (choix) {
                case "1", "2" -> GlobaleCarreDePolybeManageur(choix, scanneur);
                case "3" -> {
                    System.out.println("---------------------");
                    System.out.println("Retour au menu principal.");
                    continuer = false;
                }
                default -> {
                    System.out.println("---------------------");
                    System.out.println(COULEUR_ROUGE + "Choix invalide, veuillez réessayer." + COULEUR_PAR_DEFAUT);
                    System.out.println("---------------------");
                }
            }
        }
    }

    public static void MenuVigenere(Scanner scanneur) {

        boolean continuer = true;

        while (continuer) {
            String choix = Selection(scanneur);

            switch (choix) {
                case "1", "2" -> GlobaleVigenereManageur(choix, scanneur);
                case "3" -> {
                    System.out.println("---------------------");
                    System.out.println("Retour au menu principal.");
                    continuer = false;
                }
                default -> {
                    System.out.println("---------------------");
                    System.out.println(COULEUR_ROUGE + "Choix invalide, veuillez réessayer." + COULEUR_PAR_DEFAUT);
                    System.out.println("---------------------");
                }
            }
        }
    }


    public static void MenuROT(Scanner scanneur) {

        boolean continuer = true;

        while (continuer) {
            String choix = Selection(scanneur);

            switch (choix) {
                case "1", "2" -> GlobaleROTManageur(choix);
                case "3" -> {
                    System.out.println("Retour au menu principal.");
                    continuer = false;
                }
                default -> {
                    System.out.println("---------------------");
                    System.out.println(COULEUR_ROUGE + "Choix invalide, veuillez réessayer." + COULEUR_PAR_DEFAUT);
                    System.out.println("---------------------");
                }
            }
        }
    }

    public static void MenuRC4(Scanner scanner) {
        boolean continuer = true;

        while (continuer) {
            System.out.println("---------------------");
            System.out.println("1. Chiffrer un message avec RC4");
            System.out.println("2. Déchiffrer un message avec RC4");
            System.out.println("3. Retour");
            System.out.println("---------------------");
            System.out.print("Veuillez faire un choix entre 1 et 3 : ");

            String choix = scanner.next();

            switch (choix) {
                case "1" -> {
                    // Permet de demander la clé et le message à chiffrer
                    System.out.print("Entrez la clé de chiffrement : ");
                    String cle = scanner.next();
                    System.out.print("Entrez le message à chiffrer : ");
                    String message = scanner.next();

                    // Permet à la création de l'objet RC4
                    Rc4 rc4 = new Rc4(cle);
                    // Permet de faire appel à la méthode chiffrer

                    String resultatBase64 = rc4.chiffrerEnBase64(message);
                    System.out.println("Message chiffré (Base64) : " + resultatBase64);
                }
                case "2" -> {
                    // Permet de demander la clé et le message à déchiffrer (Base64)
                    System.out.print("Entrez la clé de chiffrement : ");
                    String cle = scanner.next();
                    System.out.print("Entrez le message à déchiffrer (Base64) : ");
                    String messageChiffreBase64 = scanner.next();

                    // Permet de déchiffrer le message encodé en Base64
                    String messageDechiffre = Rc4.dechiffrerBase64(messageChiffreBase64, cle);
                    System.out.println("Message déchiffré : " + messageDechiffre);
                }
                case "3" -> {
                    System.out.println("Retour au menu principal.");
                    continuer = false;
                }
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }


    private static String Selection(Scanner scanneur) {
        System.out.println("1. Chiffrer un message");
        System.out.println("2. Déchiffrer un message");
        System.out.println("3. Retour");
        System.out.println("---------------------");
        System.out.print("Veuillez faire un choix entre 1 et 3 : ");

        return scanneur.next();
    }
}