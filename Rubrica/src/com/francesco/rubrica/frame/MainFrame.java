package com.francesco.rubrica.frame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;

import com.francesco.rubrica.classes.NoScalingIcon;
import com.francesco.rubrica.classes.Persona;
import com.francesco.rubrica.classes.Rubrica;
import com.francesco.rubrica.listeners.DelListener;
import com.francesco.rubrica.listeners.NewUpdPersonListener;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private int pos = -1;
	private Rubrica rubrica;
	
	public int getPos() {
		return pos;
	}


	public void setPos(int pos) {
		this.pos = pos;
	}


	public Rubrica getRubrica() {
		return rubrica;
	}


	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}
	
	
	
	public MainFrame(List<Persona> table, Point point) { // definiamone un costruttore
	
		super("Rubrica"); // richiama il costruttore della superclasse Jframe passando come parametro la stringa da visualizzare sulla barra del titolo
		
		setSize(500,300); // LARGHEZZA , ALTEZZA 
		setMinimumSize(new Dimension(450,270));
		setLocation(point);;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Evento di chiusura
		
		GridBagLayout grid = new GridBagLayout();
		setLayout(grid);
		GridBagConstraints gbc = new GridBagConstraints();
		 

	
	     
		 JTable list = new JTable(); //nuovo componente lista
		 list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 list.setFont(new Font("Arial", Font.PLAIN, 20));
		 list.setRowHeight(23);
		 list.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
		 Rubrica rub = new Rubrica(table, list);
		 this.setRubrica(rub);

		 


		JButton nuovo = new JButton();
		try {
		        NoScalingIcon icon = new NoScalingIcon( new ImageIcon("src/resources/icons8-aggiungere-utente-donna-40x40.png") );
		        nuovo.setIcon( icon );

			  } catch (Exception ex) {
			    System.out.println(ex);
	     }
		 JButton modifica = new JButton();
		 try {
		        NoScalingIcon icon = new NoScalingIcon( new ImageIcon("src/resources/icons8-aggiornare-utente-donna-40x40Es2.png") );
		        modifica.setIcon( icon );

			  } catch (Exception ex) {
			    System.out.println(ex);
	     }
		 JButton elimina = new JButton();
		 try {
		        NoScalingIcon icon = new NoScalingIcon( new ImageIcon("src/resources/icons8-elimina-il-cestino-40x40.png") );
		        elimina.setIcon( icon );

			  } catch (Exception ex) {
			    System.out.println(ex);
	     }

		 JToolBar toolBar = new JToolBar();
		 toolBar.setFloatable(false);
		 toolBar.setRollover(true);
		 toolBar.setAlignmentY(TOP_ALIGNMENT);
		 this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				Component t = (Component)e.getSource();
				

				toolBar.removeAll();
				toolBar.addSeparator(new Dimension((t.getWidth() / 2) - 115, 65));
				toolBar.add(nuovo);
				toolBar.addSeparator(new Dimension(30, 65));
				toolBar.add(modifica);
				toolBar.addSeparator(new Dimension(30, 65));
				toolBar.add(elimina);
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		 gbc.gridx = 0;
		 gbc.gridy = 0;
		 gbc.gridwidth = 1;
		 gbc.gridheight = 1;
		 gbc.weightx = 10;
		 gbc.weighty = 10;
		 gbc.insets = new Insets(0, 0, 0, 0); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.PAGE_START;
		 grid.setConstraints(toolBar, gbc);
		 add(toolBar);
		 
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setViewportView(list);
		 gbc.gridx = 0;
		 gbc.gridy = 1;
		 gbc.gridwidth = 3;
		 gbc.gridheight = 1;
		 gbc.weighty = 80;
		 gbc.insets = new Insets(0, 15, 15, 15); // top,  left, bottom, right
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.anchor = GridBagConstraints.PAGE_START;
		 grid.setConstraints(scrollPane, gbc);
		 add(scrollPane);
		 
		 
		 
		 
		 nuovo.addActionListener(new NewUpdPersonListener(this));
		 modifica.addActionListener(new NewUpdPersonListener(this,modifica));
		 elimina.addActionListener(new DelListener(this));
		 list.addMouseListener(new MouseAdapter() {
			 public void mouseReleased(MouseEvent e) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();	      
			      //System.out.println(row);
			      setPos(row);
			    }
		});
		 
		 
		 
		 setVisible(true); // rendiamo il frame visibile
	}





}
