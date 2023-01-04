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

public class RecyclerViewAdapterWorkout extends RecyclerView.Adapter<com.coach.finalproject_fitness.RecyclerViewAdapterWorkout.ViewHolder> {

    private Context context;
    private ArrayList<Workout> arrayList;
    private Workout wOut;
    public RecyclerViewAdapterWorkout(Context context, ArrayList<Workout> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public com.coach.finalproject_fitness.RecyclerViewAdapterWorkout.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.workout_item, parent,false);
        com.coach.finalproject_fitness.RecyclerViewAdapterWorkout.ViewHolder viewHolder = new com.coach.finalproject_fitness.RecyclerViewAdapterWorkout.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.coach.finalproject_fitness.RecyclerViewAdapterWorkout.ViewHolder holder, int position) {
        wOut = arrayList.get(position);
        holder.tvWorkout.setText(wOut.getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvWorkout;
        private Button btnWorkout;
        private ConstraintLayout workoutItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvWorkout = itemView.findViewById(R.id.tvExName);
            btnWorkout = itemView.findViewById(R.id.btnWorkout);
            workoutItem = itemView.findViewById(R.id.workoutItem);

            btnWorkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle b = new Bundle();
                    Intent i = new Intent(context, WorkoutResultActivity.class);
                    b.putParcelableArrayList("arrayList", arrayList);
                    i.putExtras(b);
                    context.startActivity(i);
                }
            });
        }
    }
}