
package alberobinariodiricerca;

/**
 *
 * @author david.ambros
 */
public class AlberoBinarioDiRicerca {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Integer a[]={1,1,6,4,3,5,3,2,5,3,2,5};
		AlberoDiRicerca b=new AlberoDiRicerca(a);
		System.out.println(b);
		b.visitaSimmetrica();
	}
	
}
