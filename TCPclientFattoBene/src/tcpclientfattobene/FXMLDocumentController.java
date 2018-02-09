/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclientfattobene;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author david.ambros
 */
public class FXMLDocumentController implements Initializable {
	private Socket client;
	
	@FXML
	private Button creaClient;
	@FXML
	private Button invia;
	@FXML
	private Button ricevi;
	@FXML
	private TextField prendiIp;
	@FXML
	private TextField porta;
	@FXML
	private TextArea getMsg;
	@FXML
	private TextField setMsg;
	
	@FXML
	private void creaSukaClient(ActionEvent event) throws IOException {
		try{
		//client=new Socket(prendiIp.getText(), Integer.parseInt(porta.getText()));
		client=new Socket("192.168.10.4",3333);
		getMsg.setText("Socket creato");
		}catch(Exception e){
			System.out.println("Crashato");
		}
	}
	
	@FXML
	private void inviaEbani(ActionEvent event) throws IOException {
		
	String input;
        while (true) {
            input = getMsg.getText();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			
            out.println(input);
            out.flush();
        }		
	}
	
	@FXML
	private void riceviDaSukaServer(ActionEvent event) throws IOException {
	String ricevi;

		BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
		while (true) {
			ricevi = input.readLine();
			setMsg.setText(ricevi);
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}	
	
}
