package lfsr;

import java.util.Arrays;

public class LfsrClass {
    // Méthode pour initialiser le LFSR avec une graine donnée
    public static StringBuilder LFSR(String graine) {
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
