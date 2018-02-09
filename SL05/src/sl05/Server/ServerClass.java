/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sl05.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author david.ambros
 */
public class ServerClass implements Runnable{
	private String rcv;

	public ServerClass() {

	}

	DatagramSocket ds;

	@Override
	public void run() {
		try {
			 ds = new DatagramSocket(3002);
			byte[] buf = new byte[1024];
			while (true) {
				try {
					DatagramPacket dp = new DatagramPacket(buf, 1024);
					ds.receive(dp);
					String strRecv = new String(dp.getData(), 0, dp.getLength());
					rcv=strRecv;
					//System.out.println(rcv);
					invia(strRecv);
				} catch (IOException ex) {
				}
			}
		} catch (SocketException ex) {
		}
}
	public String getRcv() {
		return rcv;
	}

	private void invia(String pos) {
		try {
				
				InetAddress ia = InetAddress.getByName("localhost");
				DatagramPacket dp = new DatagramPacket(pos.getBytes(), pos.length(), ia, 3003);
				ds.send(dp);
		} catch (IOException ex) {
		}		
	}
}
