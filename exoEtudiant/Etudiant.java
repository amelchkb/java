package exoEtudiant;

public class Etudiant {
    private String nom;
    private String prenom;
    private String classe;

    public Etudiant(String nom, String prenom, String classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
    }
    
    @override
    public String toString() {
        return this.nom + " " + this.prenom + " (" + this.classe ;
    }
   
    
    
    
    
}
