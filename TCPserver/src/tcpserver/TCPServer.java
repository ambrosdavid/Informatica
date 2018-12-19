/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

class TCPServer {

    static Socket lastConnected = null;
    static LinkedHashSet<Socket> s = new LinkedHashSet<>();

    public static void main(String argv[]) throws Exception {
        String clientSentence;

        ServerSocket welcomeSocket = new ServerSocket(6666);

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("ciao0");

                    lastConnected = welcomeSocket.accept();
                    s.add(lastConnected);
                    System.out.println("ciao");
                } catch (IOException ex) {
                    Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        while (true) {
            System.out.println(s.size());
            if (s.isEmpty()) {

                continue;
            }

            BufferedReader inFromClient
                    = new BufferedReader(new InputStreamReader(lastConnected.getInputStream())
                    );

            clientSentence = inFromClient.readLine();
            System.out.println("Flo: " + clientSentence);
            Socket temp = null;
            System.out.println(s.size());
            for (Iterator<Socket> i = s.iterator(); i.hasNext();) {
                temp = i.next();
                DataOutputStream outToClient = new DataOutputStream(temp.getOutputStream());
                outToClient.writeBytes(clientSentence);
            }

        }
    }
}
