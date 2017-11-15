package fileclock;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {
    
    @Override 
    public void run() {
        for (int i = 0; i < 10; i++) { //10 cicli in cui
            System.out.printf("%s\n", new Date());//stampa la data
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("The FileClock has been interrupted");
            }
        }
    }

    public static void main(String[] args){
        FileClock c=new FileClock();//creazione oggetto fileclock
        c.run();
        new Thread(new FileClock()).start();
    }
    


}


