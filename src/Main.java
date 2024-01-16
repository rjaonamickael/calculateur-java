import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Déclaration des variables pour les opérations
        int nb1=0, nb2=0;       //Variables pour stocker les nombres pour l'opération
        float res;            //Variable pour stocker le résultat de l'opération
        String op=null;         //Variable pour stocker l'opération à faire


        //Méthode pour collecter la valeur du premier nombre
        nb1 = Collecter_Valeur(nb1,"premier");

        //Méthode pour collecter la valeur du second nombre
        nb2 = Collecter_Valeur(nb2,"second");

        //Phase du choix de l'opération
        op=Choix_Operation(op);

        //Calcul de l'opération des deux nombres grâce à la fonction operation
        res = operation(nb1,nb2,op);

        //Affichage du résultat
        System.out.println("Résultat : "+res);

    }

    ///Procédure pour collecter les valeurs saisie par l'utilisateur
    public static int Collecter_Valeur(int nb, String txt) {
        //Variable de contrôle pour savoir si le nombre saisie est correct
        boolean IsOk=false;

        //Boucler jusqu'à ce que l'utilisateur insère un nombre
        while (!IsOk) {

            //Instanciation de l'objet scanner pour récolter les valeurs entrées par l'utilsateur
            Scanner scanner = new Scanner(System.in);

            try {
                //Message pour dire à l'user d'entrer le nombre
                System.out.println("Entrer le " + txt + " nombre :");

                //Affectation de la valeur saisie par l'utilisateur dans la variable nb
                nb = scanner.nextInt();

                //Instruction pour pouvoir sortir de la boucle
                IsOk=true;

            } catch (InputMismatchException ex) {
                System.out.println("La valeur saisie n'est pas valide !");
            }
        }
        return nb;
    }


    ///Fonction pour le choix de l'opération
    public static String Choix_Operation(String operation) {
        // Variable de contrôle pour savoir si l'opération saisie est correcte
        boolean IsOk = false;

        do {
            // Instanciation de l'objet scanner pour récolter les valeurs entrées par l'utilisateur
            Scanner scanner = new Scanner(System.in);

            // Message pour dire à l'utilisateur d'entrer l'opération
            System.out.println("Choisissez l'opération (+, -, *, /)");

            // Affectation de la valeur saisie par l'utilisateur dans la variable operation
            operation = scanner.nextLine();

            // Dans le cas où l'utilisateur ait saisi une opération non valide
            if (!(operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/"))) {
                System.out.println("La valeur saisie n'est pas valide !");
            }
            else {              //Dans le cas contraire
                IsOk = true;    //Configuration de la variable de contrôle pour sortir de la boucle
            }

        } while (!IsOk);

        // Répéter l'opération tant que la valeur de l'opération n'est pas valide
        return operation;
    }


    ///Méthode pour le calcul des opérations
    public static float operation(int nb1, int nb2, String op) {
        float res=0;

        switch (op) {
            case "+":
                res = nb1 + nb2;        //Calcul du résultat
                break;

            case "-":
                res = nb1 - nb2;        //Calcul du résultat
                break;

            case "*":
                res = nb1 * nb2;        //Calcul du résultat
                break;

            case "/":

                try {
                    res = (float) nb1 / nb2;   //Calcul du résultat
                }
                catch (ArithmeticException e){
                    System.out.println("Division par 0 impossible");
                }

                break;
        }

        return res;
    }
}
