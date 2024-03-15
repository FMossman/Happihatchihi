package com.example.happihatchihi.frontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.happihatchihi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    // Field for holding the bottom navigation
    private BottomNavigationView bottomNavigationView;

    private final NavigationBarView.OnItemSelectedListener itemSelectedListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    if (menuItem.getItemId() == R.id.profile) {
                        selectedFragment = new ProfileFragment();
                        menuItem.setIcon(R.drawable.profile_selected);

                        bottomNavigationView.getMenu().findItem(R.id.mood).setIcon(R.drawable.mood_icon);
                        bottomNavigationView.getMenu().findItem(R.id.stats).setIcon(R.drawable.stats_svg);
                        bottomNavigationView.getMenu().findItem(R.id.track).setIcon(R.drawable.track_icon);


                    } else if (menuItem.getItemId() == R.id.stats) {
                        selectedFragment = new StatsFragment();
                        menuItem.setIcon(R.drawable.stats_selected);

                        bottomNavigationView.getMenu().findItem(R.id.mood).setIcon(R.drawable.mood_icon);
                        bottomNavigationView.getMenu().findItem(R.id.profile).setIcon(R.drawable.profile_icon);
                        bottomNavigationView.getMenu().findItem(R.id.track).setIcon(R.drawable.track_icon);

                    } else if (menuItem.getItemId() == R.id.mood) {
                        selectedFragment = new MoodFragment();
                        menuItem.setIcon(R.drawable.mood_selected);

                        bottomNavigationView.getMenu().findItem(R.id.profile).setIcon(R.drawable.profile_icon);
                        bottomNavigationView.getMenu().findItem(R.id.stats).setIcon(R.drawable.stats_svg);
                        bottomNavigationView.getMenu().findItem(R.id.track).setIcon(R.drawable.track_icon);

                    } else if (menuItem.getItemId() == R.id.track) {
                        selectedFragment = new TrackFragment();
                        menuItem.setIcon(R.drawable.track_selected);

                        bottomNavigationView.getMenu().findItem(R.id.mood).setIcon(R.drawable.mood_icon);
                        bottomNavigationView.getMenu().findItem(R.id.stats).setIcon(R.drawable.stats_svg);
                        bottomNavigationView.getMenu().findItem(R.id.profile).setIcon(R.drawable.profile_icon);
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                        return true;
                    }
                    return false;
                }
            };




    // Runs when app is opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting to the bottom navigation xml
        bottomNavigationView = findViewById(R.id.bottomNavView);
        // Getting rid of tint on navigation buttons
        bottomNavigationView.setItemIconTintList(null);
        // Setting up the listener to tell when an icon is clicked
        bottomNavigationView.setOnItemSelectedListener(itemSelectedListener);

        // Setting the first fragment to display login screen
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();

        bottomNavigationView.setVisibility(View.GONE);

        //bottomNavigationView.visibility = View.VISIBLE

        }
    }







