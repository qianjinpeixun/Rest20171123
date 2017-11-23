package com.qianjin.java.sss.java2s.a1101.ass41javayw;



public class Deck extends Pile {

    private LinkedList halfForP1;
    private LinkedList halfForP2;

    public Card draw() {

        return null;
    }

    // store the cards and players`card arraylist in the constructor.
    public Deck() {
        super();
        halfForP1 = new LinkedList();
        halfForP2 = new LinkedList();
    }

    public LinkedList getDeck() {
        return getCardpile();
    }

    public LinkedList getHalfForP1() {
        return halfForP1;
    }

    public LinkedList getHalfForP2() {
        return halfForP2;
    }

    // shuffle the deck.
    public void shuffle() {
        // make sure these arraylist are empty(remove all of elements that
        // remained by last game) before shuffling.
        LinkedList cards = getCardpile();
        cards.clear();
        halfForP1.clear();
        halfForP2.clear();

        /*
         * keep creating new card until the number of cards rise to 52. we see
         * every four suits as a group. and there are 13 groups in total.
         */
        for (int rank = 2; rank < 15; rank++) {
            Card Hearts = new Card("Hearts", rank);
            add(Hearts);

            Card Spades = new Card("Spades", rank);
            add(Spades);

            Card Clubs = new Card("Clubs", rank);
            add(Clubs);

            Card Diamonds = new Card("Diamonds", rank);
            add(Diamonds);

        }

        // using for loop to shuffle this deck.
        int Random, maxNum, minNum, range;
        for (int i = 0; i < 999; i++) {
            maxNum = 51;
            minNum = 0;
            range = (maxNum - minNum) + 1;
            Random = (int) Math.floor(Math.random() * range) + minNum;
            Card c = cards.getNode(Random).getData();
            cards.remove(Random);
            cards.add(cards.size(), c);
        }

        // after shuffling, select 26 different numbers from 0 to 51 (as
        // interval)randomly.
        int[] r = new int[26];
        int count = 0;
        while (count < 26) {
            maxNum = 51;
            minNum = 0;
            range = (maxNum - minNum) + 1;
            Random = (int) Math.floor(Math.random() * range) + minNum;

            // check if the element already in the integer arrays (make sure no
            // duplicates).
            boolean notRepeat = true;
            for (int j = 0; j < 26; j++) {
                if (Random == r[j]) {
                    notRepeat = false;
                    break;
                }
            }
            if (notRepeat) {
                r[count] = Random;
                count++;
            }
        }

        // Separat the deck for players, and each player get half.
        for (int i = 0; i < 52; i++) {
            boolean forPlayer1 = false;
            for (int j = 0; j < 26; j++) {
                if (i == r[j]) {
                    forPlayer1 = true;
                    break;
                }
            }
            if (forPlayer1) {
                halfForP1.addToEnd(cards.getNode(i).getData());
            }
            // player2 get the remained half, after player1 get a half set of
            // deck.
            else {
                halfForP2.addToEnd(cards.getNode(i).getData());
            }
        }
    }

}
