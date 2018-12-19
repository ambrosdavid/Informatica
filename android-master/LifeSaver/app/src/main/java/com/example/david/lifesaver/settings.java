package com.example.david.lifesaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        carDispos();
    }
    private void carDispos() {
        Button carDispos = (Button) findViewById(R.id.carDispos);

        carDispos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent carDispos = new Intent(settings.this, CarDispos.class);
                startActivity(carDispos);
            }
        });


    }
}
