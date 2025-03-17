package com.example;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class UtilisateurController implements Initializable {

    @FXML private TableView<Utilisateur> tableUtilisateurs;
    @FXML private TableColumn<Utilisateur, Integer> colId;
    @FXML private TableColumn<Utilisateur, String> colNom;
    @FXML private TableColumn<Utilisateur, String> colPrenom;
    @FXML private TableColumn<Utilisateur, String> colEmail;

    @FXML private TextField txtId;
    @FXML private TextField txtNom;
    @FXML private TextField txtPrenom;
    @FXML private TextField txtEmail;

    @FXML private Button btnAjouter;
    @FXML private Button btnModifier;
    @FXML private Button btnSupprimer;
    @FXML private Button btnEffacer;

    private GestionUtilisateurs gestionUtilisateurs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestionUtilisateurs = new GestionUtilisateurs();

        // Configuration des colonnes de la TableView
        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        colPrenom.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        // Chargement des données
        chargerUtilisateurs();

        // Gestion des clics sur la table
        tableUtilisateurs.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1 && tableUtilisateurs.getSelectionModel().getSelectedItem() != null) {
                Utilisateur utilisateur = tableUtilisateurs.getSelectionModel().getSelectedItem();
                txtId.setText(String.valueOf(utilisateur.getId()));
                txtNom.setText(utilisateur.getNom());
                txtPrenom.setText(utilisateur.getPrenom());
                txtEmail.setText(utilisateur.getEmail());
            }
        });
    }

    @FXML
    private void ajouterUtilisateur() {
        try {
            String nom = txtNom.getText();
            String prenom = txtPrenom.getText();
            String email = txtEmail.getText();

            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty()) {
                afficherAlerte("Erreur", "Champs obligatoires", "Veuillez remplir tous les champs.");
                return;
            }

            // Création d'un nouvel utilisateur avec un ID temporaire (sera remplacé par la base de données)
            Utilisateur nouvelUtilisateur = new Utilisateur(0, nom, prenom, email);

            if (gestionUtilisateurs.ajouterUtilisateur(nouvelUtilisateur)) {
                afficherAlerte("Succès", "Utilisateur ajouté", "L'utilisateur a été ajouté avec succès.");
                effacerChamps();
                chargerUtilisateurs();
            } else {
                afficherAlerte("Erreur", "Échec de l'ajout", "Impossible d'ajouter l'utilisateur.");
            }
        } catch (Exception e) {
            afficherAlerte("Erreur", "Exception", e.getMessage());
        }
    }

    @FXML
    private void modifierUtilisateur() {
        try {
            if (txtId.getText().isEmpty()) {
                afficherAlerte("Erreur", "Aucun utilisateur sélectionné", "Veuillez sélectionner un utilisateur à modifier.");
                return;
            }

            int id = Integer.parseInt(txtId.getText());
            String nom = txtNom.getText();
            String prenom = txtPrenom.getText();
            String email = txtEmail.getText();

            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty()) {
                afficherAlerte("Erreur", "Champs obligatoires", "Veuillez remplir tous les champs.");
                return;
            }

            Utilisateur utilisateur = new Utilisateur(id, nom, prenom, email);

            if (gestionUtilisateurs.modifierUtilisateur(utilisateur)) {
                afficherAlerte("Succès", "Utilisateur modifié", "L'utilisateur a été modifié avec succès.");
                effacerChamps();
                chargerUtilisateurs();
            } else {
                afficherAlerte("Erreur", "Échec de la modification", "Impossible de modifier l'utilisateur.");
            }
        } catch (Exception e) {
            afficherAlerte("Erreur", "Exception", e.getMessage());
        }
    }

    @FXML
    private void supprimerUtilisateur() {
        try {
            if (txtId.getText().isEmpty()) {
                afficherAlerte("Erreur", "Aucun utilisateur sélectionné", "Veuillez sélectionner un utilisateur à supprimer.");
                return;
            }

            int id = Integer.parseInt(txtId.getText());

            if (gestionUtilisateurs.supprimerUtilisateur(id)) {
                afficherAlerte("Succès", "Utilisateur supprimé", "L'utilisateur a été supprimé avec succès.");
                effacerChamps();
                chargerUtilisateurs();
            } else {
                afficherAlerte("Erreur", "Échec de la suppression", "Impossible de supprimer l'utilisateur.");
            }
        } catch (Exception e) {
            afficherAlerte("Erreur", "Exception", e.getMessage());
        }
    }

    @FXML
    private void effacerChamps() {
        txtId.clear();
        txtNom.clear();
        txtPrenom.clear();
        txtEmail.clear();
        tableUtilisateurs.getSelectionModel().clearSelection();
    }

    private void chargerUtilisateurs() {
        ObservableList<Utilisateur> utilisateurs = gestionUtilisateurs.getUtilisateurs();
        tableUtilisateurs.setItems(utilisateurs);
    }

    private void afficherAlerte(String titre, String entete, String contenu) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(entete);
        alert.setContentText(contenu);
        alert.showAndWait();
    }
}