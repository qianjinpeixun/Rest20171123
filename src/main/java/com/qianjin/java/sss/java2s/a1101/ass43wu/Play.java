package com.qianjin.java.sss.java2s.a1101.ass43wu;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Play {

    public static void main(String[] args) throws Exception {
        Connect4Board board = new Connect4Board();
        String red = "R";
        String yellow = "Y";
        String name1 = "";
        String name2 = "";
        boolean b = false;
        int col = 0;
        int turns = 0;
        boolean play = true;
        String p = "";
        Scanner kb = new Scanner(System.in);

        System.out.println("Welcome to Connect 4. Please enter your names.");
        System.out.print("Player 1 name: ");
        name1 = kb.nextLine();
        name2 = "Robot";

        while (play) {
            if (board.full()) {
                PrintWriter f=new PrintWriter("connect4.txt");
                f.println(board.toString());
                f.println("The board is full! No winner!");
                f.close();
                System.out.println("The board is full!");
                System.out.print("Play Again? Y/N: ");
                p = kb.nextLine();
                if (p.toLowerCase().equals("y")) {
                    turns = 0;
                    board.reset();
                    continue;
                } else {
                    play = false;
                    continue;
                }
            }
            if (turns == 0) {
                System.out.println(name1 + " - you have red chips \"" + red + "\" and go first.\n\n");
                System.out.println(board.toString());
                System.out.print("Please input a column# between 1 -7: ");
            } else {
                System.out.print("RED Please input a column# between 1 -7: ");
            }
            board.setCurrentColor(red);
            col = kb.nextInt();
            b = board.add(col, red);
            turns++;
            System.out.println(board.toString());
            b = board.winner();
            if (b) {
                System.out.println("RED �C Connect 4! Congratulations " + name1 + "! You Win in " + turns + " turns.");
                PrintWriter f=new PrintWriter("connect4.txt");
                f.println(board.toString());
                f.println("RED �C Connect 4! Congratulations " + name1 + "! You Win in " + turns + " turns.");
                f.close();
                System.out.print("Play Again? Y/N: ");
                p = kb.next();
                if (p.toLowerCase().equals("y")) {
                    turns = 0;
                    board.reset();
                    continue;
                } else {
                    play = false;
                    continue;
                }
            }

            System.out.println(name2 + " - have yellow chips \"" + yellow + "\" and  go next.\n\n");
            if (turns == 1) {
                int num = (int) (Math.random() * 6);
                num = num + 1;
                b = board.add(num, yellow);
            } else {

                // col = kb.nextInt();
                // b = board.add(col, yellow);
                board.setCurrentColor(yellow);
                board.robot(yellow);
            }

            turns++;
            System.out.println(board.toString());
            b = board.winner();
            if (b) {
                PrintWriter f=new PrintWriter("connect4.txt");
                f.println(board.toString());
                f.println("YELLOW �C Connect 4! Congratulations " + name1 + "! You Win in " + turns + " turns.");
                f.close();

                System.out.println("YELLOW �C Connect 4! Congratulations " + name1 + "! You Win in " + turns + " turns.");
                System.out.print("Play Again? Y/N: ");
                p = kb.next();
                if (p.toLowerCase().equals("y")) {
                    turns = 0;
                    board.reset();
                    continue;

                } else {
                    play = false;
                    continue;
                }
            }

        }
    }
}
