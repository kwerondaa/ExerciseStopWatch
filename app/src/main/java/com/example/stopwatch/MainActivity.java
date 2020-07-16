package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvSplash, tvSubSplash;
    Button btnGet;
    Animation atg, btngone, btngtwo;
    ImageView ivSplash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        btnGet = findViewById(R.id.btnGet);
        ivSplash = findViewById(R.id.ivSplash);

        //load animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        btngone = AnimationUtils.loadAnimation(this, R.anim.btngone);
        btngtwo = AnimationUtils.loadAnimation(this, R.anim.btngtwo);

        //passing animation
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btngone);
        tvSubSplash.startAnimation(btngone);
        btnGet.startAnimation(btngtwo);

        //events
        btnGet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, StopWatchActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        //import Font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        //Assign font
        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MLight);
        btnGet.setTypeface(MMedium);
    }
}