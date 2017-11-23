package com.qianjin.java.sss.java2s.a1101.ass34gao;

public class Card {
    private int suit;

    private int rank;

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String toString() {
        String s = "";
        switch (rank) {
        case 11:
            s = "Jack   ";
            break;
        case 12:
            s = "Queen  ";
            break;
        case 13:
            s = "King   ";
            break;
        case 14:
            s = "Ace    ";
            break;
        default:
            if (rank < 10)
                s = String.valueOf(rank) + "      ";
            else
                s = String.valueOf(rank) + "     ";
        }
        switch (suit) {
        case 0:
            s = s + "hearts      ";
            break;
        case 1:
            s = s + "diamonds    ";
            break;
        case 2:
            s = s + "clubs       ";
            break;
        case 3:
            s = s + "spades      ";
            break;
        }
        return s;

    }

    public int compare(Card c) {
        if (getRank() > c.getRank())
            return 1;
        if (getRank() < c.getRank())
            return -1;
        else
            return 0;
    }
}
