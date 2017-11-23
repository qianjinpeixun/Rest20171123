/*Lab8, Question 1 CSCI 1101
   Linked.java contains all method that we can used
   July 23, 2017
   Ang Li B00751990 
   Last three method is my work. */

public class LinkedList {
	private Node front;
	//private int count;
	//private Node end;

	public LinkedList(Node f            ) {
		front = f;


	}


   public LinkedList() {
	   front = null;
   }
 
   public void addToFront(String d) {
	   Node n = new Node(d, front);
	   front = n;
   }

   public boolean isEmpty() {
	   if(front == null)
		   return true;
	   else
		   return false;
   }
 

   public void clear() {
	   front = null;

   }

   public String getFrontData() {
	   return front.getData();
   }

   public Node getFrontNode() {
	   return front;
   }
 
   public String toString() {
	   String ts = "[";
	   Node cur = front;
	   while(cur != null) {
		   ts += cur;
		   cur = cur.getNext();
	   }
	   return ts + "]";
   }


   public int size() {
	   int count = 0;
	   Node cur = front;
	   while(cur != null) {
		   count++;
		   cur = cur.getNext();
	   }
	   return count;
   }



   public void removeFront() {
	   if(!isEmpty())
		   front = front.getNext();
	// else
	//	   System.out.println(“No front to remove!”);

   }

   public void addToEnd(String d) {
	   Node n = new Node(d, null);
	   if(isEmpty())
		   front = n;
	   else {
		   Node cur = front;
		while(cur.getNext() != null)
			cur = cur.getNext();
		   cur.setNext(n);
	   }
   }


   public void removeLast() {
	   if(!isEmpty()) {
		   if(front.getNext() == null)
			   front = null;
		   else {
			   Node cur = front;
			while(cur.getNext() != null)
				cur = cur.getNext();
			   cur.setNext(null);
		   }
	//} else { System.out.println(“No end to remove!”);
	   }
   }

   public int contains(String d) {
	   Node cur = front;
	   boolean found = false;
	   int index = -1;

	   while(cur != null && !found) {
		   index++;
		   if(cur.getData().equals(d))
			   found = true;
		      cur = cur.getNext();
	      }
	   if(!found)
		   index = -1;
	   return index;
   }
   
   public void add(int index, String d) {
	   if(index >= 0 && index <= size()        ) {
		   if(index == 0)
			   addToFront(d);
		   else {
			   Node cur = front;
			   for(int i=0; i<index-1; i++)
				   cur = cur.getNext();
			      Node n = new Node(d, cur.getNext());
			      cur.setNext(n);
         }
	   }
	//else { System.out.println(“Index out of bounds!”); }
   }



   public void remove(int index) {
	   if(index >= 0 && index <= size()        ) {
		   if(index == 0)
			   removeFront();
		   else if(index == size()-1)
			   removeLast();
		   else {
			   Node cur = front;
			   for(int i=0; i<index-1; i++)
				   cur = cur.getNext();
			      cur.setNext(cur.getNext().getNext());
		   }
	   }
	//else { System.out.println(“Index out of bounds!”); }
   }


   public Node getNode(int index) {
	   Node cur = null;
	   if(index >= 0 && index <= size()        ) {
		   if(index == 0)
			   cur = front;
		   else {
			   cur = front;
			   for(int i=0; i<index; i++)
				   cur = cur.getNext();
		   }
	   } // else { System.out.println(“Index out of bounds!”); }
	   return cur;
   }





   public void addAll(LinkedList other) {
	   Node cur = other.getFrontNode();
	   while(cur != null) {
		   addToEnd(cur.getData());
		   cur = cur.getNext();
	   }
   }



   public static LinkedList merge(LinkedList first, LinkedList second) {
	   LinkedList result = new LinkedList();

	   Node cur = first.getFrontNode();
	   while(cur != null) {
		   result.addToEnd(cur.getData());
		   cur = cur.getNext();
	   }

	   cur = second.getFrontNode();
	   while(cur != null) {
		   result.addToEnd(cur.getData());
		   cur = cur.getNext();
	   }
	   return result;
   } 



   public LinkedList subList(int start, int end) {
	   LinkedList result = new LinkedList();
	   if(!(start >= end ||  start < 0  ||  start > size()  ||  end >= size()  )) {
		   Node cur = getFrontNode();
		   for(int i=0; i<start; i++) {
			   cur = cur.getNext();
		   }
		   for(int i=start; i<=end; i++) {
			   addToEnd(cur.getData());
			   cur = cur.getNext();
		   }
	   }
	   return result;
   }


   public static LinkedList union(LinkedList first, LinkedList second) {
	   LinkedList result = new LinkedList();
	   Node cur = first.getFrontNode();
	   while(cur != null) {
		   result.addToEnd(cur.getData());
		   cur = cur.getNext();
	   }

	   cur = second.getFrontNode();
	   while(cur != null) {
		   if(result.contains(cur.getData()) == -1)
			   result.addToEnd(cur.getData());
		   cur = cur.getNext();
	   }

	   return result;
   }

   public static LinkedList intersection(LinkedList first, LinkedList second) {
	   LinkedList result = new LinkedList();
	   Node cur = first.getFrontNode();
	   while(cur != null) {
		   if(second.contains(cur.getData()) != -1)
			   result.addToEnd(cur.getData());
		      cur = cur.getNext();
	   }


	   return result;
   }
   public int countWord(String word){//String returns the number of times the String
      Node cur =front;
      int count =0;
      while(cur != null) {
		   if(cur.getData().equals(word)){//when they are equal count++,finally we can get it total times
			   count++;
         }
		   cur = cur.getNext();//if not equal cur equals to next one
	   }
	   return count;
   }
   
   public int lastIndexOf(String word) {//takes in a String and returns the index of the last occurrence in the list 
	   Node cur = front;
	   boolean found = false;
	   int index = -1;
      int a=countWord(word);//a is how many word in the list
      
	   while(cur!=null && a!=0) { 
		   if(cur.getData().equals(word)){
			   found = true;//if have same word found always true
            index++; //index alwyas ++ no matter it same word or not
            cur=cur.getNext();
            a--;
         }else{
            index++;   
		      cur = cur.getNext();
	      }
      }
	   if(!found){//if not have same word. index will be -1
		   index = -1;
      }
	   return index;
   }
   public void remove(String word){// removes every occurrence string
      int index = lastIndexOf(word);//call method lastindexOf
      while(index!=-1){//when index is -1 will continue remove
         if(index >= 0 && index <= size()        ) {//remove specific index
		      if(index == 0)
			      removeFront();
		      else if(index == size()-1)
			      removeLast();
		      else {
			      Node cur = front;
			      for(int i=0; i<index-1; i++)
				      cur = cur.getNext();
			         cur.setNext(cur.getNext().getNext());
		      }
	      }
         index=lastIndexOf(word);//when you already remove one call it again
      }   
	}    
}