/*Lab8, Question 1 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   July 21, 2017
   Jiaming Han B00726481 
   This is entirely my own work. */
   
public class Node {
	private String data;
	private Node next;

	public Node(String d, Node n ) {
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