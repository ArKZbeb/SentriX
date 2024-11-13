public class Main {
    public static void main(String[] args) {
        // Test de chiffrement de Vigenère
        String message = "HELLO WORLD";
        String key = "KEY";

        String encryptedMessage = VigenereCipher.chiffrer(message, key);
        System.out.println("Message chiffré : " + encryptedMessage);

        String decryptedMessage = VigenereCipher.dechiffrer(encryptedMessage, key);
        System.out.println("Message déchiffré : " + decryptedMessage);
    }
}
