/*Lab7, Question 2 - demo class CSCI 1101
   StudentDemo.java is a demo program for the Student class. It creates student 
   objects, and compares different students.
   July 17, 2017
   Jiaming Han B00726481
   I received help with creating Student objects from my TA but the rest is my
   own work. */
   
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListDemo2 {
  public static void main(String[] args){

    ArrayList<String>List1 = new ArrayList <String>();
    ArrayList<String>List2 = new ArrayList <String>();
    ArrayList<String>List3 = new ArrayList <String>();
    
    Scanner sc = new Scanner(System.in);
    
    //list 1
    System.out.println("Enter str1 on one line, end with -1. ");
    String str1 = sc.next();
    //keep collecting String that input by user.
    while(! str1.equals("-1")){
      List1.add(str1);
      str1 = sc.next();
    }
     for(String w1 : List1) 
       System.out.print(w1 + " ");
     System.out.println();
       
    //list 2  
    System.out.println("Enter str2 on one line, end with -1. ");
    String str2 = sc.next();
    while(! str2.equals("-1")){
      List2.add(str2);
      str2 = sc.next();
    }
     for(String w2 : List2) 
       System.out.print(w2 + " ");
     System.out.println();
       
    //Array List with distinct strings.   
    System.out.println("Array List with distinct strings: ");
       for(String w3 : List1) {
         if(!List3.contains(w3)&& !List2.contains(w3))
             List3.add(w3);
       }
           for(String w3 : List2) {
         if(!List3.contains(w3)&& !List1.contains(w3))
             List3.add(w3);
       }
       
       System.out.print(List3);   
  }
}