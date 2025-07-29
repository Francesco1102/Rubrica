package com.francesco.rubrica.frame;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;

import com.francesco.rubrica.classes.NoScalingIcon;
import com.francesco.rubrica.classes.Persona;
import com.francesco.rubrica.listeners.SaveListener;

@SuppressWarnings("serial")
public class EditorPersonaFrame extends JFrame {
	
	public EditorPersonaFrame(MainFrame mf, boolean modifica){
		super(modifica? "Editor Persona: " + mf.getRubrica().getEl(mf.getPos()).getNome() + " " + mf.getRubrica().getEl(mf.getPos()).getCognome()
				: "Editor Persona");

		
		
		String nomeP = "";
		String cognomeP = "";
		String telefonoP = "";
		String indirizzoP = "";
		String etaP = "";
		if (modifica) {
			Persona p = mf.getRubrica().getEl(mf.getPos());
			nomeP = p.getNome();
			cognomeP = p.getCognome();
			telefonoP = p.getTelefono();
			indirizzoP = p.getIndirizzo();
			etaP = String.valueOf(p.getEta());
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evento di chiusura
		setSize(500,350);
		setResizable(false);
		
		// Dove posizionare il frame
		Point loc = mf.getLocation();
		Dimension dim = mf.getSize();
		int x = dim.width - 500;
		int y = dim.height - 300;
		if (x <=0) {
			x = loc.x;
		} else {
			x = x/2 + loc.x;
		}
		if (y <=0) {
			y = loc.y;
		} else {
			y = y/2 + loc.y;
		}
		setLocation(new Point(x,y));
		
		
		GridBagLayout grid = new GridBagLayout();
		//setLayout(new GridLayout(2,1));
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JPanel request = new JPanel(grid);
		
		
		 JLabel nome = new JLabel("Nome: ");
		 nome.setFont(new Font("Arial", Font.BOLD, 20));
		 gbc.gridx = 0;
		 gbc.gridy = 0;
		 gbc.weightx = 10;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 15, 0, 0); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.NONE;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(nome, gbc);
		 request.add(nome);
		 
		 JTextField nomeField = new JTextField(nomeP);
		 nomeField.setFont(new Font("Arial", Font.PLAIN, 20));
		 gbc.gridx = 1;
		 gbc.gridy = 0;
		 gbc.weightx = 90;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 0, 0, 15);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(nomeField, gbc);
		 request.add(nomeField);
		 
		 
		 JLabel cognome = new JLabel("Cognome: ");
		 cognome.setFont(new Font("Arial", Font.BOLD, 20));
		 gbc.gridx = 0;
		 gbc.gridy = 1;
		 gbc.weightx = 2;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 15, 0, 0); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.NONE;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(cognome, gbc);
		 request.add(cognome);
		 
		 JTextField cognomeField = new JTextField(cognomeP);
		 cognomeField.setFont(new Font("Arial", Font.PLAIN, 20));
		 gbc.gridx = 1;
		 gbc.gridy = 1;
		 gbc.weightx = 98;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 0, 0, 15);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(cognomeField, gbc);
		 request.add(cognomeField);

		 JLabel telefono = new JLabel("N° Telefonico: ");
		 telefono.setFont(new Font("Arial", Font.BOLD, 20));
		 gbc.gridx = 0;
		 gbc.gridy = 2;
		 gbc.weightx = 2;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 15, 0, 0); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.NONE;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(telefono, gbc);
		 request.add(telefono);
		 
		 JTextField telefonoField = new JTextField(telefonoP);
		 telefonoField.setFont(new Font("Arial", Font.PLAIN, 20));
		 gbc.gridx = 1;
		 gbc.gridy = 2;
		 gbc.weightx = 98;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 0, 0, 15);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(telefonoField, gbc);
		 request.add(telefonoField);
		 
		 JLabel indirizzo = new JLabel("Indirizzo: ");
		 indirizzo.setFont(new Font("Arial", Font.BOLD, 20));
		 gbc.gridx = 0;
		 gbc.gridy = 3;
		 gbc.weightx = 2;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 15, 0, 0); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.NONE;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(indirizzo, gbc);
		 request.add(indirizzo);
		 
		 JTextField indirizzoField = new JTextField(indirizzoP);
		 indirizzoField.setFont(new Font("Arial", Font.PLAIN, 20));
		 gbc.gridx = 1;
		 gbc.gridy = 3;
		 gbc.weightx = 98;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 0, 0, 15);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(indirizzoField, gbc);
		 request.add(indirizzoField);
		 
		 JLabel eta = new JLabel("Età: ");
		 eta.setFont(new Font("Arial", Font.BOLD, 20));
		 gbc.gridx = 0;
		 gbc.gridy = 4;
		 gbc.weightx = 2;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 15, 0, 0); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.NONE;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(eta, gbc);
		 request.add(eta);
		 
		 
		 NumberFormat format = NumberFormat.getInstance();
	     NumberFormatter formatter = new NumberFormatter(format);
	     formatter.setValueClass(Integer.class);
	     formatter.setMinimum(0);
	     formatter.setMaximum(Integer.MAX_VALUE);
	     formatter.setAllowsInvalid(false);
	     // If you want the value to be committed on each keystroke instead of focus lost
	     formatter.setCommitsOnValidEdit(true);
	     
	     JTextField etaField = new JTextField(etaP);
	     etaField.setFont(new Font("Arial", Font.PLAIN, 20));
		 //JTextField etaField = new JTextField(etaP);
		 gbc.gridx = 1;
		 gbc.gridy = 4;
		 gbc.weightx = 98;
		 gbc.weighty = 15;
		 gbc.insets = new Insets(15, 0, 0, 15);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid.setConstraints(etaField, gbc);
		 request.add(etaField);

		 
		 
		 
		 JButton salva = new JButton("Salva");
		 salva.setFont(new Font("Arial", Font.BOLD, 20));
		 try {
		        NoScalingIcon icon = new NoScalingIcon( new ImageIcon("src/resources/icons8-salva-35.png") );
		        salva.setIcon( icon );

			  } catch (Exception ex) {
			    System.out.println(ex);
	     }
		 
		 JButton annulla = new JButton("Annulla");
		 annulla.setFont(new Font("Arial", Font.BOLD, 20));
		 try {
		        NoScalingIcon icon = new NoScalingIcon( new ImageIcon("src/resources/icons8-annulla-35.png") );
		        annulla.setIcon( icon );

			  } catch (Exception ex) {
			    System.out.println(ex);
	     }

		 
		 
		 
		 JToolBar toolBar = new JToolBar();
		 toolBar.setBorder(new EmptyBorder(10, 20, 10, 20));
		 toolBar.setLayout(new GridLayout(1,2,30,0));
		 toolBar.setFloatable(false);
		 toolBar.setRollover(true);
		 toolBar.setAlignmentY(BOTTOM_ALIGNMENT);
		 //toolBar.addSeparator(new Dimension(0,5));
		 toolBar.add(salva);
		 toolBar.add(annulla);
		 //toolBar.addSeparator(new Dimension(0,5));
		 /*gbc.gridx = 0;
		 gbc.gridy = 2;
		 gbc.gridwidth = 2;
		 gbc.gridheight = 1;
		 gbc.weightx = 10;
		 gbc.weighty = 10;
		 gbc.insets = new Insets(10, 0, 0, 0); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.anchor = GridBagConstraints.PAGE_END;
		 grid.setConstraints(toolBar, gbc);
		 add(toolBar);*/
		 
		 
		 
		 
		 
		 
		 
		 GridBagLayout grid1 = new GridBagLayout();
		 setLayout(grid1);
		 gbc.gridx = 0;
		 gbc.gridy = 0;
		 gbc.weightx = 100;
		 gbc.weighty = 80;
		 gbc.insets = new Insets(0, 0, 15, 15);
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.anchor = GridBagConstraints.CENTER;
		 grid1.setConstraints(request, gbc);
		 gbc.gridx = 0;
		 gbc.gridy = 1;
		 gbc.weightx = 100;
		 gbc.weighty = 20;
		 gbc.insets = new Insets(0, 0, 0, 0);
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.anchor = GridBagConstraints.PAGE_END;
		 grid1.setConstraints(toolBar, gbc);
		 add(request);
		 add(toolBar);
		 
		 
		 
		 // Prima di chiudere la finestra riattivare la mainFrame
		 addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent e){
                 mf.setEnabled(true);
             }
         });
		 
		 
		 EditorPersonaFrame t = this;
		 annulla.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mf.setEnabled(true);
				t.dispatchEvent(new WindowEvent(t, WindowEvent.WINDOW_CLOSING));
				
			}
		});
		 salva.addActionListener(new SaveListener(mf, t, nomeField, cognomeField, indirizzoField, telefonoField, etaField, modifica));
		 
		 
		 PlainDocument doc = (PlainDocument) etaField.getDocument();
	     doc.setDocumentFilter(new MyIntFilter());
	     
		 PlainDocument doc2 = (PlainDocument) telefonoField.getDocument();
	     doc2.setDocumentFilter(new MyLongFilter());
	}

	
}


