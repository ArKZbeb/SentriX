package Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommonClass {

    // Définition des codes de couleurs pour le texte dans la console (rouge et par défaut)
    public static String COULEUR_ROUGE = "\u001B[31m";
    public static String COULEUR_PAR_DEFAUT = "\u001B[0m";

    public static String VerificationEntree(Scanner scanneur, int chiffreMin, int chiffreMax) {
        List<String> entreeCorrecte = new ArrayList<>();

        // Crée une liste des entrées valides en fonction de chiffreMin et chiffreMax
        for (int i = chiffreMin; i <= chiffreMax; i++) {
            entreeCorrecte.add(String.valueOf(i));
        }

        // Lecture de l'entrée de l'utilisateur
        String entree = scanneur.next();

        // Vérifie si l'entrée est incluse dans la liste des valeurs valides
        if (!entreeCorrecte.contains(entree)) {
            // Affiche un message d'erreur en rouge si l'entrée n'est pas valide
            System.out.println("---------------------");
            System.out.println(COULEUR_ROUGE + "Merci de mettre une entrée correcte" + COULEUR_PAR_DEFAUT);
        }

        // Retourne l'entrée saisie (qu'elle soit valide ou non, pour traitement dans le menu principal)
        return entree;
    }

    // Méthode pour convertir le résultat binaire en décimal
    public static void BinaireVersDecimal(StringBuilder resultat) {
        // Convertit le résultat binaire en décimal
        int decimal = Integer.parseInt(resultat.toString(), 2);
        System.out.println("Resultat en decimal : " + decimal);
    }

    public static void ArretApplication() {
        // Affiche un message indiquant la fermeture de l'application
        System.out.println("Fermeture de l'application...");

        // Termine le programme avec succès (code de sortie 0)
        System.exit(0);
    }

    public static void NettoyageConsole() {
        // Affiche 50 lignes vides pour "nettoyer" la console
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}