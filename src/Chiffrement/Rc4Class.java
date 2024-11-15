package Chiffrement;

import java.util.Base64;

public class Rc4Class {

    // Tableau de permutation pour RC4
    private final int[] etat = new int[256];
    private int x, y;

    // Constructeur qui initialise l'état interne avec la clé
    public Rc4Class(String cle) {
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

    // Méthode utilitaire pour encoder en Base64
    public String chiffrerEnBase64(String message) {

        String messageChiffre = chiffrer(message);
        return Base64.getEncoder().encodeToString(messageChiffre.getBytes());
    }

    // Méthode utilitaire pour décoder le message chiffré en Base64 avant de le déchiffrer
    public static String dechiffrerBase64(String messageChiffreBase64, String cle) {
        // Permet de décoder le message Base64 en un tableau de bytes
        byte[] messageChiffreBytes = Base64.getDecoder().decode(messageChiffreBase64);

        // Permet de convertir les bytes en une chaîne pour la méthode de déchiffrement RC4
        String messageChiffre = new String(messageChiffreBytes);

        // Permet de créer une instance de RC4 pour déchiffrer le message
        Rc4Class rc4Dechiffreur = new Rc4Class(cle);
        // Permet de déchiffrer le message avec la clé
        return rc4Dechiffreur.chiffrer(messageChiffre);
    }
}
