/*Lab9, Question 1 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   July 24, 2017
   Jiaming Han B00726481 
   This is entirely my own work. */
   
public class Stack {
  private LinkedList stack;
  
  public Stack(){
     stack = new LinkedList();
  }
  public boolean isEmpty(){
   return(stack.size()==0);
  }
  
  /*Stack is LIFO, so we better add to front to make sure 
  the new words that we just add in wont be remove out. */
  public void push(String s){
   stack.addToFront(s);
  }
  
  //return what the String we removed before we remove it.
  public String pop (){
    String top = "";
    if(!isEmpty()){  
        top = stack.getFrontData();
        stack.removeFront();
    }
    else 
         top += "stack empty";
    return top;     
  }
  
  //print out the fornt node.
  public String peek(){
    String top = ""; 
    if(!isEmpty())   
         top = stack.getFrontData();
    else 
         System.out.println("Stack empty");
    return top;     
  }
}