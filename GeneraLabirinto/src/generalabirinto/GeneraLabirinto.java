/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalabirinto;

/**
 *
 * @author David
 */
public class GeneraLabirinto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Generatore labirinto=new Generatore(5);
        labirinto.genera();
        labirinto.printa();
    }
    
}
