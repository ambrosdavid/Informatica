/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sl05.Client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author david.ambros
 */
public class GraficaFxmlController implements Initializable {
	@FXML
	private Button cerca;
	@FXML
	private TextArea nomeMacchina;
	@FXML
	private TextArea tempo;

	@FXML
	private void cerca(ActionEvent event) throws Exception {
		
		u = new Utente(nomeMacchina, Integer.parseInt(tempo.getText().toString()));
		Thread t = new Thread(u);
		t.start();
		//cerca.setDisable(true);
	}
	Utente u;
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		
		
	}

}
