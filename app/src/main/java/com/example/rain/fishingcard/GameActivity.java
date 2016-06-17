package com.example.rain.fishingcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by rain on 2016/6/17.
 */
public class GameActivity extends Activity{

    com.gc.materialdesign.views.ButtonRectangle fish1, fish2, fish3, fish4, fish5, rod1, rod2, rod3;

    Poker gamePoker = new Poker();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);

        fish1 = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.fishbtn1);
        fish2 = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.fishbtn2);
        fish3 = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.fishbtn3);
        fish4 = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.fishbtn4);
        fish5 = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.fishbtn5);
        rod1 = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.rodbtn1);
        rod2 = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.rodbtn2);
        rod3 = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.rodbtn3);

        fish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fish1.setText("start");
            }
        });

        //init();

    }

    /*void init() {
        fish1.setText("" + getAPoint());
        fish2.setText("" + getAPoint());
        fish3.setText("" + getAPoint());
        fish4.setText("" + getAPoint());
        fish5.setText("" + getAPoint());
        rod1.setText("" + getAPoint());
        rod2.setText("" + getAPoint());
        rod3.setText("" + getAPoint());
    }

    int getAPoint() {
        Card card = gamePoker.getACacd();
        return card.getPoint();
    }
    */
}
