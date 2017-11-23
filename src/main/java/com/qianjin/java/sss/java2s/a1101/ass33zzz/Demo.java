package com.qianjin.java.sss.java2s.a1101.ass33zzz;

import java.util.*;

public class Demo {

    public static void main(String[] args) {

        // create a full Deck of Cards
        Deck deck = new Deck();
        // ask for two player names
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Welcome to WAR! Let's Play!");
        System.out.println("");
        System.out.print("Enter the first player's name: ");
        String p1 = keyboard.next();
        System.out.print("Enter the second player's name: ");
        String p2 = keyboard.next();

        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        Card deal = null;
        int turns = 0;
        int top1 = 0;
        int top2 = 0;

        // automatically processing each turn
        do {
            if (turns == 0) {
                // shuffle the deck
                deck.shuffle();
                // split the deck for two players
                // be “dealt” as two hands to the two players (giving each
                // player their own pile of 26 cards)
                hand1.clear();
                for (int i = 0; i < 26; i++) {
                    hand1.add(deck.getList().get(i));
                }
                hand2.clear();
                for (int i = 26; i < 52; i++) {
                    hand2.add(deck.getList().get(i));
                }
                System.out.println("");
                System.out.println(p1 + "                   #Cards         " + p2 + "                   #Cards        Winner");
            } else {
                Card card1 = hand1.get(top1);
                Card card2 = hand2.get(top2);

                //if player1 wins
                if (card1.comparision(card2)) {
                    System.out
                            .println(card1.toString() + hand1.size() + "             " + card2.toString() + hand2.size() + "            " + p1 + " (Wins " + (top1 + 1) + " card)");
                    for (int i = 0; i <= top1; i++) {
                        deal = hand1.remove(0);
                        hand1.add(deal);
                    }
                    for (int i = 0; i <= top2; i++) {
                        deal = hand2.remove(0);
                        hand1.add(deal);
                    }
                } else if (card2.comparision(card1)) {
                    System.out
                            .println(card1.toString() + hand1.size() + "             " + card2.toString() + hand2.size() + "            " + p2 + " (Wins " + (top1 + 1) + " card)");
                    for (int i = 0; i <= top2; i++) {
                        deal = hand2.remove(0);
                        hand2.add(deal);
                    }
                    for (int i = 0; i <= top1; i++) {
                        deal = hand1.remove(0);
                        hand2.add(deal);
                    }
                } else {
                    System.out.println(card1.toString() + hand1.size() + "             " + card2.toString() + hand2.size() + "            " + "WAR");
                    System.out.println("*************************WAR*************************");
                    System.out.println("");
                    // enter war mode
                    top1 = 2;
                    top2 = 2;
                    boolean winner = false;
                    while (!winner) {
                        if (top1 >= hand1.size() || top2 >= hand2.size()) {
                            break;
                        }
                        Card card01 = hand1.get(top1 - 1);
                        Card card02 = hand2.get(top2 - 1);

                        if (card01.comparision(card02)) {
                            System.out.println(card01.toString() + hand1.size() + "             " + card02.toString() + hand2.size() + "            " + p1 + " (Wins " + (top1 + 1)
                                    + " card)");
                            System.out.println("");
                            for (int i = 0; i <= top1; i++) {
                                deal = hand1.remove(0);
                                hand1.add(deal);
                            }
                            for (int i = 0; i <= top2; i++) {
                                deal = hand2.remove(0);
                                hand1.add(deal);
                            }
                            top1 = 0;
                            top2 = 0;
                            System.out.println("*********************END WAR*************************");

                            winner = true;
                        } else if (card02.comparision(card01)) {
                            System.out.println(card01.toString() + hand1.size() + "             " + card02.toString() + hand2.size() + "            " + p2 + " (Wins " + (top1 + 1)
                                    + " card)");
                            System.out.println("");
                            for (int i = 0; i <= top2; i++) {
                                deal = hand2.remove(0);
                                hand2.add(deal);
                            }
                            for (int i = 0; i <= top1; i++) {
                                deal = hand1.remove(0);
                                hand2.add(deal);
                            }
                            top1 = 0;
                            top2 = 0;
                            System.out.println("*********************END WAR*************************");
                            winner = true;
                        } else {
                            System.out.println(card01.toString() + hand1.size() + "             " + card02.toString() + hand2.size() + "            " + "WAR");
                            System.out.println("*************************WAR*************************");
                            System.out.println("");
                            top1 = top1 + 2;
                            top2 = top2 + 2;
                            winner = false;
                        }

                    }
                }

                String win = "";
                boolean end = false;

                if (hand1.isEmpty() || top1 >= hand1.size()) {
                    win = p2;
                    end = true;
                }
                if (hand2.isEmpty() || top2 >= hand2.size()) {
                    win = p1;
                    end = true;
                }
                // ask the players if they would like to play again (with a
                // Yes/No prompt) and if so, start a new game with a newly
                // shuffled Deck
                if (end) {
                    System.out.println(win + " Wins! Congratulations");
                    System.out.println("Play again (y/n)?");
                    if (keyboard.next().equalsIgnoreCase("y")) {
                        deck.shuffle();
                        hand1.clear();
                        for (int i = 0; i < 26; i++) {
                            hand1.add(deck.getList().get(i));
                        }
                        hand2.clear();
                        for (int i = 26; i < 52; i++) {
                            hand2.add(deck.getList().get(i));
                        }
                        turns = 0;
                        top1 = 0;
                        top2 = 0;
                        continue;
                    } else {
                        break;
                    }
                }
            }
            turns++;
            top1 = 0;
            top2 = 0;

        } while (!hand1.isEmpty() && !hand2.isEmpty());

    }
}
