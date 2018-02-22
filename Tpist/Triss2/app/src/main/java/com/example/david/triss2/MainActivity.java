package com.example.david.triss2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Tris tris1;
    final int x=-2;
    final int o=-3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tris1 = new Tris();
    }


    public void listener(View v) {

        for (int i=0; i<idImmagini.length;i++){
            if(v.getId()==idImmagini[i]){ //guarda quale tasto ho premuto
                if(!tris1.getGriglia()[i]) { //controllo se non è gia stato cliccato
                    indice(i).setImageResource(youtube); //bici è l'immagine del player
                    tris1.setGriglia(i, true); //griglia di pos i diventa true quindi non puo piu essere cliccabile
                    tris1.setVittoria(i,x);//setVittoria è l'array che si occupa del controllo delle vittorie
                    int rispostaPC=tris1.getIA(i, x);
                    if(rispostaPC!=-1) {//se il pc ha risposto alla scelta del player
                        if (rispostaPC == x) {//se la risposta è x vuol dire che la funzione haVinto Ha returnato -2
                            apriActivity("Hai vinto");
                           return;
                        } else if (rispostaPC == o) {//se la risposta è o vuol dire che la funzine haVinto ha returnato -3
                            apriActivity("Vince pc");
                            return;
                        }else if(rispostaPC==-4){//altrimenti è un pareggio
                            apriActivity("pareggio");
                            return;
                        }
                        indice(rispostaPC).setImageResource(facebook);//immagine del pc
                        tris1.setVittoria(rispostaPC, o);
                        if(tris1.haVinto(rispostaPC, o)!=-1){// controllase se la risposta che il pc ha fatto dopo che
                            apriActivity("Vince il pc");//ho cliccato un pulsante gli permette di vincere
                            return;
                        }
                    }
                }
                break;
            }
        }
    }

    public ImageView indice(int indice){

       return findViewById(idImmagini[indice]);

    }


    public void apriActivity(String valore){
        Intent intent=new Intent(this, Main2Activity.class);
        intent.putExtra("player",valore);
        startActivity(intent);
    }
    /**Variabili d'appoggio**/
    final int facebook=R.drawable.phone;
    final int youtube=R.drawable.bici;

    final int primoId=R.id.primo;
    final int secondoId=R.id.secondo;
    final  int terzoId=R.id.terzo;
    final int quartoId=R.id.quarto;
    final int quintoId=R.id.quinto;
    final  int sestoId=R.id.sesto;
    final  int settimoId=R.id.settimo;
    final int ottavoId=R.id.ottavo;
    final  int nonoId=R.id.nono;
    /**array per ottimizzare le prestazioni**/
    final int [] idImmagini={primoId,secondoId,terzoId,quartoId,quintoId,sestoId,settimoId,ottavoId,nonoId};
}