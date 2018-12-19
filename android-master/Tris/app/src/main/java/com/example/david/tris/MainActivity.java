package com.example.david.tris;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

import static com.example.david.tris.R.mipmap.ic_launcher23_round;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton primo=(ImageButton) findViewById(R.id.primo);

    ImageButton secondo=findViewById(R.id.secondo);
    ImageButton terzo=findViewById(R.id.terzo);
    ImageButton quarto=findViewById(R.id.quarto);
    ImageButton quinto=findViewById(R.id.quinto);
    ImageButton sesto=findViewById(R.id.sesto);
    ImageButton settimo=findViewById(R.id.settimo);
    ImageButton ottavo=findViewById(R.id.ottavo);
    ImageButton nono=findViewById(R.id.nono);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primo.setOnClickListener(this);
        secondo.setOnClickListener(this);
        terzo.setOnClickListener(this);
        quarto.setOnClickListener(this);
        quinto.setOnClickListener(this);
        sesto.setOnClickListener(this);
        settimo.setOnClickListener(this);
        ottavo.setOnClickListener(this);
        nono.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.primo:
          //      primo.setImageResource(R.drawable.car);
                break;

            case R.id.secondo:
                // do your code
                break;

            case R.id.terzo:
                // do your code
                break;

            default:
                break;
        }
    }
}
