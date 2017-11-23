package com.qianjin.java.sss.java2s.a1101.ass44gao;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Pile {

    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                getPile().addToEnd(new Card(i, j));
            }
        }
    }

    public void shuffle() {
        ArrayList<Card> card = new ArrayList<Card>();
        for (int i = 0; i < getPile().size(); i++) {
            Card c = getPile().getNode(i).getData();
            card.add(c);
        }
        Collections.shuffle(card);
        getPile().clear();
        for (int i = 0; i < card.size(); i++) {
            getPile().addToEnd(card.get(i));
        }
    }

    public Card draw() {
        Card c = getPile().getFrontData();
        getPile().removeFront();
        return c;
    }
    
    public PlayerHand get1(){
        PlayerHand p=new PlayerHand();
        for(int i=0;i<26;i++){
           p.getPile().addToEnd(getPile().getNode(i).getData());
        }
        return p;
    }
    
    public PlayerHand get2(){
        PlayerHand p=new PlayerHand();
        
        for(int i=26;i<52;i++){
            p.getPile().addToEnd(getPile().getNode(i).getData());
        }
        return p;
    }

}