class MyIntFilter extends DocumentFilter {
   public void insertString(FilterBypass fb, int offset, String string,
         AttributeSet attr) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.insert(offset, string);

      if (test(sb.toString())) {
         super.insertString(fb, offset, string, attr);
      } else {
         // warn the user and don't allow the insert
      }
   }

   private boolean test(String text) {
      try {
         Integer i = Integer.parseInt(text);
         if (i<0) {
        	 return false;
         }
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }

   public void replace(FilterBypass fb, int offset, int length, String text,
         AttributeSet attrs) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.replace(offset, offset + length, text);

      if (sb.toString() == "" || test(sb.toString())) {
         super.replace(fb, offset, length, text, attrs);
      } else {
         // warn the user and don't allow the insert
      }

   }
}

class MyLongFilter extends DocumentFilter {
	   public void insertString(FilterBypass fb, int offset, String string,
	         AttributeSet attr) throws BadLocationException {

	      Document doc = fb.getDocument();
	      StringBuilder sb = new StringBuilder();
	      sb.append(doc.getText(0, doc.getLength()));
	      sb.insert(offset, string);

	      if (test(sb.toString())) {
	         super.insertString(fb, offset, string, attr);
	      } else {
	         // warn the user and don't allow the insert
	      }
	   }

	   private boolean test(String text) {
	      try {
	         Long i = Long.parseLong(text.replace(" ", ""));
	         if (i<0) {
	        	 return false;
	         }
	         return true;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	   }

	   public void replace(FilterBypass fb, int offset, int length, String text,
	         AttributeSet attrs) throws BadLocationException {

	      Document doc = fb.getDocument();
	      StringBuilder sb = new StringBuilder();
	      sb.append(doc.getText(0, doc.getLength()));
	      sb.replace(offset, offset + length, text);

	      if (sb.toString() == "" || test(sb.toString())) {
	         super.replace(fb, offset, length, text, attrs);
	      } else {
	         // warn the user and don't allow the insert
	      }

	   }
	}