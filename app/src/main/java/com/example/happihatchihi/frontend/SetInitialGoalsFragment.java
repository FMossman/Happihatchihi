package com.example.happihatchihi.frontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.happihatchihi.R;

public class SetInitialGoalsFragment extends Fragment {

    /**
     * Default constructor for SetInitialGoalsFragment.
     * Required empty public constructor.
     */
    public SetInitialGoalsFragment() {
        // Required empty public constructor
    }

    public static SetInitialGoalsFragment newInstance() {
        SetInitialGoalsFragment fragment = new SetInitialGoalsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setinitialgoals, container, false);

        RadioGroup radioGroup = view.findViewById(R.id.initialGoalsRadioGroup);
        Button nextButton = view.findViewById(R.id.initialGoalsNextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId == R.id.waterRadioButtonInitialGoals) {
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new SetInitialGoalDetailsWaterFragment()).commit();
                } else if (selectedRadioButtonId == R.id.fruitAndVegRadioButtonInitialGoals) {
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new SetInitialGoalDetailsFruitAndVegFragment()).commit();
                } else if (selectedRadioButtonId == R.id.meditationRadioButtonInitialGoals) {
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new SetInitialGoalDetailsMeditationFragment()).commit();
                } else if (selectedRadioButtonId == R.id.customGoalRadioButtonInitialGoals) {
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new SetInitialGoalDetailsCustomGoalFragment()).commit();
                } else {
                    // No radio button selected
                }
            }
        });
        return view;
    }
}