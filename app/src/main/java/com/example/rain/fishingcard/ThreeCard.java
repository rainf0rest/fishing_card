package com.example.rain.fishingcard;

/**
 * Created by rain on 2016/10/17.
 */
public class ThreeCard {
    private Card card1;
    private Card card2;
    private Card card3;
    //private Card cardList[];

    public ThreeCard(Card a, Card b, Card c) {
        card1 = new Card(a);
        card2 = new Card(b);
        card3 = new Card(c);
        /*cardList = new Card[] {
                a,b,c
        };*/
    }

    public void sort() {
        if(card1.getPoint() < card2.getPoint()) {
            Card temp = new Card(card1);
            card1 = card2;
            card2 = temp;
        }
        if(card2.getPoint() < card3.getPoint()) {
            Card temp = new Card(card2);
            card2 = card3;
            card3 = temp;
        }
        if(card1.getPoint() < card2.getPoint()) {
            Card temp = new Card(card1);
            card1 = card2;
            card2 = temp;
        }
        if(card2.getPoint() < card3.getPoint()) {
            Card temp = new Card(card2);
            card2 = card3;
            card3 = temp;
        }
    }

    /*public void sort() {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 1; j++) {
                if(cardList[j].getPoint() > cardList[j+1].getPoint()) {

                }
                else {
                    Card temp = new Card(cardList[j]);
                    cardList[j] = cardList[j+1];
                    cardList[j+1] = temp;
                }
            }
        }
        card1 = cardList[0];
        card2 = cardList[1];
        card3 = cardList[2];
    }*/

    public Card getCard1() {
        return card1;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public Card getCard2() {
        return card2;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public Card getCard3() {
        return card3;
    }

    public void setCard3(Card card3) {
        this.card3 = card3;
    }

    /*public void reflush() {
        cardList[0] = card1;
        cardList[1] = card2;
        cardList[2] = card3;
    }*/
}
