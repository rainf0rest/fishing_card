package com.example.rain.fishingcard;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by rain on 2016/10/15.
 */
public class GamblingTPActivity extends Activity{

    private TextView textView;
    private GamblingTypeOne mygame;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gambling_tp);

        /*textView = (TextView) findViewById(R.id.gamblingTest);

        GamblingTypeOne myGame = new GamblingTypeOne();

        myGame.init();

        textView.setText("");
        textView.append("ai: ");
        textView.append(myGame.getCardColor(myGame.getPlayer1().getCard1().getColor()));
        textView.append(" " + myGame.getPlayer1().getCard1().getPoint());
        textView.append(myGame.getCardColor(myGame.getPlayer1().getCard2().getColor()));
        textView.append(" " + myGame.getPlayer1().getCard2().getPoint());
        textView.append(myGame.getCardColor(myGame.getPlayer1().getCard3().getColor()));
        textView.append(" " + myGame.getPlayer1().getCard3().getPoint());
        textView.append("\nyou:");
        textView.append(myGame.getCardColor(myGame.getPlayer2().getCard1().getColor()));
        textView.append(" " + myGame.getPlayer2().getCard1().getPoint());
        textView.append(myGame.getCardColor(myGame.getPlayer2().getCard2().getColor()));
        textView.append(" " + myGame.getPlayer2().getCard2().getPoint());
        textView.append(myGame.getCardColor(myGame.getPlayer2().getCard3().getColor()));
        textView.append(" " + myGame.getPlayer2().getCard3().getPoint());

        int result = myGame.compare();

        if(result == 1) {
            textView.append("you lost");
        }
        else {
            if(result == 2)
                textView.append("you win");
            else {
                
            }
        }
        */


    }

}
