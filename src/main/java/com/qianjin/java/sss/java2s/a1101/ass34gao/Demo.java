package com.qianjin.java.sss.java2s.a1101.ass34gao;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 0;
        Deck game = null;
        String p1 = "";
        String p2 = "";
        ArrayList<Card> player1 = null;
        ArrayList<Card> player2 = null;

        // using a while loop to each round
        while (true) {
            // if the first time, create a deck and shuffle the cards
            if (rounds == 0) {
                game = new Deck();
                game.shuffle();
                player1 = new ArrayList<Card>();
                player2 = new ArrayList<Card>();
                player1.addAll(game.getCards().subList(0, 26));
                player2.addAll(game.getCards().subList(26, game.getCards().size()));

                System.out.println("Welcome to WAR! Let's Play!");
                System.out.println("");
                System.out.print("Enter the first player's name: ");
                p1 = scanner.next();
                System.out.print("Enter the second player's name: ");
                p2 = scanner.next();
                System.out.println(p1 + "                 #cards  " + p2 + "                  #cards  " + "Winner");

            }
            // deal one card for each player
            Card card1 = player1.remove(0);
            Card card2 = player2.remove(0);
            int size1 = player1.size() + 1;
            int size2 = player2.size() + 1;
            // which card's rank is big
            if (card1.compare(card2) == 1) {
                print(card1, card2, size1, size2, p1 + " (wins 1 card)");
                player1.add(card1);
                player1.add(card2);
            } else if (card1.compare(card2) == -1) {
                print(card1, card2, size1, size2, p2 + " (wins 1 card)");
                player2.add(card2);
                player2.add(card1);
            } else {
                // if the rank of each card is the same, start the war
                ArrayList<Card> warCards1 = new ArrayList<Card>();
                ArrayList<Card> warCards2 = new ArrayList<Card>();
                warCards1.add(card1);
                warCards2.add(card2);
                print(card1, card2, size1, size2, "WAR");
                System.out.println("***********************WAR***********************");
                System.out.println("");
                while (true) {
                    // if no sufficient cards, exit the inner loop
                    if (player1.size() < 2) {
                        player1.clear();
                        break;
                    } else if (player2.size() < 2) {
                        player2.clear();
                        break;
                    }
                    // deal two cards in each turn
                    Card c1 = player1.remove(0);
                    warCards1.add(c1);
                    warCards1.add(player1.remove(0));
                    Card c2 = player2.remove(0);
                    warCards2.add(c2);
                    warCards2.add(player2.remove(0));
                    size1 = player1.size() + warCards1.size();
                    size2 = player2.size() + warCards1.size();
                    if (c1.compare(c2) == 1) {
                        print(c1, c2, size1, size2, p1 + " (wins " + warCards1.size() + " card)");
                        player1.addAll(warCards1);
                        player1.addAll(warCards2);
                        System.out.println("");
                        System.out.println("*******************END WAR***********************");
                        break;
                    } else if (c1.compare(c2) == -1) {
                        print(c1, c2, size1, size2, p2 + " (wins " + warCards2.size() + " card)");
                        player2.addAll(warCards2);
                        player2.addAll(warCards1);
                        System.out.println("");
                        System.out.println("*******************END WAR***********************");
                        break;
                    } else {
                        print(c1, c2, size1, size2, "WAR");
                        System.out.println("\n***********************WAR***********************");
                        System.out.println("");
                    }
                }
            }
            boolean winner = false;
            if (player1.size() == 0) {
                System.out.println(p2 + " Wins! Congratulations");
                winner = true;
            }
            if (player2.size() == 0) {
                System.out.println(p1 + " Wins! Congratulations");
                winner = true;
            }
            if (winner) {
                System.out.print("Play again (y/n)?");
                if (scanner.next().toLowerCase().charAt(0) == 'y') {
                    rounds = 0;
                    continue;
                } else {
                    break;
                }
            }
            rounds++;
        }

    }

    private static void print(Card card1, Card card2, int count1, int count2, String s) {
        String space1 = "      ";
        String space2 = "      ";
        if (count1 < 10) {
            space1 = space1 + " ";
        }
        if (count2 < 10) {
            space2 = space2 + " ";
        }

        System.out.println(card1.toString() + count1 + space1 + card2.toString() + count2 + space2 + s);

    }
}
