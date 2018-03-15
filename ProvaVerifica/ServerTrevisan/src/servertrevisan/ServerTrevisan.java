package servertrevisan;

/**
 *
 * @author Florian
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerTrevisan {
    
    private static final String USER = "/USER";
    private static final String SING_IN = "/SING IN";
    private static final String EXIT = "/EXIT";
    private static final String PASS = "/PASS";
    private static final String LOG = "/LOG";
    
    
    public static void main(String argv[]) throws Exception {
        final int porta = 6969;
        
        String passwordUtente = "";
        String nomeUtente = "";

        ServerSocket serber = new ServerSocket(porta);

        System.out.println("Server avviato con la porta " + porta);



        while (true) {
            
            System.out.println("Iniziato ascolto di connessione ...");
            // ASPETTO FINO A QUANDO QUALCUNO NON SI CONNETTE...
            Socket client_connesso = serber.accept();

            System.out.println("Un client si é connesso al nostro serber");

            Scanner ricezione_dal_client = new Scanner(client_connesso.getInputStream());
            PrintWriter invio_al_client = new PrintWriter(client_connesso.getOutputStream(), true);// questo true é importantissimo
            
            while(ricezione_dal_client.hasNextLine()){
                
                String info_dal_client = ricezione_dal_client.nextLine().toUpperCase();
                System.out.println(info_dal_client);
                
                if(info_dal_client.charAt(0)=='/'){
                    
                    if (info_dal_client.startsWith(USER)) {
                        nomeUtente = info_dal_client.substring(USER.length());
                        inviaAlClient(invio_al_client,nomeUtente+"! Che bel nome!");
                        continue;
                    }
                    
                    if (info_dal_client.startsWith(PASS)) {
                        passwordUtente = info_dal_client.substring(PASS.length());
                        inviaAlClient(invio_al_client,passwordUtente+" ora é la tua nuova password , la terrò a mente!");
                        continue;
                    }
                    
                    if (info_dal_client.equals(LOG)) {
                        inviaAlClient(invio_al_client,"Nome utente : "+nomeUtente+"\r\nPassword : "+passwordUtente);
                        continue;
                    }
                    
                    if (info_dal_client.equals(SING_IN)) {
                        inviaAlClient(invio_al_client,"Ben Venuto !");
                        continue;
                    }
                    
                    if (info_dal_client.equals(SING_IN)) {
                        inviaAlClient(invio_al_client,"Ben Venuto !");
                        continue;
                    }
                    if (info_dal_client.equals(EXIT)) {
                        inviaAlClient(invio_al_client,"Bye byeeee :D ");
                        break;
                    }
                }
                
                inviaAlClient(invio_al_client,"Ho ricevuto : " + info_dal_client + "\nE non é un comando! :D");
            }
            
            System.out.println("Finita communicazione con questo client...");
            ricezione_dal_client.close();
        }
    }

    private static void inviaAlClient(PrintWriter invio_al_client, String messaggio) {
        invio_al_client.println(messaggio);
    }

}
