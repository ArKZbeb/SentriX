package Chiffrement;

import java.util.HashMap;
import java.util.Map;

public class CarreDePolybe {
    // Déclaration du carré de Polybe avec les lettres de l'alphabet
    private static final char[][] CARRE = {
        {'A', 'B', 'C', 'D', 'E'},
        {'F', 'G', 'H', 'I', 'K'},  // Remplacement de J par I pour adapter au carré 5x5
        {'L', 'M', 'N', 'O', 'P'},
        {'Q', 'R', 'S', 'T', 'U'},
        {'V', 'W', 'X', 'Y', 'Z'}
    };
    
    // Maps pour stocker les correspondances entre lettres et codes
    private static final Map<Character, String> mapChiffrement = new HashMap<>();
    private static final Map<String, Character> mapDechiffrement = new HashMap<>();
    
    // Initialisation des mappages pour le chiffrement et le déchiffrement
    static {
        for (int i = 0; i < CARRE.length; i++) {
            for (int j = 0; j < CARRE[i].length; j++) {
                char lettre = CARRE[i][j];
                String code = "" + (i + 1) + (j + 1); // Création du code pour chaque lettre (ligne+colonne)
                mapChiffrement.put(lettre, code);     // Association lettre -> code pour chiffrement
                mapDechiffrement.put(code, lettre);   // Association code -> lettre pour déchiffrement
            }
        }
    }

    // Méthode pour chiffrer un texte avec le carré de Polybe
    public static String chiffrer(String texte) {
        StringBuilder texteChiffre = new StringBuilder();
        texte = texte.toUpperCase().replace("J", "I"); // Remplacement de J par I pour correspondre au carré
        
        // Boucle sur chaque lettre du texte
        for (char lettre : texte.toCharArray()) {
            // Si la lettre est dans le carré de Polybe, ajouter son code chiffré
            if (mapChiffrement.containsKey(lettre)) {
                texteChiffre.append(mapChiffrement.get(lettre)).append(" ");
            }
        }
        
        // Retourne le texte chiffré sous forme de chaîne, avec les codes séparés par des espaces
        return texteChiffre.toString().trim();
    }

    // Méthode pour déchiffrer un texte chiffré avec le carré de Polybe
    public static String dechiffrer(String texteChiffre) {
        StringBuilder texteDechiffre = new StringBuilder();
        String[] codes = texteChiffre.split(" "); // Division du texte en codes individuels
        
        // Boucle sur chaque code du texte chiffré
        for (String code : codes) {
            // Si le code est dans le mappage de déchiffrement, ajouter la lettre correspondante
            if (mapDechiffrement.containsKey(code)) {
                texteDechiffre.append(mapDechiffrement.get(code));
            }
        }
        
        // Retourne le texte déchiffré sous forme de chaîne
        return texteDechiffre.toString();
    }
}
