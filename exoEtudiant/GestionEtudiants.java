package exoEtudiant;

import java.util.ArrayList;
import java.util.Iterator;
public class GestionEtudiants {
    private static ArrayList<Etudiant> listeEtudiants = new ArrayList<>();

    public static void ajouterEtudiant(String nom, String prenom, String classe) {
        listeEtudiants.add(new Etudiant(nom, prenom, classe));
        System.out.println("Étudiant ajouté !");
    }

    public static void afficherEtudiants() {
        if (listeEtudiants.isEmpty()) {
            System.out.println("Aucun étudiant enregistré.");
        } else {
            System.out.println("Liste des étudiants :");
            for (Etudiant e : listeEtudiants) {
                System.out.println(e);
            }
        }
    }

    public static void supprimerEtudiant(String nom) {
        Iterator<Etudiant> iterator = listeEtudiants.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Etudiant e = iterator.next();
            if (e.getNom().equalsIgnoreCase(nom)) {
                iterator.remove();
                System.out.println("Étudiant " + nom + " supprimé !");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Étudiant non trouvé !");
        }
    }
    
}
