package com.qianjin.java.sss.java2s.a1101.ass33zzz;

import java.util.ArrayList;

public class Deck {

    // a collection of Cards in an ArrayList
    ArrayList<Card> list = new ArrayList<Card>();

    public Deck() {
        for (int i = 0; i < 52; i++) {
            Card c = new Card(i);
            list.add(c);
        }
    }

    public ArrayList<Card> getList() {
        return list;
    }

    // reorder the cards in the internal ArrayList into a random order.
    public void shuffle() {
        for (int i = 0; i < 10000; i++) {
            int random = (int) (Math.random() * 52);
            Card c = list.remove(random);
            list.add(c);
        }
    }

}
