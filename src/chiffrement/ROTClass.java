package chiffrement;

public class ROTClass {

    // Méthode permettant de chiffrer un message avec un décalage donné (ROT-X)
    public static String ROTChiffrer(String texte, int decalage) {
        StringBuilder resultat = new StringBuilder();
        // Permet de limiter le décalage à l'intervalle [0,25]
        decalage = decalage % 26;

        // Permet de parcourir chaque caractère du texte
        for (char caractere : texte.toCharArray()) {

            // Permet d'applique le chiffrement ROT(X) pour les lettres minuscules
            if (caractere >= 'a' && caractere <= 'z') {
                caractere = (char) ((caractere - 'a' + decalage) % 26 + 'a');
            }
            // Permet d'applique le chiffrement ROT(X) pour les lettres majuscules
            else if (caractere >= 'A' && caractere <= 'Z') {
                caractere = (char) ((caractere - 'A' + decalage) % 26 + 'A');
            }

            resultat.append(caractere);
        }
        return resultat.toString();
    }

    // Méthode permettant de déchiffrer un message avec un décalage donné (ROT-X inverse)
    public static String ROTDechiffrer(String texte, int decalage) {
        // Permet d'applique l'inverse du décalage pour déchiffrer
        return ROTChiffrer(texte, 26 - (decalage % 26));
    }

    // Méthode permettant de demander un texte valide
    public static String demanderTexte(String message) {
        java.util.Scanner lecteur = new java.util.Scanner(System.in);
        String texte;
        System.out.print(message);
        texte = lecteur.nextLine();

        // Permet de vérifier que le texte contient uniquement des lettres (a-z, A-Z)
        while (!texte.matches("[a-zA-Z]+")) {
            System.out.println("Erreur : Le texte doit contenir uniquement des lettres.");
            System.out.print(message);
            texte = lecteur.nextLine();
        }
        return texte;
    }


    // Méthode permettant de demander un décalage valide entre 0 et 25
    public static int demanderDecalage() {
        java.util.Scanner lecteur = new java.util.Scanner(System.in);
        int decalage;

        while (true) {
            System.out.print("Entrez la valeur de décalage (entre 0 et 25) : ");
            String entree = lecteur.nextLine();

            // Permet de vérifie que l'entrée contient des chiffres
            if (entree.matches("\\d+")) {
                decalage = Integer.parseInt(entree);
                if (decalage >= 0 && decalage <= 25) {
                    break;
                }
                System.out.println("Erreur : Le décalage doit être entre 0 et 25.");
            } else {
                System.out.println("Erreur : Le décalage doit être un nombre entier positif sans signe.");
            }
        }
        return decalage;
    }
}
