package com.example.sachin.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * This is Menu activity.
 * this Activity is used to display the Quiz Menu.
 * For layout design, refer activity_menu XML file
 */
public class MenuActivity extends Activity {
    /***
     * onCreate(Bundle) is where you initialize your activity.
     * @param savedInstanceState callback is called only when there is a saved instance that is previously saved by using
    // onSaveInstanceState()
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button StartButton;
        /*
         * A series of buttons are provided, representing a menu.
         * Once the desired button is triggered, it will intend the respective Quiz Activity.
         *
         *              ***Coding is done only for the first button***
         */
        StartButton = (Button) findViewById(R.id.startButton);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, QuizActivity.class));

            }
        });
    }
}
