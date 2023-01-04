package com.coach.finalproject_fitness;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Type {

    float x1, y1, x2, y2;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hiding title bar using code
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


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
                    Intent i = new Intent(MainActivity.this, Workout.class);
                    startActivity(i);
                } else if (y1 > y2) {
                    Intent i = new Intent(MainActivity.this, Diet.class);
                    startActivity(i);
                }
                break;
        }
        return false;

    }
}