package com.example.rain.fishingcard;

import java.util.Random;

/**
 * Created by rain on 2016/6/18.
 */
public class Poker {
    private int[][] poker = {{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},
            {1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13}};
    private int lave = 52;

    public Poker() {
        int[][] a = {{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},
                {1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13}};
        poker = a;
    }

    public void init() {
        int[][] a = {{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},
                {1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13}};
        poker = a;
        lave = 52;
    }

    public Card getACacd() {
        int color = makeRandom(0, 3);
        int point = makeRandom(0, 12);
        Card card = new Card();
        if(pokerIsempty() == false){
            while(colorIsEmpty(color) == true) {
                color = (color + 1) % 4;
            }
            while(poker[color][point] == 0) {
                point = (point + 1) % 13;
            }

            card.setColor(color);
            card.setPoint(point);
            lave--;

            poker[color][point] = 0;
        }

        return card;
    }

    int makeRandom(int a, int b) {
        Random random = new Random();
        return random.nextInt(b - a + 1) + a;
    }

    public boolean colorIsEmpty(int color) {
        for(int i = 0; i < 13; i++) {
            if(poker[color][i] != 0)
                return false;
        }
        return true;
    }

    public boolean pokerIsempty() {
        for(int i = 0; i < 4; i++) {
            if(colorIsEmpty(i) == false)
                return false;
        }
        return true;
    }

    public int getLave() {
        return lave;
    }
}
