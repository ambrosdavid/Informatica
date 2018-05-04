/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scorrinomi;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class ScorriNomi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("input.txt");
        Scanner input = new Scanner(inFile);
        ArrayList<String> lista = new ArrayList<>();
        riempi(lista, input);

        Frame frame = new Frame("Scorri Nomi");
        frame.setSize(640, 320);
        Button[] pulsanti = {new Button("<<"), new Button("<"), new Button("ADD"), new Button(">>"), new Button(">"), new Button("DEL")};

        AscoltatoreFinestra finestra = new AscoltatoreFinestra();
        frame.addWindowListener(finestra);

        Label indice, current;
        TextField add;
        AscoltatorePulsante a = new AscoltatorePulsante(pulsanti, lista);
        for (int i = 0; i < 6; i++) {
            pulsanti[i].addMouseListener(a);
        }

        indice = new Label("Lunghezza= " + lista.size());
        current = new Label(" " + lista.get(a.getIndice()));
        add = new TextField("Aggiungi Testo");
        a.index=indice;
        a.current=current;
        a.add=add;

        frame.add(pulsanti[0]);
        frame.add(indice);
        frame.add(pulsanti[3]);
        frame.add(pulsanti[1]);
        frame.add(current);
        frame.add(pulsanti[4]);
        frame.add(pulsanti[2]);
        frame.add(add);
        frame.add(pulsanti[5]);
        
        frame.setLayout(new GridLayout(3, 3));
        frame.setVisible(true);
        
    }

    private static void riempi(ArrayList<String> lista, Scanner input) {
        input.useDelimiter(", ");
        while (input.hasNextLine()) {
            lista.add(input.next());
        }

        System.out.println(lista);
    }

}
