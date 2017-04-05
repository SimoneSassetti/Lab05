package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	private List<Lettera> lettere;
	private List<String> complete;
	private int codice;
	private List<Dizionario> listaParola=new LinkedList<Dizionario>(); 
	
	public Model(){
		codice=0;
	}

	public List<Dizionario> cercaAnagrammi(List<String> parola) {
		lettere=new LinkedList<Lettera>();
		complete=new LinkedList<String>();
		for(String s: parola){
			Lettera l=new Lettera(codice,s);
			lettere.add(l);
			codice++;
		}
		
		List<Lettera> AnagrammaParziale=new LinkedList<Lettera>();
		recursive(AnagrammaParziale, 0);
		return listaParola;
	}
	
	private void recursive(List<Lettera> parziale, int step){
		AnagrammaDAO dao=new AnagrammaDAO();
		
		if(parziale.size()==lettere.size() && !complete.contains(calcolaCaratteri(parziale))){
			String temp=calcolaCaratteri(parziale);
			complete.add(temp);
			listaParola.add(new Dizionario(temp,dao.isCorrect(temp)));
			return;
		}
		
		for(Lettera l: lettere){
			if(!parziale.contains(l)){
				if(parziale.size()<this.lettere.size()){
					parziale.add(l);
					recursive(parziale,step+1);
					parziale.remove(l);
				}
			}
		}	
	}
	private String calcolaCaratteri(List<Lettera> parziale){
		String ris="";
		for(Lettera l: parziale){
			ris+=l.getLettera();
		}
		return ris;
	}
}
