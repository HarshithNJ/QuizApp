package com.example.quizapp;

public class QuestionAnswer {

    public static String question[] = {
            "1. Which method can be defined only once in a program?",
            "2. Which keyword is used by method to refer to the current object that invoked it?",
            "3. Which of these access specifiers can be used for an interface?",
            "4. Which of the following is correct way of importing an entire package 'pkg'?",
            "5. What is the return type of Constructors?"
    };

    public static String choices[][] = {
            {"a) finalize method","b) main method","c) static method","d) private method"},
            {"a) import","b) this","c) catch","d) abstract"},
            {"a) public","b) protected","c) private","d) All of the mentioned"},
            {"a) Import pkg.","b) import pkg.*","c) Import pkg.*","d) impork pkg."},
            {"a) int","b) float","c) void","d) None of the mentioned"}
    };

    public static String correctAnswers[] ={
            "b) main method",
            "b) this",
            "a) public",
            "b) import pkg.*",
            "d) None of the mentioned"
    };
}
