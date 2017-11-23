package com.qianjin.java.sss.java2s.a1101.ass43wu;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Deck deck = new Deck();
        String name1 = "";
        String name2 = "";
        LinkedList left = new LinkedList();
        LinkedList right = new LinkedList();
        PlayerHand d1 = new PlayerHand();
        PlayerHand d2 = new PlayerHand();
        int turns = 0;
        Scanner kb = new Scanner(System.in);

        System.out.println("Welcome to WAR! Let's Play!\n");
        System.out.print("Enter the first player's name: ");
        name1 = kb.next();
        System.out.print("Enter the second player's name: ");
        name2 = kb.next();

        while ((turns == 0) || (!d1.getPile().isEmpty() && !d2.getPile().isEmpty())) {

            if (turns == 0) {
                left = new LinkedList();
                right = new LinkedList();
                deck.shuffle();
                d1 = deck.getLeftHand(true);
                d2 = deck.getLeftHand(false);
                System.out.println("\n" + String.format("%-15s", name1) + String.format("%-10s", "#Cards") + String.format("%-15s", name2) + String.format("%-10s", "#Cards")
                        + String.format("%-20s", "Winner"));
            }
            Card c1 = d1.draw();
            Card c2 = d2.draw();

            if (c1.bigger(c2) == 1) {
                System.out.println(String.format("%-15s", c1) + String.format("%-10d", d1.getPile().size()) + String.format("%-15s", c2) + String.format("%-10d", d2.getPile().size())
                        + String.format("%-20s", name1 + " (wins 1 card)"));
                d2.getPile().remove(d2.getPile().contains(c2));
                d1.getPile().remove(d1.getPile().contains(c1));
                d1.getPile().addToEnd(c1);
                d1.getPile().addToEnd(c2);
            } else if (c1.bigger(c2) == -1) {
                System.out.println(String.format("%-15s", c1) + String.format("%-10d", d1.getPile().size()) + String.format("%-15s", c2) + String.format("%-10d", d2.getPile().size())
                        + String.format("%-20s", name2 + " (wins 1 card)"));
                d1.getPile().remove(d1.getPile().contains(c1));
                d2.getPile().remove(d2.getPile().contains(c2));
                d2.getPile().addToEnd(c2);
                d2.getPile().addToEnd(c1);
            } else {
                System.out.println(String.format("%-15s", c1) + String.format("%-10d", d1.getPile().size()) + String.format("%-15s", c2) + String.format("%-10d", d2.getPile().size())
                        + String.format("%-20s", "WAR"));
                System.out.println("********************WAR********************\n");
                d1.getPile().remove(d1.getPile().contains(c1));
                d2.getPile().remove(d2.getPile().contains(c2));
                left.addToEnd(c1);
                right.addToEnd(c2);
                while (true) {
                    if (d1.getPile().size() < 2) {
                        break;
                    } else if (d2.getPile().size() < 2) {
                        break;
                    }
                    Card c11 = d1.getPile().getNode(0).getData();
                    Card c12 = d1.getPile().getNode(1).getData();
                    Card c21 = d2.getPile().getNode(0).getData();
                    Card c22 = d2.getPile().getNode(1).getData();
                    left.addToEnd(c11);
                    left.addToEnd(c12);
                    right.addToEnd(c21);
                    right.addToEnd(c22);
                    d1.getPile().remove(d1.getPile().contains(c11));
                    d1.getPile().remove(d1.getPile().contains(c12));
                    d2.getPile().remove(d2.getPile().contains(c21));
                    d2.getPile().remove(d2.getPile().contains(c22));

                    if (c11.bigger(c21) == 0) {
                        System.out.println(String.format("%-15s", c11) + String.format("%-10d", d1.getPile().size() + left.size()) + String.format("%-15s", c21)
                                + String.format("%-10d", d2.getPile().size() + right.size()) + String.format("%-20s", "WAR"));
                        System.out.println("********************WAR********************\n");

                        continue;
                    } else if (c11.bigger(c21) == 1) {
                        d1.getPile().addAll(left);
                        d1.getPile().addAll(right);
                        System.out.println(String.format("%-15s", c11) + String.format("%-10d", d1.getPile().size() - left.size()) + String.format("%-15s", c21)
                                + String.format("%-10d", d2.getPile().size() + right.size()) + String.format("%-20s", name1 + " (wins " + right.size() + " cards)"));
                        System.out.println("\n********************END WAR****************");
                        left.clear();
                        right.clear();
                        break;
                    } else {
                        d2.getPile().addAll(right);
                        d2.getPile().addAll(left);
                        System.out.println(String.format("%-15s", c11) + String.format("%-10d", d1.getPile().size() + left.size()) + String.format("%-15s", c21)
                                + String.format("%-10d", d2.getPile().size() - right.size()) + String.format("%-20s", name2 + " (wins " + left.size() + " cards)"));
                        System.out.println("\n********************END WAR****************");
                        left.clear();
                        right.clear();
                        break;
                    }
                }
            }
            if (d1.getPile().isEmpty()) {
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
            if (d2.getPile().isEmpty()) {
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
