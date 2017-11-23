/*Lab8, Question 1 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   July 21, 2017
   Jiaming Han B00726481 
   This is entirely my own work. */

public class LinkedList {
	private Node front;
	//private int count;
	//private Node end;

	public LinkedList(Node f) {
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
	//	   System.out.println(“No front to remove!?;

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
			while(cur.getNext().getNext()!= null)
				cur = cur.getNext();
			cur.setNext(null);
		}
	//} else { System.out.println(“No end to remove!?;
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
	//else { System.out.println(“Index out of bounds!?; }
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
	//else { System.out.println(“Index out of bounds!?; }
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
	} // else { System.out.println(“Index out of bounds!?; }
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

 //union (handout 11)
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
 //intersection (handout 11)
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
  //return how many word that the linklist have
  public int countWord (String word){
      int count =0;
      Node cur = front;
         
      while(cur != null){
        if(cur.getData().equals(word))
            count ++;
        cur = cur.getNext();
      }
         return count;
  }
  // return the index of the last occurrence of the String that being type in.
  public int lastIndexOf (String word){
     Node cur = front;
     int realIndex = -1;
     int index = 0;
     while(cur != null){
       if(cur.getData().equals(word)){
          realIndex = index;
          cur = cur.getNext();
          index ++;
       }
       else {
         cur = cur.getNext();
         index ++;
       }       
     }
      return realIndex;  
  }


  // removing every occurrence that in the LinkedList (overloading).
  public void remove(String word){
      Node cur = front;
     if(isEmpty())
          front = null;
     else {
        while(cur!= null){ 
            Node nextC = cur.getNext();
          if(cur.getNext()!=null){
             if(nextC.getData().equals(word))
               cur.setNext(nextC.getNext());   
          }   
          cur = nextC;
        }
     }
  }
}