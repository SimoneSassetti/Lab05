package it.polito.tdp.anagrammi.model;

import java.util.*;

public class Model {

	private List<Lettera> lettere;
	private int codice;
	
	public Model(){
		codice=0;
		lettere=new LinkedList<Lettera>();
	}

	public List<String> cercaAnagrammi(List<String> parola) {
		for(String s: parola){
			Lettera l=new Lettera(codice,s);
			lettere.add(l);
			codice++;
		}
		
		List<Lettera> parziale=new LinkedList<Lettera>();
		List<Lettera> complete=new LinkedList<Lettera>();
		recursive(parziale, 0, complete);
		
		
		return null;
	}
	
	private void recursive(List<Lettera> parziale, int step, List<Lettera> complete){
		
		if(parziale.size()==lettere.size()){
			complete.clear();
			complete.addAll(parziale);
		}
		
		
		for(Lettera l: lettere){
			if(!parziale.contains(l)){
				parziale.add(l);
				recursive(parziale, step+1, complete);
				parziale.remove(l);
			}
		}
		
		
	}
}
