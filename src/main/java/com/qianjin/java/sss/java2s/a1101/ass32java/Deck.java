package com.qianjin.java.sss.java2s.a1101.ass32java;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;
    private ArrayList<Card> firstHalf;
    private ArrayList<Card> secondHalf;

    public ArrayList<Card> getFirstHalf() {
        return firstHalf;
    }

    public ArrayList<Card> getSecondHalf() {
        return secondHalf;
    }

    public Deck() {
        cards = new ArrayList<Card>();
        secondHalf = new ArrayList<Card>();
        firstHalf = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        cards.clear();
        firstHalf.clear();
        secondHalf.clear();

        // generate 52 cards
        for (int i = 2; i < 15; i++) {
            cards.add(new Card("Hearts", i));
            cards.add(new Card("Diamonds", i));
            cards.add(new Card("Clubs", i));
            cards.add(new Card("Spades", i));
        } // Now, there are 52 cards in this deck

        int no = 0;
        int max = 0;
        int min = 0;
        int range = 0;

        // start to shuffle this deck
        for (int i = 0; i < 1000; i++) {
            max = 51;
            min = 0;
            range = (max - min) + 1;
            no = (int) (Math.random() * range) + min;
            Card c = cards.get(no);
            cards.remove(no);
            cards.add(cards.size(), c);
        }

        // generate a 26 random different numbers between 0 to 51
        int[] r = new int[26];
        int count = 0;
        while (count < 26) {
            max = 51;
            min = 0;
            range = (max - min) + 1;
            no = (int) (Math.random() * range) + min;

            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (no == r[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                r[count] = no;
                count++;
            }
        }

        // half the deck to two players
        for (int i = 0; i < 52; i++) {
            boolean first = false;
            for (int j = 0; j < 26; j++) {
                if (i == r[j]) {
                    first = true;
                    break;
                }
            }
            if (first) {
                firstHalf.add(cards.get(i));
            } else {
                secondHalf.add(cards.get(i));
            }
        } // now, the firstHalf has 26 cards, the rightHalf as 26 cards as well
    }

}
