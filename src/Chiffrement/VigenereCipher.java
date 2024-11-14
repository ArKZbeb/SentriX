package Chiffrement;

public class VigenereCipher {
    private static final int LIMITE_CARACTERES_MESSAGE = 1000;
    private static final int LIMITE_CARACTERES_CLE = 100;

    public static String chiffrer(String texte, String cle) {
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

    public static String dechiffrer(String texte, String cle) {
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
