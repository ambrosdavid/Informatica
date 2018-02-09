package sl05.Rilevatore;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DSender extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Grafica.fxml"));
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}

  public static void main(String[] args) throws Exception {
	launch(args);
	  
    
	
  }
}
