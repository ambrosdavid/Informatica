/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatoreoptionscambiovaluta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author David
 */
public class GeneratoreoptionsCambioValuta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
            FileWriter writer = new FileWriter("MyFile.txt", true);

       

        try {
            FileReader reader = new FileReader("ciao.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                writer.write("<option>"+line+"</option>");
                writer.write("\n");
                
            }
            reader.close();
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
