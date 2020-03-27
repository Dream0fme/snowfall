package com.example.snowfall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SnowDraw snowdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        snowdraw = new SnowDraw(this);
        setContentView(snowdraw);
    }
}
