package com.coach.finalproject_fitness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomItemHolder> {

    private Context context;
    private ArrayList<Diet> recyclerItemValues;

    public CustomRecyclerViewAdapter(Context context, ArrayList<Diet> recyclerItemValues) {
        this.context = context;
        this.recyclerItemValues = recyclerItemValues;
    }

    @NonNull
    @Override
    public CustomRecyclerViewAdapter.CustomItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());

        View itemView = inflator.inflate(R.layout.detail_recycler_item, viewGroup, false);

        CustomItemHolder mViewHolder = new CustomItemHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerViewAdapter.CustomItemHolder myRecyclerViewItemHolder, int i) {
        final Diet dietItem = recyclerItemValues.get(i);

        myRecyclerViewItemHolder.day.setText(dietItem.getDay());
        myRecyclerViewItemHolder.meal.setText(dietItem.getMeal());


        myRecyclerViewItemHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, dietItem.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return  recyclerItemValues.size();
    }

    public class CustomItemHolder extends RecyclerView.ViewHolder {
        TextView day;
        TextView meal;
        LinearLayout parentLayout;

        public CustomItemHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            meal = itemView.findViewById(R.id.meal);
            parentLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
