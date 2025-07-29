package com.francesco.rubrica.classes;


public class Persona implements Comparable<Persona>{
	private long id; 


	private String nome;
	private String cognome;
	private String telefono;
	private String indirizzo;
	private int eta;
	
	

	public Persona(long id, String nome, String congnome, String telefono,String indirizzo, int eta) {
		this.id = id;
		this.nome = nome;
		this.cognome = congnome;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.eta = eta;
	}
	
	public void change(String nome, String congnome, String telefono,String indirizzo, int eta) {
		this.nome = nome;
		this.cognome = congnome;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.eta = eta;
	}
	
	public String[] getInfo() {
		String[] list = {this.nome, this.cognome, this.telefono};
		return list;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: " + this.id + "  nome: " + this.nome + "  cognome: " +  this.cognome + "  telefono: " + this.telefono
				+ "  indirizzo: " + this.indirizzo + "  eta: " + this.eta;
	}

	@Override
	public int compareTo(Persona o) {
		int val = this.nome.toLowerCase().compareTo(o.nome.toLowerCase());
		if (val == 0) {
			return this.cognome.toLowerCase().compareTo(o.cognome.toLowerCase());
		}
		return val;
		// TODO Auto-generated method stub
	}
	
	
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
