package filereader;

import filereader.Contatto;
import filereader.Lista;
import java.io.File;
import java.util.Scanner;

class Rubrica {

	Lista<Contatto> l = new Lista();
	File inFile = new File("input.txt");

	public Rubrica(Scanner s) {
		Contatto c = new Contatto();
		while (s.hasNextLine()) {
			s.skip(",");
			if (s.next().matches("@")) {
				c.setEmail(s.next());
				
			}

			while (!s.next().equals("+")) {
				if (s.next().matches("@")) {
					c.setEmail(s.next());
					
				}

				c.setNome(s.next());
				c.setCognome(s.next());
			}
			c.setNumero(s.next());
			
		}
		l.addTail(c);
	}

}
