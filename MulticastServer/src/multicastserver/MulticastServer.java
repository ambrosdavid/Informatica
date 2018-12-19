/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author David
 */
public class MulticastServer {

   public static void sendUDPMessage(String message,
   String ipAddress, int port) throws IOException {
      DatagramSocket socket = new DatagramSocket();
      InetAddress group = InetAddress.getByName(ipAddress);
      byte[] msg = message.getBytes();
      DatagramPacket packet = new DatagramPacket(msg, msg.length,
         group, port);
      socket.send(packet);
      socket.close();
   }

   public static void main(String[] args) throws IOException {
       BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
       while(true){
           String s= reader.readLine();
           sendUDPMessage(s, "230.0.0.0",
         6666);
       }
      /*sendUDPMessage("This is a multicast messge", "230.0.0.0",
         6666);
      sendUDPMessage("This is the second multicast messge",
         "230.0.0.0", 6666);
      sendUDPMessage("This is the third multicast messge",
         "230.0.0.0", 6666);*/
    //  sendUDPMessage("OK", "230.0.0.0", 6666);
   }
    
}
