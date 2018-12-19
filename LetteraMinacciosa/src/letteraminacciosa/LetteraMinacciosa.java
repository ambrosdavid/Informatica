/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letteraminacciosa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class LetteraMinacciosa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       File inFile= new File("input.txt");
       Scanner inScan=new Scanner(inFile);
       PrintWriter outFile=new PrintWriter("output.txt");
       String parolaDaScrivere=inScan.nextLine();
       inScan.nextLine();
       String giornale=inScan.nextLine();
      
       
      int c= conta(parolaDaScrivere, giornale);
       
       
    }

    private static int conta(String parola, String giornale) {
        int i0=0;
        int iF=1;
       parola.substring(i0 , iF);
        boolean lettera=false;
        for (int i = 0; i < giornale.length(); i++) {
            if(giornale.charAt(i)==parola.charAt(i0))
        }
        
    }
    
    
    
    
    
}
