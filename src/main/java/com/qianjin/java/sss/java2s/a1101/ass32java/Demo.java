package com.qianjin.java.sss.java2s.a1101.ass32java;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Deck deck;
        ArrayList<Card> secondHalf;
        ArrayList<Card> firstHalf;
        ArrayList<Card> firstUP = new ArrayList<Card>();
        ArrayList<Card> secondUp = new ArrayList<Card>();

        boolean play = true;
        Scanner kb = new Scanner(System.in);
        String p = "";
        String name1 = "";
        String name2 = "";
        String output1 = "";
        String output2 = "";
        String output = "";

        deck = new Deck();
        deck.shuffle();
        firstHalf = deck.getFirstHalf();
        secondHalf = deck.getSecondHalf();

        System.out.println("Welcome to WAR! Let's Play!");
        System.out.println("");
        System.out.print("Enter the first player's name: ");
        name1 = kb.next();
        System.out.print("Enter the second player's name: ");
        name2 = kb.next();
        System.out.println("");
        System.out.println(name1 + "               #Cards     " + name2 + "               #Cards     Winner");

        // start to play
        while (play) {
            firstUP.add(firstHalf.remove(0));
            secondUp.add(secondHalf.remove(0));
            int length1 = firstHalf.size() + 1;
            int length2 = secondHalf.size() + 1;

            // format the output message
            output1 = firstUP.get(0).toString();
            for (int i = 0; i < 16 - firstUP.get(0).toString().length(); i++) {
                output1 = output1 + " ";
            }
            if (firstHalf.size() < 10) {
                output1 = output1 + length1 + "          ";
            } else {
                output1 = output1 + length1 + "         ";
            }
            // format the output message
            output2 = secondUp.get(0).toString();
            for (int i = 0; i < 16 - secondUp.get(0).toString().length(); i++) {
                output2 = output2 + " ";
            }
            if (secondHalf.size() < 10) {
                output2 = output2 + length2 + "          ";
            } else {
                output2 = output2 + length2 + "         ";
            }
            output = output1 + output2;
            // if firstCard is higher than 2nd
            if (firstUP.get(0).compare(secondUp.get(0))) {
                System.out.println(output + name1 + " (Wins" + " 1 card)");
                firstHalf.addAll(firstUP);
                firstHalf.addAll(secondUp);
                firstUP.clear();
                secondUp.clear();
            } else if (secondUp.get(0).compare(firstUP.get(0))) {
                System.out.println(output + name2 + " (Wins" + " 1 card)");
                secondHalf.addAll(secondUp);
                secondHalf.addAll(firstUP);
                firstUP.clear();
                secondUp.clear();
            } else {
                // if the cards are the same
                System.out.println(output + "WAR");

                if (firstHalf.size() < 2 || secondHalf.size() < 2) {
                    if (firstHalf.size() < 2) {
                        output = name2 + " Wins! Congratulations";
                    } else {
                        output = name1 + " Wins! Congratulations";
                    }
                    System.out.println(output);
                    System.out.print("Play Again? Y/N: ");
                    p = kb.next();
                    if (p.toLowerCase().equals("y")) {
                        deck.shuffle();
                        continue;
                    } else {
                        play = false;
                        continue;

                    }
                }

                int index = 0;
                while (true) {
                    if (firstHalf.size() < 2 || secondHalf.size() < 2) {
                        if (firstHalf.size() < 2) {
                            output = name2 + " Wins! Congratulations";
                        } else {
                            output = name1 + " Wins! Congratulations";
                        }
                        System.out.println(output);
                        System.out.print("Play Again? Y/N: ");
                        p = kb.next();
                        if (p.toLowerCase().equals("y")) {
                            deck.shuffle();
                            continue;
                        } else {
                            play = false;
                            continue;
                        }
                    }

                    output = "*********************WAR*********************\n";
                    System.out.println(output);
                    firstUP.add(firstHalf.remove(0));
                    firstUP.add(firstHalf.remove(0));
                    secondUp.add(secondHalf.remove(0));
                    secondUp.add(secondHalf.remove(0));

                    output1 = firstUP.get(index * 2 + 1).toString();
                    for (int i = 0; i < 16 - firstUP.get(index * 2 + 1).toString().length(); i++) {
                        output1 = output1 + " ";
                    }
                    if (firstHalf.size() < 10) {
                        output1 = output1 + length1 + "          ";
                    } else {
                        output1 = output1 + length1 + "         ";
                    }
                    output2 = secondUp.get(index * 2 + 1).toString();
                    for (int i = 0; i < 16 - secondUp.get(index * 2 + 1).toString().length(); i++) {
                        output2 = output2 + " ";
                    }
                    if (secondHalf.size() < 10) {
                        output2 = output2 + length2 + "          ";
                    } else {
                        output2 = output2 + length2 + "         ";
                    }
                    output = output1 + output2;

                    if (firstUP.get(index * 2 + 1).compare(secondUp.get(index * 2 + 1))) {
                        System.out.println(output + name1 + " (Wins" + " " + secondUp.size() + " card)");
                        firstHalf.addAll(firstUP);
                        firstHalf.addAll(secondUp);
                        output = "\n*****************END WAR*********************\n";
                        System.out.println(output);
                        firstUP.clear();
                        secondUp.clear();
                        break;
                    } else if (secondUp.get(index * 2 + 1).compare(firstUP.get(index * 2 + 1))) {
                        System.out.println(output + name2 + " (Wins" + " " + firstUP.size() + " card)");
                        secondHalf.addAll(secondUp);
                        secondHalf.addAll(firstUP);
                        output = "\n*****************END WAR*********************\n";
                        System.out.println(output);
                        firstUP.clear();
                        secondUp.clear();
                        break;
                    } else {
                        System.out.println(output + "WAR");
                        index++;
                    }
                }
            }

            if (firstHalf.size() == 0 || secondHalf.size() == 0) {
                if (firstHalf.size() == 0) {
                    output = name2 + " Wins! Congratulations";
                } else {
                    output = name1 + " Wins! Congratulations";
                }
                System.out.println(output);
                System.out.print("Play Again? Y/N: ");
                p = kb.next();
                if (p.toLowerCase().equals("y")) {
                    deck.shuffle();
                    continue;
                } else {
                    play = false;
                    continue;
                }

            }
        }

    }
}
