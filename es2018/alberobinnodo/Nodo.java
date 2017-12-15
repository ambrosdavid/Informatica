/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberobinnodo;

/**
 *
 * @author David
 */
public class Nodo<T> {
    private T info;
    private Nodo<T> sx;
	private Nodo<T> dx;

    public Nodo(T radice, Nodo<T> sx, Nodo<T> dx) {
        this.info=radice;
		this.sx=sx;
		this.dx=dx;
        
    }
	 public Nodo(T radice) {
		 this(radice, null, null);
		
        
    }

	public Comparable getInfo() {
		return (Comparable) info;
	}
	

	public void setRadice(T radice) {
		this.info = radice;
	}

	public Nodo<T> getSx() {
		return sx;
	}

	public void setSx(Nodo<T> sx) {
		this.sx = sx;
	}

	public Nodo<T> getDx() {
		return dx;
	}

	public void setDx(Nodo<T> dx) {
		this.dx = dx;
	}

	boolean isFoglia() {
	 return dx==null&&sx==null;
	}
	

}