package Lfsr;

import java.util.Arrays;
import java.util.Scanner;

import static Common.CommonClass.BinaireVersDecimal;

public class LfsrClass {

    public static void LFSR(Scanner scanneur) {
        // Boucle jusqu'à ce que l'utilisateur décide de quitter
        while (true) {
            System.out.println("---------------------");
            System.out.println("Entrer une graine ou ecrire 'quitter' pour revenir en arrière:");
            String entree = scanneur.next();

            // Reviens au menu antérieur si l'utilisateur tape "quitter"
            if (entree.equalsIgnoreCase("quitter")) {
                System.out.println("Sortie...");
                break;
            }
            // Initialiser le LFSR avec la graine entrée
            StringBuilder valeurBinaireStr = InitialisationLFSR(entree);

            // Nombre d'étapes à simuler
            int etapes = 10;
            StringBuilder resultat = new StringBuilder();
            for (int i = 0; i < etapes; i++) {
                int nouveauBit = Etape(valeurBinaireStr, 0, 6); // XOR bits aux positions 0 et 6
                resultat.append(nouveauBit);
            }
            System.out.println("---------------------");
            System.out.println("Resultat : " + resultat);
            // Convertit le résultat binaire en décimal
            BinaireVersDecimal(resultat);
        }
    }

    // Méthode pour initialiser le LFSR avec une graine donnée
    public static StringBuilder InitialisationLFSR(String graine) {
        // Conversion de la graine en ascii
        byte[] valeurBinaire = graine.getBytes();
        System.out.println("---------------------");
        System.out.println("Valeur initiale : " + Arrays.toString(valeurBinaire));

        // conversion de la graine en binaire
        StringBuilder binaireStr = RecupereValeurBinaire(valeurBinaire);
        System.out.println("---------------------");
        System.out.println("Valeur binaire convertie: " + binaireStr);
        return binaireStr;
    }

    // Méthode pour simuler une étape du LFSR
    public static int Etape(StringBuilder octet, int positionA, int positionB) {
        // Obtenir les bits aux positions spécifiées
        char bitA = octet.charAt(positionA);
        char bitB = octet.charAt(positionB);
        // XOR des deux bits pour obtenir le nouveau bit
        char nouveauBit = (bitA == bitB) ? '0' : '1';
        // Décalage à gauche : supprime le bit le plus à gauche
        octet.deleteCharAt(0);
        // Ajoute le nouveau bit à la fin
        octet.append(nouveauBit);
        // Retourne le nouveau bit sous forme d'entier (0 ou 1)
        return nouveauBit == '0' ? 0 : 1;
    }

    // Méthode pour convertir un tableau d'octets en binaire
    private static StringBuilder RecupereValeurBinaire(byte[] octet) {
        // Convertit chaque octet en binaire
        StringBuilder binaire = new StringBuilder();
        for (byte b : octet) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binaire.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binaire;
    }
}
