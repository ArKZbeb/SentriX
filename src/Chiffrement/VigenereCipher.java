package Chiffrement;
import java.util.Scanner;

public class VigenereCipher {

    // Définition des limites de caractères pour le message et la clé
    private static final int LIMITE_CARACTERES_MESSAGE = 1000;
    private static final int LIMITE_CARACTERES_CLE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message;
        String key;

        // Demande à l'utilisateur de saisir un message en vérifiant la limite de caractères
        do {
            System.out.print("Entrez le message (max " + LIMITE_CARACTERES_MESSAGE + " caractères) : ");
            message = scanner.nextLine();
            if (message.length() > LIMITE_CARACTERES_MESSAGE) {
                System.out.println("Erreur : Le message dépasse la limite de " + LIMITE_CARACTERES_MESSAGE + " caractères.");
            }
        } while (message.length() > LIMITE_CARACTERES_MESSAGE);

        // Filtrage du message pour conserver uniquement les lettres
        message = filtrerLettres(message);
        System.out.println("Message après filtrage des lettres : " + message);

        // Demande à l'utilisateur de saisir une clé en vérifiant les contraintes
        boolean validKey;
        do {
            validKey = true;
            System.out.print("Entrez la clé (max " + LIMITE_CARACTERES_CLE + " caractères, lettres uniquement) : ");
            key = scanner.nextLine();

            // Vérifie si la clé dépasse la limite de caractères
            if (key.length() > LIMITE_CARACTERES_CLE) {
                System.out.println("Erreur : La clé dépasse la limite de " + LIMITE_CARACTERES_CLE + " caractères.");
                validKey = false;
            } 
            // Vérifie si la clé contient des chiffres
            else if (key.matches(".*\\d.*")) {
                System.out.println("Erreur : La clé ne doit pas contenir de chiffres. Veuillez entrer uniquement des lettres.");
                validKey = false;
            } 
            // Vérifie si la clé contient des caractères spéciaux
            else if (!key.matches("[A-Za-z]+")) {
                System.out.println("Erreur : La clé contient des caractères spéciaux. Veuillez entrer uniquement des lettres.");
                validKey = false;
            } else {
                // Filtrage de la clé pour conserver uniquement les lettres
                key = filtrerLettres(key);
                if (key.isEmpty()) {
                    System.out.println("Erreur : La clé doit contenir au moins une lettre.");
                    validKey = false;
                }
            }
        } while (!validKey);

        // Chiffrement du message
        String encryptedMessage = chiffrer(message, key);
        System.out.println("Message chiffré : " + encryptedMessage);

        // Déchiffrement du message
        String decryptedMessage = dechiffrer(encryptedMessage, key);
        System.out.println("Message déchiffré : " + decryptedMessage);

        scanner.close();
    }

    // Méthode pour filtrer une chaîne de caractères et ne conserver que les lettres
    public static String filtrerLettres(String texte) {
        return texte.replaceAll("[^A-Za-z]", "");  // Supprime tout sauf les lettres A-Z et a-z
    }

    // Méthode pour chiffrer le message avec le chiffre de Vigenère
    public static String chiffrer(String texte, String cle) {
        StringBuilder result = new StringBuilder();
        int cleIndex = 0;

        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i);
            char cleChar = cle.charAt(cleIndex % cle.length());
            // Vérifie si le caractère est une lettre
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char cleBase = Character.isUpperCase(cleChar) ? 'A' : 'a';
                int decalage = (c - base + (cleChar - cleBase)) % 26;
                result.append((char) (base + decalage));
                // Incrémente l'index de la clé
                cleIndex++;
            } else {
                // Si ce n'est pas une lettre, on l'ajoute sans modification
                result.append(c);
            }
        }
        return result.toString();
    }

    // Méthode pour déchiffrer le message avec le chiffre de Vigenère
    public static String dechiffrer(String texte, String cle) {
        StringBuilder result = new StringBuilder();
        int cleIndex = 0;

        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i);
            char cleChar = cle.charAt(cleIndex % cle.length());
            // Vérifie si le caractère est une lettre
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char cleBase = Character.isUpperCase(cleChar) ? 'A' : 'a';
                int decalage = (c - base - (cleChar - cleBase) + 26) % 26;
                result.append((char) (base + decalage));
                // Incrémente l'index de la clé
                cleIndex++;
            } else {
                // Si ce n'est pas une lettre, on l'ajoute sans modification
                result.append(c);
            }
        }
        return result.toString();
    }
}
