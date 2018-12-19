package com.example.david.lifesaver;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        EmergencyCall();
        Ambulanza();
        Pompieri();
        Polizia();
        Settings();
    }

    private void Settings() {
        ImageButton setting=(ImageButton) findViewById(R.id.settings);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(Home.this, settings.class);
            startActivity(intent);
            }
        });
    }




    private void EmergencyCall() {
        ImageButton Emergency = findViewById(R.id.Emergenza);
        final EditText Ephone = (EditText) findViewById(R.id.Ephone);
        Emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String numero="tel:"+Ephone.getText();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(numero));
                startActivity(intent);

            }
        });

     }
    private void Ambulanza() {
        ImageButton Emergency1 = (ImageButton) findViewById(R.id.Ambulanza);
        final EditText Ephone1 = (EditText) findViewById(R.id.Ephone1);
        Emergency1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String numero="tel:"+Ephone1.getText();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(numero));
                startActivity(intent);

            }
        });

    }
    private void Polizia() {
        final ImageButton Emergency2 =  (ImageButton) findViewById(R.id.Polizia);
        final EditText Ephone2 = (EditText) findViewById(R.id.Ephone2);
        Emergency2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String numero="tel:"+Ephone2.getText();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(numero));
                startActivity(intent);

            }
        });

    }
    private void Pompieri() {
        final ImageButton Emergency3 = (ImageButton) findViewById(R.id.Pompieri);
        final EditText Ephone3 = (EditText) findViewById(R.id.Ephone3);
        Emergency3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String numero="tel:"+Ephone3.getText();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(numero));
                startActivity(intent);

            }
        });

    }
}
