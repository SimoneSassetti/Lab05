package it.polito.tdp.anagrammi.model;

public class Lettera {
	
	private int codice;
	private String lettera;
	
	public Lettera(int codice, String lettera) {
		super();
		this.codice = codice;
		this.lettera = lettera;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getLettera() {
		return lettera;
	}

	public void setLettera(String lettera) {
		this.lettera = lettera;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codice;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lettera other = (Lettera) obj;
		if (codice != other.codice)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("Lettera [codice=%s, lettera=%s]", codice, lettera);
	}

	public int lunghezza() {
		return this.getLettera().length();
	}
}
