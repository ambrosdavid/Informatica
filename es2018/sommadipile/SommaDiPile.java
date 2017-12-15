/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommadipile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class SommaDiPile {

    public static void main(String[] args) throws FileNotFoundException {
        Pila<Integer> pA = new Pila();
        Pila<Integer> pB = new Pila();
        int[] iA = {1, 2, 2};
        int[] iB = {2, 0, 0, 0};
        riempiPila(pA, iA);
        riempiPila(pB, iB);

        Pila ris = sommaDiPile(pA, pB);

        while (!ris.isEmpty()) {
            System.out.print(ris.pop());
        }

    }

    private static void riempiPila(Pila pila, int[] array) {
        for (int i = 0; i < array.length; i++) {
            pila.push(array[i]);
        }

    }

    private static Pila sommaDiPile(Pila pilaA, Pila pilaB) {
        Pila c = new Pila();
        int riporto = 0;
        int risultato = 0;

        while (!pilaA.isEmpty() || !pilaB.isEmpty()) {
            if (pilaA.isEmpty()) {
                risultato = riporto + (0 + (int) pilaB.pop());
                c.push(risultato);
                System.out.println("entrato");
            } else if (pilaB.isEmpty()) {
                risultato = riporto + ((int) pilaA.pop() + 0);
                c.push(risultato);
            } else {
                risultato = riporto + ((int) pilaA.pop() + (int) pilaB.pop());

                if (risultato > 9) {
                    c.push(risultato - 10);
                    riporto++;
                } else {
                    c.push(risultato);
                    riporto = 0;
                }
            }

        }
        return c;
    }

}
