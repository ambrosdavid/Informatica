package sommathread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import sommathread.SommeRandom.Risorsa;

/**
 *
 * @author David
 */
public class SommaThread {

    public static void main(String[] args) throws InterruptedException {
        SommeRandom  s = new SommeRandom(5);
    }

}

class SommeRandom {

    Risorsa dato;
    
    public SommeRandom(int i) throws InterruptedException {
        dato = new Risorsa(0);
        Random r = new Random();
        Thread[] threads = new Thread[i];
        for (int j = 0; j < i; j++) {
            threads[j] = new Thread(new Numero(r.nextInt(1000),r.nextInt(100)));
            threads[j].start();
        }
        for (int j = 0; j < i; j++) {
            threads[j].join();
        }
        System.out.println(Risorsa.somma);
    }

    static class Risorsa {
        static int somma;
        static Semaphore s;
        
        public Risorsa(int somma) {
            this.somma = somma;
            s = new Semaphore(1);
        }
    }
}
class Numero implements Runnable{

    int attesaRandom;
    int sommaRandom;

    public Numero(int attesaRandom, int sommaRandom) {
        this.attesaRandom = attesaRandom;
        this.sommaRandom = sommaRandom;
    }
    
    @Override
    public void run() {
        
        try {
            Thread.sleep(attesaRandom);
            Risorsa.s.acquire();
            Risorsa.somma+=sommaRandom;
            Risorsa.s.release();
        } catch (InterruptedException ex) {}
    }
}