package com.example.rain.fishingcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by rain on 2016/6/17.
 */
public class GameActivity extends Activity{

    TextView fish1, fish2, fish3, fish4, fish5;

    Poker gamePoker = new Poker();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);

        fish1 = (TextView) findViewById(R.id.fish1);
        fish2 = (TextView) findViewById(R.id.fish2);
        fish3 = (TextView) findViewById(R.id.fish3);
        fish4 = (TextView) findViewById(R.id.fish4);
        fish5 = (TextView) findViewById(R.id.fish5);

        init();

    }

    void init() {
        fish1.setText("" + getAPoint());
        fish2.setText("" + getAPoint());
        fish3.setText("" + getAPoint());
        fish4.setText("" + getAPoint());
        fish5.setText("" + getAPoint());
        /*rod1.setText("" + getAPoint());
        rod2.setText("" + getAPoint());
        rod3.setText("" + getAPoint());*/
    }

    int getAPoint() {
        Card card = gamePoker.getACacd();
        return card.getPoint();
    }

}
