package pilagrafica;

import pilagrafica.FramePila;

/**
 *
 * @author david.ambros
 */
public class PilaGrafica {

	
	public static void main(String[] args) {
            
		Pila<String> p=new Pila();
                java.awt.EventQueue.invokeLater(() -> {
                    new FramePila("Interfaccia Grafica Pila", p).setVisible(true);
                });
		
		
	}
	
}
