package com.monprojet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionUtilisateurs {
    private Connection connection;


    ArrayList ListUser = new ArrayList();
      

    
    public GestionUtilisateurs(Connection connection) {
        this.connection = connection;
    }

    public void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n--- Menu Gestion des Utilisateurs ---");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Afficher les utilisateurs");
            System.out.println("3. Supprimer un utilisateur");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne

            switch (choix) {
                case 1:
                    ajouterUtilisateur(scanner);
                    break;
                case 2:
                    afficherUtilisateurs();
                    break;
                case 3:
                    supprimerUtilisateur(scanner);
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    break;
            }
        } while (choix != 0);

        scanner.close();
    }

    private void ajouterUtilisateur(Scanner scanner) {
        System.out.print("Nom de l'utilisateur : ");
        String nom = scanner.nextLine();
        System.out.print("prenom de l'utilisateur : ");
        String prenom = scanner.nextLine();
        System.out.print("Email de l'utilisateur : ");
        String email = scanner.nextLine();

        String sql = "INSERT INTO utilisateurs (nom, prenom,email) VALUES (?, ?, ?)";
        try (PreparedStatement pstmtSelect = connection.prepareStatement(sql)) {  //PrepareStatement pour eviter la concatenation
            pstmtSelect.setString(1, nom);
            pstmtSelect.setString(2, prenom);
            pstmtSelect.setString(3, email);

            pstmtSelect.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    private void afficherUtilisateurs() {
        String sql = "SELECT id, nom, email FROM utilisateurs";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("Liste des utilisateurs :");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", NOM: " + nom + ", EMAIL: " + email);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des utilisateurs : " + e.getMessage());
        }
    }

    private void supprimerUtilisateur(Scanner scanner) {
        System.out.print("ID de l'utilisateur à supprimer : ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM utilisateurs WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilisateur supprimé avec succès !");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
        }
    }
}
