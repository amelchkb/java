package exovoiture;
public class voiture {
    private String marque;
    private String modele;
    private String couleur;
    public voiture(String marque, String modele, int annee, String couleur, int kilometrage, int prix) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
}
    public String getMarque() {
        return marque;
    }
    public String getModele() {
        return modele;
    }

    public String getCouleur() {
        return couleur;
    }
    public void demarrer() {
        System.out.println("La voiture demarre");
    }
    public void accelerer() {
        System.out.println("La voiture accelere");
    }
    public void freiner() {
        System.out.println("La voiture freine");
    }
    
        
    }
    

