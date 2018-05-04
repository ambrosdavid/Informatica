package esercizisemafori;

import java.lang.Thread.State;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Florian
 */
public class TestPesciolini {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(0);

        new Thread(()->{
            try {
                Thread.sleep(1000);
                s.release();
            } catch (InterruptedException ex) {}
        }).start();
        
        Thread t = new Thread(() -> {
            try {
                s.acquire();
                Thread.sleep(100);
                s.release();
            } catch (InterruptedException ex) {}
        });

        new Thread(new Osserva(t)).start();

        t.start();

    }
}

class Osserva implements Runnable {

    Thread t;

    public Osserva(Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        State init = t.getState();

        while (!init.equals(State.TERMINATED)) {
            if (!init.equals(t.getState())) {
                init = t.getState();
                System.out.println(init.name());
            }
        }
    }

}