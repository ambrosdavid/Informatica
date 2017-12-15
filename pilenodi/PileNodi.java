package pilenodi;

/**
 * @author David
 */
public class PileNodi {

    public static void main(String[] args) {

        /* Pila<String> c = new Pila<>();

        c.push("Ciao");
        c.push("come");
        c.push("va");
        System.out.println(c.pop());
        System.out.println(c.pop());
        System.out.println(c.top());*/
        Coda<Integer> c = new Coda<>();
        for (int i = 0; i < 10; i++) {
            c.enqueue(i);
        }
        c.inverti();
        for (int i = 0; i < c.getLunghezza();) {
           System.out.println(c.deQueue());
        }
    }

}
