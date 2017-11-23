/*Lab7, Question 1 - demo class CSCI 1101
   StudentDemo.java is a demo program for the Student class. It creates student 
   objects, and compares different students.
   July 17, 2017
   Jiaming Han B00726481
   I received help with creating Student objects from my TA but the rest is my
   own work. */
   
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListDemo1 {
  public static void main(String[] args){

    ArrayList<Integer>List1 = new ArrayList <Integer>();
    ArrayList<Integer>List2 = new ArrayList <Integer>();
    ArrayList<Integer>List3 = new ArrayList <Integer>();
    
    Scanner sc = new Scanner(System.in);
    
    //list 1
    System.out.println("Enter int1 on one line, end with -1. ");
      int int1 = sc.nextInt();
    //keep collecting String that input by user.
    while(int1 != -1 ){
      List1.add(int1);
      int1 = sc.nextInt();
    }
     for(int n1 : List1) 
       System.out.print(n1 + " ");
     System.out.println();
       
    //list 2  
    System.out.println("Enter int2 on one line, end with -1. ");
      int int2 = sc.nextInt();
    while(int2 != -1 ){
      List2.add(int2);
      int2 = sc.nextInt();
    }
    
     for(int n2 : List2) 
       
       System.out.print(n2 + " ");
    System.out.println();
       
    //Array List with shared Integers:
    System.out.println("Array List with shared Integers: ");
     // same as for(int i=0; i< a1.size(); i++ ).
       for(Integer n3 : List2) {
         if(List1.contains(n3)&& !List3.contains(n3))
             List3.add(n3);
       }
       System.out.print(List3);   
  }
}    