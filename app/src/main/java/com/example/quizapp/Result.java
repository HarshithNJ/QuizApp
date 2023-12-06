package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView correctscore, wrongscore, finalscore;

    Button Restart;

    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        correctscore = (TextView) findViewById(R.id.cScore);
        wrongscore =(TextView)findViewById(R.id.wScore);
        finalscore = (TextView)findViewById(R.id.fScore);

        Intent i = getIntent();
        if(i != null) {
            score = i.getIntExtra("score", 0);
        }
        correctscore.setText(String.valueOf(score));
        wrongscore.setText(String.valueOf(5-score));
        finalscore.setText(String.valueOf(score));

        Restart = (Button) findViewById(R.id.Re);
        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Result.this,MainActivity.class);
                startActivity(intent);

                if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){

                }
            }
        });
    }

}