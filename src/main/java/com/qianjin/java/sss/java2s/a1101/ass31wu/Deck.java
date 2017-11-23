package com.qianjin.java.sss.java2s.a1101.ass31wu;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> deck;
    public Deck(){
        deck =new ArrayList<Card>();
        //generate 52 cards in order
        for(int i=1;i<5;i++){
            for( int j=2;j<15;j++){
                Card card=new Card(i,j);
                deck.add(card);
            }
        }
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
    }
    
    public ArrayList<Card> getLeftHand(boolean left){
        ArrayList<Card> list=new ArrayList<Card>();
        if(left){
            for(int i=0;i<26;i++){
                list.add(deck.get(i));
            }
        }else{
            for(int i=26;i<52;i++){
                list.add(deck.get(i));
            }
        }
        return list;
    }
}
