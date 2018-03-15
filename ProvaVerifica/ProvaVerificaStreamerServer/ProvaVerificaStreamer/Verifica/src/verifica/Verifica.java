package verifica;

import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author David
 */
public class Verifica extends Application {

    static Socket client;
    private double posFinestraX, posFinestraY;
    
    private final static String ipMacchinaServer = "192.168.1.6";
    private final static int portaMacchinaServer = 4949;

    @Override
    public void start(Stage stage) {
        initComponents(stage);
    }

    public static void main(String[] args) {

        try {
            client = new Socket(ipMacchinaServer, portaMacchinaServer);
        } catch (IOException ex) {
        }
        
        launch(args);
    }

    private void initComponents(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setAlwaysOnTop(true);
            stage.show();
        } catch (IOException ex) {
        }
    }
}
