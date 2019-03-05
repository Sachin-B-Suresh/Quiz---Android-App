package com.example.sachin.quiz;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * This is the Quiz activity.
 * For layout design, refer activity_quiz XML file
 * This activity has majority of the functions
 */
public class QuizActivity extends Activity {
    private TextView mScoreView,mQuestion,mTimer;
    private Button mTrue,mFalse;
    private String mAnswer;
    private int mScore=0;
    private int mQuestionNumber=0;

    /***
     * onCreate(Bundle) is where you initialize your activity.
     * @param savedInstanceState callback is called only when there is a saved instance that is previously saved by using
    // onSaveInstanceState()
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mTimer=(TextView)findViewById(R.id.CountTimer);
        mScoreView=(TextView)findViewById(R.id.Score);
        mQuestion=(TextView)findViewById(R.id.Question);
        mTrue=(Button)findViewById(R.id.TrueButton);
        mFalse=(Button)findViewById(R.id.FalseButton);

        GetQuestions();                           //Function used to read questions provided by admin.
        GetAnswers();                             //Function used to read the answers provided by admin.
        updateQuestion();                         //This function updated the question displayed on the screen.
        new CountDownTimer(30000, 1000) {
            /***
             * Countdown timer
             * @param millisUntilFinished
             */
            public void onTick(long millisUntilFinished) {
                mTimer.setText(""+ (millisUntilFinished / 1000));
            }
            /* A count down counter is used here.
               This counter has a 30 seconds countdown.
            */

            public void onFinish() {
                Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Final Score", mScore);
                i.putExtras(bundle);
                QuizActivity.this.finish();
                startActivity(i);

            }
        }.start();

        //Checks whether true is the right answer

        mTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswer.equals("true")) {
                    mScore++;
                    updateScore(mScore);

                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Final Score", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }
                    else {
                        updateQuestion();
                    }
                }
                else{
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Final Score", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }
                    else {
                        updateQuestion();
                    }
                }
            }
        });

        //Checks whether False is the right answer

        mFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswer.equals("false")) {
                    mScore++;
                    updateScore(mScore);

                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Final Score", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else{
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Final Score", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void GetQuestions(){
        StringBuilder text = new StringBuilder();

        BufferedReader reader = null;
        String Questions;
        String[] FinalQuestions;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("questions.txt")));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                text.append(mLine);
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Error reading file!",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
            Questions=text.toString();
            FinalQuestions=Questions.split(",");
            QuizBook.questions=FinalQuestions;
        }
    }

    public void GetAnswers(){
        StringBuilder text = new StringBuilder();

        BufferedReader reader = null;
        String Answers;
        int i=0;
        String[] FinalAnswers;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("answers.txt")));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                text.append(mLine);
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Error reading file!",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
            Answers=text.toString();
            FinalAnswers=Answers.split(",");
            }
            QuizBook.answers=FinalAnswers;
        }
     private void updateQuestion(){

        mQuestion.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer=QuizBook.answers[mQuestionNumber];
        mQuestionNumber++;
     }

    /**
     * Update score.
     *
     * @param mScore the marks scored in the quiz
     */
    public void updateScore(int mScore){
        mScoreView.setText(""+mScore);
     }
}