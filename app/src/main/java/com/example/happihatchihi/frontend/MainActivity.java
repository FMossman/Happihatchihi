package com.example.happihatchihi.frontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.fragment.app.Fragment;
import com.example.happihatchihi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    // Field for holding the bottom navigation
    private BottomNavigationView bottomNavigationView;

    /**
     * A method that sets up the initial activity and fragments
     * as well as the navigation bar when the app is started.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.
     *                           <b><i>Note: Otherwise it is null.</i></b>
     */
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
        // Hides the bottom navigation on login screen
        bottomNavigationView.setVisibility(View.GONE);
    }

    // Setting up the navigation bar
    private final NavigationBarView.OnItemSelectedListener itemSelectedListener =
            new NavigationBarView.OnItemSelectedListener() {
                /**
                 * A method to define the actions taken if each navigation button
                 * is clicked.
                 *
                 * @param menuItem The selected item
                 * @return boolean
                 */
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    if (menuItem.getItemId() == R.id.profile) {
                        selectedFragment = new ProfileFragment();
                        menuItem.setIcon(R.drawable.profile_selected);
                        resetMoodIcon();
                        resetStatsIcon();
                        resetTrackIcon();


                    } else if (menuItem.getItemId() == R.id.stats) {
                        selectedFragment = new StatsFragment();
                        menuItem.setIcon(R.drawable.stats_selected);
                        resetMoodIcon();
                        resetProfileIcon();
                        resetTrackIcon();

                    } else if (menuItem.getItemId() == R.id.mood) {
                        selectedFragment = new MainFragment();
                        menuItem.setIcon(R.drawable.mood_selected);
                        resetProfileIcon();
                        resetStatsIcon();
                        resetTrackIcon();
                        showMoodPopup();

                    } else if (menuItem.getItemId() == R.id.track) {
                        selectedFragment = new MainFragment();
                        menuItem.setIcon(R.drawable.track_selected);
                        resetMoodIcon();
                        resetStatsIcon();
                        resetProfileIcon();
                        showTrackPopup();
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                        return true;
                    }
                    return false;
                }
            };

    /**
     *  A method to show the popup for tracking goals
     */
    private void showTrackPopup() {
        TrackPopupFragment trackPopupFragment = new TrackPopupFragment();
        trackPopupFragment.show(getSupportFragmentManager(), "track_popup_fragment");
    }

    /**
     * A method to show the popup for registering the user's mood
     */
    private void showMoodPopup() {
        MoodPopupFragment moodPopupFragment = new MoodPopupFragment();
        moodPopupFragment.show(getSupportFragmentManager(), "mood_popup_fragment");
    }

    /**
     * A method for resetting the profile icon when not selected
     */
    public void resetProfileIcon() {
        bottomNavigationView.getMenu().findItem(R.id.profile).setIcon(R.drawable.profile_svg);
    }

    /**
     * A method for resetting the stats icon when not selected
     */
    public void resetStatsIcon() {
        bottomNavigationView.getMenu().findItem(R.id.stats).setIcon(R.drawable.stats_svg);
    }

    /**
     * A method for resetting the mood icon when not selected
     */
    public void resetMoodIcon() {
        bottomNavigationView.getMenu().findItem(R.id.mood).setIcon(R.drawable.mood_svg);
    }

    /**
     * A method for resetting the track icon when not selected
     */
    public void resetTrackIcon() {
        bottomNavigationView.getMenu().findItem(R.id.track).setIcon(R.drawable.track_svg);
    }
}








