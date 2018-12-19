/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author David
 */
public class Stream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       InputStream inputStream = new FileInputStream("input.txt");
       PrintStream printStream= new PrintStream(new FileOutputStream("output.txt")) ;
       
       FileInputStream input= new FileInputStream("input.txt");
       FileOutputStream out=new FileOutputStream("output.txt");
       
       FileReader inputReader = new FileReader("input.txt"); ///Stream a caratteri 
       FileWriter outputWriter =new FileWriter("output.txt", true);
       
        
       int c;
       while((c=inputReader.read()) != -1){
           outputWriter.write(c);
           
    }
       outputWriter.flush();
       outputWriter.close();
       
    }
    
}
