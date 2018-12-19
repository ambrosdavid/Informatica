package com.example.david.lifesaver;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

public class CarDispos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_dispos);
        setMacchine();

    }



    void setMacchine(){
       final Switch switch1=(Switch) findViewById(R.id.switch1);
        boolean stato =switch1.isChecked();
       final ImageView macchina=(ImageView) findViewById(R.id.imageView2);
       final ImageView macchina2=(ImageView) findViewById(R.id.macchina2);
        macchina2.setVisibility(View.INVISIBLE);
        findViewById(R.id.constraintLayout2).setVisibility(View.INVISIBLE);
    switch1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(switch1.isChecked()){
                macchina2.setVisibility(View.VISIBLE);
                findViewById(R.id.constraintLayout2).setVisibility(View.VISIBLE);
            }else{
                macchina2.setVisibility(View.INVISIBLE);
                findViewById(R.id.constraintLayout2).setVisibility(View.INVISIBLE);
            }
        }
    });


    }
}
