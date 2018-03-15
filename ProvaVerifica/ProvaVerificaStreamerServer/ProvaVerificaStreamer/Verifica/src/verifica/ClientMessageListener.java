package verifica;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;

/**
 *
 * @author David
 */
public class ClientMessageListener implements Runnable {

    private Socket client;
    private DataInputStream din;
    private StringProperty referenceTesto;

    ClientMessageListener(Socket client, StringProperty referenceTesto) {
        this.client = client;
        this.referenceTesto = referenceTesto;
    }

    @Override
    public void run() {
        try {
            din = new DataInputStream(client.getInputStream());
            while (true) {
                String message = "" + din.readUTF();
                System.out.println(message);
                Platform.runLater(() -> {
                    referenceTesto.setValue(message);
                });
            }
        } catch (IOException ex) {
        }
    }

}
