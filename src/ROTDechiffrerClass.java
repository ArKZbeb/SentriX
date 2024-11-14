import java.util.Scanner;

public class ROTDechiffrerClass {

    public static String rotation(String texte, int decalage) {
        StringBuilder resultat = new StringBuilder();
        // Permet de limiter le décalage à l'intervalle [0,25]
        decalage = decalage % 26;


        // Permet de parcours chaque caractère du texte
        for (char caractere : texte.toCharArray()) {

            // Permet de voir si le caractère est une lettre, applique le déchiffrement ROT(X)
            if (caractere >= 'a' && caractere <= 'z') {
                caractere = (char) ((caractere - 'a' - decalage) % 26 + 'a');

            }
            // Vérifie si le caractère est une lettre majuscule
            else if (caractere >= 'A' && caractere <= 'Z') {
                caractere = (char) ((caractere - 'A' - decalage) % 26 + 'A');
            }

            resultat.append(caractere);
        }
        return resultat.toString();
    }

    public static void  main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
        String message;
        int decalage = 0;

        // Permet de demander à l'utilisateur de saisir le texte à déchiffrer
        System.out.print("Entrez le texte à chiffrer (minuscule uniquement) : ");
        message = lecteur.nextLine();

        // Permet a la boucle de vérifier s'ils contient au moins une lettre
        while (!message.matches(".*[a-zA-Z]+.*")) {
            System.out.println("Erreur : Le texte doit contenir uniquement des lettres minuscules.");
            System.out.print("Entrez à nouveau le texte à chiffrer (minuscule uniquement) : ");
            message = lecteur.nextLine();
        }

        // Permet a la boucle de demander un décalage entier positif
        while (true) {
            System.out.print("Entrez la valeur de décalage (entre 0 et 25) : ");
            String entree = lecteur.nextLine();
            // Permet de vérifier que l'entrée ne contient que des chiffres
            if (entree.matches("\\d+")) {
                decalage = Integer.parseInt(entree);
                // Permet de voit si le décalage est dans la place autorisée
                if (decalage >= 0 && decalage <= 25)
                    break;
                System.out.println("Erreur : Le décalage doit être entre 0 et 25.");
            } else {
                System.out.println("Erreur : Le décalage doit être un nombre entier positif sans signe.");
            }
        }

        // Permet d'appliquer la méthode de déchiffrement
        String messageDeChiffre = rotation(message, decalage);

        // Permet d'afficher le message déchiffré
        System.out.println("Message déchiffré : " + messageDeChiffre);

        // Permet de couper le flux des ressources
        lecteur.close();
    }
}