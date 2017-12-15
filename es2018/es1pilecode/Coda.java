/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es1pilecode;

/**
 *
 * @author David
 */
public class Coda<T> {

    private Nodo testa;
    private int lunghezza;

    public Coda(Nodo testa) {
        this.testa = testa;
    }

    public Coda() {
    }

    public void enqueue(T x) {
        Nodo nuovo = new Nodo(x);
        Nodo viagg = testa;
        if (lunghezza == 0) {
            testa = nuovo;
        } else {
            for (int i = 0; i < lunghezza - 1; i++) {
                viagg = viagg.getNext();
            }
            viagg.setNext(nuovo);
        }
        lunghezza++;
    }

    public boolean isEmpty() {
        return lunghezza == 0;
    }

    public T front() {
      
        return (T) testa.getInfo();
        
    
    }

    public void dequeue() {
       
            testa = testa.getNext();
            lunghezza--;
        
    }
}
