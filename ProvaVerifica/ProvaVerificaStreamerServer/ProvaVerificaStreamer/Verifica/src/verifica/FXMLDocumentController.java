package verifica;

import java.io.IOException;
import java.net.Socket;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author David
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    protected TextField fieldDiRecezione;
    @FXML
    protected TextArea fieldDiTrasmissione;

    private StringProperty referenceTesto = new SimpleStringProperty();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fieldDiRecezione.textProperty().bind(referenceTesto);
    }

    @FXML
    public void start() {
       new Thread(new ClientMessageListener(Verifica.client, this.referenceTesto)).start();
    }

    @FXML
    public void invia() {    //invia
        new Thread(new ClientMessageInvier(Verifica.client, fieldDiTrasmissione.getText())).start();
        fieldDiTrasmissione.setText("");
    }
}