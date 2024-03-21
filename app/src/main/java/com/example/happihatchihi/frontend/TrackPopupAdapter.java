package com.example.happihatchihi.frontend;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        public RadioButton goalSelector;

        TrackPopupViewHolder(View item) {
            super(item);
            trackView = item;
            goalIcon = item.findViewById(R.id.goalIcon);
            goalNameTextView = item.findViewById(R.id.goalNameTxt);
            goalProgressTextView = item.findViewById(R.id.goalProgressTxt);
            goalSelector = item.findViewById(R.id.goalRadiobtn);

        }
    }

    private List<Goal> goalList = Arrays.asList(
            new Goal("Water",
                    R.drawable.water,
                    5,
                    "water",
                    "daily"),
            new Goal("Fruit",
                    R.drawable.health,
                    5,
                    "fruit",
                    "daily"),
            new Goal("Meditation",
                    R.drawable.meditation,
                    2,
                    "meditation",
                    "weekly"),
            new Goal("Water Plants",
                    R.drawable.target,
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
        holder.goalIcon.setImageResource(current.getIconId());
        holder.goalNameTextView.setText(current.getName());
        holder.goalProgressTextView.setText(String.valueOf(current.getGoalProgress()));
        int colorPrimary = ContextCompat.getColor(holder.itemView.getContext(),R.color.colorPrimary);
        holder.goalSelector.setButtonTintList(ColorStateList.valueOf(colorPrimary));
    }

    public void updateGoals(List<Goal> newGoalList) {
        goalList = newGoalList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return goalList.size();
    }
}
