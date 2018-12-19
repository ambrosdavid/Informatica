/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriaserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author David
 */
public class Gestore extends Thread {

    private Server server;
    Pizze pizze = new Pizze();
    private Socket conessione;
    private int clienti;

    public Gestore(Socket connessione, int clienti, Server server) {
        this.server = server;
        this.conessione = connessione;
        this.clienti = clienti;
        server.print("Connesso cliente numero: " + clienti + " alla connessione: " + connessione);

        pizze.aggiungiPizza("margherita", 5.50);
        pizze.aggiungiPizza("diavola", 5.50);
    }

    public void run() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(conessione.getInputStream()));
            PrintWriter out = new PrintWriter(conessione.getOutputStream(), true);

            out.println("Hello, you are client #" + clienti + ".");

            // Get messages from the client, line by line; 
            // return them capitalized
            while (true) {
                String input = in.readLine();

                try {

                    out.println("Costo: " + pizze.ricavaCosto(input));
                    server.print("cliente: " + clienti + "ha chiesto una Pizza " + input);
                } catch (Exception ex) {

                    server.printErr("cliente:" + clienti + "ha chiesto una Pizza non presente nel catalogo!!!"+" ("+ input+")");

                }
                if (input.equals(".")) {
                    out.println("Close connection for client #" + clienti + ".");
                    conessione.close();
                    break;
                }

            }
        } catch (IOException e) {
            server.printErr("Error handling client# " + clienti + ": " + e);
        } finally {
            try {
                conessione.close();
            } catch (IOException e) {
                // log("Couldn't close a socket, what's going on?");
            }
            server.printErr("Connection with client# " + clienti + " closed");
        }
    }

}
