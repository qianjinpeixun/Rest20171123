/*Assignment3, Question 1 CSCI 1101
  Deck.java game stores a collection of Cards in an ArrayList.
   July 23, 2017
   Yiping Liang B00744822
   This is entirely my own work. */
import java.util.ArrayList;
import java.util.*;

public class Deck {

    ArrayList<Card> cards = new ArrayList<Card>();

    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                cards.add(new Card(i, j));
            }
        }
    }
    
    public void shuffle(){
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}
