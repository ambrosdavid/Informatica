
package es1pilecode;

import java.util.Iterator;

/**
 *
 * @author David
 */
public class Es1PileCode {

    /**
     * 1.
        Invertire l’ordine degli elementi della pila S
         a)  usando altre due pile
           b)  usando una coda
            c)  usando un’altra pila ed alcune variabili
     */
    public static void main(String[] args) {
        Pila s=new Pila();
        int []a=new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i]=i;
        }
        riempiPila(s, a);
        
        Pila<String> p = new Pila();
        p.push("ciao1");p.push("ciao2");p.push("ciao3");
        invertiConCoda(s);
        Iterator it = p.iterator();
        
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        
    }

    private static void riempiPila(Pila s, int[] a) {
        for (int i = 0; i < a.length; i++) {
            s.push(a[i]);
           // System.out.println(s.top());
        }
        
    }

    private static Pila invertiConDuePile(Pila s) {
        Pila p=new Pila();
        Pila l=new Pila();
        while(!s.isEmpty()){
            l.push(s.pop());
        }
        while(!l.isEmpty()){
            p.push(l.pop());
        }
        return p;
    }

    private static void invertiConCoda(Pila s) {
        Pila a=new Pila();
       Coda c=new Coda();
       while(!s.isEmpty()){
           c.enqueue(s.pop());
       }
       while(!c.isEmpty()){
           s.push(c.front());
           c.dequeue();
       }
      
       
    }

  
    
}
