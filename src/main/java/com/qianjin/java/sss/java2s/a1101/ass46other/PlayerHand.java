package com.qianjin.java.sss.java2s.a1101.ass46other;

import java.util.ArrayList;

public class PlayerHand extends Pile {

    public void shuffle() {
        return;
    }

    public Card draw() {
        return getPile().getFrontData();
    }
    
    public int size(){
        return getPile().size();
    }

    public Card draw(int index){
        return getPile().getNode(index).getData();
    }
    
    public boolean isEmpty(){
        return getPile().isEmpty();
    }
    
    public void removeAll(ArrayList<Card> list){
        for(int i=0;i<list.size();i++){
            getPile().remove(getPile().contains(list.get(i)));
        }
    }
    
    public void addAll(ArrayList<Card> list){
        for(int i=0;i<list.size();i++){
            getPile().addToEnd(list.get(i));
        }
    }
}
