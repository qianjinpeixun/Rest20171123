package com.qianjin.java.sss.java2s.a1101.ass34gao;

import java.util.ArrayList;
import java.util.*;

public class Deck {

    ArrayList<Card> cards = new ArrayList<Card>();

    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                cards.add(new Card(i, j));
            }
        }
    }
    
    public void shuffle(){
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}
