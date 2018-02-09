/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sl05.Rilevatore;



import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author david.ambros
 */
public class ControllerRillevatore implements Initializable {
	
	@FXML
	private Button crea;
	@FXML
	private TextField nomeMacchina;
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws Exception {
		Thread t=new Thread( new Rilevatore(new Macchina(nomeMacchina.getText().toString())));
		t.start();
		crea.setDisable(true);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}	
	
}
