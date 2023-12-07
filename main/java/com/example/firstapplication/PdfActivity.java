package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firstapplication.databinding.ActivityPdfBinding;
import com.pdfview.PDFView;

public class PdfActivity extends AppCompatActivity {

    ActivityPdfBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding = ActivityPdfBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.activityMainPdfView.fromAsset("morsepdf2.pdf").show();

        binding.backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PdfActivity.this, MainActivity.class);
                startActivity(i);
            }
        });




    }
}