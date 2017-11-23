/*Lab9, Question 2 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   July 24, 2017
   Jiaming Han B00726481 
   This is entirely my own work. */
   
public class Queue {
  private LinkedList queue;
  
  public Queue(){
     queue = new LinkedList();
  } 
   
  public boolean isEmpty(){
   return(queue.size()==0);
  }
  /*Queue is FIFOso we better add to the end to make sure 
  the new words that we just add in wont be remove out. */
  public void enqueue(String s){
   queue.addToEnd(s);
  }
  
  //then the dequeue could be same as Stack.pop().
  public String dequeue(){
   String last = "";
    if(!isEmpty()){
         last = queue.getFrontData();
         queue.removeFront();
    }
    else 
         System.out.println("queue empty");
    return last;     
  } 
  
  // same above.
  public String peek(){
    String last = "";
    if(!isEmpty())   
         last = queue.getFrontData();
    else 
         System.out.println("queue empty");
    return last;     
  }
}