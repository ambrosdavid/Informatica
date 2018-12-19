package com.example.david.templatexstecco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MailActivity extends AppCompatActivity {
    ImageSwitcher sw;
    ImageButton femmina;
    ImageButton maschio;
    EditText nuovaMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        femmina=findViewById(R.id.femmina);
        maschio=findViewById(R.id.maschio);
        sw=findViewById(R.id.imgs);

        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imgV=new ImageView(getApplicationContext());
                imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imgV;
            }
        });
        setImmagine();


        mailCorrente();
    }

    private void setImmagine() {

       sw.setImageResource(R.drawable.def);
       femmina.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sw.setImageResource(R.drawable.femmina2);
           }
       });
        maschio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sw.setImageResource(R.drawable.maschio2);
            }
        });
    }

    public void cambia(View view) {
        Intent ritorno=new Intent(MailActivity.this, MainActivity.class);
        nuovaMail=findViewById(R.id.nuovaMail);
        nuovaMail.setOnClickListener(new View.OnClickListener() {///VEDERE XLKE NN WORKA N GAZ
            @Override
            public void onClick(View view) {
                nuovaMail.setText("");
            }
        });
        ritorno.putExtra("ritorno",(nuovaMail.getText().toString()));
        startActivity(ritorno);
    }
    private void mailCorrente() {
        Intent riceviMail=getIntent();
        if(riceviMail.hasExtra("mail")){
            ((TextView)findViewById(R.id.mailCorrente)).setText(riceviMail.getStringExtra("mail"));
        }
    }
}
