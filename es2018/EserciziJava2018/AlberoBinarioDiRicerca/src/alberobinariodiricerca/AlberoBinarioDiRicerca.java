
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
		Integer a[]={2,5,6,7,8};
		AlberoDiRicerca b=new AlberoDiRicerca(a);
		//System.out.println(b);
		//b.visitaSimmetrica();
                b.add(10);
                b.add(9);
                b.add(3);
                b.visitaSimmetrica();
                StampaAlbero.stampaNodo(b);
               
	}
	
}
