package com.example.happihatchihi.frontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.happihatchihi.R;

/**
 * A class to hold a stats fragment with information about
 * the users past progress
 */
public class StatsFragment extends Fragment {

    public StatsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        ImageButton backBtn = view.findViewById(R.id.historyBackBtn);
        Button waterBtn = view.findViewById(R.id.waterMoreHistoryBtn);
        Button fruitBtn = view.findViewById(R.id.fruitMoreHistoryBtn);
        Button medBtn = view.findViewById(R.id.medMoreHistoryBtn);
        ImageButton waterHistoryImgBtn = view.findViewById(R.id.waterHistoryImgBtn);
        ImageButton fruitHistoryImgBtn = view.findViewById(R.id.fruitHistoryImgBtn);
        ImageButton meditationHistoryImgBtn = view.findViewById(R.id.meditationHistoryImgBtn);
        LinearLayout waterExpanded = view.findViewById(R.id.waterExpandedLayout);
        LinearLayout fruitExpanded = view.findViewById(R.id.fruitExpandedLayout);
        LinearLayout meditationExpanded = view.findViewById(R.id.medExpandedLayout);
        waterExpanded.setVisibility(View.GONE);
        fruitExpanded.setVisibility(View.GONE);
        meditationExpanded.setVisibility(View.GONE);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment main = new MainFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, main).commit();
            }
        });

        waterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatsWaterFragment water = new StatsWaterFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, water).commit();
            }
        });


        waterHistoryImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waterExpanded.getVisibility() == View.GONE) {
                    waterExpanded.setVisibility(View.VISIBLE);
                    waterHistoryImgBtn.animate().rotation(180);
                }
                else {
                    waterExpanded.setVisibility(View.GONE);
                    waterHistoryImgBtn.animate().rotation(0);
                }
            }
        });

        fruitHistoryImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fruitExpanded.getVisibility() == View.GONE) {
                    fruitExpanded.setVisibility(View.VISIBLE);
                    fruitHistoryImgBtn.animate().rotation(180);
                }
                else {
                    fruitExpanded.setVisibility(View.GONE);
                    fruitHistoryImgBtn.animate().rotation(0);
                }
            }
        });

        meditationHistoryImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (meditationExpanded.getVisibility() == View.GONE) {
                    meditationExpanded.setVisibility(View.VISIBLE);
                    meditationHistoryImgBtn.animate().rotation(180);
                }
                else {
                    meditationExpanded.setVisibility(View.GONE);
                    meditationHistoryImgBtn.animate().rotation(0);
                }
            }
        });


        return view;
    }


}