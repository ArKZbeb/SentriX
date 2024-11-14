package Chiffrement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Enigma {
    private List<int[]> rotors;
    private int[] reflector;
    private int[] rotorPositions;
    private int[] initialRotorPositions;

    private static final int LIMITE_CARACTERES_MESSAGE = 1000;
    private static final int LIMITE_CARACTERES_CLE = 100;

    // Constructeur avec configuration et positions initiales des rotors
    public Enigma(String key, int[] initialPositions) {
        if ("HistorII".equals(key)) {
            initialiserRotorsHistoriques();
            System.out.println("Configuration historique chargée !");
        } else if (validerCle(key)) {
            initialiserRotorsPersonnalises();
            System.out.println("Configuration personnalisée chargée.");
        } else {
            throw new IllegalArgumentException("Erreur : Clé invalide.");
        }
        setInitialRotorPositions(initialPositions);
        resetRotorPositions();
    }

    // Méthode publique pour chiffrer via le menu
    public static void enigmaChiffrer(Scanner scanner) {
        System.out.print("Appuyez sur Entrée pour une configuration personnalisée ou entrez HistorII pour la configuration historique : ");
        String configKey = scanner.nextLine();
        int[] initialPositions = configurerRotors(scanner);
        Enigma enigma = new Enigma(configKey.equals("HistorII") ? "HistorII" : configKey, initialPositions);
        System.out.print("Entrez le message à chiffrer avec Enigma : ");
        String message = scanner.nextLine();
        System.out.println("Message chiffré avec Enigma : " + enigma.chiffrer(message));
    }

    // Méthode publique pour déchiffrer via le menu
    public static void enigmaDechiffrer(Scanner scanner) {
        System.out.print("Appuyez sur Entrée pour une configuration personnalisée ou entrez HistorII pour la configuration historique : ");
        String configKey = scanner.nextLine();
        int[] initialPositions = configurerRotors(scanner);
        Enigma enigma = new Enigma(configKey.equals("HistorII") ? "HistorII" : configKey, initialPositions);
        System.out.print("Entrez le message à déchiffrer avec Enigma : ");
        String message = scanner.nextLine();
        System.out.println("Message déchiffré avec Enigma : " + enigma.dechiffrer(message));
    }

    // Configuration des rotors pour la console
    private static int[] configurerRotors(Scanner scanner) {
        int[] positions = new int[3];
        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Position du rotor " + (i + 1) + " (entre 0 et 25) : ");
                positions[i] = scanner.nextInt();
                if (positions[i] >= 0 && positions[i] <= 25) {
                    break;
                } else {
                    System.out.println("Erreur : La position du rotor doit être comprise entre 0 et 25.");
                }
            }
        }
        scanner.nextLine(); // Consommer la fin de ligne
        return positions;
    }

    // Validation de la clé
    private boolean validerCle(String key) {
        return key.matches("[A-Za-z]+") && key.length() <= LIMITE_CARACTERES_CLE;
    }

    // Initialisation des rotors historiques
    private void initialiserRotorsHistoriques() {
        rotors = new ArrayList<>();
        rotors.add(new int[]{4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9});
        rotors.add(new int[]{0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4});
        rotors.add(new int[]{1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14});
        reflector = new int[]{24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 1, 6, 14, 10, 12, 8, 4, 19, 25, 13, 5, 22, 2, 21, 9, 0};
    }

    // Initialisation des rotors personnalisés
    private void initialiserRotorsPersonnalises() {
        rotors = new ArrayList<>();
        rotors.add(new int[]{1, 0, 4, 7, 2, 9, 5, 6, 3, 8, 10, 12, 11, 13, 15, 14, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25});
        rotors.add(new int[]{6, 2, 1, 5, 3, 0, 4, 8, 7, 9, 10, 12, 11, 14, 13, 15, 17, 16, 18, 20, 19, 21, 23, 22, 24, 25});
        rotors.add(new int[]{5, 2, 8, 7, 4, 1, 6, 0, 3, 9, 10, 11, 12, 13, 15, 14, 16, 18, 17, 20, 19, 21, 22, 24, 23, 25});
        reflector = new int[]{19, 14, 23, 7, 17, 15, 11, 3, 12, 25, 16, 6, 8, 22, 1, 5, 10, 4, 21, 0, 24, 18, 13, 2, 20, 9};
    }

    // Définition des positions initiales des rotors
    public void setInitialRotorPositions(int[] positions) {
        if (positions.length != 3) {
            throw new IllegalArgumentException("Erreur : Les positions initiales doivent inclure 3 valeurs pour les 3 rotors.");
        }
        this.initialRotorPositions = positions.clone();
    }

    // Réinitialisation des rotors
    private void resetRotorPositions() {
        rotorPositions = initialRotorPositions.clone();
    }

    // Chiffrement
    public String chiffrer(String texte) {
        if (!validerMessage(texte)) {
            throw new IllegalArgumentException("Erreur : Message invalide.");
        }
        resetRotorPositions();
        return traiterTexte(texte);
    }

    // Déchiffrement
    public String dechiffrer(String texte) {
        if (!validerMessage(texte)) {
            throw new IllegalArgumentException("Erreur : Message invalide.");
        }
        resetRotorPositions();
        return traiterTexte(texte);
    }

    // Validation du message
    private boolean validerMessage(String texte) {
        return texte.matches("[A-Za-z]+") && texte.length() <= LIMITE_CARACTERES_MESSAGE;
    }

    // Traitement du texte via les rotors et le réflecteur
    private String traiterTexte(String texte) {
        StringBuilder resultat = new StringBuilder();
        for (char c : texte.toUpperCase().toCharArray()) {
            int code = c - 'A';
            code = passerParRotors(code, true);
            code = reflector[code];
            code = passerParRotors(code, false);
            resultat.append((char) ('A' + code));
            incrementerRotors();
        }
        return resultat.toString();
    }

    // Passage dans les rotors (avant et après réflecteur)
    private int passerParRotors(int code, boolean forward) {
        if (forward) {
            for (int i = 0; i < rotors.size(); i++) {
                int position = (code + rotorPositions[i]) % 26;
                code = (rotors.get(i)[position] - rotorPositions[i] + 26) % 26;
            }
        } else {
            for (int i = rotors.size() - 1; i >= 0; i--) {
                int position = (code + rotorPositions[i]) % 26;
                for (int j = 0; j < 26; j++) {
                    if ((rotors.get(i)[j] - rotorPositions[i] + 26) % 26 == code) {
                        code = j;
                        break;
                    }
                }
            }
        }
        return code;
    }

    // Incrément des rotors
    private void incrementerRotors() {
        for (int i = 0; i < rotorPositions.length; i++) {
            rotorPositions[i] = (rotorPositions[i] + 1) % 26;
            if (rotorPositions[i] != 0) break;
        }
    }
}
