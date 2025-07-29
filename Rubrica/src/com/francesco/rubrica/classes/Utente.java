package com.francesco.rubrica.classes;

public class Utente {
	String username;
	String password;
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Utente(String u, String p) {
		this.username = u;
		this.password = p;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		try {
			Utente o = (Utente) obj;
			return (this.username.equals(o.username) && this.password.equals(o.password));
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "username: " + this.username + "   password: " + this.password;
	}

}
