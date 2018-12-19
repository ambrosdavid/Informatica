/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lift;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Ascensore implements Osservabile {
    private ArrayList<Osservatore> persone=new ArrayList<>();
    private boolean stateChange;
    private int numeroPiani;
    int pianoCorrente=0;
    
    public Ascensore(){
        stateChange=false;
        //this.numeroPiani=numeriPiani;
        System.out.println("Ascensore creato a piano "+numeroPiani);
    }

    @Override
    public void registerObserver(Osservatore observer) {
        persone.add(observer);
        
    }

    @Override
    public void notifyObserver() {
        if(stateChange){
            for (int i = 0; i < persone.size(); i++) {
                persone.get(i).update();
            }
        }
    }

    @Override
    public void unRegisterObserver(Osservatore observer) {
        persone.remove(observer);
    }

    @Override
    public Object getUpdate() {
       Object changedState = null;
		// should have logic to send the
		// state change to querying observer
		if (stateChange) {
			changedState = "Observer Design Pattern";
		}
		return changedState;

    }
    public void nextPiano(int desiderato){
        if(desiderato<=5 && desiderato>=-1){
            if(desiderato>pianoCorrente){
                
                Thread t=new Thread(new Sali(pianoCorrente, desiderato));
                t.start();
                
            }else if(desiderato<pianoCorrente){
                
                Thread t=new Thread(new Scendi(pianoCorrente, desiderato));
                t.start();
            }
            notifyObserver();
            stateChange=true;
            pianoCorrente=desiderato;
            
        }else{
            System.out.println("Piano inesistente");
        }
    }
    
}
