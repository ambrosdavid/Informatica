/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifica;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;

/**
 *
 * @author David
 */
public class InvioMessaggio implements Runnable {

    TextArea invia;

    public InvioMessaggio(TextArea invia) {
        this.invia = invia;
    }

    @Override
    public void run() {
        System.out.println("Run partito");
        try {
            
            DataOutputStream output = new DataOutputStream(Verifica.client.getOutputStream());
           System.out.println("Messaggio inviato= "+ invia.getText()); 
           output.writeUTF(invia.getText());
            
        } catch (IOException ex) {

        }
    }

}
