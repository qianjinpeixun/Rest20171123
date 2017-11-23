package com.qianjin.java.sss.java2s.a1101.ass43wu;



public class Deck extends Pile {

    
    public Deck(){
        super();
      //generate 52 cards in order
        for(int i=1;i<5;i++){
            for( int j=2;j<15;j++){
                Card card=new Card(i,j);
                getPile().addToEnd(card);
            }
        }
    }
    
    public void shuffle(){
        for(int i=0;i<100;i++){
            int num =  (int)(Math.random() * 52);
            Card c=getPile().getNode(num).getData();
            getPile().remove(num);
            getPile().addToEnd(c);
        }
    }
    
    public PlayerHand getLeftHand(boolean left){
        PlayerHand list=new PlayerHand();
        if(left){
            for(int i=0;i<26;i++){
                list.getPile().addToEnd(getPile().getNode(i).getData());
            }
        }else{
            for(int i=26;i<52;i++){
                list.getPile().addToEnd(getPile().getNode(i).getData());
            }
        }
        return list;
    }
    
    public Card draw(){
        return null;
    }
}
