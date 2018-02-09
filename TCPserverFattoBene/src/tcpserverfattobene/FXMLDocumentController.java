/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserverfattobene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author david.ambros
 */
public class FXMLDocumentController implements Initializable {
	Socket connessione;
	@FXML
	private Button riceviBTN;
	@FXML
	private Button inviaBTN;
	@FXML
	private TextArea getMsg;
	@FXML
	private TextField setMsg;

	@FXML
	private void riceviSuka(ActionEvent event) throws IOException {
		while(true){
		try {
			connessione = TCPserverFattoBene.server.accept();
		} catch (Exception ex) {
		}
		String ricevi;
		}
		/*BufferedReader input = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
		while (true) {
			ricevi = input.readLine();
			setMsg.setText(ricevi);
		} */
	}
	
	@FXML
	private void inviaEbani(ActionEvent event) throws IOException {

		String input;
		while (true) {
			input = getMsg.getText();
			PrintWriter out = new PrintWriter(connessione.getOutputStream(), true);

			out.println(input);
			out.flush();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		try {
			TCPserverFattoBene.server = new ServerSocket(3333);
		} catch (IOException ex) {
			Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
