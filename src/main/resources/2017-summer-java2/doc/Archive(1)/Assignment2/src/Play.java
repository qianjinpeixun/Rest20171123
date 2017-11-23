/*Assignment2, Question 1 CSCI 1101
 Play.java is a test program for the Board class,Chip class,Connect4Board class.
 It lets user input the names and the location of chips.Whether replay the game.
   July 6, 2017
   Yiping Liang B00744822
   This is entirely my own work. */
import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
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
                System.out.print("Player 2 name: ");
                p2 = scanner.next();
                System.out.print(p1 + " - you have red chips \"R\" and go first.\n");
                System.out.print(game.toString());
                user1 = "";
            } else {
                user1 = "RED ";
            }
            boolean full=true;
            for(int i=0;i<6;i++){
                for(int j=0;j<7;j++){
                    if(game.getChip(i, j)==null){
                        full=false;
                        break;
                    }
                }
                if(full==false){
                    break;
                }
            }
            if(full){
                System.out.println("The game is a draw after " + rounds + " turns!");
                System.out.print("Play Again? Y/N: ");//continue game
                if (scanner.next().equalsIgnoreCase("Y")) {
                    rounds = 0;
                    continue;
                } else {
                    break;
                }
            }

            System.out.print(user1 + "Please input a column# between 1 -7: ");
            while (((position = scanner.nextInt()) > 7) || (position < 1)) {//loop for replay
                System.out.print(user1 + " Please input a column# between 1 -7: ");
            }
            position--;
            game.add(position, "RED");
            System.out.print(game.toString());
            rounds++;
            if (game.winner()) {
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
                System.out.print(p2 + " - you have red chips \"Y\" and go first.\n");
                user2 = "";
            } else {
                user2 = "YELLOW ";
            }
            System.out.print(user2 + "Please input a column# between 1 -7: ");
            while (((position = scanner.nextInt()) > 7) || (position < 1)) {//every column
                System.out.print(user2 + " Please input a column# between 1 -7: ");
            }
            position--;//every column times 
            game.add(position, "YELLOW");
            System.out.print(game.toString());
            rounds++;
            if (game.winner()) {
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
