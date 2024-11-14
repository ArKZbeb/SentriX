package Chiffrement;

public class VigenereCipher {
    // Limites de caractères pour le message et la clé
    private static final int LIMITE_CARACTERES_MESSAGE = 1000;
    private static final int LIMITE_CARACTERES_CLE = 100;

    // Méthode pour chiffrer un texte avec le chiffre de Vigenère
    public static String chiffrer(String texte, String cle) {
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
    public static String dechiffrer(String texte, String cle) {
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
