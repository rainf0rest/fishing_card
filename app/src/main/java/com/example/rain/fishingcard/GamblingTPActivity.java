package com.example.rain.fishingcard;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rain on 2016/10/15.
 */
public class GamblingTPActivity extends Activity implements View.OnClickListener{

    private TextView AICardAPoint, AICardBPoint, AICardCPoint,
            PlayerCardAPoint, PlayerCardBPoint, PlayerCardCPoint,
            moneyOfPlayerTextView, moneyScaleTextView;
    private GamblingTypeOne mygame;
    private ImageView AICardAColor, AICardBColor, AICardCColor,
            PlayerCardAColor, PlayerCardBColor, PlayerCardCColor;
    private int[] images = new int[] {
            R.drawable.question_mark,
            R.drawable.heitao,
            R.drawable.hongtao,
            R.drawable.meihua,
            R.drawable.fangkuai
    };

    private String[] points = new String[] {
            "?",
            "A",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "J",
            "Q",
            "K"
    };

    private int moneyOfPlayer, gaMoneyofAI, gaMoneyofPlayer;


    private int[] playerAIID = new int[] {
            R.id.gaAICardAColor,
            R.id.gaAICardAPoint,
            R.id.gaAICardBColor,
            R.id.gaAICardBPoint,
            R.id.gaAICardCColor,
            R.id.gaAICardCPoint
    };

    private int[] playerYouID = new int[] {
            R.id.gaPlayerCardAColor,
            R.id.gaPlayerCardAPoint,
            R.id.gaPlayerCardBColor,
            R.id.gaPlayerCardBPoint,
            R.id.gaPlayerCardCColor,
            R.id.gaPlayerCardCPoint,
    };

    private Button addMoney, giveUp, watchCard, solo;

    SharedPreferences sharedPreferences;
    //static public int highestScore;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gambling_tp);

        AICardAColor = (ImageView) findViewById(R.id.gaAICardAColor);
        AICardBColor = (ImageView) findViewById(R.id.gaAICardBColor);
        AICardCColor = (ImageView) findViewById(R.id.gaAICardCColor);
        PlayerCardAColor = (ImageView) findViewById(R.id.gaPlayerCardAColor);
        PlayerCardBColor = (ImageView) findViewById(R.id.gaPlayerCardBColor);
        PlayerCardCColor = (ImageView) findViewById(R.id.gaPlayerCardCColor);
        AICardAPoint = (TextView) findViewById(R.id.gaAICardAPoint);
        AICardBPoint = (TextView) findViewById(R.id.gaAICardBPoint);
        AICardCPoint = (TextView) findViewById(R.id.gaAICardCPoint);
        PlayerCardAPoint = (TextView) findViewById(R.id.gaPlayerCardAPoint);
        PlayerCardBPoint = (TextView) findViewById(R.id.gaPlayerCardBPoint);
        PlayerCardCPoint = (TextView) findViewById(R.id.gaPlayerCardCPoint);

        moneyOfPlayerTextView = (TextView) findViewById(R.id.moneyofplayerText);
        moneyScaleTextView = (TextView) findViewById(R.id.moneyScale);

        addMoney = (Button) findViewById(R.id.gaBtnAddMoney);
        giveUp = (Button) findViewById(R.id.gaBtnGiveUp);
        watchCard = (Button) findViewById(R.id.gaBtnWatchCard);
        solo = (Button) findViewById(R.id.gaBtnSolo);

        addMoney.setOnClickListener(this);
        giveUp.setOnClickListener(this);
        watchCard.setOnClickListener(this);
        solo.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("gaGameTYONEData", MODE_PRIVATE);
        moneyOfPlayer = sharedPreferences.getInt("moneyofplayer", 500);
        editor = sharedPreferences.edit();


        mygame = new GamblingTypeOne();
        init();

        /*
        AICardAColor.setOnClickListener(this);
        AICardBColor.setOnClickListener(this);
        AICardCColor.setOnClickListener(this);
        AICardAPoint.setOnClickListener(this);
        AICardBPoint.setOnClickListener(this);
        AICardCPoint.setOnClickListener(this);

        PlayerCardAColor.setOnClickListener(this);
        PlayerCardBColor.setOnClickListener(this);
        PlayerCardCColor.setOnClickListener(this);
        PlayerCardAPoint.setOnClickListener(this);
        PlayerCardBPoint.setOnClickListener(this);
        PlayerCardCPoint.setOnClickListener(this);
        */



    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            //handle multiple view click events
            case R.id.gaBtnAddMoney:
                if(moneyOfPlayer < 10) {
                    Toast.makeText(GamblingTPActivity.this, "Money is not enough!", Toast.LENGTH_SHORT);
                }
                else {
                    gaMoneyofPlayer = gaMoneyofPlayer + 10;
                    gaMoneyofAI = gaMoneyofAI + 10;
                    moneyOfPlayer = moneyOfPlayer - 10;
                    //moneyOfPlayerTextView.setText("￥:" + moneyOfPlayer);
                    refresh();
                }

