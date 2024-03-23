package com.example.happihatchihi.frontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.happihatchihi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Represents the SetInitialGoals screen of the application.
 * Use the {@link SetInitialGoalsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetInitialGoalsFragment extends Fragment {

    /**
     * Default constructor for SetInitialGoalsFragment.
     * Required empty public constructor.
     */
    public SetInitialGoalsFragment() {
        // Required empty public constructor
    }

    public static SetInitialGoalsFragment newInstance(String param1, String param2) {
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

        Button nextButton = view.findViewById(R.id.initialGoalsNextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new SetInitialGoalDetailsFragment()).commit();
            }
        });
        return view;
    }
}