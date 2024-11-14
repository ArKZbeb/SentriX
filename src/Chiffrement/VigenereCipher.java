package Chiffrement;

import java.util.Scanner;

public class VigenereCipher {

    public static void chiffrer(Scanner scanner) {
        System.out.print("Entrez le message à chiffrer avec Vigenère : ");
        String message = scanner.nextLine();
        System.out.print("Entrez la clé pour Vigenère : ");
        String key = scanner.nextLine();
        System.out.println("Message chiffré : " + chiffrerTexte(message, key));
    }

    public static void dechiffrer(Scanner scanner) {
        System.out.print("Entrez le message à déchiffrer avec Vigenère : ");
        String message = scanner.nextLine();
        System.out.print("Entrez la clé pour Vigenère : ");
        String key = scanner.nextLine();
        System.out.println("Message déchiffré : " + dechiffrerTexte(message, key));
    }

    public static String chiffrerTexte(String texte, String cle) {
        StringBuilder result = new StringBuilder();
        int cleIndex = 0;
        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i);
            char cleChar = cle.charAt(cleIndex % cle.length());
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char cleBase = Character.isUpperCase(cleChar) ? 'A' : 'a';
                int decalage = (c - base + (cleChar - cleBase)) % 26;
                result.append((char) (base + decalage));
                cleIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String dechiffrerTexte(String texte, String cle) {
        StringBuilder result = new StringBuilder();
        int cleIndex = 0;
        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i);
            char cleChar = cle.charAt(cleIndex % cle.length());
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char cleBase = Character.isUpperCase(cleChar) ? 'A' : 'a';
                int decalage = (c - base - (cleChar - cleBase) + 26) % 26;
                result.append((char) (base + decalage));
                cleIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
