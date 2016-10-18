package com.example.rain.fishingcard;

/**
 * Created by rain on 2016/6/17.
 */
public class Card {
    private int color;
    private int point;

    public Card() {
        color = 0;
        point = 0;
    }

    public Card(Card c) {
        color = c.getColor();
        point = c.getPoint();
    }

    public int getColor() {
        return color;
    }

    public int getPoint() {
        return point;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
