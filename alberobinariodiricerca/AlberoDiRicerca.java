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
	private T radice;
	private AlberoDiRicerca sx;
	private AlberoDiRicerca dx;
	private T a[];

	public AlberoDiRicerca(T[] a) {
		this.a = a;
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		riempi(a, 0, a.length);
	}

	private AlberoDiRicerca(T[] a, int inf, int fin) {
		this.a = a;
		riempi(a, inf, fin);
	}

	public AlberoDiRicerca(T radice, AlberoDiRicerca sx, AlberoDiRicerca dx, T[] a) {
		this.radice = radice;
		this.sx = sx;
		this.dx = dx;
		this.a = a;
	}

	public T getInfo() {
		return this.radice;
	}

	public AlberoDiRicerca getRight() {
		return this.dx;
	}

	public AlberoDiRicerca getLeft() {
		return this.sx;
	}

	public boolean isEmpty() {
		return (dx == null && sx == null);
	}

	private void riempi(T[] a, int inf, int sup) {
		int mezzo = (inf + sup) / 2;
		radice = a[mezzo];
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
		System.out.println(b.getInfo());
		if (b.getRight() != null) {
			visitaSim(b.getRight());
		}
	}

}
