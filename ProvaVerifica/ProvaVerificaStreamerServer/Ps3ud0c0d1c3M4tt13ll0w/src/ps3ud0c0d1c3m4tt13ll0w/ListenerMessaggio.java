/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps3ud0c0d1c3m4tt13ll0w;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class ListenerMessaggio implements Runnable {

    Socket client;

    public ListenerMessaggio(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            try {

                DataInputStream input = new DataInputStream(client.getInputStream());

                System.out.println(input.readUTF());

            } catch (IOException ex) {
            }
        }
    }

}
