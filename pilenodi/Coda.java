/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilenodi;

/**
 *
 * @author David
 */
public class Coda<T> {

    private ListaLinkata<T> listaNodi;

    public Coda() {
        listaNodi = new ListaLinkata<>();
    }

    public void enqueue(T valore) {
        listaNodi.add(valore);
    }

    public T deQueue() {
        return (T) listaNodi.remove().getInfo();
    }

    public T front() {
        return (T) this.listaNodi.getTesta().getInfo();
    }

    public int getLunghezza() {
        return this.listaNodi.getLunghezza();
    }

    public void inverti() {
        Pila p = new Pila();
        for (int i = 0; i < this.getLunghezza();) {
            System.out.println(this.front());
            p.push(this.deQueue());
        }
        for (int i = 0; i < p.getLunghezza();) {
            this.enqueue((T) p.pop());
        }
    }

}

class ListaLinkata<T> {

    private Nodo testa, coda;
    private int lunghezza;

    public ListaLinkata() {
    }

    public void add(T valore) {

        Nodo nodoDaAggiungere = new Nodo(valore);

        if (lunghezza == 0) {
            coda = testa = nodoDaAggiungere; // viene creato un triplo reference
        } else {
            // alla coda che e lultimo , viene assegnato al precedente il nodo che vogliamo mettere in coda
            coda.setNext(nodoDaAggiungere);
            // una volta che labbiamo messo dietro all ultimo (coda)
            coda = nodoDaAggiungere;
        }
        lunghezza++;
    }

    public Nodo remove() {
        Nodo primo;
        if (lunghezza == 0) {
            System.out.println("Errore");
            return null;
        } else {
            primo = testa;
            testa = testa.getNext();
        }
        lunghezza--;
        return primo;
    }

    public Nodo getTesta() {
        return testa;
    }

    public Nodo getCoda() {
        return coda;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    class Nodo<T> {

        protected T info;
        protected Nodo<T> next;

        public Nodo(T info) {
            this.info = info;
        }

        public Nodo(T info, Nodo<T> next) {
            this.info = info;
            this.next = next;
        }

        public T getInfo() {
            return info;
        }

        public Nodo<T> getNext() {
            return next;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        public void setNext(Nodo<T> next) {
            this.next = next;
        }

    }
}
