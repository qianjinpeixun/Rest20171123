package com.qianjin.java.sss.java2s.a1101.ass44gao;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Play {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int rounds = 0;
        Connect4Board game = null;
        int position = 0;
        String user1 = "RED ";
        String user2 = "YELLOW ";
        String p1 = "";
        String p2 = "";

        // using a while loop to get each player's input
        while (true) {
            // If the first time to play, show welcome message and ask players'
            // names
            if (rounds == 0) {
                game = new Connect4Board();
                System.out.print("\n\nWelcome to Connect 4. Please enter your names.\n");
                System.out.print("Player 1 name: ");
                p1 = scanner.next();
                p2 = "AI";
                System.out.print(p1 + " - you have red chips \"R\" and go first.\n");
                System.out.print(game.toString());
                user1 = "";
            } else {
                user1 = "RED ";
            }
            boolean full = true;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    if (game.getChip(i, j) == null) {
                        full = false;
                        break;
                    }
                }
                if (full == false) {
                    break;
                }
            }
            if (full) {
                PrintWriter w = new PrintWriter("board.txt");
                w.println(game.toString());
                w.println("The game is a draw after " + rounds + " turns!");
                w.close();
                System.out.println("The game is a draw after " + rounds + " turns!");
                System.out.print("Play Again? Y/N: ");// continue game
                if (scanner.next().equalsIgnoreCase("Y")) {
                    rounds = 0;
                    continue;
                } else {
                    break;
                }
            }

            System.out.print(user1 + "Please input a column# between 1 -7: ");
            while (((position = scanner.nextInt()) > 7) || (position < 1)) {// loop
                                                                            // for
                                                                            // replay
                System.out.print(user1 + " Please input a column# between 1 -7: ");
            }
            position--;
            game.add(position, "RED");
            System.out.print(game.toString());
            rounds++;
            if (game.winner()) {
                PrintWriter w = new PrintWriter("board.txt");
                w.println(game.toString());
                w.println(user1 + " – Connect 4! Congratulations " + p1 + "! You Win in " + rounds + " turns.");
                w.close();

                System.out.println(user1 + " – Connect 4! Congratulations " + p1 + "! You Win in " + rounds + " turns.");
                System.out.print("Play Again? Y/N: ");
                if (scanner.next().equalsIgnoreCase("Y")) {
                    rounds = 0;
                    continue;
                } else {
                    break;
                }
            }

            if (rounds == 1) {
                System.out.print(p2 + " - have red chips \"Y\" and go first.\n");
                user2 = "";
            } else {
                user2 = "YELLOW ";
            }

            game.auto();

            System.out.print(game.toString());
            rounds++;
            if (game.winner()) {

                PrintWriter w = new PrintWriter("board.txt");
                w.println(game.toString());
                w.println(user2 + " – Connect 4! Congratulations " + p2 + "! You Win in " + rounds + " turns.");
                w.close();

                System.out.println(user2 + " – Connect 4! Congratulations " + p2 + "! You Win in " + rounds + " turns.");
                System.out.print("Play Again? Y/N: ");
                if (scanner.next().equalsIgnoreCase("Y")) {
                    rounds = 0;
                    continue;
                } else {
                    break;
                }
            }

        }
    }
}
