package verifica;

import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Andrea Dattero
 */
public class Verifica extends Application {
    static Socket client;
    @Override
    public void start(Stage stage){
        initComponents(stage);
    }

    public static void main(String[] args) {
        
        try {
            client = new Socket("192.168.1.65",8080);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        launch(args);
    }
    
    private void initComponents(Stage stage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
