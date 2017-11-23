package com.qianjin.java.sss.java2s.a1101.ass32java;

public class Card {
    private String suit;
    private int rank;

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    // convert rank number to string format
    public String toString() {
        if (rank == 11) {
            return "Jack  " + suit;
        } else if (rank == 12) {
            return "Queen  " + suit;
        } else if (rank == 13) {
            return "King  " + suit;
        } else if (rank == 14) {
            return "Ace  " + suit;
        }
        return rank + "  " + suit;
    }

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // if the suit and rank are the same, it's a same card
    public boolean valid() {
        if (suit.equals("Hearts") || suit.equals("Diamonds") || suit.equals("Clubs") || suit.equals("Spades)")) {
            if (rank > 1 && rank < 15)
                return true;
            else
                return false;
        } else
            return false;
    }

    // only check the rank number
    public boolean compare(Card c) {
        if (rank > c.getRank())
            return true;
        else
            return false;
    }
}
