package com.example.happihatchihi.frontend;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happihatchihi.R;


public class TrackPopupFragment extends DialogFragment {


    private TrackPopupAdapter adapter;
    private MainFragment mainFrag;

    public TrackPopupFragment(MainFragment mainFrag) {
        this.mainFrag = mainFrag;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);


        View mainView = inflater.inflate(R.layout.track_pop_up, container, false);
        View rowView = inflater.inflate(R.layout.goal_row, container, false);
        RecyclerView recyclerView = mainView.findViewById(R.id.goal_recycler_view);

        adapter = new TrackPopupAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        Button doneBtn = mainView.findViewById(R.id.doneBtn);
        Button startBtn = rowView.findViewById(R.id.startBtn);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            /**
             * A method to close the track popup if done is clicked
             *
             * @param v     The view of the button that has been clicked
             */
            public void onClick(View v) {
                MainActivity mainAct = (MainActivity) getActivity();
                mainAct.resetTrackIcon();
                if (mainFrag != null) {
                    mainFrag.hideWaterWarning();
                }
                else {
                    Log.e("TrackPopupFragment", "MainFragment is null");
                }
                dismiss();
            }
        });

        if (startBtn != null) {
            startBtn.setOnClickListener(new View.OnClickListener() {
                /**
                 * A method to close the track popup if done is clicked
                 *
                 * @param v     The view of the button that has been clicked
                 */
                @Override
                public void onClick(View v) {
                    Log.d("TrackPopupFragment", "Start button clicked");
                    Intent i = new Intent(getActivity(), Meditation.class);
                    startActivity(i);
                    dismiss();
                }
            });
        }



        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        getDialog().setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                MainActivity mainAct = (MainActivity) getActivity();
                mainAct.resetTrackIcon();
            }
        });
        return mainView;
    }

}
