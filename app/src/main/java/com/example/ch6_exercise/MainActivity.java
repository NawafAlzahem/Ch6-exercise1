package com.example.ch6_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
Button btMarimba,btMerenque;
MediaPlayer mpMarimba,mpMerenque;
int playing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btMarimba = (Button) findViewById(R.id.button1);
        btMerenque = (Button) findViewById(R.id.button2);

        btMarimba.setOnClickListener(bMarimba);
        btMerenque.setOnClickListener(bMerenque);

        mpMarimba = new MediaPlayer();
        mpMerenque = new MediaPlayer();

        playing = 0;
    }
        View.OnClickListener bMarimba= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(playing){
                    case 0:
                        mpMarimba=MediaPlayer.create(getApplicationContext(),R.raw.song1);
                        mpMarimba.start();
                        playing=1;
                        btMarimba.setText("pause marimba song");
                        btMerenque.setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        mpMarimba.stop();
                        playing=0;
                        btMarimba.setText("play marimba song");
                        btMerenque.setVisibility(View.VISIBLE);
                        break;

                }

            }
        };
        View.OnClickListener bMerenque= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(playing){
                    case 0:
                        mpMerenque=MediaPlayer.create(getApplicationContext(),R.raw.song2);
                        mpMerenque.start();
                        playing=1;
                        btMerenque.setText("pause merenque song");
                        btMarimba.setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        mpMerenque.stop();
                        playing=0;
                        btMerenque.setText("play merenque song");
                        btMarimba.setVisibility(View.VISIBLE);
                        break;

                }

            }
        };






}