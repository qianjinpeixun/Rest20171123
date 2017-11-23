import java.util.ArrayList;
/*Assignment3, Question 1 CSCI 1101
   Deck.java is for random 52 card and divide it to two part.
   July 23, 2017
   Ang Li B00751990 
   This is entirely my word */
public class Deck {

   private ArrayList<Card> Totalcards;//set total cards and two part of card
   private ArrayList<Card> firstPlayer;
   private ArrayList<Card> secondPlayer;

   public Deck(){
      Totalcards = new ArrayList<Card>();
      secondPlayer = new ArrayList<Card>();
      firstPlayer = new ArrayList<Card>();
   }
   
   public ArrayList<Card> getTotalCards() {//get total cards or two part of card
      return this.Totalcards;
   }
    
   public ArrayList<Card> getFirstPlayer() {
      return this.firstPlayer;
   }

   public ArrayList<Card> getSecondplayer() {
      return this.secondPlayer;
   }
   
   public void shuffle() {//shuffle method is random the 52 cards and divide it to two
      Totalcards.clear();
      firstPlayer.clear();
      secondPlayer.clear();
      for (int i = 1; i < 14; i++) {//first of all, make 52 cards
         Totalcards.add(new Card("Hearts", i));
         Totalcards.add(new Card("Diamonds", i));
         Totalcards.add(new Card("Clubs", i));
         Totalcards.add(new Card("Spades", i));
      }
      for (int i = 0; i < 52; i++) {//then use math random to random 52 cards, then add it to back of arraylist
         int no = (int)(Math.random()*52);
         Card a = Totalcards.get(no);
         Totalcards.remove(no);//remove no then add it to end of array list
         Totalcards.add(Totalcards.size(), a);  
      }
      for(int i=0;i<26;i++){//then divide random cards to two parts
         firstPlayer.add(i,Totalcards.get(i));
         secondPlayer.add(i,Totalcards.get(51-i));
      }  
   }
}