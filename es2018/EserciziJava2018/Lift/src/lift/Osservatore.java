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
public interface Osservatore {

    public void update();

    public void setObservable(Osservabile observable);
}
