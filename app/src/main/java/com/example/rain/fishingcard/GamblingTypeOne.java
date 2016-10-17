package com.example.rain.fishingcard;

/**
 * Created by rain on 2016/10/17.
 */
public class GamblingTypeOne {

    private Poker poker;

    public GamblingTypeOne() {
        poker = new Poker();
    }

    public void init() {
        poker.init();
    }

    public Card getACard() {
        return poker.getACacd();
    }

    //you should sort these three card
    public int getLevel(Card a, Card b, Card c) {
        int level = 0;
        //豹子
        if(a.getPoint() == b.getPoint() && b.getPoint() == c.getPoint()) {
            level = 6;
        }
        else {
            //同花顺
            if(a.getPoint() == b.getPoint() + 1 &&
                    b.getPoint() == c.getPoint() + 1 &&
                    a.getColor() == b.getColor() &&
                    b.getColor() == c.getColor()) {
                level = 5;
            }
            else {
                //顺子
                if(a.getPoint() == b.getPoint() + 1 &&
                        b.getPoint() == c.getPoint() + 1 ) {
                    level = 4;
                }
                else {
                    //同花
                    if(a.getColor() == b.getColor() &&
                            b.getColor() == c.getColor()) {
                        level = 3;
                    }
                    else {
                        //对子
                        if(a.getPoint() == b.getPoint() || b.getPoint() == c.getPoint()) {
                            level = 2;
                        }
                        else {
                            //杂牌
                            level = 1;
                        }
                    }
                }
            }
        }
        return level;
    }
}
