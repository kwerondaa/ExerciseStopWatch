package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    ImageView icananchor;
    Animation roundingalone;
    Chronometer timeHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        icananchor = findViewById(R.id.icanchor);
        timeHero = findViewById(R.id.timeHero);

        //create optional animation
        btnStop.setAlpha(0);

        //animation
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        //import fonts
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        btnStart.setTypeface(MMedium);
        btnStop.setTypeface(MMedium);

        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //passing animation
                icananchor.startAnimation(roundingalone);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();

                //start timer
                timeHero.setBase(SystemClock.elapsedRealtime());
                timeHero.start();
            }
        });

    }
}