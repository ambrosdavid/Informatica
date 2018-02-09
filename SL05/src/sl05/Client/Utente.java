/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sl05.Client;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;

/**
 *
 * @author david.ambros
 */
class Utente implements Runnable {
	DatagramSocket ds;
	String pos;
	int tempo;
	TextArea aggiornaNome;
	public Utente(){
		
	}

	Utente(TextArea nomeMacchina, int tempo) {
		this.tempo=tempo;
		this.aggiornaNome=nomeMacchina;
		
	}

	public String getPos() {
		return pos;
	}

	@Override
	public void run() {
		try {
			ds = new DatagramSocket(3003);
			byte[] buf = new byte[1024];
			while(true){
			
			DatagramPacket dp = new DatagramPacket(buf, 1024);
			ds.receive(dp);
			String strRecv = new String(dp.getData(), 0, dp.getLength());
			pos=strRecv;
			aggiornaNome.setText(pos);
				try {
					sleep(tempo);
				} catch (InterruptedException ex) {
					aggiornaNome.setText("***Inserisci un tempo appropriato***");
				}
			}
			
		} catch (IOException ex) {
		} 

	}

}
