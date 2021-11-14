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
    QuestionPool questionPool;
    Question q;
    Button op1,op2,op3,op4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        nextBtn = findViewById(R.id.nextBtn);
        alphabet = findViewById(R.id.arabicLetter);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.op3);
        op4 = findViewById(R.id.op4);
        questionPool = new QuestionPool();
        q = questionPool.getRandomQuestion();
        alphabet.setText(q.letter);
        op1.setText(q.op1);
        op2.setText(q.op2);
        op3.setText(q.op3);
        op4.setText(q.op4);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                q = questionPool.getRandomQuestion();
                alphabet.setText(q.letter);
                op1.setText(q.op1);
                op2.setText(q.op2);
                op3.setText(q.op3);
                op4.setText(q.op4);
            }
        });
    }

    public String getRandomOption()
    {
        String [] catLists = {"Halqiyah","Lahatiyah","Shajariyah-Haafiyah","Tarfiyah","Nit-eeyah","Lisaveyah","Ghunna"};
        String [] alphabet = {"۱","ب","ت","ث","ج","ح","خ","د","ذ","ر","ز","س","ش","ص","ض","ط","ظ","ع","غ","ف","ق","ک","ل","م","ن","ہ","و","ی"};
        String [] s1 = {"ا", "ہ", "ع","ح","غ","خ"};
        String [] s2 = {"ق","ک"};
        String [] s3 = {"ج","ش","ی","ض"};
        String [] s4 = {"ل","ن","ر"};
        String [] s5 = {"ط","د","ت"};
        String [] s6 = {"ظ","ذ","ث"};
        String [] s7 = {"م","ن"};
        Random rand = new Random();
        int index = rand.nextInt(28);
        return alphabet[index];
    }

}