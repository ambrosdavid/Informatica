package clientverifica;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Florian
 */
public class ControllerFinestra implements Initializable {

    // Tutti i messaggi che voglio inviare al server appena mi loggo...
    private static final String USER = "/USER";
    private static final String SING_IN = "/SING IN";
    private static final String EXIT = "/EXIT";
    private static final String PASS = "/PASS";
    private static final String LOG = "/LOG";

    @FXML
    private TextArea schermo;

    @FXML
    private TextField ip_campo;
    @FXML
    private TextField porta_campo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void provaConnessione() {

        String IP = ip_campo.getText();
        String porta = porta_campo.getText();

        if (isCampoValido(IP) && isCampoValido(porta)) {
            try {
                connettiti(IP, porta);
            } catch (IOException ex) {
                connessioneFallita();
            }
        }
    }

    private void connettiti(String IP, String porta) throws IOException {
        // Server vero e proprio
        Socket SERBER = new Socket("192.168.1.65", 6969);
        // Mezzo per la quale posso communicare
        PrintWriter INVIARE_AL_SERVER = new PrintWriter(SERBER.getOutputStream(), true);
        //Mezzo per la quale posso leggere le risposte
        Scanner RICEVERE_DAL_SERVER = new Scanner(SERBER.getInputStream());

        invia(INVIARE_AL_SERVER, SING_IN);

        riceviRisposta(RICEVERE_DAL_SERVER);

        invia(INVIARE_AL_SERVER, USER + " alpha");

        riceviRisposta(RICEVERE_DAL_SERVER);

        invia(INVIARE_AL_SERVER, PASS + " meme24");

        riceviRisposta(RICEVERE_DAL_SERVER);

        invia(INVIARE_AL_SERVER, LOG);

        riceviRisposta(RICEVERE_DAL_SERVER);

        invia(INVIARE_AL_SERVER, EXIT);

        riceviRisposta(RICEVERE_DAL_SERVER);

        INVIARE_AL_SERVER.close();
        RICEVERE_DAL_SERVER.close();
        SERBER.close();

    }

    private boolean isCampoValido(String IP) {
        return true;
    }

    private void connessioneFallita() {
        System.err.println("Connesione fallita.");
    }

    private void invia(PrintWriter INVIARE_AL_SERVER, String messaggio) {
        INVIARE_AL_SERVER.println(messaggio);
    }

    private void riceviRisposta(Scanner RICEVERE_DAL_SERVER) {
        // System.out.println("Recezione : " + RICEVERE_DAL_SERVER.nextLine());
        
            schermo.setText(schermo.getText()+"\n"+ "Ricezione : " + RICEVERE_DAL_SERVER.nextLine()  );
        
    }

}
