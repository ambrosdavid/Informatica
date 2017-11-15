package hellorunnable;

public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Ciao dal thread");
    }

    public static void main(String args[]) {
        new Thread(new HelloRunnable()).start();
        HelloRunnable c=new HelloRunnable();
        c.run();
    }

}
    

