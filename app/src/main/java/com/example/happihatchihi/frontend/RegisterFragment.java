package com.example.happihatchihi.frontend;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Patterns;
import com.example.happihatchihi.R;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.content.Context;



/**
 * A fragment that allows users to register for an account.
 */
public class RegisterFragment extends Fragment {

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

    public RegisterFragment() {
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
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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
        return inflater.inflate(R.layout.fragment_register, container, false);
    }



        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            name = view.findViewById(R.id.firstNameEdtTxt);
            sharedPreferences = requireContext().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE); // Initialize sharedPreferences using getContext() method
            EditText editTextPassword = view.findViewById(R.id.editTextPassword);
            EditText editTextConfirmPassword = view.findViewById(R.id.editTextConfirmPassword);
            Button registerButton = view.findViewById(R.id.registerButton);
            EditText emailEditText = view.findViewById(R.id.emailEdtTxt);
        
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();
                String email = emailEditText.getText().toString().trim();
                nameString = name.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", nameString);
                editor.apply();
                EditText firstNameEditText = view.findViewById(R.id.firstNameEdtTxt);
                EditText lastNameEditText = view.findViewById(R.id.lastNameEdtTxt);
                EditText emailEditText = view.findViewById(R.id.emailEdtTxt);
                EditText passwordEditText = view.findViewById(R.id.editTextPassword);
                EditText confirmPasswordEditText = view.findViewById(R.id.editTextConfirmPassword);
                Button registerButton = view.findViewById(R.id.registerButton);
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                        if (firstName.isEmpty()) {
                            Toast.makeText(getActivity(), "Please enter your first name", Toast.LENGTH_SHORT).show();
                        } else if (lastName.isEmpty()) {
                            Toast.makeText(getActivity(), "Please enter your last name", Toast.LENGTH_SHORT).show();
                        } else if (email.isEmpty()) {
                            Toast.makeText(getActivity(), "Please enter your email address", Toast.LENGTH_SHORT).show();
                        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                            Toast.makeText(getActivity(), "The email address is not valid", Toast.LENGTH_SHORT).show();
                        } else if (password.isEmpty()) {
                            Toast.makeText(getActivity(), "Please enter your password", Toast.LENGTH_SHORT).show();
                        } else if (confirmPassword.isEmpty()) {
                            Toast.makeText(getActivity(), "Please re-enter your password", Toast.LENGTH_SHORT).show();
                        } else if (!password.equals(confirmPassword)) {
                            Toast.makeText(getActivity(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                        } else {
                            // Passwords match and email is valid, take user to registration landing screen
                            Toast.makeText(getActivity(), "Account created", Toast.LENGTH_SHORT).show();
                            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new RegistrationLandingFragment()).commit();
                        }
                    }
        });
    }
}
