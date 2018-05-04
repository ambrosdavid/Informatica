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

    private Semaphore posti = new Semaphore(10); //posti autobus in tot 
    private final int numeroFermate, totPersone, durataTragitto;
    private final int FRX = 10;//frequenza: ogni secondo c'è una fermata
    private Random r;

    public Buss(int totPersone, int durataTragitto) {
        r = new Random();
        this.totPersone = totPersone; //12
        this.durataTragitto = durataTragitto; //60
        numeroFermate = durataTragitto / FRX;
    }

    @Override
    public void run() {

        int fermataControllore = r.nextInt(numeroFermate + 1); //il controllore sale in una fermata casuale 

        int salgonoTot = totPersone / 2 + r.nextInt(totPersone / 2 + 1);//[6+random da 0 a 6];se esce 7 come numero
        int scendonoTot = totPersone - salgonoTot;//allora numero di persone che scendono sono 12-7=5

        System.out.println("persone che saliranno durante il tragitto = " + salgonoTot);
        System.out.println("persone che scenderanno durante il tragitto = " + scendonoTot);
        //quindi scendono+salgono=totPersone;
        int sceseFinOra = 0, saliteFinOra = 0;
        int cont = 1, sces = 1;
        
        for (int i = 0; i < numeroFermate ; i++) {//per ogni fermata
            int personeSalire = r.nextInt(salgonoTot - saliteFinOra + 1);//persone che devono salire in questa fermata
            int personeScendere = r.nextInt(scendonoTot - sceseFinOra + 1);//persone che devono scendere in questa fermata
            for (int j = 0; j < personeScendere && posti.availablePermits() < 10; j++, sceseFinOra++) {//scendono le persone
                posti.release();
                System.out.println("persona scese" + sces++);
            }
            for (int j = 0; j < personeSalire && posti.availablePermits() > 0; j++, saliteFinOra++) {//salgono
                new Thread(new Passeggero("persona" + cont++)).start();

            }
            // saliteFinOra += personeSalire;
            //sceseFinOra += personeScendere;
            try {
                Thread.sleep(FRX * 100);
            } catch (InterruptedException ex) {
                System.err.println("incidente");
            }
            if (i == fermataControllore) {
                new Controllore();

            }
        }
        
        while (posti.availablePermits() < 10) {//al capolinea butto furoi i rimasti
           posti.release();
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
                posti.acquire();
                System.out.println(nome + " è salita");
            } catch (InterruptedException ex) {

            }
        }

    }

    class Controllore {

        public Controllore() {
            System.out.println("I posti Liberi del bus sono" + posti.availablePermits());
        }

    }
}
