/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlista;

import java.util.Iterator;

/**
 *
 * @author david.ambros
 */
public class IteratorProva {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int numeroElem=10;
		String []a= randomArray(numeroElem);
		Lista <String> s=new Lista(a);
		Iterator <String> it=s.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

	private static String[] randomArray(int numeroElem) {
		String [] ris=new String[numeroElem];
		for (int i = 0; i < numeroElem; i++) {
			ris[i]=" "
		}
		return ris;
	}
	
}
