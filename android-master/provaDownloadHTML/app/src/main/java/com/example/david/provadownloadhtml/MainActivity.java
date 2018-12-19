package com.example.david.provadownloadhtml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            suca();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void suca() throws IOException {

        Document doc;

            doc=Jsoup.connect("https://www.google.it").get();
            Elements immagini=doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image:immagini) {
               String str = image.attr("src");
                if (str.length() > 0) {
                    if (str.length() < 4)
                        str = doc.baseUri() + str.substring(1);
                    else if (!str.substring(0, 4).equals("http"))
                        str = doc.baseUri() + str.substring(1);
                }
                System.out.println(str);
            }

        }

    }

