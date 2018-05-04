/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainrpn;

/**
 *
 * @author David
 */
public class Pila<T> {
    private Nodo testa;
    public int lunghezza;

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

}
