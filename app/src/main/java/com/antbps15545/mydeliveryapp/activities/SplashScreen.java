package com.antbps15545.mydeliveryapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.antbps15545.mydeliveryapp.R;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class SplashScreen extends AppCompatActivity {
    GifImageView logo_iv;
    GifDrawable logo_draw;
    Animation animation, animation1;
    ConstraintLayout background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo_iv = findViewById(R.id.logo_splash);
        background = findViewById(R.id.background_splash);
        logo_draw = (GifDrawable)logo_iv.getDrawable();
        logo_draw.stop();
        startAnimation();
        overridePendingTransition(R.anim.fadein_screen_anim, R.anim.fadeout_screen_anim);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void startAnimation(){
        //logo appear from above
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.logo_appear_anim);
        logo_iv.startAnimation(animation);
        animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.background_disappear_anim);
        background.startAnimation(animation1);
        //logo rotate after 2,1s
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo_draw.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        logo_draw.setSpeed(10);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(SplashScreen.this,MainScreen.class));
                                finish();
                            }
                        },500);
                    }
                }, 2500);
            }
        }, 600);
    }
}