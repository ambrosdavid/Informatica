/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumberfx;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author David
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label minuti;
    @FXML
    private Label secondi;
    @FXML
    private Button startBtn;
    @FXML
    private Button stop;
    @FXML
    private Button reset;

    private Thread th;

    private boolean stoppato;
    private int DTsecondi;
    private int DTminuti;

    @FXML
    private void start(ActionEvent event) throws InterruptedException {

        Task<Void> taskSecondi = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                
                int i = DTsecondi=1;
                int f = DTminuti=1;
                while (true) {
                    if (i < 6) {
                        final int finalI = i++;
                        Platform.runLater(() -> secondi.setText("" + finalI));
                        DTsecondi = finalI;
                        Thread.sleep(1000);
                    } else {
                        i = 1;
                        final int minuts = f++;

                        Platform.runLater(() -> minuti.setText("" + minuts));
                        DTminuti = minuts;
                    }
                }
            }
        };
        th = new Thread(taskSecondi);
        th.setDaemon(true);
        th.start();
    }

    @FXML
    private void stop(ActionEvent event) throws InterruptedException {

        th.interrupt();
    }

    @FXML
    private void reset(ActionEvent event) throws InterruptedException {
        th.interrupt();
        secondi.setText("0");
        minuti.setText("0");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ciao");
    }

}
