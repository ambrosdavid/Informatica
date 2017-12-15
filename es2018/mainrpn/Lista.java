package mainrpn;

/**
 *
 * @author David
 */
public class Lista<T> {
    private Nodo testa;
    private Nodo coda;
    private int lunghezza;

    public Lista() {
        this.testa = null;
        this.coda = null;
    }

    public Lista(T[] a) {
        for (int i = 0; i < a.length; i++) {
            this.addTail(a[i]);
        }
    }
    
    public void addTail(T oggetto){
        Nodo daAggiungere = new Nodo(oggetto);
        if(lunghezza==0){
            testa = coda = daAggiungere;
        }else{
            coda.setNext(daAggiungere);
            coda =daAggiungere;
        }
        lunghezza++;
    }
    public void add(T info){
        if(lunghezza==0){
            this.addHead(info);
        }else{
            this.addTail(info);
        }
    }
    
    public void addHead(T info){
        Nodo daAggiungere= new Nodo(info);
        if(lunghezza==0){
            testa=coda =daAggiungere;
        }else{
           daAggiungere.setNext(testa);
           testa=daAggiungere;
        }
    }
    
    public void remove(int i){
        Nodo viaggiante = testa;
        for (int j = 0; j < i-1; j++) {
            viaggiante = viaggiante.getNext();
        }
        viaggiante.setNext(viaggiante.getNext().getNext());
        lunghezza--;
    }
    
    public T rimuoviCoda() {
        T valore = (T) coda.getInfo();
        Nodo viaggiante = testa;
        for (int i = 0; i < lunghezza-2; i++) {
            viaggiante = viaggiante.getNext();
        }
        coda = viaggiante;
        lunghezza--;
        return (T) valore;
    }
        
    public T rimuoviTesta(){
        T valore = (T) testa.getInfo();
        testa =  testa.getNext();
        return valore;
    }
    
    public int getSize(){
        return this.lunghezza;
    }
    
    @Override
    public String toString(){
        String ris=" ";
        Nodo viaggiante = testa;
        for (int i = 0;i < lunghezza; i++) {
            ris = ris+viaggiante.getInfo().toString()+";";
            viaggiante=viaggiante.getNext();
        }
        return ris;
    }

    
}
