package com.example.happihatchihi.frontend;


import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happihatchihi.R;
import com.example.happihatchihi.backend.Goal;

import java.util.Arrays;
import java.util.List;

public class TrackPopupAdapter extends RecyclerView.Adapter<TrackPopupAdapter.TrackPopupViewHolder> {
    public class TrackPopupViewHolder extends RecyclerView.ViewHolder {
        public View trackView;
        public ImageView goalIcon;
        public TextView goalNameTextView;
        public TextView goalProgressTextView;
        public RadioButton goalButton;
        public Button startBtn;

        TrackPopupViewHolder(View item) {
            super(item);
            trackView = item;
            goalIcon = item.findViewById(R.id.goalIcon);
            goalNameTextView = item.findViewById(R.id.goalNameTxt);
            goalProgressTextView = item.findViewById(R.id.goalProgressTxt);
            goalButton = item.findViewById(R.id.goalRadiobtn);
            startBtn = item.findViewById(R.id.startBtn);
        }
    }

    private List<Goal> goalList = Arrays.asList(
            new Goal("Water",
                    5,
                    "water",
                    "daily"),
            new Goal("Fruit",
                    5,
                    "fruit",
                    "daily"),
            new Goal("Meditation",
                    2,
                    "meditation",
                    "weekly"),
            new Goal("Water Plants",
                    1,
                    "createyourown",
                    "weekly")
            );

    @NonNull
    @Override
    public TrackPopupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goal_row, parent, false);
        return new TrackPopupViewHolder(view);
    }

    public List<Goal> getGoalList() {
        return goalList;
    }

    @Override
    public void onBindViewHolder(@NonNull TrackPopupViewHolder holder, int position) {
        Goal current = goalList.get(position);
        int icon = getGoalIcon(current);
        holder.goalButton.setId(View.generateViewId());
        holder.goalIcon.setImageResource(icon);
        holder.goalNameTextView.setText(current.getName());


        String progress = current.getGoalProgress() + "/" + current.getGoalQuantity();
        holder.goalProgressTextView.setText(progress);
        int colorPrimary = ContextCompat.getColor(holder.itemView.getContext(),R.color.colorPrimary);
        holder.goalButton.setButtonTintList(ColorStateList.valueOf(colorPrimary));
        Context context = holder.itemView.getContext();

        if (current.getType().equals("meditation")) {
            holder.startBtn.setVisibility(View.VISIBLE);
        } else {
            holder.startBtn.setVisibility(View.GONE);
        }

        holder.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Meditation.class);
                context.startActivity(i);
            }
        });

        holder.goalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increase progress by one when the radio button is clicked
                current.addProgress();

                // Update the TextView displaying the progress
                String updatedProgressText = current.getGoalProgress() + " / " + current.getGoalQuantity();
                holder.goalProgressTextView.setText(updatedProgressText);
            }
        });
    }

    public void updateGoals(List<Goal> newGoalList) {
        goalList = newGoalList;
        notifyDataSetChanged();
    }

    public int getGoalIcon(Goal current) {
        if (current.getType().equals("water")) {
            return R.drawable.water;
        }
        else if(current.getType().equals("fruit")) {
            return R.drawable.health;
        }
        else if(current.getType().equals("meditation")) {
            return R.drawable.meditation;
        }
        else {
            return R.drawable.target;
        }

    }

    @Override
    public int getItemCount() {
        return goalList.size();
    }


}
