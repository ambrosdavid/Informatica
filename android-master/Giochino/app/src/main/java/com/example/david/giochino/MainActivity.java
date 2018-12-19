package com.example.david.giochino;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private TextView punteggio;
    private ImageView ragno;
    private FrameLayout frame;
    private int posX;
    private int posY;
    private Button sx;
    private Button dx;
    private TextView tap;

    private Handler handler =new Handler();
    private Timer timer=new Timer();

    private int dimensioneFinestra;
    private int dimensioneRagno;

    private int altezzaSchermo;
    private int larghezzaSchermo;


    private int direzione=0;
    private boolean start=false;

    private int moscaX;
    private int moscaY;

    private int punti=0;

    /*<ImageView
            android:id="@+id/mosca"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:src="@drawable/mosca"/>*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        punteggio=findViewById(R.id.punteggio);
        ragno=findViewById(R.id.ragno);
       // mosca=findViewById(R.id.mosca);
        frame=findViewById(R.id.frame);
        sx=findViewById(R.id.sx);
        dx=findViewById(R.id.dx);
        tap=findViewById(R.id.tap);


      //  mosca.setX(-180);
       // mosca.setY(-180);

        ragno.setY(1400);
        posX=(int)ragno.getX();
        posY=(int)ragno.getY();



        dx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                direzione=1;
            }
        });
        sx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                direzione=-1;
            }
        });

        WindowManager wm=getWindowManager();
        Display disp=wm.getDefaultDisplay();
        Point dimensione=new Point();
        disp.getSize(dimensione);

        altezzaSchermo=dimensione.y;
        larghezzaSchermo=dimensione.x;



    }

    private void generaMosche() {

        int delay=0;

        for(int i=0; i<10;i++) {
            ImageView mosca = new ImageView(this);

            mosca.setImageResource(R.drawable.mosca);
            float altezzaMosca=mosca.getDrawable().getIntrinsicHeight();


            mosca.setY((-altezzaMosca / 2));//vero width in pixel
            mosca.setX((int) Math.floor(Math.random() * (larghezzaSchermo - mosca.getHeight())));
            FrameLayout.LayoutParams par =new FrameLayout.LayoutParams(100, 100);
            mosca.setLayoutParams(par);


            frame.addView(mosca);
            long tempoAnimazione=(long) (2000 + (Math.random() * 3000));

            mosca.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    ObjectAnimator y = ObjectAnimator.ofFloat(mosca, "translationY", mosca.getY(), altezzaSchermo + (altezzaMosca / 2));
                    ObjectAnimator x = ObjectAnimator.ofFloat(mosca, "translationX", mosca.getX(), (int) Math.floor(Math.random() * (larghezzaSchermo - altezzaMosca)));
                    AnimatorSet animSetXY = new AnimatorSet();
                    animSetXY.playTogether(x, y);
                    animSetXY.setInterpolator(new AccelerateDecelerateInterpolator());
                    animSetXY.setDuration(tempoAnimazione);
                    animSetXY.start();

                }
            },delay);
            delay+=tempoAnimazione-Math.random()*(tempoAnimazione/1.2);

            new Thread(() -> {
                while (start) {
                   if( viewsOverlap(mosca, ragno)){
                       mosca.setAlpha(0f);
                   };
                    dormi(20);
                }
            }).start();



          // dormi();




        }


    }

    private void dormi(int i) {
        try {
            Thread.sleep(i);
        } catch (Exception e) {

        }
    }

 /*   public void startMovimento(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        cambiaPos();
                    }
                });
            }
        },0,20);
    }

  /*  public void cambiaPos() {

        if (!start) {


        } else {
            tap.setVisibility(View.INVISIBLE);

            checkHit(null);
            punteggio.setText("Punteggio: "+punti);
            //for
            moscaY +=12+(punti/100);
            if(moscaY>altezzaSchermo){
                moscaY= -20;
                moscaX=(int) Math.floor(Math.random()*(larghezzaSchermo-mosca.getHeight()));
            }
            mosca.setX(moscaX);
            mosca.setY(moscaY);

            if (direzione==1) {
                posX += 10;

            } else {
                posX -= 10;
            }

            if(posX<0)posX=0;
            dimensioneFinestra=frame.getWidth();
            dimensioneRagno=ragno.getWidth();
            if(posX> dimensioneFinestra-dimensioneRagno)posX=dimensioneFinestra-dimensioneRagno;
            ragno.setX(posX);
        }
    }*/

    private boolean viewsOverlap(View v1, View v2) {
        int[] v1_coords = new int[2];
        v1.getLocationOnScreen(v1_coords);
        int v1_w = v1.getWidth();
        int v1_h = v1.getHeight();
        Rect v1_rect = new Rect(v1_coords[0], v1_coords[1], v1_coords[0] + v1_w, v1_coords[1] + v1_h);

        int[] v2_coords = new int[2];
        v2.getLocationOnScreen(v1_coords);
        int v2_w = v2.getWidth();
        int v2_h = v2.getHeight();
        Rect v2_rect = new Rect(v2_coords[0], v2_coords[1], v2_coords[0] + v2_w, v2_coords[1] + v2_h);

        return v1_rect.intersect(v2_rect) || v1_rect.contains(v2_rect) || v2_rect.contains(v1_rect);
    }
    private void checkHit(ImageView mosca) {

       int centroMoscaX= (int) (mosca.getX()+mosca.getLayoutParams().width/2);
        int centroMoscaY= (int) (mosca.getY()+mosca.getLayoutParams().width/2);

      //  int centroMoscaX= (int) mosca.getX();
        // int centroMoscaY= (int) mosca.getY();

        if(centroMoscaY<ragno.getY()+ragno.getWidth()) {
            if (ragno.getY() <= centroMoscaY && centroMoscaY >= 50 &&
                    ragno.getX() <= centroMoscaX && centroMoscaX <= ragno.getX() + 50) {
                moscaY = -10;
                mosca.setAlpha(0f);
                System.out.println("bresa");
                moscaX = (int) Math.floor(Math.random() * (larghezzaSchermo - mosca.getHeight()));
                punti += 10;
                mosca.destroyDrawingCache();
                runOnUiThread(() -> punteggio.setText("Punteggio: " + punti));

            }
        }

    }

    public boolean onTouchEvent(MotionEvent me){

        if(me.getAction()== MotionEvent.ACTION_DOWN){
            if(!start) {
                //startMovimento();
                start = true;
                tap.setVisibility(View.INVISIBLE);
              /*  new Thread(()->{
                    generaMosche();
                }).start();*/
                        generaMosche();
                new Thread(()->{
                    double velocita=10;
                    while(start){
                        float posX=(ragno.getX()+(float)(velocita*direzione));
                        if(posX<0)posX=0;
                        dimensioneFinestra=frame.getWidth();
                        dimensioneRagno=ragno.getWidth();
                        if(posX> dimensioneFinestra-dimensioneRagno)posX=dimensioneFinestra-dimensioneRagno;
                        ragno.setX(posX);

                        dormi(20);
                    }
                }).start();
            }
        }


        return true;
    }
}
