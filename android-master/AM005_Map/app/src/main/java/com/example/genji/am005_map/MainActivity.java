package com.example.genji.am005_map;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        Intent i=new Intent(Intent.ACTION_DIAL);
        i.putExtra("chiave", 2);
        i.getStrin
        Bundle bundle=new Bundle();
        bundle.putString("chiave2", "32");
        i.putExtras(bundle);
        i.setData(Uri.parse("tel: 3273673394"));
        startActivity(i);
    }

    public void onClickBrowser(View view) {
        String url = "http://www.zuccante.it";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
