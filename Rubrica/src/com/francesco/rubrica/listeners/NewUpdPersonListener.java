package com.francesco.rubrica.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.francesco.rubrica.frame.EditorPersonaFrame;
import com.francesco.rubrica.frame.MainFrame;


public class NewUpdPersonListener implements ActionListener {
	public MainFrame mainF;
	private JButton modifica = null;
	
	public NewUpdPersonListener(MainFrame mf, JButton modifica) {
		this.mainF = mf;
		this.modifica = modifica;
	}
	
	public NewUpdPersonListener(MainFrame mf) {
		this.mainF = mf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (mainF.getPos() == -1 && e.getSource().equals(this.modifica)) {
			JOptionPane.showMessageDialog(this.mainF, "Per modificare un contatto è necessario prima selezionarlo dalla tabella", "Errore", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		this.mainF.setEnabled(false);
		EditorPersonaFrame e1 =  new EditorPersonaFrame(this.mainF, e.getSource().equals(this.modifica));
		e1.setVisible(true);
	}

}
