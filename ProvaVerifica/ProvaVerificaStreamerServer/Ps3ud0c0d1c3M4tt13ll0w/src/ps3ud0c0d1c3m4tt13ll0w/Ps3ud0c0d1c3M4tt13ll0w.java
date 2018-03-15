package ps3ud0c0d1c3m4tt13ll0w;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Andrea Dattero
 */
public class Ps3ud0c0d1c3M4tt13ll0w {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4949);
            while(true){
                Socket client= ss.accept();
               // Thread t=new Thread(new ListenerMessaggio(client));
              //  t.start();  
              iniziaLettura(client);
                System.out.println("Client connected: "+client.getInetAddress());
                DataOutputStream dout = new DataOutputStream(client.getOutputStream());
                
                
                String msg = "Ciao, mio studente ";
                 
                dout.writeUTF(msg);
                
                dout.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        private static void iniziaLettura(Socket get) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        DataInputStream dis = new DataInputStream(get.getInputStream());
                        System.out.println(dis.readUTF());
                    } catch (IOException ex) {
                    }
                }
            }
        }).start();
    }
}
