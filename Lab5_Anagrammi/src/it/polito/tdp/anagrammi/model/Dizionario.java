package it.polito.tdp.anagrammi.model;

public class Dizionario {
	
	private String parola;
	private boolean trovato;
	
	public Dizionario(String parola, boolean trovato) {
		super();
		this.parola = parola;
		this.trovato = trovato;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isTrovato() {
		return trovato;
	}
	public void setTrovato(boolean trovato) {
		this.trovato = trovato;
	}
	
	
	
	
	
}
