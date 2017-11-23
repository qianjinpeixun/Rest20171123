package com.qianjin.java.sss.java2s.a1101.ass41javayw;

public class PlayerHand extends Pile {
    private LinkedList cards;

    public PlayerHand(LinkedList cards) {
        this.cards = cards;
    }

    public void shuffle() {

        for (int i = 0; i < 100; i++) {
            int maxNum = 25;
            int minNum = 0;
            int range = (maxNum - minNum) + 1;
            int random = (int) Math.floor(Math.random() * range) + minNum;
            Node d = cards.getNode(random);
            cards.remove(random);
            cards.addToEnd(d.getData());
        }
    }

    public Card draw() {
        Card c = cards.getFrontData();
        cards.removeFront();
        return c;
    }
    
    public int size(){
        return cards.size();
    }
    
    public void addAll(LinkedList l){
        cards.addAll(l);
    }

}
