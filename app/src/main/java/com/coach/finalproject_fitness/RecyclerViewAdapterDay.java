package com.coach.finalproject_fitness;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterDay extends RecyclerView.Adapter<RecyclerViewAdapterDay.ViewHolder> {

    private Context context;
    private ArrayList<Day> arrayList;

    public RecyclerViewAdapterDay(Context context, ArrayList<Day> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.day_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Day day = arrayList.get(position);
        holder.tv_day.setText(day.getDay());
        holder.checkBox.setChecked(day.isSelected());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_day;
        private CheckBox checkBox;
        private ConstraintLayout dayItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_day = itemView.findViewById(R.id.tv_day);
            checkBox = itemView.findViewById(R.id.check);
            dayItem = itemView.findViewById(R.id.dayItem);

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isChecked =((CheckBox) v).isChecked();

                    if(isChecked){
                        arrayList.get(getAdapterPosition()).setSelected(true);
                    }else {
                        arrayList.get(getAdapterPosition()).setSelected(false);
                    }

                    notifyDataSetChanged(); //??
                    for(int i = 0; i < arrayList.size(); i++){
                        Log.d("TAG",arrayList.toString());
                    }
                }
            });

            dayItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, String.valueOf(arrayList.get(getAdapterPosition())),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
