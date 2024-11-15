package Hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HachageClass {

    public static String Hachage256(Scanner scanneur, String message) throws NoSuchAlgorithmException {
        if(message.isEmpty()){

            // Demande à l'utilisateur de saisir le texte à hacher
            System.out.println("Donnez votre mot à hacher");

            // Récupère la saisie de l'utilisateur
            message = scanneur.next();
        }

        // Initialise un objet MessageDigest pour utiliser l'algorithme SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Convertit le texte en un tableau de bytes (octets) en utilisant l'encodage UTF-8,
        // puis effectue le hachage avec SHA-256
        byte[] motHashe = digest.digest(message.getBytes(StandardCharsets.UTF_8));

        // Affiche le tableau de bytes représentant le hachage SHA-256 du texte
        System.out.println(TransformationEnHexadecimal(motHashe));
        return TransformationEnHexadecimal(motHashe).toString();
    }

    public static String HachageMD5(Scanner scanneur, String message) throws NoSuchAlgorithmException {
        if(message.isEmpty()) {
            // Demande à l'utilisateur de saisir le texte à hacher
            System.out.println("Donnez votre mot à hacher");

            // Récupère la saisie de l'utilisateur
            message = scanneur.next();
        }
        // Initialise un objet MessageDigest pour utiliser l'algorithme MD5Q
        MessageDigest digest = MessageDigest.getInstance("MD5");

        // Convertit le texte en un tableau de bytes (octets) en utilisant l'encodage UTF-8,
        // puis effectue le hachage avec MD5
        byte[] motHashe = digest.digest(message.getBytes());

        // Affiche le tableau de bytes représentant le hachage MD5 du texte
        System.out.println(TransformationEnHexadecimal(motHashe));
        return TransformationEnHexadecimal(motHashe).toString();
    }

    // Méthode pour convertir un tableau de bytes en chaîne hexadécimale
    private static StringBuilder TransformationEnHexadecimal(byte[] motsHashe) {
        // Initialisation d'un StringBuilder pour stocker le mot en format hexadécimal
        StringBuilder motEnHexa = new StringBuilder();

        // Parcourt chaque byte dans le tableau motHashe
        for (int i = 0; i< motsHashe.length; i++) {
            motEnHexa.append(String.format("%02x", motsHashe[i]));
        }
        // Retourne le mot converti en hexadécimal
        return motEnHexa;
    }
}