                break;
            case R.id.gaBtnGiveUp:

                break;
            case R.id.gaBtnWatchCard:
                getPlayerCard();
                break;
            case R.id.gaBtnSolo:
                getAllCard();
                if(mygame.compare() == 1) {
                    Toast.makeText(GamblingTPActivity.this, "you lost!", Toast.LENGTH_LONG);
                    moneyScaleTextView.setText("lost");
                }
                else {
                    Toast.makeText(GamblingTPActivity.this, "you win!", Toast.LENGTH_LONG);
                    moneyScaleTextView.setText("win");
                    moneyOfPlayer = moneyOfPlayer + gaMoneyofAI + gaMoneyofPlayer;
                    editor.putInt("moneyofplayer", moneyOfPlayer);
                    editor.commit();
                }
                gaMoneyofPlayer = 0;
                gaMoneyofAI = 0;
                break;
        }
    }

    private void init() {
        mygame.init();
        AICardAColor.setImageResource(images[0]);
        AICardBColor.setImageResource(images[0]);
        AICardCColor.setImageResource(images[0]);
        PlayerCardAColor.setImageResource(images[0]);
        PlayerCardBColor.setImageResource(images[0]);
        PlayerCardCColor.setImageResource(images[0]);

        AICardAPoint.setText(points[0]);
        AICardBPoint.setText(points[0]);
        AICardCPoint.setText(points[0]);
        PlayerCardAPoint.setText(points[0]);
        PlayerCardBPoint.setText(points[0]);
        PlayerCardCPoint.setText(points[0]);

        //moneyOfPlayerTextView.setText("￥:" + moneyOfPlayer);
        refresh();

        gaMoneyofAI = 0;
        gaMoneyofPlayer = 0;

    }

    private void getAICard() {
        AICardAColor.setImageResource(images[mygame.getPlayer1AColor()]);
        AICardBColor.setImageResource(images[mygame.getPlayer1BColor()]);
        AICardCColor.setImageResource(images[mygame.getPlayer1CColor()]);
        AICardAPoint.setText(points[mygame.getPlayer1APoint()]);
        AICardBPoint.setText(points[mygame.getPlayer1BPoint()]);
        AICardCPoint.setText(points[mygame.getPlayer1CPoint()]);
    }

    private void getPlayerCard() {
        PlayerCardAColor.setImageResource(images[mygame.getPlayer2AColor()]);
        PlayerCardBColor.setImageResource(images[mygame.getPlayer2BColor()]);
        PlayerCardCColor.setImageResource(images[mygame.getPlayer2CColor()]);
        PlayerCardAPoint.setText(points[mygame.getPlayer2APoint()]);
        PlayerCardBPoint.setText(points[mygame.getPlayer2BPoint()]);
        PlayerCardCPoint.setText(points[mygame.getPlayer2CPoint()]);
    }

    private void getAllCard() {
        AICardAColor.setImageResource(images[mygame.getPlayer1AColor()]);
        AICardBColor.setImageResource(images[mygame.getPlayer1BColor()]);
        AICardCColor.setImageResource(images[mygame.getPlayer1CColor()]);
        AICardAPoint.setText(points[mygame.getPlayer1APoint()]);
        AICardBPoint.setText(points[mygame.getPlayer1BPoint()]);
        AICardCPoint.setText(points[mygame.getPlayer1CPoint()]);

        PlayerCardAColor.setImageResource(images[mygame.getPlayer2AColor()]);
        PlayerCardBColor.setImageResource(images[mygame.getPlayer2BColor()]);
        PlayerCardCColor.setImageResource(images[mygame.getPlayer2CColor()]);
        PlayerCardAPoint.setText(points[mygame.getPlayer2APoint()]);
        PlayerCardBPoint.setText(points[mygame.getPlayer2BPoint()]);
        PlayerCardCPoint.setText(points[mygame.getPlayer2CPoint()]);
    }

    private void refresh() {
        moneyOfPlayerTextView.setText("￥:" + moneyOfPlayer);
        moneyScaleTextView.setText("AI:￥" + gaMoneyofAI + "/You:￥" + gaMoneyofPlayer);
    }

}
