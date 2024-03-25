package com.example.happihatchihi.frontend;

import android.content.Context; // Add missing import statement
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Patterns;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.happihatchihi.R;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

import java.util.Objects;


/**
 * A fragment that allows users to register for an account.
 */
public class RegistrationLandingFragment extends Fragment {


    public RegistrationLandingFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RegistrationLandingFragment newInstance() {
        RegistrationLandingFragment fragment = new RegistrationLandingFragment();
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
        return inflater.inflate(R.layout.fragment_registrationlandingscreen, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        TextView nameTextView = getView().findViewById(R.id.detailsInstructions); // Initialize nameTextView variable
        nameTextView.setText("Welcome " + name + "! You're about to hatch your Hatchi! It grows and thrives by you meeting your wellbeing goals. Build up your streak and watch your Hatchi grow! In order to get you started, you now need to decide on your wellbeing goals!");
        super.onViewCreated(view, savedInstanceState);
        Button setGoalsButton = view.findViewById(R.id.setGoalsButton);

        setGoalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new SetInitialGoalsFragment()).commit();
                
                
            }
        });

        ImageView backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to RegisterFragment
                Fragment registerFragment = new RegisterFragment();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, registerFragment)
                        .commit();
            }
        });

    };
}