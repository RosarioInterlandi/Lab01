package it.polito.tdp.Lab01;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.Lab01.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTime;
    
    @FXML
    void handleCancel(ActionEvent event) {
    	long t1=System.nanoTime();
    	String parola = txtParola.getText();
    	elenco.doCancel(parola);
    	long t2 = System.nanoTime();
    	txtTime.appendText((t2-t1)+"\n");
    }

    @FXML
    void doInsert(ActionEvent event) {
    	long t1=System.nanoTime();
    	String parola = txtParola.getText();
    	if (parola.compareTo("")==0) {
    		String elencoInStringa="";
    		for(String p:elenco.getElenco()) {
    			if (elencoInStringa.compareTo("")!=0)
    				elencoInStringa += "\n";
    			elencoInStringa += p;
    		}
    		txtResult.setText(elencoInStringa);	
    	}
    	else {
    		elenco.addParola(parola);
    	}
    	long t2 = System.nanoTime();
    	txtTime.appendText((t2-t1)+"\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	long t1=System.nanoTime();
    	elenco.reset();
    	long t2 = System.nanoTime();
    	txtTime.appendText((t2-t1)+"\n");
    }

    @FXML
    void initialize() {
    	assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new Parole() ;
    }

}
