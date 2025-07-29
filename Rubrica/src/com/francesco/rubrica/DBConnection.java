package com.francesco.rubrica;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    public static Connection getConnection() {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream("credenziali_database.properties")) {
            // Carica il file .properties
            props.load(fis);

            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            String host = props.getProperty("db.host");
            String port = props.getProperty("db.port");
            
            String url = "jdbc:mysql://" + host + ":" + port + "/rubrica" + "?serverTimezone=UTC";

            return DriverManager.getConnection(url, username, password);

        } catch (IOException e) {
            System.err.println("Errore nella lettura del file di configurazione: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Errore nella connessione al database: " + e.getMessage());
        }

        return null;
    }
}

