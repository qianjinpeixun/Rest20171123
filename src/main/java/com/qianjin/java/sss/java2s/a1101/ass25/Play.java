package com.qianjin.java.sss.java2s.a1101.ass25;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Connect4Board connect4Board = new Connect4Board();
        int count = 0;
        int column = 99;
        String player1 = "";
        String player2 = "";
        boolean replay = true;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            if (replay) {
                System.out.print("Welcome to Connect 4. Please enter your names.\n");
                connect4Board = new Connect4Board();

                System.out.print("Player 1 name: ");
                player1 = scanner.next();
                System.out.print("Player 2 name: ");
                player2 = scanner.next();

                System.out.print(player1 + " - you have red chips \"R\" and go first.\n");
                System.out.println(connect4Board.toString());
                column = 99;
                while (!(column < 7 && column >= 0)) {
                    System.out.print("Please input a column# between 1 -7:");
                    column = scanner.nextInt() - 1;
                }
                connect4Board.add(column, "R");
                System.out.println(connect4Board.toString());

                System.out.print(player2 + " - you have red chips \"Y\" and go first.\n");
                System.out.println("");
                column = 99;
                while (!(column < 7 && column >= 0)) {
                    System.out.print("Please input a column# between 1 -7:");
                    column = scanner.nextInt() - 1;
                }
                connect4Board.add(column, "Y");
                System.out.println(connect4Board.toString());
                count = 2;
                replay = false;
            }

            column = 99;
            while (!(column < 7 && column >= 0)) {
                System.out.print("RED Please input a column# between 1 -7: ");
                column = scanner.nextInt() - 1;
            }
            connect4Board.add(column, "R");
            System.out.println(connect4Board.toString());
            count++;
            if (connect4Board.winner()) {
                System.out.print("RED – Connect 4! Congratulations " + player1 + "! You Win in " + count + " turns.\n");
                System.out.print("Play Again? Y/N: ");
                if (scanner.next().toUpperCase().equals("Y")) {
                    replay = true;
                    continue;
                } else {
                    break;
                }
            }
            column = 99;
            while (!(column < 7 && column >= 0)) {
                System.out.print("YELLOW Please input a column# between 1 -7: ");
                column = scanner.nextInt() - 1;
            }
            connect4Board.add(column, "Y");
            System.out.println(connect4Board.toString());
            count++;
            if (connect4Board.winner()) {
                System.out.print("YELLOW – Connect 4! Congratulations " + player2 + "! You Win in " + count + " turns.\n");
                System.out.print("Play Again? Y/N: ");
                if (scanner.next().toUpperCase().equals("Y")) {
                    replay = true;
                    continue;
                } else {
                    break;
                }
            }

        }
    }
}
