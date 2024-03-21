package com.example.happihatchihi.frontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

    /**
     * Called when the view for this fragment is created.
     * Inflates the layout for this fragment and sets up the click listeners for the SetInitialGoals button,
     * register text view, and forgot password text view.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container          The parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return The View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setinitialgoals, container, false);


        return view;
    }
}