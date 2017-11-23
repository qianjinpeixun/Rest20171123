package com.qianjin.java.sss.java2s.a1101.ass41javayw;


import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Play {
    static int gameBreak = 0;
    static boolean isRed = false;
    static boolean isYellow = false;
    static String R = "R";
    static String Y = "Y";

    public static void main(String[] args) throws IOException {
        while (gameBreak == 0) {
            gettingStart();
        }
    }

    public static void printToFile(Connect4Board c4, String line) throws IOException {
        String[] ss = c4.toString().split("\n");
        BufferedWriter bw = new BufferedWriter(new FileWriter("play.txt"));
        for (int i = 0; i < ss.length; i++) {
            bw.write(ss[i]);
            bw.newLine();
        }
        bw.newLine();
        bw.write(line);
        bw.close();
    }

    public static void gettingStart() throws IOException {

        Scanner sc = new Scanner(System.in);
        Connect4Board c4 = new Connect4Board();

        int c;
        String p1, p2;

        // getting start.
        System.out.println("Welcome to Connect 4. Please enter your names.");
        p1 = sc.next();
        p2 = "AI";
        System.out.println(p1 + " - you have red chips 'R' and you go first.");
        System.out.println(c4);
        System.out.println(" Please input a column# between 1-7: ");
        c = sc.nextInt();
        c4.add(c, R);
        System.out.println(c4);

        System.out.println(p2 + " - then go.");
        ai(c4);
        System.out.println(c4);
        int n = -1;
        // already have two chips before the loop.
        int turns = 2;
        // the loop while be end while the winner is created.
        while (c4.getWinner() != true) {
            n *= (-1);
            if (n == 1) {
                System.out.println("Red - Please input a column# between 1-7: ");
                c = sc.nextInt();
                isRed = c4.add(c, R);
                System.out.println(c4);
                isRed = c4.winner();
                isYellow = false;
                turns++;
            }
            if (n == -1) {
                System.out.println("Yellow - AI will go: ");
                ai(c4);
                System.out.println(c4);
                isYellow = true;
                isRed = false;
                turns++;
            }
        }
        // System.out.println("isRed=" + isRed + ",isYellow=" + isYellow);
        // print out the information of the winner.
        if (isRed) {
            String s = "Red �C Connect 4! " + c4.winType() + p1 + "! You win in " + turns + " turns";
            System.out.println(s);
            printToFile(c4, s);
        }
        if (isYellow) {
            String s = "Yellow �C Connect 4! " + c4.winType() + p2 + "! You win in " + turns + " turns";
            System.out.println(s);
            printToFile(c4, s);
        }
        System.out.println("Play again (Y/N): ");
        char k;
        do {
            k = sc.next().toUpperCase().charAt(0);

            if (k == 'Y') {
                return;
            } else if (k == 'N') {
                System.out.println(" Thanks for playing!");
                gameBreak = 1;
            } else {
                System.out.println(" Error, you could ask yes or no only. (try again)");
            }
        } while (k != 'Y' && k != 'N');
    }

    public static void ai(Connect4Board c4) {
        Chip[][] chips = c4.getBoard();
        boolean found = false;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (chips[i][j] == null || chips[i][j].getColor().equals(R))
                    continue;
                else {
                    int c = c4.checkH(i, j);

                    if (c != -1) {
                        c4.add(c, Y);
                        found = true;
                        break;

                    }
                    c = c4.checkV(i, j);
                    if (c != -1) {
                        c4.add(j + 1, Y);
                        found = true;
                        break;
                    }

                    c = c4.checkR(i, j);
                    if (c != -1) {
                        c4.add(c + 1, Y);
                        found = true;
                        break;
                    }

                    c = c4.checkL(i, j);
                    // System.out.println("check Y i=" + i + ",j=" + j + ",c=" +
                    // c);
                    if (c != -1) {
                        c4.add(c, Y);
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                break;
            }
        }

        if (found) {
            return;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (chips[i][j] == null || chips[i][j].getColor().equals(Y))
                    continue;
                else {
                    int c = c4.checkH(i, j);

                    if (c != -1) {
                        c4.add(c, Y);
                        found = true;
                        break;

                    }
                    c = c4.checkV(i, j);
                    if (c != -1) {
                        c4.add(j + 1, Y);
                        found = true;
                        break;
                    }

                    c = c4.checkR(i, j);
                    if (c != -1) {
                        c4.add(c + 1, Y);
                        found = true;
                        break;
                    }

                    c = c4.checkL(i, j);
                    // System.out.println("i=" + i + ",j=" + j + ",c=" + c);
                    if (c != -1) {
                        c4.add(c, Y);
                        found = true;
                        break;
                    }

                }
            }
            if (found) {
                break;
            }
        }

        if (!found) {
            int r = 5;
            do {
                int maxNum = 7;
                int minNum = 1;
                int range = (maxNum - minNum) + 1;
                r = (int) Math.floor(Math.random() * range) + minNum;
                // System.out.println("random r=" + r);
            } while (!c4.add(r, Y));
        }

    }
}
