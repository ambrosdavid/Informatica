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
public class Persona implements Osservatore {

    private int pianoCorrente;

  

    
    private Osservabile ascensore; // the observable object

    @Override
    public void setObservable(Osservabile ascensore) {
        this.ascensore=ascensore;
    }

    public Persona(int pianoCorrente) {
        this.pianoCorrente = pianoCorrente;
    }

    @Override
    public void update() {
        System.out.println("Ascensore Arrivato");
    }
    public int getPianoCorrente() {
        return pianoCorrente;
    }
    

}
