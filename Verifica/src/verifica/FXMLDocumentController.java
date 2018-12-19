package verifica;

import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Andrea Dattero
 */
public class FXMLDocumentController implements Initializable {
    Thread th;
    @FXML
    protected TextArea testo;
    @FXML
    private Button start;
    @FXML
    private Button stop;
    @FXML
    private TextArea invia;
    @FXML
    private Button sendMSG;
    
    private StringProperty referenceTesto =new SimpleStringProperty();;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        testo.textProperty().bind(referenceTesto);
    }    
    
    @FXML
    public void riccevi(){
        th=new Thread(new ClientMessageListener(Verifica.client,this.referenceTesto));
        th.start();
    }
    @FXML
    public void invia(){
        new Thread(new InvioMessaggio( invia)).start();
        invia.setText("");
    }
    
    @FXML
    public void stop(){
        th.interrupt();
    }
    
}
