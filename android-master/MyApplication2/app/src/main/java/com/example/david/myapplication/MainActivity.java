package com.example.david.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.textView);
        Button dw=findViewById(R.id.getData);

        dw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new scarica().execute();
            }
        });
    }
    public class scarica extends AsyncTask<Void,Void,Void> {
        String parole;
        @Override
        protected Void doInBackground(Void... voids) {


            Document doc;
            try {

                //get all images
                doc = Jsoup.connect("https://www.instagram.com/david_ambros/followers/").get();
                Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
                for (Element image : images) {

                    System.out.println("\nsrc : " + image.attr("src"));
                    System.out.println("height : " + image.attr("height"));
                    System.out.println("width : " + image.attr("width"));
                    System.out.println("alt : " + image.attr("alt"));

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

    }


    }




