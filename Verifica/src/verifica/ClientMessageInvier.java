package verifica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Florian
 */
public class ClientMessageInvier implements Runnable {

    private Socket client;
    private String messaggioDaInviare;

    public ClientMessageInvier(Socket client,String messaggioDaInviare) {
        this.client = client;
        this.messaggioDaInviare = messaggioDaInviare;
    }

    @Override
    public void run() {
        DataOutputStream din;
        try {
            din = new DataOutputStream(client.getOutputStream());
            din.writeUTF(messaggioDaInviare);
            System.out.println(messaggioDaInviare);
        } catch (IOException ex) {
        }
    }

}
