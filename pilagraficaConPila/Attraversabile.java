/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilagrafica;

/**
 *
 * @author David
 */
interface Attraversabile {
    public Object next();
    public boolean hasNext();
    public void goHead();
    public void goOneDown();
    public Object current();
}
