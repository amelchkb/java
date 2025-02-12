package exo2;

public class comptebancaire {
    private String titulaire;
    private double solde;

    public comptebancaire(String titulaire, double solde) {
        this.titulaire = titulaire;
        this.solde = solde;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println(this.titulaire + " a déposé " + montant );
    }

    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;   
            System.out.println(this.titulaire + " a retiré " + montant );
            }
    }

    

    
}
