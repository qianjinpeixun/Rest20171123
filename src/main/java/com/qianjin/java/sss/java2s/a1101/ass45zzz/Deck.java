package com.qianjin.java.sss.java2s.a1101.ass45zzz;

import java.util.ArrayList;

public class Deck extends Pile {

    public Deck() {
        for (int i = 0; i < 52; i++) {
            Card c = new Card(i);
            getPile().addToEnd(c);
        }
    }

    // reorder the cards in the internal ArrayList into a random order.
    public void shuffle() {
        for (int i = 0; i < 10000; i++) {
            int random = (int) (Math.random() * 52);
            Card c = getPile().getNode(random).getData();
            getPile().remove(random);
            getPile().addToEnd(c);
        }
    }

    // There is a PlayerHand class
    // So this class do not need to implement draw method
    public Card draw() {
        return null;
    }

}
