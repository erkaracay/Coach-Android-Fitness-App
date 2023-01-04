package com.coach.finalproject_fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

public class WorkoutResultActivity extends AppCompatActivity {

    RecyclerView recycler;
    RecyclerViewAdapterWorkoutResults adapter;
    Intent intent;
    ArrayList<Workout> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hiding title and status bars using code
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_workout_result);

        intent = getIntent();
        arrayList = intent.getParcelableArrayListExtra("arrayList");

        recycler = findViewById(R.id.recyclerWorkoutResults);
        adapter = new RecyclerViewAdapterWorkoutResults(this, arrayList);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recycler.setAdapter(adapter);
    }
}