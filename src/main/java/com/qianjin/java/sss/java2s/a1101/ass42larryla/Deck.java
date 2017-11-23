package com.qianjin.java.sss.java2s.a1101.ass42larryla;

public class Deck extends Pile {

    // set total cards and two part of card
    private LinkedList Totalcards;
    private LinkedList firstPlayer;
    private LinkedList secondPlayer;

    public Deck() {
        Totalcards = new LinkedList();
        secondPlayer = new LinkedList();
        firstPlayer = new LinkedList();
    }

    public Card draw() {
        return Totalcards.getFrontData();
    }

    public LinkedList getTotalCards() {// get total cards or two part of card
        return this.Totalcards;
    }

    public LinkedList getFirstPlayer() {
        return this.firstPlayer;
    }

    public LinkedList getSecondplayer() {
        return this.secondPlayer;
    }

    // shuffle method is random the 52 cards and divide it to two
    public void shuffle() {
        Totalcards.clear();
        firstPlayer.clear();
        secondPlayer.clear();
        // first of all, make 52 cards
        for (int i = 1; i < 14; i++) {
            Totalcards.addToEnd(new Card("Hearts", i));
            Totalcards.addToEnd(new Card("Diamonds", i));
            Totalcards.addToEnd(new Card("Clubs", i));
            Totalcards.addToEnd(new Card("Spades", i));
        }
        // then use math random to random 52 cards, then add it to back of
        // arraylist
        for (int i = 0; i < 52; i++) {
            int no = (int) (Math.random() * 52);
            Card a = Totalcards.getNode(no).getData();
            // remove no then add it to end of array list
            Totalcards.remove(no);
            Totalcards.add(Totalcards.size(), a);
        }
        // then divide random cards to two parts
        for (int i = 0; i < 26; i++) {
            firstPlayer.add(i, Totalcards.getNode(i).getData());
            secondPlayer.add(i, Totalcards.getNode(51 - i).getData());
        }
    }
}