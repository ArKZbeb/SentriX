package Hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HachageClass {

    public static void Hachage256(Scanner scanneur) throws NoSuchAlgorithmException {
        // Demande à l'utilisateur de saisir le texte à hacher
        System.out.println("Donnez votre mot à hacher");

        // Récupère la saisie de l'utilisateur
        String texte = scanneur.next();

        // Initialise un objet MessageDigest pour utiliser l'algorithme SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Convertit le texte en un tableau de bytes (octets) en utilisant l'encodage UTF-8,
        // puis effectue le hachage avec SHA-256
        byte[] motHashe = digest.digest(texte.getBytes(StandardCharsets.UTF_8));

        // Affiche le tableau de bytes représentant le hachage SHA-256 du texte
        System.out.println(TransformationEnHexadecimal(motHashe));
    }

    // Méthode pour convertir un tableau de bytes en chaîne hexadécimale
    private static StringBuilder TransformationEnHexadecimal(byte[] motHashe) {
        // Initialisation d'un StringBuilder pour stocker le mot en format hexadécimal
        StringBuilder motEnHexa = new StringBuilder();

        // Parcourt chaque byte dans le tableau motHashe
        for (byte b : motHashe) {
            // Convertit chaque byte en une chaîne hexadécimale à deux chiffres
            // et l'ajoute à motEnHexa
            motEnHexa.append(String.format("%02x", b));
        }

        // Retourne le mot converti en hexadécimal
        return motEnHexa;
    }
}
