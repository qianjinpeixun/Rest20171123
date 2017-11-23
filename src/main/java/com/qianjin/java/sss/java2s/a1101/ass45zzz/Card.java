package com.qianjin.java.sss.java2s.a1101.ass45zzz;

public class Card {
    // A Card object is made up of a suit (Hearts, Diamonds, Clubs, or Spades)
    private int number;
    private static String[] suit = { "Hearts", "Diamonds", "Clubs", "Spades" };
    private static String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

    public Card(int number) {
        if (number < 0 || number > 51)
            this.number = 0;
        else
            this.number = number;
    }

    public int getValue() {
        return number % 13;
    }

    // comparison method that determines which of two Cards has the higher rank
    // (note that suit is irrelevant when comparing rank; the Ace of Spades
    // is“worth” as much as an Ace of Hearts)
    public boolean comparision(Card c) {
        return getValue() > c.getValue();
    }

    // gives a reasonable representation for the Card
    public String toString() {
        String s = rank[number % 13] + "  " + suit[number / 13];
        int t = (20 - s.length());
        for (int i = 0; i < t; i++) {
            s = s + " ";
        }
        return s;
    }
}
