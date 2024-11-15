package Chiffrement;

import java.util.Scanner;

public class VigenereCipherClass {
    // Méthode permetant de rediriger vers le chiffrement ou l'inverse en fonction de l'entree de l'utilisateur
    public static void GlobaleVigenereManageur(String entree, Scanner scanneur){
        switch(entree){
            case "1" ->{
                // Permet de demander à l'utilisateur de saisir un texte contenant uniquement des lettres
                System.out.println("Entrez le texte à chiffrer : ");
                String texte = scanneur.next();

                System.out.println("Entrez la clé : ");
                String cle = scanneur.next();

                // Permet chiffrer le texte
                String resultat = VigenereChiffrer(texte, cle);

                System.out.println("Message chiffré : " + resultat);
            }
            case "2" ->{
                // Permet de demander à l'utilisateur de saisir un texte contenant uniquement des lettres
                System.out.println("Entrez le texte à déchiffrer : ");
                String texte = scanneur.next();

                System.out.println("Entrez la clé : ");
                String cle = scanneur.next();

                // Permet de déchiffrer le texte
                String resultat = VigenereDechiffrer(texte, cle);

                System.out.println("Message déchiffré : " + resultat);
            }
        }
    }

    // Méthode pour chiffrer un texte avec le chiffre de Vigenère
    public static String VigenereChiffrer(String texte, String cle) {
        StringBuilder result = new StringBuilder(); // StringBuilder pour construire le texte chiffré
        int cleIndex = 0; // Index pour suivre la position dans la clé

        // Boucle pour parcourir chaque caractère du texte
        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i); // Caractère actuel du texte
            char cleChar = cle.charAt(cleIndex % cle.length()); // Caractère de la clé correspondant

            // Vérifie si le caractère est une lettre
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a'; // Base pour majuscule ou minuscule
                char cleBase = Character.isUpperCase(cleChar) ? 'A' : 'a'; // Base de la clé pour majuscule/minuscule
                int decalage = (c - base + (cleChar - cleBase)) % 26; // Calcul du décalage pour le chiffrement
                result.append((char) (base + decalage)); // Ajoute le caractère chiffré au résultat
                cleIndex++; // Incrémente l'index de la clé
            } else {
                // Ajoute les caractères non alphabétiques sans modification
                result.append(c);
            }
        }
        return result.toString(); // Retourne le texte chiffré
    }

    // Méthode pour déchiffrer un texte chiffré avec le chiffre de Vigenère
    public static String VigenereDechiffrer(String texte, String cle) {
        StringBuilder result = new StringBuilder(); // StringBuilder pour construire le texte déchiffré
        int cleIndex = 0; // Index pour suivre la position dans la clé

        // Boucle pour parcourir chaque caractère du texte chiffré
        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i); // Caractère actuel du texte chiffré
            char cleChar = cle.charAt(cleIndex % cle.length()); // Caractère de la clé correspondant

            // Vérifie si le caractère est une lettre
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a'; // Base pour majuscule ou minuscule
                char cleBase = Character.isUpperCase(cleChar) ? 'A' : 'a'; // Base de la clé pour majuscule/minuscule
                int decalage = (c - base - (cleChar - cleBase) + 26) % 26; // Calcul du décalage pour le déchiffrement
                result.append((char) (base + decalage)); // Ajoute le caractère déchiffré au résultat
                cleIndex++; // Incrémente l'index de la clé
            } else {
                // Ajoute les caractères non alphabétiques sans modification
                result.append(c);
            }
        }
        return result.toString(); // Retourne le texte déchiffré
    }
}