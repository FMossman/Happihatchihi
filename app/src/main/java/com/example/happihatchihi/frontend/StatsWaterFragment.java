package com.example.happihatchihi.frontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.happihatchihi.R;

/**
 * A fragment for holding information about a goal's history.
 */
public class StatsWaterFragment extends Fragment {




    public StatsWaterFragment() {
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
        View view = inflater.inflate(R.layout.fragment_stats_water, container, false);

        ImageButton historyBackBtn = view.findViewById(R.id.historyBackBtn);
        ImageButton todayHistoryImgBtn = view.findViewById(R.id.todayHistoryImgBtn);
        ImageButton weekHistoryImgBtn = view.findViewById(R.id.weekHistoryImgBtn);
        ImageButton monthHistoryImgBtn = view.findViewById(R.id.monthHistoryImgBtn);
        LinearLayout todayExpanded = view.findViewById(R.id.todayExpandedLayout);
        LinearLayout weekExpanded = view.findViewById(R.id.weekExpandedLayout);
        LinearLayout monthExpanded = view.findViewById(R.id.monthExpandedLayout);
        todayExpanded.setVisibility(View.GONE);
        weekExpanded.setVisibility(View.GONE);
        monthExpanded.setVisibility(View.GONE);

        historyBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatsFragment stats = new StatsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, stats).commit();
            }
        });

        todayHistoryImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (todayExpanded.getVisibility() == View.GONE) {
                    todayExpanded.setVisibility(View.VISIBLE);
                    todayHistoryImgBtn.animate().rotation(180);
                }
                else {
                    todayExpanded.setVisibility(View.GONE);
                    todayHistoryImgBtn.animate().rotation(0);
                }
            }
        });

        weekHistoryImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weekExpanded.getVisibility() == View.GONE) {
                    weekExpanded.setVisibility(View.VISIBLE);
                    weekHistoryImgBtn.animate().rotation(180);
                }
                else {
                    weekExpanded.setVisibility(View.GONE);
                    weekHistoryImgBtn.animate().rotation(0);
                }
            }
        });

        monthHistoryImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (monthExpanded.getVisibility() == View.GONE) {
                    monthExpanded.setVisibility(View.VISIBLE);
                    monthHistoryImgBtn.animate().rotation(180);
                }
                else {
                    monthExpanded.setVisibility(View.GONE);
                    monthHistoryImgBtn.animate().rotation(0);
                }
            }
        });

        return view;
    }
}