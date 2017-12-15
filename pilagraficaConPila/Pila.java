/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilagrafica;

import java.util.Iterator;

public class Pila<T> {

    private Nodo testa;
    private int lunghezza;

    public Pila(Nodo testa) {
        this.testa = testa;
    }

    Pila() {
        this(null);
    }

    public void push(T valore) {
        Nodo daAggiungere = new Nodo(valore);
        if (lunghezza == 0) {
            testa = daAggiungere;
        } else {
            daAggiungere.setNext(testa);
            testa = daAggiungere;
        }
        lunghezza++;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public String isEmpty() {
        String ris = "";
        if (lunghezza > 0) {
            ris = "false";
        } else {
            ris = "true";
        }
        return ris;
    }

    public T pop() {
        Nodo testaAttuale = null;
        if (lunghezza == 0) {
            return null;
        } else {
            testaAttuale = this.testa;
            this.testa = this.testa.getNext();
        }
        lunghezza--;
        return (T) testaAttuale.getInfo();
    }

    public T top() {
        if (lunghezza == 0) {
            return null;
        } else {
            return (T) this.testa.getInfo();

        }

    }

    class Iteratore implements Attraversabile {

        Nodo viaggiante = testa;
        int lung = lunghezza;

        @Override
        public boolean hasNext() {
            return lung > 0;
        }

        @Override
        public Object next() {
            T temp = (T) viaggiante.getInfo();
            viaggiante = viaggiante.getNext();
            lung--;
            return temp;
        }

        @Override
        public void goHead() {
            viaggiante = testa;

        }

        @Override
        public Object current() {
            return viaggiante.getInfo();
        }

        @Override
        public void goOneDown() {
            viaggiante = viaggiante.getNext();
            lung--;
        }

    }

    public Iteratore iterator() {
        return new Iteratore() {
            Nodo viaggiante = testa;
            int lung = lunghezza;

            @Override
            public boolean hasNext() {
                return lung > 0;
            }

            @Override
            public Object next() {
                T temp = (T) viaggiante.getInfo();
                viaggiante = viaggiante.getNext();
                lung--;
                return temp;
            }

            @Override
            public void goHead() {
                viaggiante = testa;
            }

            @Override
            public Object current() {
                return viaggiante.getInfo();
            }

            @Override
            public void goOneDown() {
                if(viaggiante.getNext()!=null){
                viaggiante = viaggiante.getNext();
                lung--;
                }else{
                    System.out.println("non ci sono elementi");
                }
            }

        };

    }

}

class Nodo<T> {

    private T info;
    private Nodo<T> next;

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
