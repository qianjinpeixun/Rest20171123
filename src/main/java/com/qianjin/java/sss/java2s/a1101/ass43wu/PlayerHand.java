package com.qianjin.java.sss.java2s.a1101.ass43wu;

public class PlayerHand extends Pile {

    public void shuffle() {

    }

    public Card draw() {
        Card c = getPile().getNode(0).getData();
        // getPile().remove(getPile().contains(c));
        return c;
    }

}
