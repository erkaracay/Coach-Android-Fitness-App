package com.coach.finalproject_fitness;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterWorkoutResults extends RecyclerView.Adapter<RecyclerViewAdapterWorkoutResults.ViewHolder> {

    private Context context;
    private ArrayList<Workout> arrayList;
    private String[] days = new String[] {"Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"};

    public RecyclerViewAdapterWorkoutResults(Context context, ArrayList<Workout> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.workout_result_item, parent,false);
        com.coach.finalproject_fitness.RecyclerViewAdapterWorkoutResults.ViewHolder viewHolder = new com.coach.finalproject_fitness.RecyclerViewAdapterWorkoutResults.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        arrayList = getData();
        Exercise exercise = arrayList.get(position).getExercise();
        holder.tvDay.setText(days[position]);
        //holder.tvExName.setText(exercise.getName());
        //holder.tvSet.setText(exercise.getSetCount());
        //holder.tvRep.setText(exercise.getRepCount());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDay;
        private TextView tvExName;
        private TextView tvSet;
        private TextView tvRep;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDay = itemView.findViewById(R.id.tvWorkoutDay);
            tvExName = itemView.findViewById(R.id.tvExName);
            tvSet = itemView.findViewById(R.id.tvSet);
            tvRep = itemView.findViewById(R.id.tvRep);
        }
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
