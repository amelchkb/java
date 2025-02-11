
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

    
   

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void afficher() {
        System.out.println("Marque : " + marque);
        System.out.println("Modele : " + modele);
        System.out.println("Annee : " + annee);
        System.out.println("Couleur : " + couleur);
        System.out.println("Kilometrage : " + kilometrage);
        System.out.println("Prix : " + prix);
    }
    
}
