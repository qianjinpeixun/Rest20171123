package com.qianjin.java.sss.java2s.a1101.ass42larryla;

public class PlayerHand extends Pile {


    public PlayerHand(LinkedList h) {
        super();
        for(int i=0;i<h.size();i++){
            super.add(h.getNode(i).getData());
        }
    }

    public void shuffle() {
        for (int i = 0; i < 1000; i++) {
            int no = (int) (Math.random() * 26);
            Card a = getPile().getNode(no).getData();
            // remove no then add it to end of array list
            getPile().remove(no);
            getPile().add(getPile().size(), a);
        }
    }

    public Card draw() {
        Card c = getPile().getFrontData();
        getPile().removeFront();
        return c;
    }
    
    public int size(){
        return getPile().size();
    }
    
    public void addAll(LinkedList l){
        getPile().addAll(l);
    }
}
