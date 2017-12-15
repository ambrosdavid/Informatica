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
public class Nodo<T> {
    private T info;
    private Nodo<T> next;

    public Nodo(T info, Nodo<T> next) {
        this.info = info;
        this.next = next;
    }

    public Nodo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }
    
}
