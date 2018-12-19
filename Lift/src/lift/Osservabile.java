/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lift;

/**
 *
 * @author David
 */
public interface Osservabile {
    
    public void registerObserver(Osservatore observer);
    
    public void notifyObserver();
    
    public void unRegisterObserver(Osservatore observer);
    
    public Object getUpdate();
}

