package hellorunnable2;
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Ciao dal Thread");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }

}