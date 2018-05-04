package giocopulsanti;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.Thread.State;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
class SchiacciaTalpa extends Frame implements ActionListener {

    private Button griglia[][];
    private int righe, colonne;
    Random r = new Random();
    private int riga /*= r.nextInt(5)*/;
    private int colonna /*= r.nextInt(5)*/;
    private int contatore;

    Thread t = new Thread(new CountDown(3000));

    SchiacciaTalpa(String nome, int righe, int colonne) {
        super(nome);
        this.righe = righe;
        this.colonne = colonne;

        this.griglia = new Button[righe][colonne];

        System.out.println(riga);
        System.out.println(colonna);

        setLayout(new GridLayout(righe, colonne));
        setSize(640, 640);
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                Button b = new Button("" + i + j);
                b.setBackground(Color.white);
                add(b);
                b.addActionListener(this);
                griglia[i][j] = b;
            }
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        }
        );

        t.start();
        aggiorna();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (t.getState() != State.TERMINATED) {
            if (e.getSource() == griglia[riga][colonna]) {
                aggiorna();
                contatore++;
                

            } else {
                contatore--;
                
            }
        }
        if (t.getState() == State.TERMINATED) {
            Thread punteggio=new Thread(new Punteggio(contatore));
            punteggio.start();
        }
    
    }

    private void aggiorna() {
        griglia[riga][colonna].setBackground(Color.white);

        riga = r.nextInt(righe);
        colonna = r.nextInt(colonne);
        griglia[riga][colonna].setBackground(Color.red);

        //System.out.println("riga"+riga+ "colonna"+colonna);
    }

}
