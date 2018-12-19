/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriaserver;

import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author David
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public JFXTextArea finestra;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new Thread(()->{
            try {
                Server server = new Server(6666, this);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    public void scrivi(String s) {
        finestra.setText(finestra.getText()+"\n"+ s);
    }

    public void scriviErr(String s) {
        String tempStyle=finestra.getStyle();
        finestra.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
        finestra.setText(finestra.getText()+"\n"+ s);
        finestra.setStyle(tempStyle);
        

    }

}
