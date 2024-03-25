package com.example.happihatchihi.frontend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.activity.OnBackPressedCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.happihatchihi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // This is an example of handling back button press event
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Your code here
                // For example:
                // Perform some action or navigate back to the previous fragment/activity
            }
        });

        Button resetHatchiBtn = view.findViewById(R.id.resetHatchiBtn);
        resetHatchiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Reset Hatchi?");
                builder.setMessage("Are you sure you wish to reset your Hatchi? You will lose all progress.");
                builder.setPositiveButton("Confirm",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Create another dialog here
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
                            builder2.setCancelable(true);
                            builder2.setTitle("Are you really sure?");
                            builder2.setMessage("This action cannot be undone.");
                            builder2.setPositiveButton("Yes, I'm sure",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new SetInitialGoalsFragment()).commit();
                                    }
                                });
                            builder2.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });

                            AlertDialog dialog2 = builder2.create();
                            dialog2.show();
                        }
                    });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button logoutBtn = view.findViewById(R.id.logOutButton);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
                bottomNavigationView.setVisibility(View.GONE);
            }
        });

        Button editProfileBtn = view.findViewById(R.id.editProfileBtn);
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new EditProfileFragment()).commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
                bottomNavigationView.setVisibility(View.GONE);
            }
        });

        Button pauseHatchiBtn = view.findViewById(R.id.pauseHatchiBtn);
        pauseHatchiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new PauseHatchiFragment()).commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        ImageView backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        Button editNotificationsBtn = view.findViewById(R.id.editNotificationsButton);
        editNotificationsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new EditNotificationsFragment()).commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });
        

        Button editGoalsBtn = view.findViewById(R.id.editGoalsBtn);
        editGoalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new EditGoalsFragment()).commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });
    }
}