package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Mname;
    Button Start,About;

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mname = (EditText) findViewById(R.id.Name);


        Start =(Button) findViewById(R.id.startbtn);
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendData();

                if(TextUtils.isEmpty(Mname.getText().toString())){
                    Mname.setError("First Enter Your Name to Start a Quiz.");
                    return;
                }
                Toast.makeText(MainActivity.this, "Starting Quiz", Toast.LENGTH_SHORT).show();

                Intent intent;
                intent = new Intent(MainActivity.this, Quiz.class);
                intent.putExtra(Quiz.NAME, name);
                startActivity(intent);
            }
        });

        About =(Button) findViewById(R.id.aboutbtn);
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, AbousUS.class);
                startActivity(intent);
            }
        });
    }
    public void sendData(){
        name = Mname.getText().toString().trim();
    }
}