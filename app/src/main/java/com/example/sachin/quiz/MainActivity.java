package com.example.sachin.quiz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;


/**
 * This is the Main activity.
 * This Activity is used to display the welcome page.
 * For layout design, refer activity_main XML file
 * The execution of this application starts from this activity.
 */
public class MainActivity extends Activity {
    /***
     * onCreate(Bundle) is where you initialize your activity.
     * @param savedInstanceState callback is called only when there is a saved instance that is previously saved by using
    // onSaveInstanceState()
     */
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        Button StartButton;

        //* StartButton: This button when triggered intents the next activity, ie: MenuActivity.

            StartButton = (Button) findViewById(R.id.startButton);
            StartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, MenuActivity.class));

                }
            });

        }
    }


