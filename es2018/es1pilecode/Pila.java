/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es1pilecode;

import java.util.Iterator;

/**
 *
 * @author David
 */
public class Pila<T> implements Iterable {
    private Nodo testa;
    private int lunghezza;

    public Pila(Nodo testa) {
        this.testa = testa;
    }
     public Pila() {
        this.testa = null;
    }

    public void push(T info){
        Nodo nuovo=new Nodo(info);
        if(lunghezza==0){
            testa=nuovo;
        }else{
            nuovo.setNext(testa);
            testa=nuovo;
        }
        lunghezza++;
}
    public T top(){
        return (T) testa.getInfo();
        
    }
    public T pop(){
        T valore = null;
        if(lunghezza==0){
            System.out.println("Pila vuota");
        }else{
           valore = (T) testa.getInfo();
            testa=testa.getNext();
            lunghezza--;
        }
        return valore;
    }
    public boolean isEmpty(){
        return lunghezza==0;
    }

    @Override
    public Iterator iterator() {
        return new Iterator(){
            int l1=lunghezza;
            Nodo n=testa;
            @Override
            public boolean hasNext() {
                return l1>0;
            }

            @Override
            public T next() {
                T temp = (T) n.getInfo();
                n = n.getNext();
                l1--;
                return temp;
            }
        };
       
    }
    
    
    

}
