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
        player1 = new ThreeCard(poker.getACacd(), poker.getACacd(), poker.getACacd());
        player2 = new ThreeCard(poker.getACacd(), poker.getACacd(), poker.getACacd());
    }

    public void reset() {
        poker.init();
        player1.setCard1(poker.getACacd());
        player1.setCard2(poker.getACacd());
        player1.setCard3(poker.getACacd());
        player1.reflush();
        player2.setCard1(poker.getACacd());
        player2.setCard2(poker.getACacd());
        player2.setCard3(poker.getACacd());
        player2.reflush();
    }

    public ThreeCard getPlayer1() {
        return player1;
    }

    public void setPlayer1(ThreeCard player1) {
        this.player1 = player1;
    }

    public ThreeCard getPlayer2() {
        return player2;
    }

    public void setPlayer2(ThreeCard player2) {
        this.player2 = player2;
    }

    public Card getACard() {
        return poker.getACacd();
    }

    private ThreeCard player1, player2;

    public void sortCard() {
        player1.sort();
        player2.sort();
    }

    public int compare() {
        return compare(player1, player2);
    }

    public int compare(ThreeCard p1, ThreeCard p2) {
        if(getLevel(p1) > getLevel(p2)) {
            return 1;
        }
        else {
            if(getLevel(p1) < getLevel(p2)) {
                return 2;
            }
            else {
                p1.sort();
                p2.sort();
                if(p1.getCard1().getPoint() > p2.getCard1().getPoint()) {
                    return 1;
                }
                else {
                    if(p1.getCard1().getPoint() < p2.getCard1().getPoint()) {
                        return 2;
                    }
                    else {
                        if(p1.getCard2().getPoint() > p2.getCard2().getPoint()) {
                            return 1;
                        }
                        else {
                            if(p1.getCard2().getPoint() < p2.getCard2().getPoint()) {
                                return 2;
                            }
                            else {
                                if(p1.getCard3().getPoint() > p2.getCard3().getPoint()) {
                                    return 1;
                                }
                                else {
                                    if(p1.getCard3().getPoint() < p2.getCard3().getPoint()) {
                                        return 2;
                                    }
                                    else {
                                        return 1;//默认第一个参数为庄家的牌
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int getLevel(ThreeCard c) {
        c.sort();
        return getLevel(c.getCard1(), c.getCard2(), c.getCard3());
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

    String getCardColor(int n) {
        String s = new String();
        switch(n) {
            case 0:
                s = "黑桃";
                break;
            case 1:
                s = "红桃";
                break;
            case 2:
                s = "梅花";
                break;
            case 3:
                s = "方块";
                break;
            default:
                break;
        }
        return s;
    }

    public int getPlayer1APoint() {
        return player1.getCard1().getPoint() + 1;
    }

    public int getPlayer1BPoint() {
        return player1.getCard2().getPoint() + 1;
    }

    public int getPlayer1CPoint() {
        return player1.getCard3().getPoint() + 1;
    }

    public int getPlayer1AColor() {
        return player1.getCard1().getColor() + 1;
    }

    public int getPlayer1BColor() {
        return player1.getCard2().getColor() + 1;
    }

    public int getPlayer1CColor() {
        return player1.getCard3().getColor() + 1;
    }

    public int getPlayer2APoint() {
        return player2.getCard1().getPoint() + 1;
    }

    public int getPlayer2BPoint() {
        return player2.getCard2().getPoint() + 1;
    }

    public int getPlayer2CPoint() {
        return player2.getCard3().getPoint() + 1;
    }

    public int getPlayer2AColor() {
        return player2.getCard1().getColor() + 1;
    }

    public int getPlayer2BColor() {
        return player2.getCard2().getColor() + 1;
    }

    public int getPlayer2CColor() {
        return player2.getCard3().getColor() + 1;
    }



}
