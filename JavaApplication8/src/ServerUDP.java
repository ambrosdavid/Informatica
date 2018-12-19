//Importo i package necessari
import java.net.*;
import java.io.*;
public class ServerUDP {
   public void start() throws IOException {
 
     //Attivo la Socket sul Server in ascolto sulla porta 7777
     DatagramSocket s = new DatagramSocket(7777);
 
     //Informazioni sul Server in ascolto
     InetAddress indirizzo = s.getLocalAddress();
     String server = indirizzo.getHostAddress();
     int port = s.getLocalPort();
     System.out.println("In ascolto Server UDP: "+ server + " porta: " + port);
 
     //Ciclo infinito per ascolto dei Client
     while (true) {
 
       //Preparazione delle informazioni da ricevere
       byte[] buf = new byte[65536];
       System.out.println("In attesa di chiamate dai Client... ");
       DatagramPacket recv = new DatagramPacket(buf, buf.length);
       s.receive(recv);
 
       //Informazioni sul Client che ha effettuato la chiamata
       InetAddress address = recv.getAddress();
       String client = address.getHostName();
       int porta = recv.getPort();
       System.out.println("In chiamata Client: "+ client + " porta: " + porta);
 
       //Messaggio ricevuto dal Client
       String messaggio = (new String(recv.getData()).trim());
       System.out.println("Il Client ha scritto: " + messaggio);
     }
   }
   public static void main (String[] args) throws IOException {
     ServerUDP udpServer = new ServerUDP();
     udpServer.start();
   }
}