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

/**
 * The adapter manages what is shown in the recycler view.
 */
public class TrackPopupAdapter extends RecyclerView.Adapter<TrackPopupAdapter.TrackPopupViewHolder> {
    public class TrackPopupViewHolder extends RecyclerView.ViewHolder {
        public View trackView;
        public ImageView goalIcon;
        public TextView goalNameTextView;
        public TextView goalProgressTextView;
        public RadioButton goalButton;
        public Button startBtn;
        // checked is used to track whether the radio button has been selected
        boolean checked = false;

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


    //List of goals for using in frontend for prototype
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


    @Override
    public void onBindViewHolder(@NonNull TrackPopupViewHolder holder, int position) {
        // Collects the goal used for each row of the recycler view
        Goal current = goalList.get(position);
        // Creates an id for the radio buttons in the recycler view
        holder.goalButton.setId(View.generateViewId());
        // Sets up the correct icon based on goal type
        int icon = getGoalIcon(current);
        holder.goalIcon.setImageResource(icon);
        // Sets the name based on the goal name
        holder.goalNameTextView.setText(current.getName());
        // Collects the current progress of the goal
        int intProgress = current.getGoalProgress();
        // Creates a string to show progress out of desired quantity
        String initialProgress = current.getGoalProgress() + "/" + current.getGoalQuantity();
        holder.goalProgressTextView.setText(initialProgress);
        // Sets the initial color of the radio button as this feature isn't available in styles
        int colorPrimary = ContextCompat.getColor(holder.itemView.getContext(),R.color.colorPrimary);
        holder.goalButton.setButtonTintList(ColorStateList.valueOf(colorPrimary));
        Context context = holder.itemView.getContext();

        // Ensures mediation button is show if meditation goal is included
        if (current.getType().equals("meditation")) {
            holder.startBtn.setVisibility(View.VISIBLE);
        } else {
            holder.startBtn.setVisibility(View.GONE);
        }



        // Moves to meditation activity is start meditation button is clicked
        holder.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Meditation.class);
                context.startActivity(i);
            }
        });

        // Controls the effects of clicking a goal's radio button
        holder.goalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adds progress if possible if clicked
                if (!holder.checked) {
                    current.addProgress();
                    holder.checked = true;

                }
                // Removes progress if unselected if it was added
                else {
                    int progress = current.getGoalProgress();
                    if (progress != intProgress) {
                        current.removeProgress();
                    }
                    holder.goalButton.setChecked(false);
                    holder.checked = false;

                }

                // Update the TextView displaying the progress
                String updatedProgressText = current.getGoalProgress() + " / " + current.getGoalQuantity();
                holder.goalProgressTextView.setText(updatedProgressText);
            }
        });
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
