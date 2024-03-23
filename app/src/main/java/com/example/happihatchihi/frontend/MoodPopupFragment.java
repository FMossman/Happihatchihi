package com.example.happihatchihi.frontend;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happihatchihi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MoodPopupFragment extends DialogFragment {



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);

        View moodView = inflater.inflate(R.layout.mood_pop_up, container, false);


        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        ImageButton happyBtn = moodView.findViewById(R.id.happyButton);
        ImageButton vHappyBtn = moodView.findViewById(R.id.veryHappyButton);
        ImageButton unhappyBtn = moodView.findViewById(R.id.unhappyButton);
        ImageButton vUnhappyBtn = moodView.findViewById(R.id.veryUnhappyButton);

        happyBtn.setOnClickListener(new View.OnClickListener() {
            /**
             * A method to show happy has been selected and deselects other moods
             *
             * @param v     The view of the button that has been clicked
             */
            public void onClick(View v) {
                happyBtn.setBackgroundResource(R.drawable.rounded_corners_selected);
                vHappyBtn.setBackgroundResource(R.drawable.rounded_corners);
                unhappyBtn.setBackgroundResource(R.drawable.rounded_corners);
                vUnhappyBtn.setBackgroundResource(R.drawable.rounded_corners);
            }
        });

        vHappyBtn.setOnClickListener(new View.OnClickListener() {
            /**
             * A method to show very happy has been selected and deselects other moods
             *
             * @param v     The view of the button that has been clicked
             */
            public void onClick(View v) {
                vHappyBtn.setBackgroundResource(R.drawable.rounded_corners_selected);
                happyBtn.setBackgroundResource(R.drawable.rounded_corners);
                unhappyBtn.setBackgroundResource(R.drawable.rounded_corners);
                vUnhappyBtn.setBackgroundResource(R.drawable.rounded_corners);
            }
        });

        unhappyBtn.setOnClickListener(new View.OnClickListener() {
            /**
             * A method to show unhappy has been selected and deselects other moods
             *
             * @param v     The view of the button that has been clicked
             */
            public void onClick(View v) {
                unhappyBtn.setBackgroundResource(R.drawable.rounded_corners_selected);
                happyBtn.setBackgroundResource(R.drawable.rounded_corners);
                vHappyBtn.setBackgroundResource(R.drawable.rounded_corners);
                vUnhappyBtn.setBackgroundResource(R.drawable.rounded_corners);
            }
        });

        vUnhappyBtn.setOnClickListener(new View.OnClickListener() {
            /**
             * A method to show very unhappy has been selected and deselects other moods
             *
             * @param v     The view of the button that has been clicked
             */
            public void onClick(View v) {
                vUnhappyBtn.setBackgroundResource(R.drawable.rounded_corners_selected);
                happyBtn.setBackgroundResource(R.drawable.rounded_corners);
                vHappyBtn.setBackgroundResource(R.drawable.rounded_corners);
                unhappyBtn.setBackgroundResource(R.drawable.rounded_corners);
            }
        });



        getDialog().setOnCancelListener(new DialogInterface.OnCancelListener() {
            /**
             * A method to reset the mood icon when the mood popup closes.
             *
             * @param dialog    The dialog that was canceled will be passed into the
             *                  method
             */
            @Override
            public void onCancel(DialogInterface dialog) {
                MainActivity mainAct = (MainActivity) getActivity();
                mainAct.resetMoodIcon();
            }
        });
        return moodView;
    }


}
