/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberobinariodiricerca;

import java.util.Arrays;

/**
 *
 * @author david.ambros
 */
public class AlberoDiRicerca<T> {

    T informazione;
    AlberoDiRicerca sx;
    AlberoDiRicerca dx;

    public AlberoDiRicerca(T[] a) {

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        riempi(a, 0, a.length);
    }

    private AlberoDiRicerca(T[] a, int inf, int fin) {

        riempi(a, inf, fin);
    }

    public AlberoDiRicerca(T radice, AlberoDiRicerca sx, AlberoDiRicerca dx) {
        this.informazione = radice;
        this.sx = sx;
        this.dx = dx;

    }

    public T getRadice() {
        return this.informazione;
    }

    private void setRadice(T newRoot) {
        this.informazione = newRoot;

    }

    private AlberoDiRicerca getRight() {
        return this.dx;
    }

    public void setRight(T newRight) {
        this.dx.informazione = newRight;
    }

    public void setLeft(T newLeft) {
        this.sx.informazione = newLeft;
    }

    private AlberoDiRicerca getLeft() {
        return this.sx;
    }

    public boolean isFoglia() {
        return (dx == null && sx == null);
    }

    private void riempi(T[] a, int inf, int sup) {
        int mezzo = (inf + sup) / 2;
        informazione = a[mezzo];
        if (inf < mezzo) {
            sx = new AlberoDiRicerca(a, inf, mezzo);
        }
        if (mezzo + 1 < sup) {
            dx = new AlberoDiRicerca(a, mezzo + 1, sup);
        }
    }

    public void visitaSimmetrica() {
        visitaSim(this);
    }

    private void visitaSim(AlberoDiRicerca<T> b) {
        if (b.getLeft() != null) {
            visitaSim(b.getLeft());
        }
        System.out.println(b.getRadice());
        if (b.getRight() != null) {
            visitaSim(b.getRight());
        }
    }

    public void add(Comparable newInfo) {
        if(informazione==null){
            informazione=(T) newInfo;
        }
        this.add(this, newInfo);
        

    }

    private void add(AlberoDiRicerca padre, Comparable newInfo) {

        if (newInfo.compareTo(padre.informazione) > 0) {
            if (padre.getRight() == null) {
                padre.dx = new AlberoDiRicerca(newInfo, null, null);
            } else {
                add(padre.getRight(), newInfo);
            }
        }
        if (newInfo.compareTo(padre.informazione) < 0) {
            if (padre.getLeft() == null) {
                padre.sx = new AlberoDiRicerca(newInfo, null, null);
            } else {
            add(padre.getLeft(), newInfo);
            }
        }
        if (newInfo.compareTo(padre.informazione) == 0) {
            return;
        }

    }

}
