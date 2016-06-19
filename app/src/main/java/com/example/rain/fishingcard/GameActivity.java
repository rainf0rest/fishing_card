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

        fish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work(1, getNumber(fish1.getText().toString()));
            }
        });

        fish2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work(2, getNumber(fish2.getText().toString()));
            }
        });

        fish3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work(3, getNumber(fish3.getText().toString()));
            }
        });

        fish4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work(4, getNumber(fish4.getText().toString()));
            }
        });

        fish5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work(5, getNumber(fish5.getText().toString()));
            }
        });

        rod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work(-1, getNumber(rod1.getText().toString()));
            }
        });

        rod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work(-2, getNumber(rod2.getText().toString()));
            }
        });

        rod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work(-3, getNumber(rod3.getText().toString()));
            }
        });

        rod4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work(-4, getNumber(rod4.getText().toString()));
            }
        });

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

    int shoupai = 0, pupai = 0, shouchoose = 0, pu = 0;
    int pupaich[] = {0,0,0,0,0,0,0};

    void work(int type, int pp) {
        if(type < 0){
            shoupai = pp;
            shouchoose = type;
        }else {
            pupai = pupai + pp;
            pupaich[type] = 1;
        }

        if(shoupai == pupai && shoupai != 0) {
            check();
        }
        comboText.setText("" + shouchoose);

    }

    void check() {
        switch(shouchoose) {
            case -1:
                rod1.setText("" + getAPoint());
                break;
            case -2:
                rod2.setText("" + getAPoint());
                break;
            case -3:
                rod3.setText("" + getAPoint());
                break;
            case -4:
                rod4.setText("" + getAPoint());
                break;
        }
        for(int i = 1; i <= 5; i++) {
            if(pupaich[i] == 1) {
                switch(i){
                    case 1:
                        fish1.setText("" + getAPoint());
                        break;
                    case 2:
                        fish2.setText("" + getAPoint());
                        break;
                    case 3:
                        fish3.setText("" + getAPoint());
                        break;
                    case 4:
                        fish4.setText("" + getAPoint());
                        break;
                    case 5:
                        fish5.setText("" + getAPoint());
                        break;
                }
            }
        }
        shouchoose = 0;
        shoupai = 0;
        pupai = 0;
        for(int i = 0; i < pupaich.length; i++) {
            pupaich[i] = 0;
        }

        scoreText.setText("score:" + score);
        cardLaveText.setText("" + gamePoker.getLave());
        //comboText.setText("" + shouchoose);
        comboText.setText("check");
    }
}
