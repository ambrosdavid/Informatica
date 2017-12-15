/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereadergmail;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Contatto {

    private ArrayList<String> aL = new ArrayList<>();
    
    public Contatto() {

    }

    public void add(String a) {
        aL.add(a);

    }

    public String get(int indice) {
        return aL.get(indice);
    }

    @Override
    public String toString() {
        String daScrivere = "";
        for (int i = 0; i < aL.size(); i++) {
            if(aL.get(i).length()>0)
            daScrivere += " Info :"+aL.get(i);
        }
        return daScrivere;
    }

}
