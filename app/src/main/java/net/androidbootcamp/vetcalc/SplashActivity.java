/*  Vet Calc - Version .01
    By Schuyler Ankele
    Splash Activity - More Documentation will be provided on the project README.md

 */



package net.androidbootcamp.vetcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask task = new TimerTask(){


            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        };
        Timer openeing = new Timer();
        // 2.5 seconds - We can extend this if we need to load other data later
        openeing.schedule(task, 2500);
    }
}
