import java.util.Scanner;
/*Assignment 1, Exercise 1 CSCI 1101
   Dome is a java class for a intertesting game that connect 4. 
   July 07, 2017
   Ang Li B00751990 
   This is entirely my own work. */
public class Dome{
   public static void main(String[] args){
      Scanner kb=new Scanner(System.in);
      firstOne();//call method firstOne
      System.out.println("Play again (Y/N): ");//use while loop to circulation when the a is not n
      String a=kb.nextLine();
      while(!a.equalsIgnoreCase("n")){
         while(!a.equalsIgnoreCase("y")&&!a.equalsIgnoreCase("n")){//circulation when the a is not n and y
            System.out.println("Play again (Y/N): ");//if a is not n and y whill circulation that
            a=kb.nextLine();
         }
         while(a.equalsIgnoreCase("y")){//if a equals y, it will continue method firstOne();
            firstOne();
            System.out.println("Play again (Y/N): ");//then ask user to enter it again.
            a=kb.nextLine();
         }
      }
   }
   public static void firstOne(){
      Scanner kb=new Scanner(System.in);
      String colour;//set a colour
      int number=0;
      Connect4 c1;//new connect4 c1
      Chip c2,c3;//new chip c2 and c3
      c1=new Connect4();//constructor
      c2=new Chip("RED");//set c2 colour is red
      c3=new Chip("YELLOW");//set c3 colour is yellow
      String c="R";//c=r
      String d="Y";//d=y
      System.out.println("Welcome to Connect 4. Please enter your names.");
      System.out.println("Player 1 name: ");
      String a=kb.nextLine();//user 1 name
      System.out.println("Player 2 name: ");
      String b=kb.nextLine();//user 2 name
      System.out.println(a+" - you have red chips \""+c2.getChip()+"\" and you go first.");
      secondOne(c1.getBoard());//use method secondOne change the board to String
      System.out.println("Please input a column# between 1-7: ");
      int x=kb.nextInt();//user 1 enter one number,then add it in array board
      c1.add1(x,c);
      colour=c;//when you use add, that colour will equals to colour.
      number++;//when you use add, number will +1
      secondOne(c1.getBoard());
      System.out.println(b+" - you have yellow chips \""+c3.getChip()+"\" and you go next.");
      System.out.println("Please input a column# between 1-7: ");
      int r=kb.nextInt();//user 2 enter one number ,then add it in same array
      c1.add1(r,d);
      colour=d;
      number++;
      secondOne(c1.getBoard());
      int l=0;//set l is 0
      while(c1.winner()!=true&&l==0&&number!=42){//when number is 42 means array is full
         int p=0;
         System.out.println("RED Please input a column# between 1-7: ");
         x=kb.nextInt();
         int o=x;
         while(c1.add1(x,c)!=true&&p==0){//if add1 method is false but array is not full it will print that
            System.out.println("This column this full, change one.");
            x=kb.nextInt();
            if(x!=o){//when user enter another number p=1 the while loop will stop
               p=1;
            }else{
               System.out.println("This column this full, change one.");
               x=kb.nextInt();
            }
         }
         colour=c;//same with top
         number++;
         secondOne(c1.getBoard());  
         if(c1.winner()==true){
            l=1;
         }else{//else is user 2 and user 2 is same with user 1
            System.out.println("Yellow Please input a column# between 1-7: ");
            r=kb.nextInt();
            int t=r;
            while(c1.add1(r,d)!=true&&p==0){
               System.out.println("This column this full, change one.");
               r=kb.nextInt();
               if(r!=t){
                  p=1;
               }else{
                  System.out.println("This column this full, change one.");
                  r=kb.nextInt();
               }
            }
            colour=d;
            number++;
            secondOne(c1.getBoard());
         }
      }//when the while loop stop, it divide 2 ways ,one is array is full, another is connect 4 
      if(number==42){//so when it stop because array is full, it will print game over
         System.out.println("Game Over! No Winner!");
      }else{//when it stop becasue connect, then the java will congratulation the winner.
         if(colour=="R"){
            System.out.println("RED - Connect 4! "+c1+a+" You Win in "+number+" turns.");
         }else{
            System.out.println("Yellow - Connect 4! "+c1+b+" You Win in "+number+" turns."); 
         }
      }
   }
   public static void secondOne(Chip[][]a){//this method is make the array board to String and make it nicer
      System.out.println("  1 2 3 4 5 6 7");
      for (int i = 0; i < a.length; i++) {
         System.out.print(""+(i+1));
         for (int j = 0; j < a[i].length; j++){
            if(a[i][j]==null){
               System.out.print("| ");
            }else{
               System.out.print("|"+a[i][j]);
            }  
         }
         System.out.println("|");
      }
   }
}

