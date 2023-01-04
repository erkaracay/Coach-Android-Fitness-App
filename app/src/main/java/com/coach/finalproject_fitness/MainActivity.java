package com.coach.finalproject_fitness;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    float x1, y1, x2, y2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hiding title and status bar using code
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (y1 < y2) {
                    Intent i = new Intent(MainActivity.this, WorkoutActivity.class);
                    startActivity(i);
                    final MediaPlayer mp = MediaPlayer.create(this, R.raw.sample);
                    mp.start();
                } else if (y1 > y2) {
                    Intent i = new Intent(MainActivity.this, DietActivity.class);
                    startActivity(i);
                    final MediaPlayer mp = MediaPlayer.create(this, R.raw.sample);
                    mp.start();
                }
                break;
        }
        return false;

    }
}