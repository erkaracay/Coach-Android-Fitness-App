package com.coach.finalproject_fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DietActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Day> arrayList = new ArrayList<>();
    String[] data = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday"};

    //dialog box
    private TextView dayTextView;
    private TextView mealNameTextView;
    private TextView ingredientsTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hiding title and status bars using code
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_diet);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapterDay adapterDay = new RecyclerViewAdapterDay(this,getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapterDay);

    }

    private  ArrayList<Day> getData(){
        for (String datum : data) {
            arrayList.add(new Day(datum, false));
        }
        return arrayList;
    }

}