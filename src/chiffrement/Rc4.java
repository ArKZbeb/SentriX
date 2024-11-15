package chiffrement;

import java.util.Scanner;

public class Rc4 {

    // Tableau de permutation pour RC4
    private final int[] etat = new int[256];
    private int x, y;

    // Constructeur qui initialise l'état interne avec la clé
    public Rc4(String cle) {
        // Index pour la génération de flux
        initialiser(cle);
    }

    // Permet a l'initialisation de la clé (Key Scheduling Algorithm - KSA)
    private void initialiser(String cle) {
        // Permet le remplissage initial de l'état avec des valeurs de 0 à 255
        for (int i = 0; i < 256; i++) {
            etat[i] = i;
        }

        int j = 0;
        // Permet à un Mélange de l'état en fonction de la clé
        for (int i = 0; i < 256; i++) {
            // Permet le calcule de l'index de mélange
            j = (j + etat[i] + cle.charAt(i % cle.length())) & 0xFF;
            // Permet d'échanger des valeurs dans le tableau pour le mélange
            echanger(i, j);
        }
    }

    // Méthode pour échanger les valeurs dans le tableau d'état
    private void echanger(int i, int j) {
        int temp = etat[i];
        etat[i] = etat[j];
        etat[j] = temp;
    }

    // Permet au Chiffrement et déchiffrement du message (Pseudo-Random Generation Algorithm - PRGA)
    public String chiffrer(String message) {
        // Contiendra le texte chiffré ou déchiffré
        StringBuilder sortie = new StringBuilder();

        // Permet de faire le traitement de chaque caractère du message
        for (char c : message.toCharArray()) {
            // Permet de incrémenter x dans l'état
            x = (x + 1) & 0xFF;
            // Permet de faire le calcul de l'index y basé sur l'état
            y = (y + etat[x]) & 0xFF;

            // Permet de faire l'échange des valeurs dans l'état
            echanger(x, y);

            // Permet à la génération du caractère chiffré / déchiffré en appliquant XOR
            int caractereChiffre = c ^ etat[(etat[x] + etat[y]) & 0xFF];
            // Permet d'ajouter le caractère chiffré/déchiffré à la sortie
            sortie.append((char) caractereChiffre);
        }
        // Permet de retourne le résultat chiffré/déchiffré
        return sortie.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Permet de faire une demande à l'utilisateur de saisir la clé pour RC4
        System.out.print("Entrez la clé pour RC4 : ");
        String cle = scanner.nextLine();

        // Permet de faire une demande à l'utilisateur de saisir le message à chiffrer
        System.out.print("Entrez le message à chiffrer : ");
        String message = scanner.nextLine();

        // Permet à la création d'une instance RC4 pour chiffrer
        Rc4 rc4Chiffreur = new Rc4(cle);
        // Permet au chiffrement du message
        String messageChiffre = rc4Chiffreur.chiffrer(message);

        // Permet de faire l'affichage du message chiffré en hexadécimal pour une meilleure lisibilité
        System.out.println("Message chiffré (hex) : " + toHex(messageChiffre));

        // Permet à la création d'une nouvelle instance RC4 pour déchiffrer, pour réinitialiser l'état avec la même clé
        Rc4 rc4Dechiffreur = new Rc4(cle);
        // Permet au déchiffrement du message chiffré
        String messageDechiffre = rc4Dechiffreur.chiffrer(messageChiffre);

        // Permet de faire l'affichage du message déchiffré
        System.out.println("Message déchiffré : " + messageDechiffre);

        // Permet de faire la vérification si le déchiffrement est correct
        if (message.equals(messageDechiffre)) {
            System.out.println("Le message a été déchiffré correctement.");
        } else {
            System.out.println("Le déchiffrement a échoué.");
        }
    }

    // Méthode utilitaire pour convertir un texte en sa représentation hexadécimale
    private static String toHex(String message) {
        StringBuilder hex = new StringBuilder();
        for (char c : message.toCharArray()) {
            // Permet à la conversion de chaque caractère en hexadécimal
            hex.append(String.format("%02X", (int) c));
        }
        // Permet de retourner la chaîne en hexadécimal
        return hex.toString();
    }
}

