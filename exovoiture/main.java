package exovoiture;

public class main {
    public static void main(String[] args) {
        voiture v = new voiture("Peugeot", "208", 2019, "rouge", 10000, 15000);
        v.demarrer();
        v.accelerer();
        v.freiner();
    }
    
}
