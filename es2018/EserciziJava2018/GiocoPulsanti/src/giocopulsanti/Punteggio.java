/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocopulsanti;

import java.awt.Frame;
import java.awt.Label;

/**
 *
 * @author David
 */
public class Punteggio implements Runnable {
    private int cont;
    Frame f;
    public Punteggio(int contatore) {
        this.cont=cont; 
        f=new Frame("punteggio");
        Label l=new Label("Punteggio= "+cont);
        f.add(l);
        f.setSize(600,500);
    }

    @Override
    public void run() {
       
        f.setVisible(true);
       
        
    }
    
}
