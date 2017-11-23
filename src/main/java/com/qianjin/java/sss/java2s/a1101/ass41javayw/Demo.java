package com.qianjin.java.sss.java2s.a1101.ass41javayw;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        LinkedList p1Putin = new LinkedList();
        LinkedList p2Putin = new LinkedList();

        boolean getStart = true;
        Scanner sc = new Scanner(System.in);
        String Enter = "";
        String Round = "";

        // get a new deck object and two players`card arraylists from deck
        // class.
        Deck deck = new Deck();
        deck.shuffle();
        PlayerHand playerHand1 = new PlayerHand(deck.getHalfForP1());
        PlayerHand playerHand2 = new PlayerHand(deck.getHalfForP2());
        playerHand1.shuffle();
        playerHand2.shuffle();

        System.out.println("Welcome to WAR! Let's Play!");
        System.out.println();

        System.out.print("Enter the first player's name: ");
        String Player1 = sc.next();
        System.out.print("Enter the second player's name: ");
        String Player2 = sc.next();

        System.out.println();
        System.out.println(Player1 + "            #Cards         " + Player2 + "            #Cards         Winner");

        // getting start the game.
        while (getStart) {

            Card cd1 = playerHand1.draw();
            p1Putin.addToEnd(cd1);

            Card cd2 = playerHand2.draw();
            p2Putin.addToEnd(cd2);

            // get the length of each arraylist (+1 beacuse it start from 0).
            int length1 = playerHand1.size() + 1;
            int length2 = playerHand2.size() + 1;

            // using loop to format the output.
            String p1Turn = p1Putin.getNode(0).getData().toString();
            for (int i = 0; i < 16 - p1Putin.getNode(0).getData().toString().length(); i++) {
                p1Turn = p1Turn + " ";
            }
            // 10 space if the number of rank lees than 10.
            if (playerHand1.size() < 10)
                p1Turn = p1Turn + length1 + "            ";
            // 9 space if the number of rank greater than 10.
            else
                p1Turn = p1Turn + length1 + "           ";

            String p2Turn = p2Putin.getNode(0).getData().toString();
            for (int i = 0; i < 16 - p2Putin.getNode(0).getData().toString().length(); i++) {
                p2Turn = p2Turn + " ";
            }
            if (playerHand2.size() < 10) {
                p2Turn = p2Turn + length2 + "            ";
            } else {
                p2Turn = p2Turn + length2 + "           ";
            }
            Round = p1Turn + p2Turn;

            /*
             * Comparation, if the rank of plyaer1`s card is greater than
             * player2s, then print out player1 win this round. and the winner
             * obtain 3 cards from competitor`s card arraylist. Moreover, remove
             * all of elements that in 'player put in' ArrayLists, after each
             * round.
             */
            if (p1Putin.getNode(0).getData().versus(p2Putin.getNode(0).getData())) {
                System.out.println(Round + Player1 + " (Wins" + " 1 card)");
                playerHand1.addAll(p1Putin);
                playerHand1.addAll(p2Putin);
                p1Putin.clear();
                p2Putin.clear();
            }
            // same above but print out player2 win this round.
            else if (p2Putin.getNode(0).getData().versus(p1Putin.getNode(0).getData())) {
                System.out.println(Round + Player2 + " (Wins" + " 1 card)");
                playerHand2.addAll(p2Putin);
                playerHand2.addAll(p1Putin);
                p1Putin.clear();
                p2Putin.clear();
            }

            // otherwise, its warring time if both of two player get same rank
            // of cards.
            else {
                System.out.println(Round + "WAR");

                // the player will lose the game if his/her remaining cards are
                // less than two before starting the war. then print out the
                // winner.
                if (playerHand1.size() < 2 || playerHand2.size() < 2) {
                    if (playerHand1.size() < 2) {
                        Round = Player2 + " Wins! Congratulations";
                    } else {
                        Round = Player1 + " Wins! Congratulations";
                    }
                    System.out.println(Round);

                    System.out.print("Play Again? Y/N: ");
                    Enter = sc.next();
                    if (Enter.toLowerCase().equals("y")) {
                        deck.shuffle();
                        playerHand1 = new PlayerHand(deck.getHalfForP1());
                        playerHand2 = new PlayerHand(deck.getHalfForP2());
                        playerHand1.shuffle();
                        playerHand2.shuffle();
                        continue;
                    } else {
                        System.out.println("Thanks for playing !");
                        getStart = false;
                        continue;

                    }
                }
                // loop the warring time, same rules above.
                int index = 0;
                while (true) {
                    if (playerHand1.size() < 2 || playerHand2.size() < 2) {
                        if (playerHand1.size() < 2) {
                            Round = Player2 + " Wins! Congratulations";
                        } else {
                            Round = Player1 + " Wins! Congratulations";
                        }

                        System.out.println(Round);
                        System.out.print("Play Again? Y/N: ");
                        Enter = sc.next();
                        if (Enter.toLowerCase().equals("y")) {
                            deck.shuffle();
                            playerHand1 = new PlayerHand(deck.getHalfForP1());
                            playerHand2 = new PlayerHand(deck.getHalfForP2());
                            playerHand1.shuffle();
                            playerHand2.shuffle();
                            continue;
                        } else {
                            System.out.println("Thanks for playing !");
                            getStart = false;
                            continue;
                        }
                    }

                    Round = "\n*********************WAR*********************\n";
                    System.out.println(Round);
                    // Each player draws out two cards from their card arraylist
                    // to prepare to the war.

                    Card car1 = playerHand1.draw();
                    p1Putin.addToEnd(car1);

                    car1 = playerHand1.draw();
                    p1Putin.addToEnd(car1);

                    car1 = playerHand2.draw();
                    p2Putin.addToEnd(car1);

                    car1 = playerHand2.draw();
                    p2Putin.addToEnd(car1);

                    // show the suit and rank of the card that player1 put in
                    // the 'battlefield'.
                    p1Turn = p1Putin.getNode(index * 2 + 1).getData().toString();
                    for (int i = 0; i < 16 - p1Turn.length(); i++)
                        p1Turn = p1Turn + " ";

                    // same above, just used to format the output.
                    if (playerHand1.size() < 10)
                        p1Turn = p1Turn + length1 + "          ";
                    else
                        p1Turn = p1Turn + length1 + "         ";

                    // same as player1 do.
                    p2Turn = p2Putin.getNode(index * 2 + 1).getData().toString();
                    for (int i = 0; i < 16 - p2Turn.length(); i++) {
                        p2Turn = p2Turn + " ";
                    }
                    if (playerHand2.size() < 10)
                        p2Turn = p2Turn + length2 + "          ";

                    else
                        p2Turn = p2Turn + length2 + "         ";

                    // to sum up the information of this round.
                    Round = p1Turn + p2Turn;

                    /*
                     * in the war time, if some player get win the warring
                     * round, they can obtain all of the card that both of them
                     * put in. (include him/herself)
                     */
                    if (p1Putin.getNode(index * 2 + 1).getData().versus(p2Putin.getNode(index * 2 + 1).getData())) {
                        System.out.println(Round + Player1 + " (Wins" + " " + p2Putin.size() + " card)");
                        playerHand1.addAll(p1Putin);
                        playerHand1.addAll(p2Putin);
                        Round = "\n*****************END WAR*********************\n";
                        System.out.println(Round);
                        p1Putin.clear();
                        p2Putin.clear();
                        break;
                    }

                    else if (p2Putin.getNode(index * 2 + 1).getData().versus(p1Putin.getNode(index * 2 + 1).getData())) {
                        System.out.println(Round + Player2 + " (Wins" + " " + p1Putin.size() + " card)");
                        playerHand2.addAll(p2Putin);
                        playerHand2.addAll(p1Putin);
                        Round = "\n*****************END WAR*********************\n";
                        System.out.println(Round);
                        p1Putin.clear();
                        p2Putin.clear();
                        break;
                    }
                    // otherwise, the warring time wont be stop (back to the
                    // while loop) until some player get greater rank of card
                    // than the others.
                    else {
                        System.out.println(Round + "WAR");
                        index++;
                    }
                }
            }

            // if some player lose all of the card (the size of card arraylist
            // equals to zero), then he/she lose. print out the winner
            if (playerHand1.size() == 0 || playerHand2.size() == 0) {
                if (playerHand1.size() == 0) {
                    Round = Player2 + " Wins! Congratulations";
                } else {
                    Round = Player1 + " Wins! Congratulations";
                }
                System.out.println(Round);

                System.out.print("Play Again? (y/n): ");
                Enter = sc.next();
                if (Enter.toLowerCase().equals("y")) {
                    deck.shuffle();
                    playerHand1 = new PlayerHand(deck.getHalfForP1());
                    playerHand2 = new PlayerHand(deck.getHalfForP2());
                    playerHand1.shuffle();
                    playerHand2.shuffle();
                    continue;
                } else {
                    getStart = false;
                    System.out.println("Thanks for playing !");
                }
            }
        }

    }
}
