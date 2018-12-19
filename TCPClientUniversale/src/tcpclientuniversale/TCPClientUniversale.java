package tcpclientuniversale;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class TCPClientUniversale {

    public static Socket clientSocket;

    private final static Runnable print = new Runnable() {
        @Override
        public void run() {

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter outToServer = null;
            try {
                outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException ex) {
                Logger.getLogger(TCPClientUniversale.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sentence = ".";
           // outToServer.println(nome);
            while (!sentence.isEmpty()) {

                try {
                    sentence = inFromUser.readLine();
                } catch (IOException ex) {
                }

                outToServer.println(sentence);
            }
        }
    };

    private final static Runnable read = new Runnable() {
        @Override
        public void run() {
            BufferedReader inFromSerber = null;
            try {
                inFromSerber = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException ex) {
            }

            while (true) {
                try {
                    System.out.println(inFromSerber.readLine());
                } catch (IOException ex) {
                }
            }
        }
    };

    private static final int port = 6666;
    private static final String ip = "151.49.158.86";
    private final static String nome = "Xilo";

    public static void main(String argv[]) throws Exception {

        System.out.println("Tryng to connect at \nip : 188.218.198.148 \nport : 6666");

        clientSocket = new Socket(ip, port);

        System.out.println(clientSocket);
        System.out.println(clientSocket.getOutputStream());

        System.out.println("Connected :D");

        new Thread(print).start();
        new Thread(read).start();
    }
}
