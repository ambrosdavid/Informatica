/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scorrinomi;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class AscoltatorePulsante implements MouseListener {

    private Button[] pulsanti;
    static ArrayList<String> lista;
    private int indice = 0;
    Label index, current;
    TextField add;
    Color base;

    public AscoltatorePulsante() {

    }

    AscoltatorePulsante(Button[] pulsanti, ArrayList<String> lista) {
        this.pulsanti = pulsanti;
        this.lista = lista;
        base = pulsanti[0].getForeground();
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
		aggiorna();
        if (e.getSource() == pulsanti[0]) {

            portaInizio();
        }
        if (e.getSource() == pulsanti[1]) {

            indietroUno();
        }
        if (e.getSource() == pulsanti[2]) {

            add(add.getText());
        }
        if (e.getSource() == pulsanti[3]) {

            portaFine();
        }
        if (e.getSource() == pulsanti[4]) {

            avantiUno();
            // indice++;

        }
        if (e.getSource() == pulsanti[5]) {

            delete(indice);
        }
		if (e.getSource() == pulsanti[6]) {

            inserisciAllaFine(add.getText());
        }
        aggiorna();

    }

    public int getIndice() {
        return indice;
    }

    void portaInizio() {
        indice = 0;

    }

    void portaFine() {
        indice = lista.size() - 1;
    }

    void avantiUno() {

        if (indice < lista.size() - 1) {
            indice++;
        } else {
            rosso(Color.RED);
        }

    }

    void indietroUno() {
        if (indice > 0) {
            indice--;
        } else {
            rosso(Color.RED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
		
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
		((Button)e.getSource()).setBackground(Color.green);
			
		
    }

    @Override
    public void mouseExited(MouseEvent e) {
		((Button)e.getSource()).setBackground(base);
		aggiorna();
    }

    private void aggiorna() {
        current.setText(lista.get(indice));
        index.setText(lista.get(indice).length() + " ");

        pulsanti[0].setBackground(null);
        pulsanti[1].setBackground(base);
        pulsanti[3].setBackground(base);
        pulsanti[4].setBackground(base);
        if (indice == 0) {
            pulsanti[0].setBackground(Color.red);
            pulsanti[1].setBackground(Color.red);
        }
        if (indice == lista.size() - 1) {
            pulsanti[3].setBackground(Color.red);
            pulsanti[4].setBackground(Color.red);
        }
    }

    private void add(String toAdd) {
        lista.add(indice, toAdd);
		
    }

    private void delete(int indice) {
        lista.remove(indice);
    }

    private void rosso(Color RED) {

    }

	private void inserisciAllaFine(String toAdd) {
		lista.add(toAdd);
	}

}
