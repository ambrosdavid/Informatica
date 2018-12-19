/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copy;

import java.io.*;

public class Copy {
    
    public static void main(String[] args){
        
        String s, file;
        BufferedReader standard = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream out = null;
        
        // checks arguments number
        if (args.length >= 1) file = args[0];
        else file = "parappa.txt";
        // open the file name
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e){
            System.exit(1);
        }
        // users have to leave by using Control-C
        while(true){
            try {
                // read and write
                s = standard.readLine();
                out.write(s.getBytes());
                out.write("\n".getBytes());
                if(s.compareTo("fine") == 0){
                    System.out.println("FINE");
                    System.exit(0);
                }
            } catch (IOException e){
                System.out.println("I/O error");
                System.exit(1);
            } 
            /*   autocloseable
            finally {  
                out.close();
                standard.close();
            }
            */
        }
    }
}
