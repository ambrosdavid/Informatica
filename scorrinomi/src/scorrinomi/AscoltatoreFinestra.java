/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scorrinomi;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class AscoltatoreFinestra extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Chiusura");
        try {
            scriviSuFile(AscoltatorePulsante.lista);
        } catch (FileNotFoundException ex) {
        }
        System.exit(0);

    }

    private void scriviSuFile(ArrayList<String> lista) throws FileNotFoundException {
        PrintWriter outFile = new PrintWriter("output.txt");
        for (int i = 0; i < lista.size(); i++) {
            outFile.println(lista.get(i));
        }
        outFile.close();
    }

}
