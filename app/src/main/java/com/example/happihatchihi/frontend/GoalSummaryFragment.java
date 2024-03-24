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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    EditText name;
    private String mParam2;
    String nameString;
    SharedPreferences sharedPreferences;

    public GoalSummaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GoalSummaryFragment newInstance(String param1, String param2) {
        GoalSummaryFragment fragment = new GoalSummaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

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
                    SetInitialGoalsFragment fragment = SetInitialGoalDetailsWaterFragment.newInstance(mParam1, mParam2);
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
                    SetInitialGoalsFragment fragment = SetInitialGoalDetailsFruitAndVegFragment.newInstance(mParam1, mParam2);
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
                    SetInitialGoalsFragment fragment = SetInitialGoalDetailsCustomGoalFragment.newInstance(mParam1, mParam2);
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


