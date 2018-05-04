/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereadergmail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Rubrica {
    private File input;
    public ArrayList<Contatto> contatti= new ArrayList<>();
    PrintWriter outFile=new PrintWriter("output.txt");

    public Rubrica(String nomeFile) throws FileNotFoundException {
        input=new File(nomeFile);
        Scanner inScan=new Scanner(input);
        inScan.useDelimiter(",");
        while(inScan.hasNextLine()){
            Contatto c=new Contatto();
            while(inScan.hasNext()){
                c.add(inScan.next());
            }
            contatti.add(c);
            inScan.nextLine();
            
        }
        
        
        
    }

    @Override
    public String toString() {
        String daScrivere = "";
        for (int i = 0; i < contatti.size(); i++) {
            daScrivere+= contatti.get(i).toString()+"\n";
            outFile.println(contatti.get(i).toString());
        }
        outFile.close();
        return daScrivere;
    }
    
    
    
    
    
    
    
    
    
}
