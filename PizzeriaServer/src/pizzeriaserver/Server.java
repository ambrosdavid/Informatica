/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriaserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Server {
    private int porta;
    private ServerSocket server;
    private int clienti;
    private FXMLDocumentController controller;
    
    public Server(int porta, FXMLDocumentController controller) throws IOException{
        this.controller=controller;
        this.porta=porta;
        server= new ServerSocket(porta);
        
      
            while(true){
            Socket connessione=null;
                try {
                    connessione = server.accept();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            new Gestore(connessione, this.clienti++, this).start();
        }
        
    }
    
    public void print(String s){
       controller.scrivi(s);
    }
    public void printErr(String s){
       controller.scriviErr(s);
    }
    
    
    
    
}
