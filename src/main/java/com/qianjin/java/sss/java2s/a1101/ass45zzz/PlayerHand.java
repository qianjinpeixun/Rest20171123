package com.qianjin.java.sss.java2s.a1101.ass45zzz;

public class PlayerHand extends Pile {

    // the cards copied from deck using shallow copy
    // so this child class do not need a shuffle implementation
    public void shuffle() {

    }

    // each turn to draw a card, remove it from hand
    public Card draw() {
        Card c = getPile().getFrontData();
        getPile().removeFront();
        return c;
    }

    // clear the current pile
    public void clear() {
        getPile().clear();
    }

    // if there is no any card in hand, return true
    public boolean isEmpty() {
        return getPile().isEmpty();
    }

    // get how many cards in hand
    public int size() {
        return getPile().size();
    }

    // peek the card but not delete it in hand
    public Card look(int i) {
        return getPile().getNode(i).getData();
    }

}
