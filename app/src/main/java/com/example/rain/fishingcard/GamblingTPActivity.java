package com.example.rain.fishingcard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

    private AlertDialog.Builder builder;

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
                showSimpleListDialog();
                break;
            case R.id.gaBtnGiveUp:
                editor.putInt("moneyofplayer", moneyOfPlayer);
                editor.commit();
                showLostDia();
                break;
            case R.id.gaBtnWatchCard:
                mygame.sortCard();
                getPlayerCard();
                break;
            case R.id.gaBtnSolo:
                mygame.sortCard();
                getAllCard();
                Toast.makeText(GamblingTPActivity.this,"AI: " + mygame.getWhat(mygame.getPlayer1()) + "\nyou:"
                        + mygame.getWhat(mygame.getPlayer2()),Toast.LENGTH_SHORT).show();
                if(mygame.compare() == 1) {
                    //Toast.makeText(GamblingTPActivity.this, "you lost!", Toast.LENGTH_SHORT).show();
                    //moneyScaleTextView.setText("lost");
                    editor.putInt("moneyofplayer", moneyOfPlayer);
                    editor.commit();
                    showLostDia();
                }
                else {
                    //Toast.makeText(GamblingTPActivity.this, "you win!", Toast.LENGTH_SHORT).show();
                    //moneyScaleTextView.setText("win");
                    moneyOfPlayer = moneyOfPlayer + gaMoneyofAI + gaMoneyofPlayer;
                    editor.putInt("moneyofplayer", moneyOfPlayer);
                    editor.commit();
                    showWinDia();
                }
                //gaMoneyofPlayer = 0;
                //gaMoneyofAI = 0;
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
        gaMoneyofAI = 0;
        gaMoneyofPlayer = 0;
        addMoney(10);
        //moneyOfPlayerTextView.setText("￥:" + moneyOfPlayer);
        refresh();
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

    private  void showWinDia() {

        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.win);
        builder.setTitle(R.string.dia_game_win_title);
        builder.setMessage("getMoney: " + (gaMoneyofPlayer + gaMoneyofAI));

        builder.setPositiveButton(R.string.dia_game_win_posbtn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this,"pos",Toast.LENGTH_SHORT).show();
                resetGame();
            }
        });

        builder.setNegativeButton(R.string.dia_game_win_negbtn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this,"neg",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();

    }

    private  void showLostDia() {

        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.lost);
        builder.setTitle(R.string.dia_game_lost_title);
        builder.setMessage("lost Money: " + gaMoneyofPlayer);

        builder.setPositiveButton(R.string.dia_game_win_posbtn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this,"pos",Toast.LENGTH_SHORT).show();
                resetGame();
            }
        });

        builder.setNegativeButton(R.string.dia_game_win_negbtn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this,"neg",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();

    }
    private void addMoney(int n) {
        gaMoneyofPlayer += n;
        gaMoneyofAI += n;
        moneyOfPlayer -= n;
    }

    private void resetGame() {
        mygame.reset();

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

        gaMoneyofAI = 0;
        gaMoneyofPlayer = 0;
        addMoney(10);
        //moneyOfPlayerTextView.setText("￥:" + moneyOfPlayer);
        refresh();


    }


    private void showSimpleListDialog() {
        builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.coin);
        builder.setTitle(R.string.simple_list_dialog);

        /**
         * 设置内容区域为简单列表项
         */
        final String[] Items={"￥10","￥20","￥50"};
        builder.setItems(Items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int h = 0;
                switch (i) {
                    case 0:
                        h = 10;
                        break;
                    case 1:
                        h = 20;
                        break;
                    case 2:
                        h = 50;
                        break;
                }
                moneyOfPlayer -= h;
                gaMoneyofAI += h;
                gaMoneyofPlayer += h;
                refresh();
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

}
