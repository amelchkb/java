package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionUtilisateurs {
    private Connection connection;
    private ObservableList<Utilisateur> utilisateurs;

    public GestionUtilisateurs() {
        // Récupération de la connexion depuis la classe Connexion
        this.connection = Connexion.getConnection();
        this.utilisateurs = FXCollections.observableArrayList();
    }

    // Méthode pour ajouter un utilisateur
    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateurs (nom, prenom, email) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, utilisateur.getNom());
            pstmt.setString(2, utilisateur.getPrenom());
            pstmt.setString(3, utilisateur.getEmail());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    utilisateurs.add(utilisateur);
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur: " + e.getMessage());
        }
        return false;
    }

    // Méthode pour modifier un utilisateur
    public boolean modifierUtilisateur(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, utilisateur.getNom());
            pstmt.setString(2, utilisateur.getPrenom());
            pstmt.setString(3, utilisateur.getEmail());
            pstmt.setInt(4, utilisateur.getId());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // Mise à jour de la liste observable
                for (int i = 0; i < utilisateurs.size(); i++) {
                    if (utilisateurs.get(i).getId() == utilisateur.getId()) {
                        utilisateurs.set(i, utilisateur);
                        break;
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de l'utilisateur: " + e.getMessage());
        }
        return false;
    }

    // Méthode pour supprimer un utilisateur
    public boolean supprimerUtilisateur(int id) {
        String sql = "DELETE FROM utilisateurs WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // Suppression de l'utilisateur de la liste observable
                utilisateurs.removeIf(utilisateur -> utilisateur.getId() == id);
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'utilisateur: " + e.getMessage());
        }
        return false;
    }

    // Méthode pour récupérer tous les utilisateurs
    public ObservableList<Utilisateur> getUtilisateurs() {
        utilisateurs.clear();
        String sql = "SELECT * FROM utilisateurs";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                
                Utilisateur utilisateur = new Utilisateur(id, nom, prenom, email);
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des utilisateurs: " + e.getMessage());
        }
        return utilisateurs;
    }
}