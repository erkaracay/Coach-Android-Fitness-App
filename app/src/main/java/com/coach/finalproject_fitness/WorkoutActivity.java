package com.coach.finalproject_fitness;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity {

    RecyclerView recycler;
    ArrayList<Workout> arrayList = new ArrayList<>();
    RecyclerViewAdapterWorkout adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hiding title and status bars using code
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_workout);

        recycler = findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapterWorkout(this, getData());
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recycler.setAdapter(adapter);

    }

    private ArrayList<Workout> getData(){
        Exercise ex = new Exercise(3, 2, "Squats");
        String data[] = {
                "Weight Loss Workout",
                "Muscle Gain Workout"
        };

        for (String datum : data) {
            arrayList.add(new Workout(datum, ex));
        }

        return arrayList;
    }

}