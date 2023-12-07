package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.firstapplication.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    HashMap<String, String> morseLetter = new HashMap<String, String>(){{
        put("A",".-");
        put("B","-...");
        put("C","-.-.");
        put("D","-..");
        put("E",".");
        put("F","..-.");
        put("G","--.");
        put("H","....");
        put("I","..");
        put("J",".---");
        put("K","-.-");
        put("L",".-..");
        put("M","--");
        put("N","-.");
        put("O","---");
        put("P",".--.");
        put("Q","--.-");
        put("R",".-.");
        put("S","...");
        put("T","-");
        put("U","..-");
        put("V","...-");
        put("W",".--");
        put("X","-..-");
        put("Y","-.--");
        put("Z","--..");
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












    }

    private void playMorseCode(String word2) {
        for (int i = 0; i < word2.length(); i++) {
            String morsecode = morseLetter.get(String.valueOf(word2.charAt(i)));
            for (int j = 0; j < morsecode.length(); j++) {
                if(morsecode.charAt(j) == '.'){
                  playDot();
                }else if(morsecode.charAt(j) == '-'){
                   playDash();
                }else{

                    playNothing();
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
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void playDash() {
        final MediaPlayer mediaPlayer2 = MediaPlayer.create(this,R.raw.beep2);
        mediaPlayer2.start();

        try {
            Thread.sleep(500);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mediaPlayer2.stop();
    }

    private void playDot() {
        final MediaPlayer mediaPlayer1 = MediaPlayer.create(this,R.raw.beep1);
        mediaPlayer1.start();
        try {
            Thread.sleep(400);

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