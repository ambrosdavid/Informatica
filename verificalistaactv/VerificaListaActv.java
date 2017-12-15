/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificalistaactv;

import java.io.FileNotFoundException;

/**
 *
 * @author David
 */
public class VerificaListaActv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Mappa m=new Mappa();
        m.load("stops.txt");
        
        System.out.println(m.search(45.4, 12));
    }
    
}
