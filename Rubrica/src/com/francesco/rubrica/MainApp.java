package com.francesco.rubrica;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import com.francesco.rubrica.classes.Persona;
import com.francesco.rubrica.classes.Utente;
import com.francesco.rubrica.frame.LoginFrame;


public class MainApp {
    public static void main(String[] args) {
    	//Creazione tabella
    	
    	UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 18));
    	UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14));
    	
    	
    	List<Utente> users = getUsers();
    	List<Persona> list = getPersone();

    	@SuppressWarnings("unused")
		LoginFrame lf = new LoginFrame(list,users);

    }
    
    private static List<Utente> getUsers() {
        // Step 2: Making connection using
        // Connection type and inbuilt function on
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        List<Utente> list = new ArrayList<Utente>();
        
        con = DBConnection.getConnection();

        // Try block to catch exception/s
        try {

            // SQL command data stored in String datatype
            String sql = "select * from user";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            // Condition check
            while (rs.next()) {
            	
                //int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                list.add(new Utente(username, password));
            }
            return list;
        }

        // Catch block to handle exception
        catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
            return null;
        }
    }
    
    private static List<Persona> getPersone() {
        // Step 2: Making connection using
        // Connection type and inbuilt function on
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        List<Persona> list = new ArrayList<Persona>();
        
        con = DBConnection.getConnection();

        // Try block to catch exception/s
        try {

            // SQL command data stored in String datatype
            String sql = "select * from contact";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();


            // Condition check
            while (rs.next()) {

                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String telefono = rs.getString("telefono");
                String indirizzo = rs.getString("indirizzo");
                int eta = rs.getInt("eta");
                list.add(new Persona(id, nome, cognome, telefono, indirizzo, eta));
                


            }
            return list;
        }

        // Catch block to handle exception
        catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
            return null;
        }
    }
}
