/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberobinnodo;

/**
 *
 * @author david.ambros
 */
public class AlberoBinNodo {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Integer c = 1;
		Integer c2 = 2;
		Integer c3 = 3;
		AlberoBinarioRicerca a = new AlberoBinarioRicerca();
		a.add(c2);
		a.add(c3);
		a.add(1);
		a.add(5);
		a.add(9);
		a.add(20);

		a.visitaSimmetrica();
	}

}
