/*Lab8, Question 1 CSCI 1101
   Node.java contains what node should be.
   July 23, 2017
   Ang Li B00751990 
   This is entirely not my word */

public class Node {
	private String data;
	private Node next;

	public Node(String d, Node n            ) {
		data = d;
		next = n;
	}
	// The usual get/set methods, plus toString()
	public void setData(String d) { data = d; }
	public void setNext(Node n) { next = n; }
	public String getData() { return data; }
	public Node getNext() { return next; }
	public String toString() { return data + " --> "; }
}