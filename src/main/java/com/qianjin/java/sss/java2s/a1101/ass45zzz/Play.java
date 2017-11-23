package com.qianjin.java.sss.java2s.a1101.ass45zzz;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Play {

    public static void main(String[] args) throws Exception {

        Connect4Board connect4 = new Connect4Board();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to connect 4. Please enter your names.");
        // Using scanner object to collect the names of the two players
        System.out.print("Player 1 name: ");
        String p1 = keyboard.next();
        String p2 = "AI";
        AI ai = new AI(connect4);
        PrintWriter writer = new PrintWriter("Connect4Board.txt");
        int turns = 0;
        int col = 0;
        Chip chip;
        boolean added = false;
        while (true) {

            if (connect4.isFull()) {
                System.out.println("The board is full and no more pieces may be added, game over!");
                writer.println(connect4.toString());
                writer.println("The board is full and no more pieces may be added, game over!");
                writer.close();
                break;
            }

            if (turns == 0) {
                System.out.println(p1 + " - you have red chips \"R\" and you go first.");
                System.out.println(connect4.toString());
                // collect each of their moves (the column into which they want
                // to add one of their Chips)
                while (true) {
                    System.out.print("Please input a column# between 1-7: ");
                    col = keyboard.nextInt();
                    if (col >= 1 && col <= 7)
                        break;
                }
                chip = new Chip("Red");
                connect4.add(col - 1, "red");
                turns++;
                System.out.println(connect4.toString());
                System.out.println(p2 + " - has yellow chips \"Y\" and go next\n");
                // The first turn, place a chip at random position
                col = ai.getRandom();
                chip = new Chip("Yellow");
                connect4.add(col - 1, "Yellow");
                turns++;
                System.out.println(connect4.toString());
            } else {
                while (true) {
                    System.out.print("RED Please input a column# between 1-7: ");
                    col = keyboard.nextInt();
                    if (col < 1 || col > 7)
                        continue;
                    chip = new Chip("RED");
                    added = connect4.add(col - 1, "RED");
                    if (added) {
                        break;
                    }
                }
                System.out.println(connect4.toString());
                boolean win = connect4.winner();
                turns++;
                if (win) {
                    System.out.println("RED - Connect 4! Congratulations " + p1 + "! You Win in " + turns + " turns.");
                    writer.println(connect4.toString());
                    writer.println("RED - Connect 4! Congratulations " + p1 + "! You Win in " + turns + " turns.");
                    writer.close();
                    System.out.print("Play Again? Y/N: ");
                    String answer = keyboard.next().toLowerCase();
                    if (answer.charAt(0) == 'y') {
                        connect4 = new Connect4Board();
                        turns = 0;
                        continue;
                    } else {
                        break;
                    }
                }

                connect4.setWinCount(3);
                // found a best position to place a chip
                col = ai.getColumn();
                connect4.add(col, "Yellow");
                connect4.setWinCount(4);
                System.out.print("AI place at column: " + (col + 1));
                System.out.println(connect4.toString());

                win = connect4.winner();
                turns++;
                if (win) {
                    System.out.println("Yellow - Connect 4! Congratulations " + p2 + "! You Win in " + turns + " turns.");
                    writer.println(connect4.toString());
                    writer.println("AI Win in " + turns + " turns.");
                    writer.close();
                    System.out.print("Play Again? Y/N: ");
                    String answer = keyboard.next().toLowerCase();
                    if (answer.charAt(0) == 'y') {
                        connect4 = new Connect4Board();
                        turns = 0;
                        System.out.println();
                        continue;
                    } else {
                        break;
                    }

                }
            }
        }

    }

}
