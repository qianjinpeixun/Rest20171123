package com.qianjin.java.sss.java2s.a1101.ass42larryla;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);
        firstOne();// call method firstOne
        // use while loop to
        // circulation when the a is
        // not n
        System.out.println("Play again (Y/N): ");
        String a = kb.nextLine();
        while (!a.equalsIgnoreCase("n")) {
            // circulation when the a is not n and y
            while (!a.equalsIgnoreCase("y") && !a.equalsIgnoreCase("n")) {
                // if a is not n and y
                // whill circulation
                // that
                System.out.println("Play again (Y/N): ");
                a = kb.nextLine();
            }
            // if a equals y, it will continue
            // method firstOne();
            while (a.equalsIgnoreCase("y")) {
                firstOne();
                // then ask user to
                // enter it again.
                System.out.println("Play again (Y/N): ");
                a = kb.nextLine();
            }
        }
    }

    public static void firstOne() throws Exception {
        Scanner kb = new Scanner(System.in);
        String colour;// set a colour
        int number = 0;
        Connect4 c1;// new connect4 c1
        Chip c2, c3;// new chip c2 and c3
        c1 = new Connect4();// constructor
        c2 = new Chip("RED");// set c2 colour is red
        c3 = new Chip("YELLOW");// set c3 colour is yellow
        String c = "R";// c=r
        String d = "Y";// d=y
        System.out.println("Welcome to Connect 4. Please enter your names.");
        System.out.println("Player 1 name: ");
        String a = kb.nextLine();// user 1 name
        String b = "Mr. Computer";// user 2 name
        System.out.println(a + " - you have red chips \"" + c2.getChip() + "\" and you go first.");
        // use method secondOne change the board to String0
        secondOne(c1.getBoard());
        System.out.println("Please input a column# between 1-7: ");
        int x = kb.nextInt();// user 1 enter one number,then add it in array
                             // board
        c1.add1(x, c);
        colour = c;// when you use add, that colour will equals to colour.
        number++;// when you use add, number will +1
        secondOne(c1.getBoard());

        System.out.println(b + " have yellow chips \"" + c3.getChip() + "\" and will go next.");
        c1.add1(fourthOne(c1.getBoard()), d);
        colour = d;
        number++;
        secondOne(c1.getBoard());
        int l = 0;// set l is 0
        // when number is 42 means array is full
        while (c1.winner() != true && l == 0 && number != 42) {
            int p = 0;
            System.out.println("RED Please input a column# between 1-7: ");
            x = kb.nextInt();
            int o = x;
            // if add1 method is false but array is not full it will print that
            while (c1.add1(x, c) != true && p == 0) {
                System.out.println("This column this full, change one.");
                x = kb.nextInt();
                // when user enter another number p=1 the while loop will stop
                if (x != o) {
                    p = 1;
                } else {
                    System.out.println("This column this full, change one.");
                    x = kb.nextInt();
                }
            }
            colour = c;// same with top
            number++;
            secondOne(c1.getBoard());
            if (c1.winner() == true) {
                l = 1;
            } else {// else is user 2 and user 2 is same with user 1
                System.out.println("Yellow will go by computer.");
                int r = 0;
                do {
                    r = fourthOne(c1.getBoard());
                } while (c1.add1(r, d) != true);
                colour = d;
                number++;
                secondOne(c1.getBoard());
            }
        }
        // when the while loop stop, it divide 2 ways ,one is array is full,
        // another is connect 4
        // so when it stop because array is full, it will
        // print game over
        if (number == 42) {
            System.out.println("Game Over! No Winner!");
        } else {
            // when it stop becasue connect, then the java will
            // congratulation the winner.
            String msg = "";
            if (colour == "R") {
                msg = "RED - Connect 4! " + c1 + a + " You Win in " + number + " turns.";
            } else {
                msg = "Yellow - Connect 4! " + c1 + b + " You Win in " + number + " turns.";
            }
            System.out.println(msg);
            PrintWriter p = new PrintWriter("game.txt");
            thirdOne(p, c1.getBoard());
            p.println("");
            p.println(msg);
            p.close();
        }
    }

    public static void thirdOne(PrintWriter p, Chip[][] a) {
        p.println("  1 2 3 4 5 6 7");
        for (int i = 0; i < a.length; i++) {
            p.print("" + (i + 1));
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == null) {
                    p.print("| ");
                } else {
                    p.print("|" + a[i][j]);
                }
            }
            p.println("|");
        }
    }

    // this method is make the array board to String and make it nicer

    public static void secondOne(Chip[][] a) {
        System.out.println("  1 2 3 4 5 6 7");
        for (int i = 0; i < a.length; i++) {
            System.out.print("" + (i + 1));
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == null) {
                    System.out.print("| ");
                } else {
                    System.out.print("|" + a[i][j]);
                }
            }
            System.out.println("|");
        }
    }

    // computer to play another player
    public static int fourthOne(Chip[][] a) {
        int position = Computer.getColum(a);
        position=position+1;
        return position;
    }
}
