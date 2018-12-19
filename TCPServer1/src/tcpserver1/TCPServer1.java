/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author David
 */
public class TCPServer1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server= new ServerSocket(6666);
        
        while(true){
        Socket conessione = server.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(conessione.getInputStream()));
        PrintWriter out =new PrintWriter(conessione.getOutputStream());
        
        
        
        }
        
    }
    
}
