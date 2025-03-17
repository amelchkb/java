package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String URL = "jdbc:mysql://localhost:3306/ma_base";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion à la base de données réussie");
            } catch (SQLException e) {
                System.out.println("Erreur de connexion à la base de données: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion: " + e.getMessage());
            }
        }
    }
}
