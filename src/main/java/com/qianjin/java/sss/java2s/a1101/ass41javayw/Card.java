package com.qianjin.java.sss.java2s.a1101.ass41javayw;


public class Card {
   private String suit;
   private int rank;
   //these arrays are used for this class only. 
   private final static String[] suitArrays = {"Spades", "Hearts", "Diamonds", "Clubs"};
   private final static int[] rankArrays = {2,3,4,5,6,7,8,9,10,11,12,13,14};
   
   //constructor.
   public Card(String S, int R) {
       suit = S;
       rank = R;
   }
   //get suit and rank.
   public String getSuit() {
       return suit;
   }

   public int getRank() {
       return rank;
   }

   // convert the rank number to poker style.
   public String toString() {
       if (rank == rankArrays[9]) {
           return "Jack  " + suit;
       }
       else if (rank == rankArrays[10]) {
           return "Queen  " + suit;
       }
       else if (rank == rankArrays[11]) {
           return "King  " + suit;
       }
       //set Ace`s rank is 14, it is highest number of rank. 
       else if (rank == rankArrays[12]) {
           return "Ace  " + suit;
       }
       return rank + "  " + suit;
   }

   // player spelling points (comparing the rank of the card) with each other.
   public boolean versus(Card c) {
       if (rank > c.getRank())
           return true;
       else
           return false;
   }

   //make sure that the rank and suit of each card wont out of index bound, and without any duplicates.
   public boolean checkValid() {
     for(int i=0; i<suitArrays.length;i++){
       if (suit.equals(suitArrays[i])) {
           if (rank > 1 && rank < 15)
               return true;
           else
               return false;
       }
     }
        return false;
   }
}
