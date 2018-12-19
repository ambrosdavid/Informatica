/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalabirinto;

import java.util.Random;

/**
 *
 * @author David
 */
public class Generatore {

    private int grandezza;
    private int[][] matrice;
    private Random r=new Random();
    public Generatore(int grandezza) {
        this.grandezza = grandezza;
        matrice = new int[this.grandezza][this.grandezza];

    }

    public void printa() {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
    }
    private int x = 0;
    private int y = 0;

    public void genera() {
        
        for (int i = 0; i < matrice.length * 10; i++) {
           int caso=r.nextInt(4);
           if(caso==0){
               su();
           }
           if(caso==1){
               giu();
           }
           if(caso==2){
               destra();
           }
           if(caso==3){
               sinistra();
           }
           
           try{
               matrice[x][y]=1;
           }catch(Exception ex){
               
           }
        }

    }

    private void sinistra() {
        
        x--;
    }

    private void destra() {
        x++;
    }

    private void giu() {
        y--;
    }

    private void su() {
        y++;
    }
}
