package com.example.happihatchihi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    private NavigationBarView.OnItemSelectedListener itemSelectedListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    if (menuItem.getItemId() == R.id.profile) {
                        selectedFragment = new ProfileFragment();
                    } else if (menuItem.getItemId() == R.id.stats) {
                        selectedFragment = new StatsFragment();
                    } else if (menuItem.getItemId() == R.id.mood) {
                        selectedFragment = new MoodFragment();
                    } else if (menuItem.getItemId() == R.id.track) {
                        selectedFragment = new TrackFragment();
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                        return true;
                    }
                    return false;
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting rid of tint on navigation buttons
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnItemSelectedListener(itemSelectedListener);

        // Optionally, set a default fragment to display
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
    }
}

