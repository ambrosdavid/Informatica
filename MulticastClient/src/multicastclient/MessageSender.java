/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastclient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author David
 */
public class MessageSender {
    public final static int PORT = 6669;
    private DatagramSocket sock;
    private String hostname;


    MessageSender(DatagramSocket s, String h) {
        sock = s;
        hostname = h;
    }

    private void sendMessage(String s) throws Exception {
        System.out.println("STRINGA = "+ s);
        byte buf[] = s.getBytes();
        InetAddress address = InetAddress.getByName(hostname);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, PORT);

        sock.send(packet);

    }


    public Runnable scrivi(String st) {
        String s=st;
        return ()->{

            try {
                sendMessage(s);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
