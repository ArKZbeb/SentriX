package Chiffrement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnigmaClass {
    // Liste pour stocker les configurations des rotors
    private List<int[]> rotors;
    // Tableau représentant le réflecteur
    private int[] reflector;
    // Positions actuelles des rotors
    private int[] rotorPositions;
    // Positions initiales des rotors
    private int[] initialRotorPositions;

    // Limite de caractères pour le message
    private static final int LIMITE_CARACTERES_MESSAGE = 1000;
    // Limite de caractères pour la clé
    private static final int LIMITE_CARACTERES_CLE = 100;

    // Constructeur de la classe Enigma
    public EnigmaClass(String key, int[] initialPositions) {
        // Si la clé est "HistorII", on charge la configuration historique des rotors
        if ("HistorII".equals(key)) {
            initialiserRotorsHistoriques();
            System.out.println("Configuration historique chargée !");
        } 
        // Sinon, on vérifie si la clé est valide pour charger une configuration personnalisée
        else if (validerCle(key)) {
            initialiserRotorsPersonnalises();
            System.out.println("Configuration personnalisée chargée.");
        } 
        // En cas de clé invalide, on met un message et on reviens à l'itération d'avant
        else {
            System.out.println("Erreur : Clé invalide.");
        }
        // On définit les positions initiales des rotors et on les réinitialise
        setInitialRotorPositions(initialPositions);
        resetRotorPositions();
    }

    // Méthode statique pour chiffrer un message avec l'interface console
        public static String enigmaChiffrer(Scanner scanner) {
        System.out.print("Votre clé : ");
        String configKey = scanner.next();
        
        // Configuration des positions initiales des rotors
        int[] initialPositions = configurerRotors(scanner);
        EnigmaClass enigma;

        // Si la clé est "HistorII", on charge la configuration historique
        if (configKey.equals("HistorII")) {
            enigma = new EnigmaClass("HistorII", initialPositions);
            System.out.print("Entrez une clé de chiffrement (mot clair pour aligner les rotors) : ");
            configKey = scanner.nextLine();
        } 
        // Sinon, on utilise la clé personnalisée fournie
        else {
            enigma = new EnigmaClass(configKey, initialPositions);
        }

        // Saisie du message à chiffrer et affichage du résultat chiffré
        System.out.print("Entrez le message à chiffrer avec Enigma : ");
        String message = scanner.nextLine();
        System.out.println("Message chiffré avec Enigma : " + enigma.chiffrer(message));
        return enigma.chiffrer(message);
    }

    // Méthode statique pour déchiffrer un message avec l'interface console
    public static void enigmaDechiffrer(Scanner scanner) {
        System.out.print("Appuyez sur Entrée pour une configuration personnalisée : ");
        String configKey = scanner.next();
        
        // Configuration des positions initiales des rotors
        int[] initialPositions = configurerRotors(scanner);
        EnigmaClass enigma;

        // Si la clé est "HistorII", on charge la configuration historique
        if (configKey.equals("HistorII")) {
            enigma = new EnigmaClass("HistorII", initialPositions);
            System.out.print("Entrez une clé de déchiffrement (identique à celle utilisée pour chiffrer) : ");
            configKey = scanner.next();
        } 
        // Sinon, on utilise la clé personnalisée fournie
        else {
            enigma = new EnigmaClass(configKey, initialPositions);
        }

        // Saisie du message à déchiffrer et affichage du résultat déchiffré
        System.out.print("Entrez le message à déchiffrer avec Enigma : ");
        String message = scanner.next();
        System.out.println("Message déchiffré avec Enigma : " + enigma.dechiffrer(message));
    }

    // Méthode pour configurer les positions des rotors
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
        scanner.nextLine(); // Consomme la fin de ligne restante
        return positions;
    }

    // Méthode pour valider la clé de chiffrement
    private boolean validerCle(String key) {
        return key.matches("[A-Za-z]+") && key.length() <= LIMITE_CARACTERES_CLE;
    }

    // Méthode pour initialiser les rotors avec une configuration historique
    private void initialiserRotorsHistoriques() {
        rotors = new ArrayList<>();
        rotors.add(new int[]{4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9});
        rotors.add(new int[]{0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4});
        rotors.add(new int[]{1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14});
        reflector = new int[]{24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 1, 6, 14, 10, 12, 8, 4, 19, 25, 13, 5, 22, 2, 21, 9, 0};
    }

    // Méthode pour initialiser les rotors avec une configuration personnalisée
    private void initialiserRotorsPersonnalises() {
        rotors = new ArrayList<>();
        rotors.add(new int[]{1, 0, 4, 7, 2, 9, 5, 6, 3, 8, 10, 12, 11, 13, 15, 14, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25});
        rotors.add(new int[]{6, 2, 1, 5, 3, 0, 4, 8, 7, 9, 10, 12, 11, 14, 13, 15, 17, 16, 18, 20, 19, 21, 23, 22, 24, 25});
        rotors.add(new int[]{5, 2, 8, 7, 4, 1, 6, 0, 3, 9, 10, 11, 12, 13, 15, 14, 16, 18, 17, 20, 19, 21, 22, 24, 23, 25});
        reflector = new int[]{19, 14, 23, 7, 17, 15, 11, 3, 12, 25, 16, 6, 8, 22, 1, 5, 10, 4, 21, 0, 24, 18, 13, 2, 20, 9};
    }

    // Définit les positions initiales des rotors
    public void setInitialRotorPositions(int[] positions) {
        if (positions.length != 3) {
            System.out.println("Erreur : Les positions initiales doivent inclure 3 valeurs pour les 3 rotors.");
        }
        this.initialRotorPositions = positions.clone();
    }

    // Réinitialise les rotors à leurs positions de départ
    private void resetRotorPositions() {
        rotorPositions = initialRotorPositions.clone();
    }

    // Méthode de chiffrement
    private String chiffrer(String texte) {
        if (!validerMessage(texte)) {
            System.out.println("Erreur : Message invalide.");
        }
        resetRotorPositions();
        return traiterTexte(texte);
    }

    // Méthode de déchiffrement
    private String dechiffrer(String texte) {
        if (!validerMessage(texte)) {
            System.out.println("Erreur : Message invalide.");
        }
        resetRotorPositions();
        return traiterTexte(texte);
    }

    // Validation du message
    private boolean validerMessage(String texte) {
        return texte.matches("[A-Za-z]+") && texte.length() <= LIMITE_CARACTERES_MESSAGE;
    }

    // Méthode pour traiter le texte (chiffrer ou déchiffrer)
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

    // Méthode pour passer par les rotors
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

    // Incrémente les rotors
    private void incrementerRotors() {
        for (int i = 0; i < rotorPositions.length; i++) {
            rotorPositions[i] = (rotorPositions[i] + 1) % 26;
            if (rotorPositions[i] != 0) break;
        }
    }
}
