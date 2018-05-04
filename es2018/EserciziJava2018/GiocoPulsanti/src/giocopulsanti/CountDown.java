/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocopulsanti;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class CountDown implements Runnable {
    private int tempo;
    
    public CountDown(int tempo) {
        this.tempo=tempo;
    }

    @Override
    public void run() {
        try {System.out.println("Hai "+ tempo/1000 +" secondi a disposizione");
            Thread.sleep(tempo);
            
        } catch (InterruptedException ex) {
            
            System.out.println("Thread interrotto");
        }
        System.out.println("Tempo Finito");
    }
    
}
