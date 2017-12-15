package alberobinario;

import java.util.Iterator;

/**
 * @author david.ambros
 * @param <T>
 */
public class AlberoBin<T> implements Iterable {

	private T info;
	private AlberoBin sx;
	private AlberoBin dx;
	Lista<T> l = new Lista<>();

	public AlberoBin(T info, AlberoBin sx, AlberoBin dx) {
		this.info = info;
		this.sx = sx;
		this.dx = dx;
	}

	public AlberoBin() {

	}

	public T getInfo() {
		return this.info;
	}

	public AlberoBin getRight() {
		return this.dx;
	}

	public AlberoBin getLeft() {
		return this.sx;
	}

	public boolean isEmpty() {
		return (dx == null && sx == null);
	}

	public void visitaAnticipata() {
		visAnt(this);
	}

	private void visAnt(AlberoBin<T> b) {
		if (!b.isEmpty()) {
			System.out.println(b.getInfo());
			l.addTail(b.getInfo());
			visAnt(b.getLeft());
			visAnt(b.getRight());

		}
	}

	public void visitaDifferita() {
		visDif(this);
	}

	private void visDif(AlberoBin<T> b) {
		if (!b.isEmpty()) {
			visDif(b.getLeft());
			visDif(b.getRight());
			System.out.println(b.getInfo());
		}
	}

	@Override
	public Iterator iterator() {
		return new Iterator() {

			@Override
			public boolean hasNext() {
				return false;

			}

			@Override
			public Object next() {
				return null;

			}

		};
	}

}
