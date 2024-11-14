package Chiffrement;

import java.util.HashMap;
import java.util.Map;

public class CarreDePolybe {
    private static final char[][] CARRE = {
        {'A', 'B', 'C', 'D', 'E'},
        {'F', 'G', 'H', 'I', 'K'},
        {'L', 'M', 'N', 'O', 'P'},
        {'Q', 'R', 'S', 'T', 'U'},
        {'V', 'W', 'X', 'Y', 'Z'}
    };
    
    private static final Map<Character, String> mapChiffrement = new HashMap<>();
    private static final Map<String, Character> mapDechiffrement = new HashMap<>();
    
    static {
        for (int i = 0; i < CARRE.length; i++) {
            for (int j = 0; j < CARRE[i].length; j++) {
                char lettre = CARRE[i][j];
                String code = "" + (i + 1) + (j + 1);
                mapChiffrement.put(lettre, code);
                mapDechiffrement.put(code, lettre);
            }
        }
    }

    public static String chiffrer(String texte) {
        StringBuilder texteChiffre = new StringBuilder();
        texte = texte.toUpperCase().replace("J", "I"); 
        
        for (char lettre : texte.toCharArray()) {
            if (mapChiffrement.containsKey(lettre)) {
                texteChiffre.append(mapChiffrement.get(lettre)).append(" ");
            }
        }
        
        return texteChiffre.toString().trim();
    }

    public static String dechiffrer(String texteChiffre) {
        StringBuilder texteDechiffre = new StringBuilder();
        String[] codes = texteChiffre.split(" ");
        
        for (String code : codes) {
            if (mapDechiffrement.containsKey(code)) {
                texteDechiffre.append(mapDechiffrement.get(code));
            }
        }
        
        return texteDechiffre.toString();
    }
}
