package com.example.happihatchihi.frontend;

import java.util.List;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.view.View;


import com.example.happihatchihi.R;

/**
* The Meditation class allows the user to play a track for
* a certain period of time selected using radio buttons.
* There is also a message displayed with each track in a text view.
 */
public class Meditation extends AppCompatActivity {
    private MediaPlayer hatchiPlayer;
    private int trackPlaying = 0;
    private List<String> playList;
    //Default of 2mins
    private int durationOfMeditation = 120000;

    /**
    * Method to set up hatchi player and initialize meditation activity
    * @param inputValues Object containing values to start the activity
     **/
    @Override
    public void onCreate(Bundle inputValues){
        super.onCreate(inputValues);
        setContentView(R.layout.activity_meditate);

        playList = new ArrayList<>();
        playList.add("piano");
        playList.add("ocean");
        hatchiPlayer = MediaPlayer.create(
                this, getMoodTracksId(playList.get(trackPlaying)));
        timeSelection();
    }

    /**
    *Method to fetch the tracks ID from the raw folder
    *@params nameOfTrack Name of the track to fetch the ID for
    *@return ID of the track
     */
    @SuppressLint("DiscouragedApi")
    private int getMoodTracksId(String nameOfTrack){
        return getResources().getIdentifier(
                nameOfTrack, "raw", getPackageName());
    }
    /**
    *Method to change the track duration field depending on the radio button selected
     */
    private void timeSelection(){
        RadioGroup duration = findViewById(R.id.durationRadioGroup);
        duration.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radio2mins){
                    durationOfMeditation = 120000;//2mins
                }
                else if(checkedId == R.id.radio4mins){
                    durationOfMeditation = 240000;//4mins
                }
                else if (checkedId == R.id.radio8mins){
                    durationOfMeditation = 480000; // 8mins
                }}
        });
    }
    /**
    *Method to change to the previous track
     */
    private void playPrevious() {
        if (trackPlaying > 0) {
            trackPlaying -= 1;
        } else {
            return;
        }
        playTrack();
    }
    /**
    *Method to change to the next track
     */
    private void playNext(){
        if(trackPlaying < playList.size()-1){
            trackPlaying += 1;
        }
        playTrack();
    }
    /**
    *Method to - play the track and set the text of the meditation page
     */
    private void playTrack() {
        if (hatchiPlayer != null) {
            hatchiPlayer.release();
        }
        hatchiPlayer = MediaPlayer.create(
                this, getMoodTracksId(playList.get(trackPlaying)));
        //Set the mood text window
        TextView moodView = findViewById(R.id.moodView);
        if (trackPlaying == 0) {
            moodView.setText("You are a HappiHatchi. Listen to the tranquil sound of the piano." +
                    "Relax, all your Hatchi problems will vanish away.");
        } else if (trackPlaying == 1) {
            moodView.setText("Breath in and out with the soothing sound of the ocean." +
                    "Let the waves wash all your Hatchi worries away.");
        }
//        Starts the track playing with the duration provided
        hatchiPlayer.start();
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (hatchiPlayer != null && hatchiPlayer.isPlaying()) {
                    hatchiPlayer.pause();
                    hatchiPlayer.seekTo(0); // Rewind the track
                    ((Button) findViewById(R.id.playButton)).setText("Play");
                }
            }
        }, durationOfMeditation);
    }
    /**Next button onClick method
    @param v A View object
     */
    public void onNextClicked(View v){
            playNext();
    }
    /**Previous button onClick method
    @param v A View object
     */
    public void onPreviousClicked(View v){
        playPrevious();
    }
    /**play audio onClick method
    @param v: A View object
     */
    public void playAudio(View v){
        if(hatchiPlayer.isPlaying()){
            hatchiPlayer.pause();
            ((Button)v).setText("Play");
        }else{
            playTrack();
            ((Button)v).setText("Pause");
        }}
    public void backToHome(View v){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("showNav", true);
        i.putExtra("showMainFrag", true);
        startActivity(i);
        if(hatchiPlayer.isPlaying()) {
            hatchiPlayer.pause();
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (hatchiPlayer != null){
            hatchiPlayer.release();
            hatchiPlayer = null;
        }
    }
}
