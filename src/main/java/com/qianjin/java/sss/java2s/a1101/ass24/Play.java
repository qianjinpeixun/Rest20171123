package com.qianjin.java.sss.java2s.a1101.ass24;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Connect4Board conn = new Connect4Board();
        String player1="";
        String player2="";
        int column = 0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            if (count==0) {
                // If play again, needs to set board's chips to empty
                InitBoard(conn.getBoard());
                // Red has the first turn
                printMessage("\n\nWelcome to Connect 4. Please enter your names.\n");
               
                printMessage("Player 1 name: ");
                player1 = scanner.next();
                printMessage("Player 2 name: ");
                player2 = scanner.next();
                printMessage(player1 + " - you have red chips \"R\" and go first.\n");
                printMessage(conn.toString());
                // If the return value of add is false, do it again
                do {
                    printMessage("Please input a column# between 1 -7:");
                    column = scanner.nextInt() - 1;
                } while (!conn.add(column, "R"));
                printMessage(conn.toString());

                // The YELLOW has the next turn.
                printMessage(player2 + " - you have yellow chips \"Y\" and you go next.\n\n");
                do {
                    printMessage("Please input a column# between 1 -7:");
                    column = scanner.nextInt() - 1;
                } while (!conn.add(column, "Y"));
                printMessage(conn.toString());
                count = 2;
            }
            // If the board is full, ask if play again
            if (conn.boardIsFull()) {
                printMessage("The current board is full, no winner!\nPlay Again? Y/N: ");
                if (scanner.next().toLowerCase().equals("y")) {
                    count=0;
                } else {
                    break;
                }
            }
            // RED start to play
            do {
                printMessage("RED Please input a column# between 1 -7:");
                column = scanner.nextInt() - 1;
            } while (!conn.add(column, "R"));
            System.out.println(conn.toString());
            count++;
            // Check if there is a winner
            if (conn.winner()) {
                // If there is a winner, ask if play again
                printMessage("RED – Connect 4! Congratulations " + player1 + "! You Win in " + count + " turns.\nPlay Again? Y/N: ");
                if (scanner.next().toLowerCase().equals("y")) {
                    count=0;
                    continue;
                } else {
                    break;
                }
            }

            // YELLOW start to play
            do {
                printMessage("YELLOW Please input a column# between 1 -7:");
                column = scanner.nextInt() - 1;
            } while (!conn.add(column, "Y"));
            printMessage(conn.toString());
            count++;
            // Check if there is a winner
            if (conn.winner()) {
                // If there is a winner, ask if play again
                printMessage("YELLOW – Connect 4! Congratulations " + player2 + "! You Win in " + count + " turns.\nPlay Again? Y/N: ");
                if (scanner.next().toLowerCase().equals("y")) {
                    count=0;
                    continue;
                } else {
                    break;
                }
            }
        }
    }

    // print the message
    private static void printMessage(String s) {
        System.out.print(s);
    }

    // set all of chips in the board to null
    private static void InitBoard(Chip[][] board) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] != null) {
                    board[i][j] = null;
                }
            }
        }

    }
}
