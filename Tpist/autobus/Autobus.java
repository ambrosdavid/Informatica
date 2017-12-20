/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobus;

import java.util.Random;
import java.util.concurrent.Semaphore;


/**
 *
 * @author David
 */
public class Autobus {

    public static void main(String[] args) {

        Buss b = new Buss(12, 60);
        Thread buss = new Thread(b);
        buss.start();

    }

}

class Buss implements Runnable {

    static Semaphore posti = new Semaphore(10);
    final int numeroFermate, totPersone, durataTragitto;
    final int FRX = 10;
    Random r;

    public Buss(int totPersone, int durataTragitto) {
        r = new Random();
        this.totPersone = totPersone;
        this.durataTragitto = durataTragitto;
        numeroFermate = durataTragitto / FRX;
    }

    @Override
    public void run() {
        
        int FermataControllore=r.nextInt(numeroFermate+1);
        
        int salgonoTot = totPersone / 2 + r.nextInt(totPersone / 2 + 1);//se esce 7 come numero

        int scendonoTot = totPersone - salgonoTot ;//allora numero di persone che salgono sono 12-7=5
        System.out.println("persone che saliranno durante il tragitto = " + salgonoTot);
        System.out.println("persone che scenderanno durante il tragitto = " + scendonoTot);
        //quindi scendono+salgono=totPersone;
        int sceseFinOra = 0, saliteFinOra = 0;
        int cont = 1, sces = 1;

        for (int i = 0; i < numeroFermate; i++) {
            int personeSalire = r.nextInt(salgonoTot - saliteFinOra + 1);//persone che devono salire in questa fermata
            int personeScendere = r.nextInt(scendonoTot - sceseFinOra + 1);
            for (int j = 0; j < personeScendere && Buss.posti.availablePermits() < 10; j++, sceseFinOra++) {
                Buss.posti.release();
                System.out.println("persona scese" + sces++);
            }
            for (int j = 0; j < personeSalire && Buss.posti.availablePermits() > 0; j++, saliteFinOra++) {
                new Thread(new Passeggero("persona" + cont++)).start();

            }
           // saliteFinOra += personeSalire;
            //sceseFinOra += personeScendere;
            System.out.println(personeScendere);
            try {
                Thread.sleep(FRX * 100);
            } catch (InterruptedException ex) {
                System.out.println("incidente");
            }
            if(i==FermataControllore){
                new Controllore();
                
            }
        }
        for (int i = 0; i < salgonoTot - saliteFinOra; i++) {
            new Thread(new Passeggero("persona" + cont++)).start();

        }
        for (int i = 0; i < scendonoTot - sceseFinOra; i++) {
            Buss.posti.release();
            System.out.println("persona scese" + sces++);
        }
        while(Buss.posti.availablePermits()<10){
            Buss.posti.release();
            System.out.println("Sbatto fuori le persone dal buss");
        }

    }

    class Passeggero implements Runnable {

        private String nome;

        public Passeggero(String nome) {
            this.nome = nome;
        }

        @Override
        public void run() {
            try {
                Buss.posti.acquire();
                System.out.println(nome + " è salita");
            } catch (InterruptedException ex) {

            }
        }

    }
    class Controllore {

        public Controllore() {
            System.out.println("I posti Liberi del bus sono" + Buss.posti.availablePermits());
        }
        
        
    }
}
