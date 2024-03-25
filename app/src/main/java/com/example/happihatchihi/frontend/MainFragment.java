package com.example.happihatchihi.frontend;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.example.happihatchihi.R;


public class MainFragment extends Fragment {

    // Interface so MainFragment can access method in MainActivity
    public interface WaterWarningClickListener {
        void waterWarningClicked(MainFragment main);
    }
    private WaterWarningClickListener listener;

    // Empty constructor was required
    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: Add animation when Hatchi is clicked
       // startAnimateHatchi();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }



    @Override
    public void onViewCreated(@Nullable View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (view != null) {

            // Find the water warning image button
            ImageButton waterWarningBtn = view.findViewById(R.id.waterWarningImgBtn);
            if (waterWarningBtn != null) {
                waterWarningBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.waterWarningClicked(new MainFragment());
                        }
                    }
                });
            }
        }
        if(getActivity() instanceof WaterWarningClickListener) {
            setWaterWarningClickListener((WaterWarningClickListener) getActivity());
        }
    }

    public void setWaterWarningClickListener(WaterWarningClickListener listener) {
        this.listener = listener;
    }

    public void hideWaterWarning() {
        // Hides water warning if not already hidden
        View view = getView();
        if (view != null) {
            Log.e("hide", "view is not null");
            ImageButton waterWarning = view.findViewById(R.id.waterWarningImgBtn);
            if (waterWarning != null) {
                Log.e("hide", "waterwarning is not null");
                waterWarning.setVisibility(View.GONE);
            }
        }

    }

/**
 * Not working yet
    public void startAnimateHatchi(){
        ImageButton button = (ImageButton)getActivity().findViewById(R.id.hatchiImgBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundResource(R.drawable.hatchi_animation_4);
                AnimationDrawable frameAnimation = (AnimationDrawable) button.getBackground();
                frameAnimation.start();
            }
        });

    }
 **/
}