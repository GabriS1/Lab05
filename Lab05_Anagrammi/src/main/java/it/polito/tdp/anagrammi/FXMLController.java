package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnFind;

    @FXML
    private TextArea txtCorrect;

    @FXML
    private TextArea txtUncorrect;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	this.txtCorrect.clear();
    	this.txtUncorrect.clear();
    	String s= this.txtInsert.getText();
    	
    	List<Parola> anagrammi= new ArrayList<>();
    	anagrammi= this.model.anagrammi(s);
    	
    	for(Parola pi : anagrammi) {
    		if(pi.isCorrect()) {
    			this.txtCorrect.appendText(pi.getTesto()+"\n");
    		}else {
    			this.txtUncorrect.appendText(pi.getTesto()+"\n");
    		}
    	}
    	
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtCorrect.clear();
    	this.txtUncorrect.clear();
    	this.txtInsert.clear();

    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnFind != null : "fx:id=\"btnFind\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtUncorrect != null : "fx:id=\"txtUncorrect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model m) {
    	this.model=m; 
    }
}
