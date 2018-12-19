/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainrpn;

/**
 *
 * @author David
 */
public class Item {
    
    private int numero;
    private char operazione;
    private boolean isOperazione = false;
    
    public Item(int numero) {
        this.numero = numero;
    }

    public Item(char operazione) {
        this.operazione = operazione;
        isOperazione = true;
    }

    public int getNumero() {
        return numero;
    }

    public char getOperazione() {
        return operazione;
    }
    
    public boolean isOperatore(){
        return isOperazione;
    }
}
