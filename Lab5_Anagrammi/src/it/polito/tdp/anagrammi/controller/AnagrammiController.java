package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Dizionario;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	Model model;
	public void setModel(Model model){
		this.model=model;
	}
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtInput;
    @FXML
    private Button btnCalcola;
    @FXML
    private TextArea txtCorretti;
    @FXML
    private TextArea txtErrati;
    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	String parolaInserita="";
    	parolaInserita=txtInput.getText();
    	List<String> lettere=new LinkedList<String>();
    	for(int i=0; i<parolaInserita.length(); i++){
    		lettere.add(parolaInserita.substring(i, i+1));
    	}
    	
    	for(Dizionario d: model.cercaAnagrammi(lettere)){
    		if(d.isTrovato()){
    			txtCorretti.appendText(d.getParola()+"\n");
    		}
    		else{
    			txtErrati.appendText(d.getParola()+"\n");
    		}
    	}	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInput.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
