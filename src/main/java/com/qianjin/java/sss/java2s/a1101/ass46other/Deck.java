package com.qianjin.java.sss.java2s.a1101.ass46other;

import java.util.Random;

public class Deck extends Pile {

    public Deck() {
        for (int i = 1; i < 5; i++) {
            for (int j = 2; j < 15; j++) {
                Card c = new Card(j, i);
                getPile().addToEnd(c);
            }
        }
    }

    public Card draw() {
        return null;
    }

    public void shuffle() {
        for (int i = 0; i < 100; i++) {
            int r1 = new Random().nextInt(52);
            int r2 = new Random().nextInt(52);
            Card c = getPile().getNode(r1).getData();
            getPile().add(r1, getPile().getNode(r2).getData());
            getPile().add(r2, c);
        }
    }

    public PlayerHand getPile1() {
        PlayerHand hand = new PlayerHand();
        for (int i = 0; i < 26; i++) {
            hand.add(getPile().getNode(i).getData());
        }
        return hand;
    }

    public PlayerHand getPile2() {
        PlayerHand hand = new PlayerHand();
        for (int i = 26; i < 52; i++) {
            hand.add(getPile().getNode(i).getData());
        }
        return hand;
    }

}
