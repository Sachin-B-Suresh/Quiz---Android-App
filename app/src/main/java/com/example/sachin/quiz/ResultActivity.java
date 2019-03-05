package com.example.sachin.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/***
 * This Activity displays the quiz result.
 */
public class ResultActivity extends Activity {
    TextView mGrade,mFinalScore;
    Button mRetry,mMenu;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mGrade=(TextView)findViewById(R.id.Grade);
        mFinalScore=(TextView)findViewById(R.id.OutOf);
        mRetry=(Button) findViewById(R.id.Retry);
        mMenu=(Button) findViewById(R.id.Menu);
        Bundle bundle= getIntent().getExtras();
        int score= bundle.getInt("Final Score");
        mFinalScore.setText("You Scored "+ score+ " Out of "+ QuizBook.questions.length);
        if(score == 10)
            mGrade.setText("Outstanding");
        if(score == 9)
            mGrade.setText(" Excellent");
        if(score == 8)
            mGrade.setText("Very Good");
        if(score == 7)
            mGrade.setText("Good");
        if(score== 6)
            mGrade.setText("Need Improvement");
        if(score <= 5)
            mGrade.setText("Better Luck Next Time");
        //This button is used to retry the quiz.
        mRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,QuizActivity.class));
                ResultActivity.this.finish();
            }
        });

        //This button is used to go back to the quiz menu.
        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,MenuActivity.class));
                ResultActivity.this.finish();
            }
        });
    }

}
