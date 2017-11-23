package com.qianjin.java.sss.java2s.a1101.ass43wu;


public class Card {

    private int suit;
    private int rank;


    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        String c = "";
        if (rank == 11) {
            c = "Jack";
        } else if (rank == 12) {
            c = "Queen";
        } else if (rank == 13) {
            c = "King";
        } else if (rank == 14) {
            c = "Ace";
        }else{
            c=String.valueOf(rank);
        }
        if (suit == 1) {
            c = c + "  Hearts";
        } else if (suit == 2) {
            c = c + "  Diamonds";
        } else if (suit == 3) {
            c = c + "  Clubs";
        } else if (suit == 4) {
            c = c + "  Spades";
        }
        return c;
    }

    // if this card is bigger than c, return 1
    // if this card is smaller than c, return -1
    // if two cards equals, return 0
    public int bigger(Card c) {
        if (c.getRank() < rank)
            return 1;
        else if (c.getRank() > rank)
            return -1;
        else
            return 0;
    }
}
