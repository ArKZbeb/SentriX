package Doc;

import java.util.Scanner;

public class DocumentationClass {

    // Codes de couleur pour les descriptions
    public static final String COULEUR_BLEU = "\u001B[34m";
    public static final String COULEUR_PAR_DEFAUT = "\u001B[0m";

    // Méthode principale pour afficher la documentation et naviguer dans le menu
    public static void AfficherDocumentation(Scanner scanner) {
        boolean continuer = true;

        while (continuer) {
            // Menu principal de documentation
            System.out.println("---------------------");
            System.out.println("Documentation des Méthodes");
            System.out.println("---------------------");
            System.out.println("1. Menu Principal");
            System.out.println("2. Méthodes de Chiffrement");
            System.out.println("3. Méthodes de Hachage");
            System.out.println("4. Quitter");
            System.out.println("---------------------");
            System.out.print("Veuillez faire un choix entre 1 et 4 : ");

            // Lecture de l'option choisie par l'utilisateur
            String choix = scanner.next();

            // Affichage de la documentation pour chaque section
            switch (choix) {
                case "1" -> AfficherDocumentationMenuPrincipal(scanner);
                case "2" -> AfficherDocumentationChiffrement(scanner);
                case "3" -> AfficherDocumentationHachage(scanner);
                case "4" -> {
                    System.out.println("Fermeture du menu de documentation...");
                    continuer = false;
                }
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    // Documentation pour le menu principal
    private static void AfficherDocumentationMenuPrincipal(Scanner scanner) {
        boolean continuer = true;

        while (continuer) {
            System.out.println("---------------------");
            System.out.println("Documentation du Menu Principal");
            System.out.println("---------------------");
            System.out.println("1. MenuDemarage");
            System.out.println("2. MenuChoixChiffrement");
            System.out.println("3. MenuChoixHachage");
            System.out.println("4. Retour");
            System.out.println("---------------------");
            System.out.print("Veuillez choisir une méthode pour afficher sa description (1-4) : ");

            String choix = scanner.next();

            switch (choix) {
                case "1" -> DescriptionMenuDemarage();
                case "2" -> DescriptionMenuChoixChiffrement();
                case "3" -> DescriptionMenuChoixHachage();
                case "4" -> continuer = false;
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    // Documentation pour les méthodes de chiffrement
    private static void AfficherDocumentationChiffrement(Scanner scanner) {
        boolean continuer = true;

        while (continuer) {
            System.out.println("---------------------");
            System.out.println("Documentation des Méthodes de Chiffrement");
            System.out.println("---------------------");
            System.out.println("1. ROT(X)");
            System.out.println("2. Vigenère");
            System.out.println("3. Carré de Polybe");
            System.out.println("4. Enigma");
            System.out.println("5. Retour");
            System.out.println("---------------------");
            System.out.print("Veuillez choisir une méthode pour afficher sa description (1-5) : ");

            String choix = scanner.next();

            switch (choix) {
                case "1" -> DescriptionROT();
                case "2" -> DescriptionVigenere();
                case "3" -> DescriptionCarreDePolybe();
                case "4" -> DescriptionEnigma();
                case "5" -> continuer = false;
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    // Documentation pour les méthodes de hachage
    private static void AfficherDocumentationHachage(Scanner scanner) {
        boolean continuer = true;

        while (continuer) {
            System.out.println("---------------------");
            System.out.println("Documentation des Méthodes de Hachage");
            System.out.println("---------------------");
            System.out.println("1. SHA-256");
            System.out.println("2. MD5");
            System.out.println("3. RC4");
            System.out.println("4. Retour");
            System.out.println("---------------------");
            System.out.print("Veuillez choisir une méthode pour afficher sa description (1-4) : ");

            String choix = scanner.next();

            switch (choix) {
                case "1" -> DescriptionSHA256();
                case "2" -> DescriptionMD5();
                case "3" -> DescriptionRC4();
                case "4" -> continuer = false;
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    // Méthodes de description pour chaque option de chiffrement et de hachage

    private static void DescriptionMenuDemarage() {
        System.out.println("---------------------");
        System.out.println(COULEUR_BLEU + "Description de MenuDemarage:" + COULEUR_PAR_DEFAUT);
        System.out.println("Affiche le menu principal de l'application SentriX, permettant de naviguer vers les sous-menus de chiffrement, hachage, et options supplémentaires.");
    }

    private static void DescriptionMenuChoixChiffrement() {
        System.out.println("---------------------");
        System.out.println(COULEUR_BLEU + "Description de MenuChoixChiffrement:" + COULEUR_PAR_DEFAUT);
        System.out.println("Permet de choisir entre différents algorithmes de chiffrement : ROT(X), Vigenère, et Carré de Polybe.");
    }

    private static void DescriptionMenuChoixHachage() {
        System.out.println("---------------------");
        System.out.println(COULEUR_BLEU + "Description de MenuChoixHachage:" + COULEUR_PAR_DEFAUT);
        System.out.println("Permet de choisir entre différents algorithmes de hachage : SHA-256, MD5, et RC4.");
    }

    private static void DescriptionROT() {
        System.out.println("---------------------");
        System.out.println(COULEUR_BLEU + "Description de ROT(X):" + COULEUR_PAR_DEFAUT);
        System.out.println("Effectue un chiffrement de substitution en décalant chaque lettre du message d'un nombre X de positions.");
    }

    private static void DescriptionVigenere() {
        System.out.println("---------------------");
        System.out.println(COULEUR_BLEU + "Description de Vigenère:" + COULEUR_PAR_DEFAUT);
        System.out.println("Chiffre ou déchiffre un message en utilisant une clé de texte répétée pour créer un modèle de substitution cyclique.");
    }

    private static void DescriptionCarreDePolybe() {
        System.out.println("---------------------");
        System.out.println(COULEUR_BLEU + "Description de Carré de Polybe:" + COULEUR_PAR_DEFAUT);
        System.out.println("Utilise une grille carrée pour transformer chaque lettre en coordonnées numériques.");
    }

    private static void DescriptionEnigma() {
        System.out.println("---------------------");
        System.out.println(COULEUR_BLEU + "Description de Enigma:" + COULEUR_PAR_DEFAUT);
        System.out.println("Simule le chiffrement de type Enigma, basé sur des rotors pour obtenir des substitutions complexes et variées.");
    }

    private static void DescriptionSHA256() {
        System.out.println("---------------------");
        System.out.println(COULEUR_BLEU + "Description de SHA-256:" + COULEUR_PAR_DEFAUT);
        System.out.println("Génère un hachage de 256 bits pour sécuriser l'intégrité des messages, utilisé dans des contextes cryptographiques.");
    }

    private static void DescriptionMD5() {
        System.out.println("---------------------");
        System.out.println(COULEUR_BLEU + "Description de MD5:" + COULEUR_PAR_DEFAUT);
        System.out.println("Produit un hachage de 128 bits, souvent utilisé pour vérifier l'intégrité des fichiers et des données.");
    }

    private static void DescriptionRC4() {
        System.out.println("---------------------");
        System.out.println(COULEUR_BLEU + "Description de RC4:" + COULEUR_PAR_DEFAUT);
        System.out.println("Algorithme de chiffrement de flux qui utilise une clé pour chiffrer les données de manière rapide et légère.");
    }
}
