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
 * Represents the login screen of the application.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Default constructor for LoginFragment.
     * Required empty public constructor.
     */
    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
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
     * Inflates the layout for this fragment and sets up the click listeners for the login button,
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Set up click listener for the login button
        final Button button = view.findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Replace the current fragment with the MainFragment
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
                // Show the bottom navigation view
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        // Set up click listener for the register text view
        final TextView registerTextView = view.findViewById(R.id.RegisterTextView);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Replace the current fragment with the RegisterFragment
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new RegisterFragment()).commit();
            }
        });

        // Set up click listener for the forgot password text view
        final TextView forgotPasswordTextView = view.findViewById(R.id.forgotPasswordTextView);
        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Replace the current fragment with the PasswordResetFragment
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new PasswordResetFragment()).commit();
            }
        });

        return view;
    }


}