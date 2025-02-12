package exo2;

public class main {
    public static void main(String[] args) {
        comptebancaire c1 = new comptebancaire("Amel", 1000);
        c1.deposer(500);
        c1.retirer(200);
        c1.retirer(2000);
    }
}
