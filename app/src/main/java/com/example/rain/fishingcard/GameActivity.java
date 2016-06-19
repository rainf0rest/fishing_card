package com.example.rain.fishingcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by rain on 2016/6/17.
 */
public class GameActivity extends Activity{

    TextView fish1, fish2, fish3, fish4, fish5, fish6, fish7, fish8,
            rod1, rod2, rod3, rod4, scoreText, cardLaveText, comboText;
    int combo = 0, score = 0;
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
        fish6 = (TextView) findViewById(R.id.fish6);
        fish7 = (TextView) findViewById(R.id.fish7);
        fish8 = (TextView) findViewById(R.id.fish8);
        rod1 = (TextView) findViewById(R.id.rod1);
        rod2 = (TextView) findViewById(R.id.rod2);
        rod3 = (TextView) findViewById(R.id.rod3);
        rod4 = (TextView) findViewById(R.id.rod4);
        scoreText = (TextView) findViewById(R.id.score);
        cardLaveText = (TextView) findViewById(R.id.cardLave);
        comboText = (TextView) findViewById(R.id.combo);

        init();

    }

    void init() {
        fish1.setText("" + getAPoint());
        fish2.setText("" + getAPoint());
        fish3.setText("" + getAPoint());
        fish4.setText("" + getAPoint());
        fish5.setText("" + getAPoint());
        fish6.setVisibility(View.INVISIBLE);
        fish7.setVisibility(View.INVISIBLE);
        fish8.setVisibility(View.INVISIBLE);
        rod1.setText("" + getAPoint());
        rod2.setText("" + getAPoint());
        rod3.setText("" + getAPoint());
        rod4.setText("" + getAPoint());
        scoreText.setText("score:" + score);
        cardLaveText.setText("" + gamePoker.getLave());
        comboText.setText("" + combo);

        /*rod1.setText("" + getAPoint());
        rod2.setText("" + getAPoint());
        rod3.setText("" + getAPoint());*/
    }

    String getAPoint() {
        Card card = gamePoker.getACacd();
        int point = card.getPoint();
        String s = "A";
        if(point >= 1 && point <= 9) {
            s =  "" + point++;
        }
        else {
            switch (point) {
                case 0:
                    s = "A";
                    break;
                case 10:
                    s = "J";
                    break;
                case 11:
                    s = "Q";
                    break;
                case 12:
                    s = "K";
                    break;
                default:
                    break;
            }
        }
        return s;
    }

    int getNumber(String s) {
        int i;
        switch(s) {
            case "A":
                i = 1;
                break;
            case "J":
                i = 11;
                break;
            case "Q":
                i = 12;
                break;
            case "K":
                i = 13;
                break;
            default:
                i = Integer.parseInt(s);
                break;
        }
        return i;
    }
}
