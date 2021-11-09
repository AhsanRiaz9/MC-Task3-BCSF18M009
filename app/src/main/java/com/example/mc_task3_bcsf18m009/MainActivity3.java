package com.example.mc_task3_bcsf18m009;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    Button nextBtn;
    TextView alphabet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        nextBtn = findViewById(R.id.nextBtn);
        alphabet = findViewById(R.id.arabicLetter);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphabet.setText(getRandomOption());
            }
        });
    }
    publin int getRandomInt()
    {
        Random rand = new Random();
        return rand.nextInt(30);
    }

    public String getRandomOption()
    {
        String [] catLists = {"Makharij","Lahatiyah","Shajariyah-Haafiyah","Tarfiyah","Nit-eeyah","Lisaveyah","Ghunna"};
        String [] alphabet = {"۱","ب","پ","ت","ث","ج","ح","خ","د", "ذ","ر","ز",
                "س","ش","ص",
                "ض","ط","ظ",
                "ع","غ","ف",
                "ق","ک","ل",
                "م","ن","ہ",
                "و","ی"};
        Random rand = new Random();
        int index = rand.nextInt(30);
        return alphabet[index];
    }

}