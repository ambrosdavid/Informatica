/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainrpn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author David
 */
public class RPN {

    private ArrayList<Item> lista;
    private String s;
    private String a;

    public RPN(String s) {
        this.s = s;
        a = convertiInStringRpm(s);
    }

    private String convertiInStringRpm(String s) {
        String ris = " ";
        Pila p = new Pila();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                ris = ris + s.charAt(i);
            } else if (s.charAt(i) == '+' || s.charAt(i) == '*' || s.charAt(i) == '-' || s.charAt(i) == '/') {
                ris += " ";
                System.out.println(s.charAt(i));
                p.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                ris = ris + " " + p.pop() + " ";
            }
        }

        for (int j = 0; j < p.lunghezza;) {
            ris = ris + p.pop();
        }

        ris = ris.replaceAll("  ", " ");
        String[] array = ris.split(" ");
        
        lista = new ArrayList<>();

        for (int i = 1; i < array.length; i++) {
            if (array[i].equals("+") || array[i].equals("*") || array[i].equals("-") || array[i].equals("/")) {
                lista.add(new Item(array[i].charAt(0)));
            } else {
                lista.add(new Item(Integer.parseInt(array[i])));
            }
        }

        return ris;

    }

    int calcola() {
        Pila<Integer> p = new Pila();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).isOperatore()) {
                int n1 = p.pop();
                int n2 = p.pop();
                if (lista.get(i).getOperazione() == '+') {
                    p.push(n2 + n1);
                }
                if (lista.get(i).getOperazione() == '-') {
                    p.push(n2 - n1);
                }
                if (lista.get(i).getOperazione() == '*') {
                    p.push(n2 * n1);
                }
                if (lista.get(i).getOperazione() == '/') {
                    p.push(n2 / n1);
                }
            }else{
                p.push(lista.get(i).getNumero());
            }
        }
        return p.top();

    }

}
