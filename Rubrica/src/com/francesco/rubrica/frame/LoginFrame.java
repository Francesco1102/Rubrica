package com.francesco.rubrica.frame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.francesco.rubrica.classes.NoScalingIcon;
import com.francesco.rubrica.classes.Persona;
import com.francesco.rubrica.classes.Utente;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	public LoginFrame(List<Persona> table, List<Utente> users) throws HeadlessException {
		super("Login");
		
		setSize(350,230); // LARGHEZZA , ALTEZZA 
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Evento di chiusura
		
		
		GridBagLayout grid = new GridBagLayout();
		setLayout(grid);
		GridBagConstraints gbc = new GridBagConstraints();
		
	
	     
		JLabel username = new JLabel("Username: ");
		 username.setFont(new Font("Arial", Font.BOLD, 20));
		 gbc.gridx = 0;
		 gbc.gridy = 0;
		 gbc.weightx = 10;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 15, 2, 0); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.NONE;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(username, gbc);
		 add(username);
		 
		 JTextField usernameField = new JTextField();
		 usernameField.setFont(new Font("Arial", Font.PLAIN, 20));
		 gbc.gridx = 1;
		 gbc.gridy = 0;
		 gbc.weightx = 90;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 0, 0, 15);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(usernameField, gbc);
		 add(usernameField);
		 
		 
		 JLabel password = new JLabel("Password: ");
		 password.setFont(new Font("Arial", Font.BOLD, 20));
		 gbc.gridx = 0;
		 gbc.gridy = 1;
		 gbc.weightx = 10;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 15, 2, 0); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.NONE;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(password, gbc);
		 add(password);
		 
		 JTextField passwordField = new JTextField();
		 passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		 gbc.gridx = 1;
		 gbc.gridy = 1;
		 gbc.weightx = 90;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 0, 0, 15);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(passwordField, gbc);
		 add(passwordField);
		 
		 JButton log = new JButton("Login");
		 log.setFont(new Font("Arial", Font.BOLD, 20));
		 gbc.gridx = 0;
		 gbc.gridy = 2;
		 gbc.weightx = 90;
		 gbc.weighty = 15;
		 gbc.gridheight = 2;
		 gbc.gridwidth = 2;
		 gbc.insets = new Insets(15, 30, 20, 30);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.CENTER;
		 //grid.setConstraints(log, gbc);
		 //add(log);
		 try {
		        NoScalingIcon icon = new NoScalingIcon( new ImageIcon("src/resources/icons8-credenziali-utente-35.png") );
		        log.setIcon( icon );

			  } catch (Exception ex) {
			    System.out.println(ex);
	     }
		 LoginFrame t = this;
		 log.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (users.contains(new Utente(usernameField.getText(),passwordField.getText()))) {
					@SuppressWarnings("unused")
					MainFrame mf = new MainFrame(table, t.getLocation());
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(t, "Credenziali Errate", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		 
		 JToolBar toolBar = new JToolBar();
		 toolBar.setBorder(new EmptyBorder(10, 0, 10, 0));
		 toolBar.setFloatable(false);
		 toolBar.setRollover(true);
		 toolBar.setAlignmentY(BOTTOM_ALIGNMENT);
		 toolBar.addSeparator(new Dimension((this.getWidth() / 2) - 55,5));
		 toolBar.add(log);
		 gbc.gridx = 0;
		 gbc.gridy = 2;
		 gbc.gridwidth = 2;
		 gbc.gridheight = 1;
		 gbc.weightx = 10;
		 gbc.weighty = 10;
		 gbc.insets = new Insets(10, 0, 0, 0); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.anchor = GridBagConstraints.PAGE_END;
		 grid.setConstraints(toolBar, gbc);
		 add(toolBar);
		 
		 
		 
		 setVisible(true);
	}

}
