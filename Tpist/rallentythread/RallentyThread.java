package rallentythread;

import java.lang.Thread.State;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class RallentyThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t1[] = new Thread[5];
        for (int i = 0; i < t1.length; i++) {
            t1[i] = new Thread(new dormi(2), "Thread" + i);

        }
        Osservatore o = new Osservatore(t1[3]);
        Thread osservatore=new Thread(o);
        osservatore.start();
        for (int i = 0; i < t1.length; i++) {
            t1[i].start();
            //t1[3].interrupt();
            t1[i].join();
        }

    }

}

class dormi implements Runnable {

    private int secondi;

    public dormi(int secondi) {
        this.secondi = secondi;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "Sto per dormire");
            Thread.sleep(this.secondi * 1000);

        } catch (InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + "***è stato interroto***");
            return;
        }
        System.out.println(Thread.currentThread().getName() + "Ho finito di dormire");
    }
}

class Osservatore implements Runnable {

    private Thread t;

    public Osservatore(Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        State statoCorrente = t.getState();
        System.out.println(statoCorrente.name());
        while (statoCorrente != State.TERMINATED) {
            while (statoCorrente == t.getState()) {

            }
            statoCorrente = t.getState();
            System.out.println(statoCorrente.name());
        }

    }

}
