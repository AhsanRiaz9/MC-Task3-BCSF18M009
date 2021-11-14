package com.example.mc_task3_bcsf18m009;

import static android.graphics.Color.parseColor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    Button nextBtn;
    TextView alphabet, correctAns;
    QuestionPool questionPool;
    Question q;
    Button op1,op2,op3,op4;
    int defaultColor;
    int correctColor;
    int wrongColor;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        // color initlization
        defaultColor = parseColor("#78432C");
        correctColor = parseColor("#0f8425");
        wrongColor = parseColor("#b71249");
        nextBtn = findViewById(R.id.nextBtn);
        alphabet = findViewById(R.id.arabicLetter);
        correctAns = findViewById(R.id.correctAns);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.op3);
        op4 = findViewById(R.id.op4);
        nextBtn.setOnClickListener(this);
        op1.setOnClickListener(this);
        op2.setOnClickListener(this);
        op3.setOnClickListener(this);
        op4.setOnClickListener(this);

        questionPool = new QuestionPool();
        q = questionPool.getRandomQuestion();
        alphabet.setText(q.letter);
        op1.setText(q.op1);
        op2.setText(q.op2);
        op3.setText(q.op3);
        op4.setText(q.op4);
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

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.nextBtn:
                q = questionPool.getRandomQuestion();
                alphabet.setText(q.letter);
                op1.setText(q.op1);
                op2.setText(q.op2);
                op3.setText(q.op3);
                op4.setText(q.op4);
                flag = false;
                resetColor();
                correctAns.setText("");
                break;
            case R.id.op1:
                if(flag==false)
                {
                    changeBtnColors(op1,isCorrectAnswer(op1.getText().toString()));
                    correctAns.setText("Correct: " + q.correctOption.toUpperCase());
                    flag = true;
                }
                break;
            case R.id.op2:
                if(flag==false)
                {
                    changeBtnColors(op2,isCorrectAnswer(op2.getText().toString()));
                    correctAns.setText("Correct: " + q.correctOption.toUpperCase());
                    flag = true;
                }
                break;
            case R.id.op3:
                if(flag==false)
                {
                    changeBtnColors(op3,isCorrectAnswer(op3.getText().toString()));
                    correctAns.setText("Correct: " + q.correctOption.toUpperCase());
                    flag = true;
                }
                break;
            case R.id.op4:
                if(flag==false)
                {
                    changeBtnColors(op4,isCorrectAnswer(op4.getText().toString()));
                    correctAns.setText("Correct: " + q.correctOption.toUpperCase());
                    flag = true;
                }
                break;
        }
    }
    void changeBtnColors(Button btn, boolean dec)
    {
        if(dec==true)
        {
            btn.setBackgroundColor(correctColor);
        }
        else
        {
            btn.setBackgroundColor(wrongColor);
        }
    }
    void resetColor()
    {
        op1.setBackgroundColor(defaultColor);
        op2.setBackgroundColor(defaultColor);
        op3.setBackgroundColor(defaultColor);
        op4.setBackgroundColor(defaultColor);
    }

    boolean isCorrectAnswer(String ans)
    {
        return ans==q.correctOption;
    }

}