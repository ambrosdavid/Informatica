package alberobinario;

import java.util.Iterator;

/**
 *
 * @author David
 */
public class Lista<T> implements Iterable {

	private Nodo testa;
	private Nodo coda;
	private int lunghezza;

	public Lista() {
		this.testa = null;
		this.coda = null;
	}

	public Lista(T[] a) {
		for (int i = 0; i < a.length; i++) {
			this.addTail(a[i]);
		}
	}

	public void addTail(T oggetto) {
		Nodo daAggiungere = new Nodo(oggetto);
		if (lunghezza == 0) {
			testa = coda = daAggiungere;
		} else {
			coda.setNext(daAggiungere);
			coda = coda.getNext();
		}
		lunghezza++;
	}

	public void addHead(T info) {
		Nodo daAggiungere = new Nodo(info);
		if (lunghezza == 0) {
			testa = coda = daAggiungere;
		} else {
			daAggiungere.setNext(testa);
			testa = daAggiungere;
		}
		lunghezza++;

	}

	public void remove(int i) {
		Nodo viaggiante = testa; 
		for (int j = 0; j < i - 1; j++) {
			viaggiante = viaggiante.getNext();
		}
		viaggiante.setNext(viaggiante.getNext().getNext());
		lunghezza--;
	}

	public T rimuoviCoda() {
		T valore = (T) coda.getInfo();
		Nodo viaggiante = testa;
		for (int i = 0; i < lunghezza - 2; i++) {
			viaggiante = viaggiante.getNext();
		}
		coda = viaggiante;
		lunghezza--;
		return (T) valore;
	}

	public T rimuoviTesta() {
		T valore = (T) testa.getInfo();
		testa = testa.getNext();
		return valore;
	}

	public int getSize() {
		return this.lunghezza;
	}

	@Override
	public String toString() {
		String ris = " ";
		Nodo viaggiante = testa;
		for (int i = 0; i < lunghezza; i++) {
			ris = ris + viaggiante.getInfo().toString() + ";";
			viaggiante = viaggiante.getNext();
		}
		return ris;
	}

	public T get(int n) {
		Nodo viaggiaVeryFast = testa;

		for (int i = 0; i < n - 1; i++) {
			viaggiaVeryFast = viaggiaVeryFast.getNext();
		}
		System.out.println(viaggiaVeryFast.getInfo());

		return (T) viaggiaVeryFast.getInfo();

	}

	public void set(int n, T ciao) {
		Nodo viaggiaVeryFast = testa;

		for (int i = 0; i < n - 1; i++) {
			viaggiaVeryFast = viaggiaVeryFast.getNext();
		}
		viaggiaVeryFast.setInfo(ciao);
	}

	public void add(int n, T x) {
		if (n == 0) {
			addHead(x);

			return;

		}
		Nodo viaggiaVeryFast = testa;

		for (int i = 0; i < n - 1; i++) {
			viaggiaVeryFast = viaggiaVeryFast.getNext();
		}
		Nodo temp = viaggiaVeryFast.getNext();
		Nodo infiltra = new Nodo(x);
		viaggiaVeryFast.setNext(infiltra);
		infiltra.setNext(temp);
		lunghezza++;

	}

	@Override
	public Iterator iterator() {
		return new Iterator() {

			int size = lunghezza;
			Nodo testa1 = testa;

			@Override
			public boolean hasNext() {
				return size > 0;
			}

			@Override
			public T next() {
				T temp = (T) testa1.getInfo();
				testa1 = testa1.getNext();
				size--;
				return temp;
			}

		};

	}

}
