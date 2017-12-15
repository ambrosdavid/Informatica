/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author david.ambros
 */
public class FileReader {

	
	public static void main(String[] args) throws FileNotFoundException {
		File inFile=new File("input.txt");
		Scanner inScan=new Scanner(inFile);
		PrintWriter outFile=new PrintWriter("output1.txt");
		Rubrica r=new Rubrica(inScan);
		
		Iterator it=r.l.iterator();
		while(it.hasNext()){
			outFile.println(it.next().toString());
		}
		outFile.close();
		
	}
	
}
