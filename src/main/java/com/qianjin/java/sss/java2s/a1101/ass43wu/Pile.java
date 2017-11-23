package com.qianjin.java.sss.java2s.a1101.ass43wu;

public abstract class Pile {

    private LinkedList cardpile;
    public Pile(){
        cardpile =new LinkedList();
        
    }
    
    public LinkedList getPile(){
        return cardpile;
    }
    
    public void add(Card c){
        cardpile.addToFront(c);
    }
    
    public void addToBottom(Card c){
        cardpile.addToEnd(c);
    }
    
    public abstract void shuffle();
    public abstract Card draw();
}
