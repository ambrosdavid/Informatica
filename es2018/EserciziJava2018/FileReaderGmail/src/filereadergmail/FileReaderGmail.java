
package filereadergmail;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author David
 */
public class FileReaderGmail {


    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        
        Rubrica r=new Rubrica("input.txt");
        System.out.println(r);
        
        
    }
    
}
