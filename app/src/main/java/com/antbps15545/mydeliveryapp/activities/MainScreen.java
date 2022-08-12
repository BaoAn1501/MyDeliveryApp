package com.antbps15545.mydeliveryapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.antbps15545.mydeliveryapp.R;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        overridePendingTransition(R.anim.fadein_screen_anim, R.anim.fadeout_screen_anim);
    }
}