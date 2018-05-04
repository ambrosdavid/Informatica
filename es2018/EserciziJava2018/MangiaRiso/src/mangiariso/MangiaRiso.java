/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangiariso;



import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author David
 */
public class MangiaRiso {

    public static void main(String[] args) {
        Tavolo f = new Tavolo(5);
    }
}

class Tavolo{

    static Semaphore posate[];
    
    Tavolo(int nFilosofi) {
        posate = new Semaphore[nFilosofi];
        for (int i = 0; i < nFilosofi; i++) {
            posate[i] = new Semaphore(1);
        }
        for (int i = 0; i < nFilosofi; i++) {
            new Thread(new Filosofo(i)).start();
        }
    }
}
class Filosofo implements Runnable{
    int n;
    public Filosofo(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        while(true){
            try {
            if(n%2!=0){
                Tavolo.posate[n].acquire();
                Tavolo.posate[(n + 1) % Tavolo.posate.length].acquire();

                System.out.println("Ho mangiato con le posate pos : " + n + " e " + (n + 1) % Tavolo.posate.length);

                Tavolo.posate[n].release();
                Tavolo.posate[(n + 1) % Tavolo.posate.length].release();
            }else{
                Tavolo.posate[(n + 1) % Tavolo.posate.length].acquire();
                Tavolo.posate[n].acquire();
                System.out.println("Ho mangiato con le posate pos : " + n + " e " + (n + 1) % Tavolo.posate.length);

                Tavolo.posate[n].release();
                Tavolo.posate[(n + 1) % Tavolo.posate.length].release();        
            }
            } catch (InterruptedException ex) {
            }
        }
    }
}