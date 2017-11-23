/*Lab9, Question 1/2  - demo class CSCI 1101
   StudentDemo.java is a demo program for the Student class. It creates student 
   objects, and compares different students.
   July 24, 2017
   Jiaming Han B00726481
   I received help with creating Student objects from my TA but the rest is my
   own work. */

public class Demo {
  public static void main(String[] args){
  
  //Test: lets make a little communication. 
   
    Stack s = new Stack();
    
    s.push("?");
    s.push("us ");
    s.push("join ");
    s.push("wanna ");
    s.push("man. ");
    s.push("Yo, ");
    
    System.out.print(s.peek());   
    s.pop();
    System.out.print(s.peek());
    s.pop();
    System.out.print(s.peek());
    s.pop();
    System.out.print(s.peek());
    s.pop();
    System.out.print(s.peek());
    s.pop();
    System.out.println(s.peek()); 
    
    
    Queue q = new Queue(); 
    //the output structure of Queue should be opposited with Stack.
    q.enqueue("No, thx. ");
    q.enqueue("u ");
    q.enqueue("guys ");
    q.enqueue("such are ");
    q.enqueue("freaking ");
    q.enqueue("noobs.");

    System.out.print(q.peek());   
    q.dequeue();
    System.out.print(q.peek());
    q.dequeue();
    System.out.print(q.peek());
    q.dequeue();
    System.out.print(q.peek());
    q.dequeue();
    System.out.print(q.peek());
    q.dequeue();
    System.out.println(q.peek());   
  }
}      
    