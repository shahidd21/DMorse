package com.example.firstapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapplication.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    HashMap<String, String> morseLetter = new HashMap<String, String>(){{
        put("A","._");
        put("B","_...");
        put("C","_._.");
        put("D","_..");
        put("E",".");
        put("F",".._.");
        put("G","__.");
        put("H","....");
        put("I","..");
        put("J",".___");
        put("K","_._");
        put("L","._..");
        put("M","__");
        put("N","_.");
        put("O","___");
        put("P",".__.");
        put("Q","__._");
        put("R","._.");
        put("S","...");
        put("T","_");
        put("U",".._");
        put("V","..._");
        put("W",".__");
        put("X","_.._");
        put("Y","_.__");
        put("Z","__..");
        put(" ","  ");
    }};

    String word=" ";
    String word2=" ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());



        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                word = binding.textbox.getText().toString();
                word2 = word.toUpperCase();

                printMorse(word2);
                word="";
            }
        });

        binding.playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                word = binding.textbox.getText().toString();
                word2 = word.toUpperCase();
                playMorseCode(word2);
            }
        });

        binding.morseChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,PdfActivity.class);
                startActivity(i);
            }
        });












    }

    private void playMorseCode(String word2) {

        for (int i = 0; i < word2.length(); i++) {
            String morsecode = morseLetter.get(String.valueOf(word2.charAt(i)));
            for (int j = 0; j < morsecode.length(); j++) {
                if (morsecode.charAt(j) == '.') {
                    playDot();
                } else if (morsecode.charAt(j) == '_') {
                    playDash();
                }
            }
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void playNothing() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void playDash() {
        final MediaPlayer mediaPlayer2 = MediaPlayer.create(this,R.raw.finalbeep2);
        mediaPlayer2.start();

        try {
            Thread.sleep(500);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mediaPlayer2.stop();
    }

    private void playDot() {
        final MediaPlayer mediaPlayer1 = MediaPlayer.create(this,R.raw.finalbeep1);
        mediaPlayer1.start();
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        mediaPlayer1.stop();
    }

    private void printMorse(String word2) {

        String morseLine="";
        for (int i = 0; i < word2.length(); i++) {

           morseLine = morseLine + morseLetter.get(String.valueOf(word2.charAt(i)))+" ";
           binding.morseText.setText(morseLine);
        }
    }
}