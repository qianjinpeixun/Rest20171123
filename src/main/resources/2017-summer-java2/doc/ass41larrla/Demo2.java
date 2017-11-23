import java.util.ArrayList;
import java.util.Scanner;
/*Assignment3, Question 1 CSCI 1101
   Demo2.java is for a game use Deck.java and Card.java. 
   July 23, 2017
   Ang Li B00751990 
   This is entirely my word */
public class Demo2 {
   public static void main(String[] args) {//main method
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
   public static void firstOne(){//method firstOne
      Scanner kb = new Scanner(System.in);
      //creat new fro arraylist
      ArrayList<Card> x;//x and y is deck first part cards and second part of cards
      ArrayList<Card> y;
      ArrayList<Card> store1 = new ArrayList<Card>();
      ArrayList<Card> store2 = new ArrayList<Card>();
      
      Deck deck;
      deck = new Deck();//new deck
      deck.shuffle();//call the shuffle method
      x = deck.getFirstPlayer();//all method make x and y equals to random cards
      y = deck.getSecondplayer();

      System.out.println("Welcome to WAR! Let's Play!");
      System.out.println("");
      System.out.print("Enter the first player's name: ");
      String n1 = kb.next();
      System.out.print("Enter the second player's name: ");
      String n2 = kb.next();
      System.out.println("");
      System.out.println(n1 + "               #Cards     " + n2 + "               #Cards     Winner");
      
      //game information
      int a=0;//a is important for make java get out while loop
      while (a==0) {
         store1.add(x.remove(0));
         store2.add(y.remove(0));//remove first card
         int total1 = x.size() + 1;
         int total2 = y.size() + 1;
         String u1 = "";
         u1 = store1.get(0).toString();
         u1 = u1 + "       ";
         u1 = u1 + total1 + "          ";
         String u2 = "";
         u2 = store2.get(0).toString();
         u2 = u2 + "       ";
         u2 = u2 + total2 + "          ";
         String u3 = "";
         u3 = u1 + u2;
         
         if (store1.get(0).compare(store2.get(0))) {//compare first card
            System.out.println(u3 + n1 + " (Wins" + " 1 card)");
            x.addAll(store1);
            x.addAll(store2);
            store1.clear();
            store2.clear();
            
         }else if (store2.get(0).compare(store1.get(0))) {
            System.out.println(u3 + n2 + " (Wins" + " 1 card)");
            y.addAll(store2);
            y.addAll(store1);
            store1.clear();
            store2.clear();
            
         }else {//if it is equal will get war
            System.out.println(u3 + "WAR"); 
            int a1=0;
            while (a1==0) {
               if (x.size() < 2 || y.size() < 2) {//when you play the war less than 2 cards ,another player will win
                  if (x.size() < 2) {
                     u3 = n2 + " Wins! Congratulations";       
                  } else {
                     u3 = n1 + " Wins! Congratulations";          
                  }
                  System.out.println(u3);
                  return;//when one player win, will get out to the while loop   
                                      
               }else{//if not end 
                  u3 = "************************************WAR****************************************\n";
                  System.out.println(u3);
                  store1.add(x.remove(0));
                  store1.add(x.remove(0));
                  store2.add(y.remove(0));
                  store2.add(y.remove(0));
                  //every player takes two cards and filp over first one to compare ,same with top
                  int v = 0;
                  u1 = store1.get(v * 2 + 1).toString();           
                  u1 = u1 + "       ";             
                  u1 = u1 + total1 + "          ";                  
                  u2 = store2.get(v * 2 + 1).toString();                 
                  u2 = u2 + "       ";
                  u2 = u2 + total2 + "          ";
                  u3 = u1 + u2;
                  
                  if (store1.get(v * 2 + 1).compare(store2.get(v * 2 + 1))) {
                     System.out.println(u3 + n1 + " (Wins" + " " + store2.size() + " card)");
                     x.addAll(store1);//add all things to x then clear
                     x.addAll(store2);
                     u3 = "\n***************************************END WAR**********************************\n";
                     System.out.println(u3);
                     store1.clear();
                     store2.clear();
                     a1=1;
                     
                  } else if (store2.get(v * 2 + 1).compare(store1.get(v * 2 + 1))) {
                     System.out.println(u3 + n2 + " (Wins" + " " + store1.size() + " card)");
                     y.addAll(store2);
                     y.addAll(store1);
                     u3 = "\n******************************************END WAR**********************************\n";
                     System.out.println(u3);
                     store1.clear();
                     store2.clear();
                     a1=1;
                     
                  } else {
                     System.out.println(u3 + "WAR");
                     v++;
                  }
               }
            }
         }

         if (x.size() == 0 || y.size() == 0) {//when x is not enought to compare again then a=1
            if(x.size() == 0) {//a =1 means get out the while loop
               u3 = n2 + " Wins! Congratulations";
               a=1;
            }else {
               u3 = n1 + " Wins! Congratulations";
               a=1;
            }
            System.out.println(u3);  
         }
      }
   }
}
