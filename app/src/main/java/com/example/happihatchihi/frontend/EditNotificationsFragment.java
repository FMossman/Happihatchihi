package com.example.happihatchihi.frontend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.example.happihatchihi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EditNotificationsFragment extends Fragment {

    public EditNotificationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editnotifications, container, false);

        final ImageButton back = view.findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ProfileFragment())
                        .commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        SwitchCompat allNotificationSwitch = view.findViewById(R.id.allNotificationsSwitch);
        allNotificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Get references to the other switches
                SwitchCompat switch1 = view.findViewById(R.id.waterNotificationsSwitch);
                SwitchCompat switch2 = view.findViewById(R.id.fruitandVegNotificationsSwitch);
                SwitchCompat switch3 = view.findViewById(R.id.meditationNotificationsSwitch);
                // Set the state of the other switches based on the state of the allNotificationSwitch
                switch1.setChecked(isChecked);
                switch2.setChecked(isChecked);
                switch3.setChecked(isChecked);
            }
        });

        Button editNotificationsConfirmButton = view.findViewById(R.id.editNotificationsConfirmButton);
        editNotificationsConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ProfileFragment())
                        .commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });



        return view;
    }


}

