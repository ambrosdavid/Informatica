package pingpongjava;

public class PingPong extends Thread {

    private String cosaDire; //Cosa dire 
    private int ritardo;// durata della pausa
    private int quanteVolte;

    public PingPong(String cosaDire, int ritardo, int volte) {//costruttore
        this.cosaDire = cosaDire;
        this.ritardo = ritardo;
        this.quanteVolte = volte;
    }

    public void run() {
        try {
            for (;;) {
                System.out.println(cosaDire + " ");
                Thread.sleep(ritardo);// aspetta tot tempo
                this.quanteVolte--;
                if (this.quanteVolte == 0) {
                    System.out.println(Thread.currentThread().getState());
                    return;
                }
            }
        } catch (InterruptedException e) {

            return;
            // end this thread
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new PingPong("ping", 1, 4));
        System.out.println(t.getState());
        Thread osservatore=new Thread(new Osservatore(t));
        osservatore.start();
        t.start();
       /* System.out.println("Thread.start--->");
        System.out.println(t.getState());
        while(!t.getState().name().equals("TERMINATED"));
        System.out.println(t.getState());
        
        // new PingPong("PONG", 1000, 4).start(); // 1s*/
    }
}


class Osservatore implements Runnable{
    Thread t;
    Osservatore(Thread t){
        this.t=t;
    }
    @Override
    public void run() {
        String statoPrec= t.getState().name();
        while(true){
            if(!t.getState().name().equals(statoPrec)){
                System.out.println("lo stato è cambiato da " +statoPrec +" a " + t.getState());
                statoPrec=t.getState().name();
            }
        }
    }
    
    
    
}
