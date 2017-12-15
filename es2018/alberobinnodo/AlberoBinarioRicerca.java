/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberobinnodo;

/**
 *
 * @author david.ambros
 */
public class AlberoBinarioRicerca<T> {
	private Nodo<Comparable> root; //nodo radice

	AlberoBinarioRicerca(T info) {
		root = new Nodo(info);
	}

	AlberoBinarioRicerca() {
		root=null;
	}
	
	public void add(Comparable info) {
		Nodo temp = new Nodo(info);
		
		boolean sinistra=false;
		if(root==null){
			root=temp;
			return;
		}
		Nodo viaggiante = root;
		while (sinistra ? viaggiante.getSx()!=null : viaggiante.getDx()!=null ) {
			System.out.println("ciao");
			if (viaggiante.getInfo().compareTo(info) < 0) {
				viaggiante = viaggiante.getDx();
				sinistra=false;
			}
			if (viaggiante.getInfo().compareTo(info) > 0) {
				viaggiante = viaggiante.getSx();
				sinistra=true;
			}
		}
		if(sinistra){
			viaggiante.setSx(temp);
			
		}else{
			viaggiante.setDx(temp);
		}

		

	}

	public void visitaSimmetrica() {
		//System.out.println(root.getInfo());
		viSim(root);
	}

	private void viSim(Nodo<Comparable> b) {
		if (b.getSx() != null) {
			viSim(b.getSx());
		}
		System.out.println(b.getInfo());
		if (b.getDx() != null) {
			viSim(b.getDx());
		}
		

	}
}
