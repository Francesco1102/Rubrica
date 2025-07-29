package com.francesco.rubrica.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.francesco.rubrica.classes.Persona;
import com.francesco.rubrica.frame.EditorPersonaFrame;
import com.francesco.rubrica.frame.MainFrame;

public class SaveListener implements ActionListener {
	
	private MainFrame mf;
	private EditorPersonaFrame epf;
	private JTextField nome;
	private JTextField cognome;
	private JTextField indirizzo;
	private JTextField telefono;
	private JTextField eta;
	private boolean modifica;
	
	
	
	public SaveListener(MainFrame mf, EditorPersonaFrame epf, JTextField nomeField, JTextField cognomeField, JTextField indirizzoField, JTextField telefonoField, JTextField etaField, boolean modifica) {
		this.mf = mf;
		this.epf = epf;
		this.nome = nomeField;
		this.cognome = cognomeField;
		this.indirizzo = indirizzoField;
		this.telefono = telefonoField;
		this.eta = etaField;
		this.modifica = modifica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name = this.nome.getText();
		String surname = this.cognome.getText();
		String addr = this.indirizzo.getText();
		String telephone = this.telefono.getText();
		String age = this.eta.getText();
		
		if(name.trim().length() == 0 || surname.trim().length() == 0 || addr.trim().length() == 0 || telephone.trim().length() == 0 || age.trim().length() == 0){
		    JOptionPane.showMessageDialog(this.epf, "Ogni campo deve essere riempito", "Errore", JOptionPane.ERROR_MESSAGE);
		    return;
		}
		Persona p = new Persona(1L,name,surname,telephone,addr,Integer.parseInt(age));
		
		if (this.modifica) {
			mf.getRubrica().updateEl(p,this.mf.getPos());
		} else {
			mf.getRubrica().addEl(p);
		}
		int position = mf.getRubrica().getPos(p);
		mf.setPos(position);
		mf.setEnabled(true);
		epf.dispatchEvent(new WindowEvent(epf, WindowEvent.WINDOW_CLOSING));
	}

}



