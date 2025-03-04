package exoEtudiant;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int choix = 0;
        Scanner sc= new Scanner(System.in);
        do{
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher la liste des étudiants");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Quitter");
            choix = sc.nextInt();
        }while(choix != 4);
        sc.close();
    }

    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\n1. Ajouter un étudiant");
        System.out.println("2. Afficher la liste des étudiants");
        System.out.println("3. Supprimer un étudiant");
        System.out.println("4. Quitter");
        System.out.print("Choisissez une option : ");
        
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                System.out.print("Entrez le nom de l'étudiant : ");
                String nom = scanner.nextLine();
                System.out.print("Entrez le prénom de l'étudiant : ");
                String prenom = scanner.nextLine();
                System.out.print("Entrez la classe de l'étudiant : ");
                String classe = scanner.nextLine();
                ajouterEtudiant(nom, prenom, classe);
                break;
            case 2:
                afficherEtudiants();
                break;
            case 3:
                System.out.print("Entrez le nom de l'étudiant à supprimer : ");
                String nomSup = scanner.nextLine();
                supprimerEtudiant(nomSup);
                return;
            default:
                System.out.println("Option invalide, essayez encore.");
        }
    }
}

    public static void ajouterEtudiant(String nom, int age) {
        // Implementation here
    }

    public static void afficherEtudiants() {
        // Implementation here
    }

    public static void supprimerEtudiant(String nom) {
        // Implementation here
    }
}               System.out.println("Option invalide, essayez encore.");
        }
    }
}*/

