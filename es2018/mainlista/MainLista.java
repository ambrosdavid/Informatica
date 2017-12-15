package mainlista;

/**
 *
 * @author David
 */
public class MainLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String [] a={"aa", "bb", "cc", "dd"};
        Lista<String> l= new Lista(a);
        l.rimuoviCoda();
        l.addTail("dopo cc");
        System.out.println(l.toString());
        l.get(3);
        
        l.add(0, "Ciao");
        System.out.println(l.toString());
        /*
       String a="ciao";
       String b="ciao2";
       String c="ciao3";
       Pila <String> p=new Pila();
       p.push(a);
       p.top();
       p.push(b);
       p.top();
        System.out.println(p.pop());
        p.top();
       Coda<Integer> c=new Coda();
       c.enqueue(3);
       c.enqueue(2);
       c.enqueue(6);
       c.dequeue();
       c.dequeue();
        c.dequeue();
        System.out.println(c.front());*/
       
}
}
