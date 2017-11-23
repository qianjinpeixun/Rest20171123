package com.qianjin.java.sss.java2s.a1101.ass35;

import java.util.*;

public class Demo {
    private static Deck deck;
    private static String player1 = "";
    private static String player2 = "";
    private static ArrayList<Card> pile1;
    private static ArrayList<Card> pile2;

    private static ArrayList<Card> war1;
    private static ArrayList<Card> war2;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        pile1 = deck.getPile1();
        pile2 = deck.getPile2();
        war1 = new ArrayList<Card>();
        war2 = new ArrayList<Card>();
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to WAR! Let's Play!");
        System.out.print("Enter the first player's name: ");
        player1 = getStr(s.next());
        System.out.print("Enter the second player's name: ");
        player2 = getStr(s.next());
        System.out.println("");
        System.out.println(player1 + getStr(" ") + getStr("#Cards") + player2 + getStr(" ") + getStr("#Cards") + getStr("Winner"));
        boolean firstWin = false;
        boolean secondWin = false;
        boolean win1 = false;

        while (true) {
            firstWin = false;
            secondWin = false;
            Card card1 = pile1.get(0);
            Card card2 = pile2.get(0);
            war1.add(card1);
            war2.add(card2);
            if (card1.higher(card2)) {
                print1(card1, card2);
                win1 = true;
            } else if (card2.higher(card1)) {
                print2(card1, card2);
                win1 = false;
            } else {
                int index = 1;
                System.out.println(getRowStr(card1, card2) + "WAR");
                System.out.println("******************************************WAR******************************************\n");
                while (true) {
                    if ((index + 2) > pile1.size()) {
                        secondWin = true;
                        break;
                    }
                    if ((index + 2) > pile2.size()) {
                        firstWin = true;
                        break;
                    }
                    Card c11 = pile1.get(index);
                    Card c12 = pile1.get(index + 1);
                    Card c21 = pile2.get(index);
                    Card c22 = pile2.get(index + 1);
                    war1.add(c11);
                    war1.add(c12);
                    war2.add(c21);
                    war2.add(c22);

                    if (c11.higher(c21)) {
                        print1(c11, c21);
                        win1 = true;
                        System.out.println("******************************************END WAR******************************************\n");
                        break;
                    } else if (c21.higher(c11)) {
                        print2(c11, c21);
                        win1 = false;
                        System.out.println("******************************************END WAR******************************************\n");
                        break;
                    } else {
                        System.out.println(getRowStr(c11, c21) + "WAR");
                        System.out.println("******************************************WAR******************************************\n");
                        index = index + 2;
                    }
                }
            }

            if (secondWin) {
                System.out.println(player2 + " Wins! Congratulations0");
                if (!checkPlayAgain()) {
                    break;
                }
            }

            if (firstWin) {
                System.out.println(player1 + " Wins! Congratulations0");
                if (!checkPlayAgain()) {
                    break;
                }
            }

            if (win1) {
                remove1();
            } else {
                remove2();
            }

            if (pile1.isEmpty()) {
                System.out.println(player2 + " Wins! Congratulations0");
                if (!checkPlayAgain()) {
                    break;
                }
            }

            if (pile2.isEmpty()) {
                System.out.println(player1 + " Wins! Congratulations0");
                if (!checkPlayAgain()) {
                    break;
                }
            }

        }

    }

    private static void remove1() {

        pile1.removeAll(war1);
        pile1.addAll(war1);
        pile1.addAll(war2);
        pile2.removeAll(war2);
        war1.clear();
        war2.clear();
    }

    private static void remove2() {

        pile2.removeAll(war2);
        pile2.addAll(war2);
        pile2.addAll(war1);
        pile1.removeAll(war1);
        war1.clear();
        war2.clear();
    }

    private static boolean checkPlayAgain() {
        Scanner s = new Scanner(System.in);
        System.out.print("Play again (y/n)? ");
        if (s.next().equalsIgnoreCase("y")) {
            System.out.println("");
            System.out.println(player1 + getStr("#Cards") + player2 + getStr("#Cards") + getStr("Winner"));
            deck = new Deck();
            deck.shuffle();
            pile1 = deck.getPile1();
            pile2 = deck.getPile2();
            war1 = new ArrayList<Card>();
            war2 = new ArrayList<Card>();
            return true;
        } else {
            return false;
        }
    }

    private static String getStr(String s) {
        return String.format("%-10s", s);
    }

    private static String getStr(int s) {
        return String.format("%-10d", s);
    }

    private static String getRowStr(Card car1, Card car2) {
        return car1.toString() + getStr(pile1.size()) + car2.toString() + getStr(pile2.size());
    }

    private static void print1(Card card1, Card card2) {
        String o = getRowStr(card1, card2) + getStr(player1);
        if (war1.size() == 1)
            System.out.println(o + getStr("(wins " + war1.size() + " card)"));
        else
            System.out.println(o + getStr("(wins " + war1.size() + " cards)"));
    }

    private static void print2(Card card1, Card card2) {
        String o = getRowStr(card1, card2) + getStr(player2);
        if (war2.size() == 1)
            System.out.println(o + getStr("(wins " + war1.size() + " card)"));
        else
            System.out.println(o + getStr("(wins " + war1.size() + " cards)"));
    }

}
