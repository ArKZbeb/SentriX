package Menu;


import chiffrement.ROTClass;
import chiffrement.Rc4;


import java.security.NoSuchAlgorithmException;

import java.util.Base64;
import java.util.Scanner;
import static Common.CommonClass.*;
import static Hash.HachageClass.Hachage256;
import static Hash.HachageClass.HachageMD5;

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
                        NombrePseudoAleatoires();
                case "4" -> System.out.println("Description des outils - à venir.");

                // TODO méthode à implementer
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
    public static void MenuChoixChiffrement(Scanner scanner) {
        boolean retourMenuDemarage = false;

        while (!retourMenuDemarage) {
            // Affichage des options pour le menu de chiffrement
            System.out.println("---------------------");
            System.out.println("1. ROT(X)");
            System.out.println("2. Vigenère");
            System.out.println("3. Carré de Polybe");
            System.out.println("4. Retour en arrière");
            System.out.println("5. Quitter");
            System.out.println("---------------------");
            System.out.print("Veuillez faire un choix entre 1 et 5 : ");

            // Lire et vérifier l'entrée de l'utilisateur
            String entree = VerificationEntree(scanner, 1, 5);
            switch (entree) {
                case "1" -> {
                    System.out.println("---------------------");
                    System.out.println("Option ROT(X) sélectionnée");
                    MenuROT(scanner);
                }
                // TODO méthode à implementer
                case "2" -> {
                    System.out.println("---------------------");
                    System.out.println("Option Vigenère sélectionnée");
                }
                // TODO méthode à implementer
                case "3" -> {
                    System.out.println("---------------------");
                    System.out.println("Option Carré de Polybe sélectionnée");
                }
                // TODO méthode à implementer
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

    // Méthode pour afficher et gérer les options de hachage
    public static void MenuChoixHachage(Scanner scanneur) throws NoSuchAlgorithmException {
        boolean retourMenuDemarage = false;

        while (!retourMenuDemarage) {
            // Affichage des options pour le menu de hachage
            System.out.println("---------------------");
            System.out.println("1. Enigma");
            System.out.println("2. RC4");
            System.out.println("3. SHA-256");
            System.out.println("4. MD5");
            System.out.println("5. Retour en arrière");
            System.out.println("6. Quitter");
            System.out.println("---------------------");
            System.out.print("Veuillez faire un choix entre 1 et 6 : ");

            // Lire et vérifier l'entrée de l'utilisateur
            String entree = VerificationEntree(scanneur, 1, 6);
            switch (entree) {
                case "1" -> {
                    System.out.println("---------------------");
                    System.out.println("Option Enigma sélectionnée");
                }
                // TODO méthode à implementer
                case "2" -> {
                    System.out.println("---------------------");
                    System.out.println("Option RC4 sélectionnée");
                    MenuRC4(scanneur);
                }
                // TODO méthode à implementer
                case "3" -> {
                    System.out.println("---------------------");
                    Hachage256(scanneur);
                }
                case "4" -> {
                    System.out.println("---------------------");
                    HachageMD5(scanneur);
                }
                // TODO méthode à implementer
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

    // Dans MenuClass
    public static void MenuROT(Scanner scanner) {

        boolean continuer = true;

        while (continuer){
            System.out.println("---------------------");
            System.out.println("1. Chiffrer un message");
            System.out.println("2. Déchiffrer un message");
            System.out.println("3. Retour");
            System.out.println("---------------------");
            System.out.print("Veuillez faire un choix entre 1 et 3 : ");

            String choix = scanner.next();

            switch (choix) {
                case "1" -> {
                    // Permet de demander à l'utilisateur de saisir un texte contenant uniquement des lettres
                    String texte = ROTClass.demanderTexte("Entrez le texte à chiffrer : ");

                    // Permet de demander à l'utilisateur de saisir un décalage valide
                    int decalage = ROTClass.demanderDecalage();

                    // Permet chiffrer le texte avec le décalage
                    String resultat = ROTClass.ROTChiffrer(texte, decalage);
                    System.out.println("Message chiffré : " + resultat);
                }
                case "2" -> {
                    // Permet de demander à l'utilisateur de saisir un texte contenant uniquement des lettres
                    String texte = ROTClass.demanderTexte("Entrez le texte à déchiffrer : ");

                    // Permet de demander à l'utilisateur de saisir un décalage valide
                    int decalage = ROTClass.demanderDecalage();

                    // Peremt de déchiffrer le texte avec le décalage
                    String resultat = ROTClass.ROTDechiffrer(texte, decalage);
                    System.out.println("Message déchiffré : " + resultat);
                }
                case "3" -> {System.out.println("Retour au menu principal.");
                    continuer = false;
                }
                default -> {
                    System.out.println("---------------------");
                    System.out.println(COULEUR_ROUGE + "Choix invalide, veuillez réessayer."+ COULEUR_PAR_DEFAUT);
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


    // Méthode pour générer et afficher un nombre pseudo-aléatoire (fonctionnalité à ajouter)
    public static void NombrePseudoAleatoires() {
        System.out.println("Nombre pseudo-aléatoire - fonction à venir.");
    }
}