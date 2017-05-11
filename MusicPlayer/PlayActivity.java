package com.bmpl.playingmusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener{

    Button playButton, pauseButton, stopButton;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        playButton = (Button)findViewById(R.id.playButton);
        pauseButton = (Button)findViewById(R.id.pauseButton);
        stopButton = (Button)findViewById(R.id.stopButton);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        //mediaPlayer.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.playButton:
                mediaPlayer.start();
                break;

            case R.id.pauseButton:
                mediaPlayer.pause();
                break;

            case R.id.stopButton:
                mediaPlayer.stop();
                break;
        }
    }
}