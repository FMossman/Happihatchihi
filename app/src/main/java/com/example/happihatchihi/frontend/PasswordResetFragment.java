package com.example.happihatchihi.frontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.happihatchihi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
/**
 * A fragment that allows users to reset their password.
 */
public class PasswordResetFragment extends Fragment {


    public PasswordResetFragment() {
        // Required empty public constructor
    }

    public static PasswordResetFragment newInstance() {
        PasswordResetFragment fragment = new PasswordResetFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgotpassword, container, false);

        EditText emailEditText = view.findViewById(R.id.editTextEmailAddress);
        Button submitButton = view.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getActivity(), "Please enter an email address", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(getActivity(), "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                } else {
                    // Email address is valid, perform further actions
                    Toast.makeText(getActivity(), "Password reset link sent", Toast.LENGTH_SHORT).show();
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
                }
            }
        });

        


        return view;
    }

    
}