package com.francesco.rubrica.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.francesco.rubrica.classes.Persona;
import com.francesco.rubrica.frame.MainFrame;

public class DelListener implements ActionListener {
	
	
	private MainFrame mainF;
	
	public DelListener(MainFrame mf) {
		this.mainF = mf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int pos = this.mainF.getPos(); 
		if (pos == -1) {
			JOptionPane.showMessageDialog(this.mainF, "Per eliminare un contatto è necessario prima selezionarlo dalla tabella", "Errore", JOptionPane.ERROR_MESSAGE);
		} else {
			Persona p = this.mainF.getRubrica().getEl(pos);
			
			int resp = JOptionPane.showConfirmDialog(this.mainF,"Eliminare la persona " + p.getNome() + " " + p.getCognome() + "?",
					"Conferma", JOptionPane.YES_NO_OPTION);
			
			if (resp == JOptionPane.YES_OPTION) {
				this.mainF.getRubrica().deleteEl(pos);
				this.mainF.setPos(-1);

			}
		}
	}

}
