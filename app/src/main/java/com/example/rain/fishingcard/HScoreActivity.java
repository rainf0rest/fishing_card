package com.example.rain.fishingcard;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by rain on 2016/7/1.
 */
public class HScoreActivity extends Activity {

    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);

        textView = (TextView) findViewById(R.id.hscoreTextview);
        textView.setText("最高分： " + MainActivity.highestScore);
    }
}
