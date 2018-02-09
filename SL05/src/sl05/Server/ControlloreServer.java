/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sl05.Server;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/**
 *
 * @author david.ambros
 */
public class ControlloreServer implements Initializable {
	
	
	@FXML
	private TextField text;
	@FXML
	private Button btn;
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws Exception {	
		text.setText(server.getRcv());
		System.out.println(server.getRcv());
	}
	
	ServerClass server=new ServerClass();
	Thread t=new Thread(server);
		
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		t.start();
	}	
	
}
