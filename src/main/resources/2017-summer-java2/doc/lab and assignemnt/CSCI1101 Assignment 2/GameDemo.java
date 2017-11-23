/*Assignemnt2, Question 1 - demo class CSCI 1101
 StudentDemo.java is a demo program for the Student class. It creates student
 objects, and compares different students.
 July 9, 2017
 Jiaming Han B00726481
 I received help with creating Student objects from my TA but the rest is
 my own work. */
 
import java.util.Scanner;
import java.util.Random;

public class GameDemo {
   static int gameBreak = 0;
   static boolean isRed = false;
   static boolean isYellow = false;
  public static void main(String[] args){ 
    while (gameBreak == 0){
       gettingStart();
    }
  }
   public static void gettingStart(){
       Scanner sc = new Scanner(System.in);
       Connect4Board c4 = new Connect4Board();

       int c;
       String  p1, p2;
       String R = "R";
       String Y = "Y";
      // getting start.
      System.out.println("Welcome to Connect 4. Please enter your names.");
      System.out.println("Player 1 name : " );
       p1 = sc.next();
      System.out.println("Player 2 name : " );
       p2 = sc.next();
      System.out.println(p1 + " - you have red chips 'R' and you go first.");
      System.out.println(c4);
      System.out.println(" Please input a column# between 1-7: ");
      c = sc.nextInt();
      c4.add(c,R);
      System.out.println(c4);
      
      System.out.println(p2 + " - you have red chips 'Y' and you go first.");
      System.out.println(" Please input a column# between 1-7: ");
      c = sc.nextInt();
      c4.add(c,Y); 
      System.out.println(c4);
      int n =-1;
      //already have two chips before the loop.
      int turns = 2;
      // the loop while be end while the winner is created.
      while(c4.getWinner()!= true){
         n *= (-1);
         if(n == 1){
            System.out.println("Red - Please input a column# between 1-7: ");
            c = sc.nextInt();
            isRed = c4.add(c,R);
            System.out.println(c4);
            isRed = c4.winner();
            turns ++;
         }
         if(n == -1){
            System.out.println("Yellow - Please input a column# between 1-7: ");
            c = sc.nextInt();
            isYellow = c4.add(c,Y); 
            System.out.println(c4);
            isYellow = c4.winner();
            turns ++;
         }
      }   
      //print out the information of the winner. 
      if(isRed)
         System.out.println("Red ¨C Connect 4! "+ c4.winType()+p1 +"! You win in "+ turns +" turns");
      if(isYellow)
         System.out.println("Yellow ¨C Connect 4! "+ c4.winType()+p2 +"! You win in "+ turns +" turns");
         System.out.println("Play again (Y/N): ");
           char k;
        do {
              k = sc.next().toUpperCase().charAt(0);
            
             if (k == 'Y'){
               return ;
             }
             else if (k == 'N'){
               System.out.println(" Thanks for playing!");
                gameBreak = 1;  
             }
             else {
               System.out.println(" Error, you could ask yes or no only. (try again)");
             }
        }
        while(k != 'Y'&& k != 'N');   
   }
}
      
