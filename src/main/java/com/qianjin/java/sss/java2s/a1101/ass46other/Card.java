package com.qianjin.java.sss.java2s.a1101.ass46other;

public class Card {

    private int rank;
    private int suit;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (rank >= 2 && rank <= 14)
            this.rank = rank;
        else
            this.rank = 2;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        if (suit >= 1 && suit <= 4)
            this.suit = suit;
        else
            this.suit = 1;
    }

    public Card(int rank, int suit) {
        setRank(rank);
        setSuit(suit);
    }

    public String toString() {
        String s = "2";
        if (getRank() == 11)
            s = "Jack";
        else if (getRank() == 12)
            s = "Queen";
        else if (getRank() == 13)
            s = "King";
        else if (getRank() == 14)
            s = "Ace";
        else
            s = String.valueOf(getRank());

        String r = String.format("%-10s", s);
        String u = "";
        if (getSuit() == 1) {
            u = "Hearts";
        } else if (getSuit() == 2) {
            u = "Diamonds";
        } else if (getSuit() == 3) {
            u = "Clubs";
        } else {
            u = "Spades";
        }
        String uu = String.format("%-10s", u);
        return r + uu;
    }

    public boolean higher(Card another) {
        if (getRank() > another.getRank())
            return true;
        else
            return false;
    }

}
