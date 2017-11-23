package com.qianjin.java.sss.java2s.a1101.ass42larryla;

public class Card {
    private String suit;
    private int rank;

    public Card() {
    }

    // card has two attributes suit and rank
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // get suit and rank
    public String getSuit() {
        return this.suit;
    }

    public int getRank() {
        return this.rank;
    }

    // valid method is make the card not repeat when it already have one
    public boolean valid() {
        if (suit.equals("Hearts") || suit.equals("Diamonds") || suit.equals("Clubs") || suit.equals("Spades)")) {
            if (rank > 0 && rank < 14) {
                return true;
            } else {
                return false;
            }
        } else
            return false;
    }

    // compare method is compare the biggest card
    public boolean compare(Card c) {
        if (rank > c.getRank() && rank != 1 && c.getRank() != 1) {
            return true;
        } else if (rank == 1 && c.getRank() != 1) {
            // Ace is biggest so when rank is 1 return true
            return true;
        } else {
            return false;
        }
    }

    // gives a reasonable representation for the Card
    public String toString() {
        String a = " Jack";
        String b = " Queen";
        String c = " King";
        String d = " Ace";
        if (rank == 11) {
            return suit + a;
        } else if (rank == 12) {
            // that is what card is like
            return suit + b;
        } else if (rank == 13) {
            return suit + c;
        } else if (rank == 1) {
            return suit + d;
        }
        return suit + " " + rank;
    }
}