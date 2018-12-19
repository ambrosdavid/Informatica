/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lift;

/**
 *
 * @author David
 */
public class Lift {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ascensore a1 = new Ascensore();
        Persona p1 = new Persona(2);
        a1.registerObserver(p1);
        p1.setObservable(a1);
        
        
        System.out.println(p1.getPianoCorrente());
        a1.nextPiano(p1.getPianoCorrente());

    }

}
