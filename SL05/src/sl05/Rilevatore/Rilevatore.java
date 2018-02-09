/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sl05.Rilevatore;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author david.ambros
 */
public class Rilevatore implements Runnable {
	Macchina macchina;
	Random r = new Random();
	DatagramSocket ds;

	public Rilevatore(Macchina macchina) throws SocketException, UnknownHostException, IOException {
		this.macchina = macchina;

	}

	//45,05°N e 45,65°N 
	//double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
	private double latRandom() {

		double ris = 45.05 + (r.nextDouble() * (45.65 - 45.05));
		return ris;

	}

	//11,88°E e 12,38
	private double lonRandom() {
		return 11.88 + (0.50 * r.nextDouble());

	}

	@Override
	public void run() {
		while (true) {
			try {
				ds = new DatagramSocket();
				String pos = "La " + macchina.getNome() + " si trova " + latRandom() + " lat, " + lonRandom() + " lon";
				InetAddress ia = InetAddress.getByName("localhost");
				DatagramPacket dp = new DatagramPacket(pos.getBytes(), pos.length(), ia, 3002);
				ds.send(dp);
				Thread.sleep(200);
			} catch (Exception ex) {

			}
		}
	}

}
