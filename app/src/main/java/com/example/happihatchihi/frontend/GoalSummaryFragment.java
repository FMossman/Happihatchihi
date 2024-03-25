package com.example.happihatchihi.frontend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.happihatchihi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * A fragment that allows users to register for an account.
 */
public class GoalSummaryFragment extends Fragment {


    String nameString;
    SharedPreferences sharedPreferences;

    public GoalSummaryFragment() {
        // Required empty public constructor
    }

    public static GoalSummaryFragment newInstance() {
        GoalSummaryFragment fragment = new GoalSummaryFragment();
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
        return inflater.inflate(R.layout.fragment_goalssummary, container, false);
    }



        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            // Find the waterEdit, fruitAndVegEdit, and customEdit image views
            ImageView waterEdit = view.findViewById(R.id.waterEdit);
            ImageView fruitAndVegEdit = view.findViewById(R.id.fruitAndVegEdit);
            ImageView customEdit = view.findViewById(R.id.customEdit);

            // Set onClick listeners for the image views
            waterEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to the WaterGoalDetailsFragment
                    SetInitialGoalsFragment fragment = SetInitialGoalDetailsWaterFragment.newInstance();
                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });

            fruitAndVegEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to the FruitAndVegGoalDetailsFragment
                    SetInitialGoalsFragment fragment = SetInitialGoalDetailsFruitAndVegFragment.newInstance();
                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });

            customEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to the CustomGoalDetailsFragment
                    SetInitialGoalsFragment fragment = SetInitialGoalDetailsCustomGoalFragment.newInstance();
                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });

            Button startButton = view.findViewById(R.id.nextButton);
            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Replace the current fragment with the MainFragment
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
                    // Show the bottom navigation view
                    BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
                    bottomNavigationView.setVisibility(View.VISIBLE);
                }

            });

            ImageView backButton = view.findViewById(R.id.backButton);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to SetInitialGoalsFragment
                    Fragment setInitialGoalsFragment = new SetInitialGoalsFragment();
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, setInitialGoalsFragment)
                            .commit();
                }
            });

    }

                
}


