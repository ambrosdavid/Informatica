package alberobinario;

/**
 *
 * @author david.ambros
 */
public class AlberoBinario {

	public static void main(String[] args) {
		AlberoBin b;
		b = new AlberoBin(1, new AlberoBin(2, new AlberoBin(), new AlberoBin()), new AlberoBin(5, new AlberoBin(), new AlberoBin()));
		b.visitaAnticipata();
		b.visitaDifferita();
		

	}

}
