package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Quiz extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestions;
    TextView scoreCount;

    public static final String NAME= "NAME";
    TextView mname;
    private String name;
    TextView Question;
    Button ansA,ansB,ansC,ansD,Submit,Quit;

    int score =0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        totalQuestions = (TextView) findViewById(R.id.total_questions);
        Question = (TextView) findViewById(R.id.question);
        ansA = (Button) findViewById(R.id.ans_A);
        ansB = (Button) findViewById(R.id.ans_B);
        ansC = (Button) findViewById(R.id.ans_C);
        ansD = (Button) findViewById(R.id.ans_D);
        Submit = (Button) findViewById(R.id.submit);
        mname =(TextView) findViewById(R.id.mName);
        scoreCount = (TextView)findViewById(R.id.score);
        Intent i=getIntent();
        name = i.getStringExtra(NAME);
        mname.setText("Hello "+name);


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        Submit.setOnClickListener(this);

        totalQuestions.setText("Total Questions : "+totalQuestion);

        loadNewQuestion();
    }

    private void loadNewQuestion() {

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        Question.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    private void finishQuiz() {
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus ="PASSED";
        }else{
            passStatus = "BETTER LUCK NEXT TIME";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+score+" Out of "+totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setNegativeButton("Result", (dialogInterface, i) -> onnxt())
                .setCancelable(true)
                .show();

    }

    void onnxt(){
        Intent i = new Intent(Quiz.this, Result.class);
        i.putExtra("score", score);
        startActivity(i);
    }

    void restartQuiz(){
        Intent intent = new Intent(Quiz.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        ansA.setBackgroundColor(Color.BLACK);
        ansB.setBackgroundColor(Color.BLACK);
        ansC.setBackgroundColor(Color.BLACK);
        ansD.setBackgroundColor(Color.BLACK);

        Button clickedBtn = (Button) v;
        if(clickedBtn.getId()==R.id.submit){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
                scoreCount.setText(String.valueOf(score));
            }
            currentQuestionIndex++;
            loadNewQuestion();

        }else {
            selectedAnswer = clickedBtn.getText().toString();
            clickedBtn.setBackgroundColor(Color.MAGENTA);
        }

        Quit = (Button) findViewById(R.id.quit);
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Quiz.this, Result.class);
                startActivity(intent);
            }
        });

    }
}