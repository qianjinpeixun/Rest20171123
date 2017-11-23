package com.qianjin.java.sss.java2s.a1101.ass35;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    ArrayList<Card> list = new ArrayList<Card>();

    public Deck() {
        for (int i = 1; i < 5; i++) {
            for (int j = 2; j < 15; j++) {
                Card c = new Card(j, i);
                list.add(c);
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < 100; i++) {
            int r1 = new Random().nextInt(52);
            int r2 = new Random().nextInt(52);
            Card c = list.get(r1);
            list.set(r1, list.get(r2));
            list.set(r2, c);
        }
    }

    public ArrayList<Card> getPile1() {
        ArrayList<Card> card = new ArrayList<Card>();
        for (int i = 0; i < 26; i++) {
            card.add(list.get(i));
        }
        return card;
    }

    public ArrayList<Card> getPile2() {
        ArrayList<Card> card = new ArrayList<Card>();
        for (int i = 26; i < 52; i++) {
            card.add(list.get(i));
        }
        return card;
    }

}
