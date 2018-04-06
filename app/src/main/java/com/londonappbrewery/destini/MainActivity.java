package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Story[] mStories;
    private int mIndex;
    private Button mButtonTop, mButtonBottom;
    private TextView mStoryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mStoryTextView = findViewById(R.id.storyTextView);

        initiateStories();

        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("IndexKey");
            mButtonTop.setText(mStories[mIndex].getAnswerTop());
            mButtonBottom.setText(mStories[mIndex].getAnswerBottom());
            mStoryTextView.setText(mStories[mIndex].getStory());
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v;
                updateStory(button.getText().toString());
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v;
                updateStory(button.getText().toString());
            }
        });

    }

    private void updateStory(String answer) {
        if (answer.equals(getResources().getString(R.string.T1_Ans1)) || answer.equals(getResources().getString(R.string.T2_Ans1))) {
            mIndex = 2;
        } else if (answer.equals(getResources().getString(R.string.T1_Ans2))) {
            mIndex = 1;
        } else if (answer.equals(getResources().getString(R.string.T2_Ans2))) {
            mIndex = 3;
        } else if (answer.equals(getResources().getString(R.string.T3_Ans1))) {
            mIndex = 5;
        } else if (answer.equals(getResources().getString(R.string.T3_Ans2))) {
            mIndex = 4;
        }

        mStoryTextView.setText(mStories[mIndex].getStory());
        mButtonTop.setText(mStories[mIndex].getAnswerTop());
        mButtonBottom.setText(mStories[mIndex].getAnswerBottom());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("IndexKey", mIndex);
    }

    private void initiateStories() {

        mStories = new Story[6];

        // Story 1
        mStories[0] = new Story(
                getResources().getString(R.string.T1_Story),
                getResources().getString(R.string.T1_Ans1),
                getResources().getString(R.string.T1_Ans2)
        );

        // Story 2
        mStories[1] = new Story(
                getResources().getString(R.string.T2_Story),
                getResources().getString(R.string.T2_Ans1),
                getResources().getString(R.string.T2_Ans2)
        );

        // Story 3
        mStories[2] = new Story(
                getResources().getString(R.string.T3_Story),
                getResources().getString(R.string.T3_Ans1),
                getResources().getString(R.string.T3_Ans2)
        );

        // End 4
        mStories[3] = new Story(
                getResources().getString(R.string.T4_End),
                "",
                ""
        );

        // End 5
        mStories[4] = new Story(
                getResources().getString(R.string.T5_End),
                "",
                ""
        );

        // End 6
        mStories[5] = new Story(
                getResources().getString(R.string.T6_End),
                "",
                ""
        );
    }
}
