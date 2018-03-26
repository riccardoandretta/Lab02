package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary dictionary = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtResult.clear();
    	String riga = txtWord.getText().toLowerCase();
    	
    	//Controllo sull'input
    	if (riga == null || riga.length() == 0) {
			txtResult.setText("Inserire una o due parole.");
			txtWord.clear();
			return;
    	}    	
    	    	
    	if (riga.contains(" ")) {
    		if (riga.trim().compareTo("") == 0) {
        		txtResult.setText("Inserire una o due parole.");
        		txtWord.clear();
        		return;
        	}
    		    		
    		String [] array = riga.split(" ");
    		
    		if (!array[0].matches("[a-zA-Z]*") || !array[1].matches("[a-zA-Z]*")) { // * indica 0 o più volte; + indica 1 o più volte
        		txtResult.setText("Insert only alfabethic expression");
        		txtWord.clear();
        		return;
        	}
    		
    		
    		dictionary.addWord(array[0], array[1]);
    		txtResult.setText("New word added!");
    		txtWord.clear();
    	
    	}else {
    		
    		String translation;
    		//Aggiungo -->
    		if(riga.matches("[a-zA-Z?]*")) {
    			translation = dictionary.translateWordWildCard(riga);
    		}
    		else if(riga.matches("[a-zA-Z]*")) {
    			translation = dictionary.translateWord(riga);
    			}
    		else { // aggiungo ? --> 
        		txtResult.setText("Insert only alfabethic expression");
        		txtWord.clear();
        		return;
        	}
    		
    		if (translation == null) {
    			txtResult.setText("Word not found.");}
    		else {
    			txtResult.setText(translation+"\n");}
    		txtWord.clear();
    	}
    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtWord.clear();
    }
    
}
