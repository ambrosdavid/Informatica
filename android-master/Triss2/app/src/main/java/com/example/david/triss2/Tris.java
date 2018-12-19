package com.example.david.triss2;

import java.util.Random;

/**
 * Created by David on 03/02/2018.
 */

public class Tris{



    private  boolean griglia[] =new boolean[9];
    private  int vittoria[] =new int[9];
    private int nMosse=0;

    public Tris() {
    }

    public void setGriglia(int indice,boolean stato) {
        griglia[indice]=stato;
    }

    public void setVittoria(int indice, int valore) {
        vittoria[indice]=valore;
    }

    public boolean[] getGriglia() {
        return griglia;
    }

    public int getIA(int ultimaScelta, int chiHaVinto){
        return haVinto(ultimaScelta, chiHaVinto);
    }
    /*
 *   0 | 1 | 2
 *  ---+---+---
 *   3 | 4 | 5
 *  ---+---+---
 *   6 | 7 | 8
 */
    private final int[][][] lineeVincitrici = {//tutte le possibili combinazioni
            {{1,2},{4,8},{3,6}},
            {{0,2},{4,7}},
            {{0,1},{4,6},{5,8}},
            {{4,5},{0,6}},
            {{3,5},{0,8},{2,6},{1,7}},
            {{3,4},{2,8}},
            {{7,8},{2,4},{0,3}},
            {{6,8},{1,4}},
            {{6,7},{0,4},{2,5}}
    };

    public int haVinto(int ultimoMovimento, int chiHaVinto) {
       int[] linee;
        for (int i = 0; i < lineeVincitrici[ultimoMovimento].length; i++) { //va nel punto che e stato cliccato
            linee = lineeVincitrici[ultimoMovimento][i];
            if(chiHaVinto == vittoria[linee[0]] && chiHaVinto == vittoria[linee[1]]) {//se viene aggiunta quest'ultima
                //posizione alla coppia di posizioni che gia ci sono e combaciano tutte 3 viene deciso il vincitore
                return chiHaVinto;

            }
        }

        //se non ha vinto nessuno, si prova a vedere se si tratta di un pareggio
        if(controlloPareggio()) {
            return -4;
        }
        if(chiHaVinto==-3){//Se l'ultima scelta e stata fatta da un pc, non server rifarne un altra;
            return -1;
        }

            Random r = new Random();//crea indici random finche non trova
            int random = r.nextInt(9);//un punto vuoto sulla griglia
            if (griglia[random]) {//se è gia stato preso...
                while (griglia[random]) {
                    random = r.nextInt(9);//...ne cerca altri
                }
            }

            griglia[random] = true; //la griglia generale viene riempita dal pc nel indice random
            vittoria[random] = -2; //pc riempe la griglia della vittoria(composta da O e X) in pos random
            return random;

    }

    private boolean controlloPareggio(){
      return ++nMosse==9;
    }//se non ci sono piu mosse disponibili returna true


}