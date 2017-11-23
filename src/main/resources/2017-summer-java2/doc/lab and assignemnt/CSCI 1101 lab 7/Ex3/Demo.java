/*Lab7, Question 3  - demo class CSCI 1101
   StudentDemo.java is a demo program for the Student class. It creates student 
   objects, and compares different students.
   July 17, 2017
   Jiaming Han B00726481
   I received help with creating Student objects from my TA but the rest is my
   own work. */
import java.util.ArrayList; 
import java.util.Scanner;
public class Demo{
  public static void main(String[] args){
  
   Scanner sc = new Scanner(System.in);
   ArrayList <String> arrL1 = new ArrayList<String>();
   ArrayList <String> arrL2 = new ArrayList<String>();

 
   // collecting the input that typed by user
   System.out.println("Enter words on one line, end with -1");
      String str1 = sc.next();
      while(!str1.equals("-1")){
         arrL1.add(str1);
         str1 = sc.next();
      }

   System.out.println("Enter words on one line, end with -1");
      String str2 = sc.next();
      while(!str2.equals("-1")){
         arrL2.add(str2);
         str2 = sc.next();
      }    
   //testing for AlphabetizedList. (deep copy)
   AlphabetizedList a1 = new AlphabetizedList(arrL1);
   AlphabetizedList a2 = new AlphabetizedList(arrL2);
   
   //print out each AlphabetizedList. 
   System.out.println(a1.compare(a2));
   a1.AlphabetizedList();
   System.out.println(a1);
   a2.AlphabetizedList();
   System.out.println(a2); 
   
   //make sure the merge method could work :) 
   a1.merge(a2) ;
   System.out.println(a1); 
  }
} 