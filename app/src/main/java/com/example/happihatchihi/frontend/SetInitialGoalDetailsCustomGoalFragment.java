package com.example.happihatchihi.frontend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.happihatchihi.R;

/**
 * A simple {@link Fragment} subclass.
 * Represents the SetInitialGoals screen of the application.
 * Use the {@link SetInitialGoalsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetInitialGoalDetailsCustomGoalFragment extends Fragment {

    /**
     * Default constructor for SetInitialGoalsFragment.
     * Required empty public constructor.
     */
    public SetInitialGoalDetailsCustomGoalFragment() {
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
        

        };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setgoaldetailscustomgoal, container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.frequencySpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                view.getContext(),
                R.array.day_array,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);

        Spinner recurrencespinner = (Spinner) view.findViewById(R.id.recurrenceSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> recurrenceadapter = ArrayAdapter.createFromResource(
                view.getContext(),
                R.array.recurrence_array,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        recurrenceadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        recurrencespinner.setAdapter(recurrenceadapter);

        Spinner notificationspinner = (Spinner) view.findViewById(R.id.notificationSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> notificationadapter = ArrayAdapter.createFromResource(
                view.getContext(),
                R.array.notification_array,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        notificationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        notificationspinner.setAdapter(notificationadapter);

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

        // Add onClick listener for addAnotherGoalButton
        Button addAnotherGoalButton = view.findViewById(R.id.anotherGoalButton);
        addAnotherGoalButton.setOnClickListener(new View.OnClickListener() {
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
        Button nextButton = view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to GoalsSummaryFragment
                Fragment goalsSummaryFragment = new GoalSummaryFragment();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, goalsSummaryFragment)
                        .commit();
            }
        });

        return view;
    }

}