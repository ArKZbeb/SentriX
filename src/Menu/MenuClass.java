package Menu;

import java.util.Scanner;
import static Common.CommonClass.*;

public class MenuClass {
    // Définition des codes de couleurs pour le texte dans la console (rouge et blanc par défaut)
    public static String COULEUR_ROUGE = "\u001B[31m";
    public static String COULEUR_PAR_DEFAUT = "\u001B[0m";

    // Méthode pour afficher et gérer le menu principal de démarrage
    public static void MenuDemarage(Scanner scanner) {
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
            String choix = scanner.next();

            // Gestion des différentes options de menu en fonction du choix de l'utilisateur
            switch (choix) {
                case "1":
                    // Menu pour les différents chiffrements possibles
                    MenuChoixChiffrement(scanner);
                    break;
                case "2":
                    // Menu pour les différents hachages possibles
                    MenuChoixHachage(scanner);
                    break;
                case "3":
                    // Appel de la fonction pour générer un nombre aléatoire
                    NombrePseudoAleatoires();
                    break;
                case "4":
                    System.out.println("Description des outils - à venir.");
                    // TODO méthode à implementer
                    break;
                case "5":
                case "quitter":
                    // Sortir de la boucle et quitter l'application
                    stopApplication = true;
                    break;
                default:
                    // Message d'erreur pour les entrées invalides
                    System.out.println("---------------------");
                    System.out.println(COULEUR_ROUGE + "Merci de mettre un input correct" + COULEUR_PAR_DEFAUT);
                    break;
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
                case "1":
                    System.out.println("---------------------");
                    System.out.println("Option ROT(X) sélectionnée");
                    // TODO méthode à implementer
                    break;
                case "2":
                    System.out.println("---------------------");
                    System.out.println("Option Vigenère sélectionnée");
                    // TODO méthode à implementer
                    break;
                case "3":
                    System.out.println("---------------------");
                    System.out.println("Option Carré de Polybe sélectionnée");
                    // TODO méthode à implementer
                    break;
                case "4":
                    // Retour au menu principal
                    retourMenuDemarage = true;
                    break;
                case "5":
                case "quitter":
                    // Quitter l'application
                    ArretApplication();
                    break;
                default:
                    break;
            }
        }
    }

    // Méthode pour afficher et gérer les options de hachage
    public static void MenuChoixHachage(Scanner scanner) {
        boolean retourMenuDemarage = false;

        while (!retourMenuDemarage) {
            // Affichage des options pour le menu de hachage
            System.out.println("---------------------");
            System.out.println("1. Enigma");
            System.out.println("2. RC4");
            System.out.println("3. SHA-256");
            System.out.println("4. Retour en arrière");
            System.out.println("5. Quitter");
            System.out.println("---------------------");
            System.out.print("Veuillez faire un choix entre 1 et 5 : ");

            // Lire et vérifier l'entrée de l'utilisateur
            String entree = VerificationEntree(scanner, 1, 5);
            switch (entree) {
                case "1":
                    System.out.println("---------------------");
                    System.out.println("Option Enigma sélectionnée");
                    // TODO méthode à implementer
                    break;
                case "2":
                    System.out.println("---------------------");
                    System.out.println("Option RC4 sélectionnée");
                    // TODO méthode à implementer
                    break;
                case "3":
                    System.out.println("---------------------");
                    System.out.println("Option SHA-256 sélectionnée");
                    // TODO méthode à implementer
                    break;
                case "4":
                    // Retour au menu principal
                    retourMenuDemarage = true;
                    break;
                case "5":
                case "quitter":
                    // Quitter l'application
                    ArretApplication();
                    break;
                default:
                    break;
            }
        }
    }

    // Méthode pour générer et afficher un nombre pseudo-aléatoire (fonctionnalité à ajouter)
    public static void NombrePseudoAleatoires() {
        System.out.println("Nombre pseudo-aléatoire - fonction à venir.");
    }
}