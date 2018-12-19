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
public class Sali implements Runnable {

    int pianoCorrente, desiderato;
    
    public Sali(int pianoCorrente, int desiderato) {
        this.pianoCorrente=pianoCorrente;
        this.desiderato=desiderato;
    }

    @Override
    public void run() {
        while(pianoCorrente!=desiderato){
            System.out.println("Piano Corrente "+pianoCorrente);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            pianoCorrente++;
        }
        System.out.println("Arrivato");
    }
    
}
