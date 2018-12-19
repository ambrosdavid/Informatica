package com.example.david.appdistecco;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Intent ritorno=new Intent(/*this activity, mainActivity*/);//Intent che ritorna al programma principale
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mailCorrente();

        mDrawerLayout=findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(MainActivity.this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=findViewById(R.id.Navigation_v);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cambia(View view) {
        ritorno.putExtra("ritorno",((EditText)findViewById(R.id.nuovaMail)).getText().toString());
        startActivity(ritorno);
    }

    private void mailCorrente() {
        Intent riceviMail=getIntent();
        if(riceviMail.hasExtra("mail")){
            ((TextView)findViewById(R.id.mailCorrente)).setText(riceviMail.getStringExtra("mail"));
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();

        switch (item.getItemId()){
            case R.id.home:
                System.out.println("ciao");
                break;
            case R.id.coupon:
                System.out.println("ciao2");
                break;
            case R.id.info:
                System.out.println("ciao3");
                break;
        }
        return false;
    }
}
