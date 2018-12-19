/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class MulticastClient implements Runnable {
    

    public static void main(String[] args) throws SocketException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
       /*  MessageSender ms= new MessageSender( new DatagramSocket(6669),"151.49.159.155");
        
        
       new Thread(()->{
           BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
           
            while(true){
               try {
                   String s=  bf.readLine();
                   ms.scrivi(s);
               } catch (IOException ex) {
                   Logger.getLogger(MulticastClient.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }).start();
        */
        
        Thread t = new Thread(new MulticastClient());
        t.start();
    }

    public void receiveUDPMessage(String ip, int port) throws
            IOException {
        byte[] buffer = new byte[1024];
        MulticastSocket socket = new MulticastSocket(6666);
        InetAddress group = InetAddress.getByName("230.0.0.0");
        socket.joinGroup(group);
        while (true) {
            System.out.println("Waiting for multicast message...");
            DatagramPacket packet = new DatagramPacket(buffer,
                    buffer.length);
            socket.receive(packet);
            String msg = new String(packet.getData(),
                    packet.getOffset(), packet.getLength());
            System.out.println("[Multicast UDP message received]>> " + msg);
            
            
            if ("OK".equals(msg)) {
                System.out.println("No more message. Exiting : " + msg);
                break;
            }
        }
        socket.leaveGroup(group);
        socket.close();
    }

    @Override
    public void run() {
        try {
            receiveUDPMessage("230.0.0.0", 6666);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
