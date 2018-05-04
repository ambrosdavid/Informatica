/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provahtmlpharser;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 *
 * @author David
 */
public class ProvaHTMLPharser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //  Document doc;
        Document doc;

        doc = Jsoup.connect("https://www.instagram.com/p/BdgV9TAlohF/?taken-by=david_ambros").timeout(6000).get();
        Elements immagini = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
        for (Element image : immagini) {
            String str = image.attr("src");
            if (str.length() > 0) {
                if (str.length() < 4) {
                    str = doc.baseUri() + str.substring(1);
                } else if (!str.substring(0, 4).equals("http")) {
                    str = doc.baseUri() + str.substring(1);
                }
            }
            System.out.println(str);
        }

    }

}
