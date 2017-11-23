package com.qianjin.java.sss.java2s.a1101.ass31wu;

import java.util.*;

public class Demo {

    public static void main(String[] args) {

        Deck deck = new Deck();
        String name1 = "";
        String name2 = "";
        ArrayList<Card> left = new ArrayList<Card>();
        ArrayList<Card> right = new ArrayList<Card>();
        ArrayList<Card> d1 = new ArrayList<Card>();
        ArrayList<Card> d2 = new ArrayList<Card>();
        int turns = 0;
        Scanner kb = new Scanner(System.in);

        System.out.println("Welcome to WAR! Let's Play!\n");
        System.out.print("Enter the first player's name: ");
        name1 = kb.next();
        System.out.print("Enter the second player's name: ");
        name2 = kb.next();

        while ((turns == 0) || (!d1.isEmpty() && !d2.isEmpty())) {

            if (turns == 0) {
                left = new ArrayList<Card>();
                right = new ArrayList<Card>();
                deck.shuffle();
                d1 = deck.getLeftHand(true);
                d2 = deck.getLeftHand(false);
                deck.getLeftHand(false);
                System.out.println("\n" + String.format("%-15s", name1) + String.format("%-10s", "#Cards") + String.format("%-15s", name2) + String.format("%-10s", "#Cards")
                        + String.format("%-20s", "Winner"));
            }
            Card c1 = d1.get(0);
            Card c2 = d2.get(0);

            if (c1.bigger(c2) == 1) {
                System.out.println(String.format("%-15s", c1) + String.format("%-10d", d1.size()) + String.format("%-15s", c2) + String.format("%-10d", d2.size())
                        + String.format("%-20s", name1 + " (wins 1 card)"));
                d2.remove(c2);
                d1.remove(c1);
                d1.add(c1);
                d1.add(c2);
            } else if (c1.bigger(c2) == -1) {
                System.out.println(String.format("%-15s", c1) + String.format("%-10d", d1.size()) + String.format("%-15s", c2) + String.format("%-10d", d2.size())
                        + String.format("%-20s", name2 + " (wins 1 card)"));
                d1.remove(c1);
                d2.remove(c2);
                d2.add(c2);
                d2.add(c1);
            } else {
                System.out.println(String.format("%-15s", c1) + String.format("%-10d", d1.size()) + String.format("%-15s", c2) + String.format("%-10d", d2.size())
                        + String.format("%-20s", "WAR"));
                System.out.println("********************WAR********************\n");
                d1.remove(c1);
                d2.remove(c2);
                left.add(c1);
                right.add(c2);
                while (true) {
                    if (d1.size() < 2) {
                        break;
                    } else if (d2.size() < 2) {
                        break;
                    }
                    Card c11 = d1.get(0);
                    Card c12 = d1.get(1);
                    Card c21 = d2.get(0);
                    Card c22 = d2.get(1);
                    left.add(c11);
                    left.add(c12);
                    right.add(c21);
                    right.add(c22);
                    d1.remove(c11);
                    d1.remove(c12);
                    d2.remove(c21);
                    d2.remove(c22);

                    if (c11.bigger(c21) == 0) {
                        System.out.println(String.format("%-15s", c11) + String.format("%-10d", d1.size() + left.size()) + String.format("%-15s", c21)
                                + String.format("%-10d", d2.size() + right.size()) + String.format("%-20s", "WAR"));
                        System.out.println("********************WAR********************\n");

                        continue;
                    } else if (c11.bigger(c21) == 1) {
                        d1.addAll(left);
                        d1.addAll(right);
                        System.out.println(String.format("%-15s", c11) + String.format("%-10d", d1.size() - left.size()) + String.format("%-15s", c21)
                                + String.format("%-10d", d2.size() + right.size()) + String.format("%-20s", name1 + " (wins " + right.size() + " cards)"));
                        System.out.println("\n********************END WAR****************");
                        left.clear();
                        right.clear();
                        break;
                    } else {
                        d2.addAll(right);
                        d2.addAll(left);
                        System.out.println(String.format("%-15s", c11) + String.format("%-10d", d1.size() + left.size()) + String.format("%-15s", c21)
                                + String.format("%-10d", d2.size() - right.size()) + String.format("%-20s", name2 + " (wins " + left.size() + " cards)"));
                        System.out.println("\n********************END WAR****************");
                        left.clear();
                        right.clear();
                        break;
                    }
                }
            }
            if (d1.isEmpty()) {
                System.out.println(name2 + " Wins! Congratulations");
                System.out.print("Play again (y/n)?");
                if (kb.next().equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.print("\n\n\n");
                    turns = 0;
                    continue;
                }
            }
            if (d2.isEmpty()) {
                System.out.println(name1 + " Wins! Congratulations");
                System.out.print("Play again (y/n)?");
                if (kb.next().equalsIgnoreCase("n")) {
                    System.out.print("\n\n\n");
                    break;
                } else {
                    turns = 0;
                    continue;
                }
            }
            turns++;
        }

    }
}
