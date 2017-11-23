/*Lab6, Question 2  - demo class CSCI 1101
   StudentDemo.java is a demo program for the Student class. It creates student 
   objects, and compares different students.
   July 10, 2017
   Jiaming Han B00726481
   I received help with creating Student objects from my TA but the rest is my
   own work. */
   
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListDemo1 {
  public static void main(String[] args){
   
     ArrayList<String>List1 = new ArrayList <String>();
     ArrayList<String>List2 = new ArrayList <String>();
     Scanner sc = new Scanner(System.in);
     
     System.out.println(" Enter words on one line, end with -1. ");
     String words = sc.next();
     
     //keep collecting String that input by user.
     while(! words.equals("-1")){
       List1.add(words);
       words = sc.next();
     }
     
     /* same as: for(int i=0;i<words.length;i++){
            String w = words[i];
        using to print each String in arrays  */
     for(String w1 : List1) 
       System.out.print(w1 + " ");
        
       System.out.println();
       
       System.out.println("Array List with no duplicates: ");
        
       //add the same output in arrays list 2 without duplicates.
       for(String w2 : List1) {
         if(!List2.contains(w2)){
             List2.add(w2);
         }
        }
       System.out.print(List2);          
  }
}
   