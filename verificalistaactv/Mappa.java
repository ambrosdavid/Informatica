/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificalistaactv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Mappa {

    private Lista<PuntoMappa> lista = new Lista<>();
    private File input;

    public Mappa(String nome) throws FileNotFoundException {
        load(nome);
    }
    public Mappa(){}

    public void load(String nomeFile) throws FileNotFoundException {
        input = new File(nomeFile);
        Scanner inScan = new Scanner(input);
        inScan.nextLine();
        inScan.useDelimiter(",");
        while (inScan.hasNextLine()) {
            PuntoMappa p = new PuntoMappa();
            p.setStopID(inScan.next());
            inScan.next();
            p.setStopName(inScan.next());
            inScan.next();
            String lat = inScan.next();
            String log = inScan.next();
            try {
                p.setStopLat(Double.parseDouble(lat));
                p.setStopLon(Double.parseDouble(log));
                lista.addTail(p);
            } catch (NumberFormatException e) {
            }

            inScan.nextLine();
        }
    }

    public PuntoMappa search(double lat, double lon) {
        Iterator it = lista.iterator();
        double distanzaMinTrovata = Double.MAX_VALUE;
        PuntoMappa fermataPiuVicina = null;
        while (it.hasNext()) {
            PuntoMappa fermataCurrent = (PuntoMappa) it.next();
            if (fermataCurrent.distanza(lat, lon) < distanzaMinTrovata) {
                distanzaMinTrovata = fermataCurrent.distanza(lat, lon);
                fermataPiuVicina = fermataCurrent;
            }
        }
        return fermataPiuVicina;
    }

}
