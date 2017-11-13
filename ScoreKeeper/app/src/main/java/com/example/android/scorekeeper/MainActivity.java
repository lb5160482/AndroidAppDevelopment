package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int scoreA = 0;
    private int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayA() {
        TextView tv = (TextView)findViewById(R.id.team_a_score_text_view);
        tv.setText(Integer.toString(scoreA));
    }

    private void displayB() {
        TextView tv = (TextView)findViewById(R.id.team_b_score_text_view);
        tv.setText(Integer.toString(scoreB));
    }

    public void addThreeA(View view) {
        scoreA += 3;
        displayA();
    }

    public void addThreeB(View view) {
        scoreB += 3;
        displayB();
    }

    public void addTwoA(View view) {
        scoreA += 2;
        displayA();
    }

    public void addTwoB(View view) {
        scoreB += 2;
        displayB();
    }

    public void addOneA(View view) {
        scoreA += 1;
        displayA();
    }

    public void addOneB(View view) {
        scoreB += 1;
        displayB();
    }

    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayA();
        displayB();
    }
}