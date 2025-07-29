package com.francesco.rubrica.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.francesco.rubrica.DBConnection;

public class Rubrica {
	
	private List<Persona> table; 
	private JTable tableVisual;
	private Connection con = DBConnection.getConnection();
	
	public Rubrica(List<Persona> table, JTable tableVisual) {
		this.table = table;
		this.tableVisual = tableVisual;
		this.tableVisual.setModel(createModel());
	}
	
	public Persona getEl(int pos) {
		return this.table.get(pos);
	}
	
	public void deleteEl(int pos) {
		Persona p = this.table.remove(pos);
		DefaultTableModel d = (DefaultTableModel) this.tableVisual.getModel();
		d.removeRow(pos);
		
		
		String sql = "DELETE FROM contact WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setLong(1, p.getId()); // ID del contatto da eliminare
                stmt.executeUpdate();
                
                //int righeEliminate = stmt.executeUpdate();
                //System.out.println("Righe eliminate: " + righeEliminate);
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void addEl(Persona p) {
		this.table.add(p);
		this.tableVisual.setModel(createModel());
		
		int position = this.getPos(p);
		this.tableVisual.setRowSelectionInterval(position, position);
		
		
        String sql = "INSERT INTO contact (nome, cognome, telefono, indirizzo, eta) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCognome());
            stmt.setString(3, p.getTelefono());
            stmt.setString(4, p.getIndirizzo());
            stmt.setInt(5, p.getEta());
            stmt.executeUpdate();
            
            //int righeInserite = stmt.executeUpdate();
            //System.out.println("Righe inserite: " + righeInserite);
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    long idGenerato = rs.getLong(1); // la prima colonna è l'id
                    p.setId(idGenerato);
                    //System.out.println("ID generato: " + idGenerato);
                }
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
	}
	
	public void updateEl(Persona p, int pos) {
		long id = this.table.get(pos).getId();
		p.setId(id);
		
		this.table.set(pos, p);
		this.tableVisual.setModel(createModel());
		
		int position = this.getPos(p);
		this.tableVisual.setRowSelectionInterval(position, position);
		
		
        String sql = "UPDATE contact SET nome = ?, cognome = ?, telefono = ?, indirizzo = ?, eta = ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCognome());
            stmt.setString(3, p.getTelefono());
            stmt.setString(4, p.getIndirizzo());
            stmt.setInt(5, p.getEta());
            stmt.setLong(6, p.getId());
            stmt.executeUpdate();
            
            //int righeAggiornate = stmt.executeUpdate();
            //System.out.println("Righe aggiornate: " + righeAggiornate);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public int getPos(Persona p) {
		return this.table.indexOf(p);
	}
	
	@SuppressWarnings("serial")
	private DefaultTableModel createModel() {
		this.table.sort(null);
		String[] columnNames = {"Nome","Cognome","N° Telefonico"};
		String[][] data = this.table.stream().map(Persona::getInfo).toArray(String[][]::new);
		return (new DefaultTableModel(data,columnNames) {
			
		     @Override
		     public boolean isCellEditable(int row, int column) {
		        return false;
		     }
		     
		     
		 });
	}

}
