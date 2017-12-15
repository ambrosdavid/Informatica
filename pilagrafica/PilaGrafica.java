package pilagrafica;

import java.util.Stack;
import pilagrafica.FramePila;

/**
 *
 * @author david.ambros
 */
public class PilaGrafica {

	
	public static void main(String[] args) {
		Stack<String> p=new Stack();
		FramePila f=new FramePila("Interfaccia Grafica Pila", p);
		f.setVisible(true);
	}
	
}
