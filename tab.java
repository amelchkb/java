import java.util.Scanner;
public class tab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]t = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Entrer une valeur");
            t[i] = sc.nextInt();
            }
            
        }
        sc.close();
}
