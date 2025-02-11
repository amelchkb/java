import java.util.Scanner;
public class texte {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Entrez un texte : ");
        String texte = sc.nextLine(); 
        int nombreCaracteres = texte.length();
        String[] mots = texte.trim().split("\\s+"); 
        int nombreMots = (texte.trim().isEmpty()) ? 0 : mots.length;
        System.out.println("Nombre de caractères : " + nombreCaracteres);
        System.out.println("Nombre de mots : " + nombreMots);

        sc.close(); 
    }
}

