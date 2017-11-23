/*
 * A CS1101 abstract class for a Pile of Cards.
 * Intended to work only with Card objects.
 * 
 * Author: Jeremy Porter
 */ 
 
public abstract class Pile {
   private LinkedList cardpile;

   public Pile() {
      cardpile = new LinkedList();
   }
   
   public LinkedList getPile() {
      return cardpile;
   }   
   
   public void add(Card c) {
      addToBottom(c);
   }
   
   public void addToBottom(Card c) {
      cardpile.addToEnd(c);
   }
   
   
   public abstract void shuffle();
   
   public abstract Card draw();
   
}