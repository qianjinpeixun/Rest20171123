package com.qianjin.java.sss.java2s.a1101.ass44gao;
public class Card {
    private int suit;

    private int rank;

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String toString() {
        String s = "";
        
        if (rank==11){
            s = "Jack   ";
            }
            else if(rank==12){
            s = "Queen  ";
            }
            else if(rank==13){
            s = "King   ";
            }
            else if(rank==14){
            s = "Ace    ";
           }
       
            if (rank < 10)
                s = String.valueOf(rank) + "      ";
            else
                s = String.valueOf(rank) + "     ";
        
       if(suit==0){
            s = s + "hearts      ";
           }
       else if(suit==1){
            s = s + "diamonds    ";
            }
       else if(suit==2){
            s = s + "clubs       ";
            }
       else if(suit==3){
            s = s + "spades      ";
            }
        
        return s;

    }

    public int compare(Card c) {
        if (getRank() > c.getRank())
            return 1;
        if (getRank() < c.getRank())
            return -1;
        else
            return 0;
    }
}
