/*Lab8, Question 1 CSCI 1101
   LinkedList.java has many method to calculate linklist
   July 21, 2017
   Yiping Liang B00744822
   This is entirely my own work. */

public class LinkedList {
	private Node front;
	private int count;
	private Node end;

	public LinkedList(Node f) {// daihui kanzheli youmeiyou xuyaode
		front = f;

	}

	public LinkedList() {
		front = null;
		count = 0;

	}

	public void addToFront(String d) {
		Node n = new Node(d, front);
		front = n;
	}

	public boolean isEmpty() {
		if (front == null)
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
		while (cur != null) {
			ts += cur;
			cur = cur.getNext();
		}
		return ts + "]";
	}

	public int size() {
		int count = 0;
		Node cur = front;
		while (cur != null) {
			count++;
			cur = cur.getNext();
		}
		return count;
	}

	public int countWord(String word) {// It takes in a String returns the
										// number of times the String is
										// contained in the LinkedList.

		Node cur = front;
		int index = 0;
		while (cur != null) {
			if (cur.getData().equals(word))
				index++;
			cur = cur.getNext();

		}
		return index;
	}

	public int lastIndexOf(String word) {// It takes in a String and returns the
		Node curr = front;
		int index = 0;
		int result = -1;
		while (curr != null) {
			if (curr.getData().equals(word)) {
				result = index;
			}
			curr = curr.getNext();
			index++;

		}
		return result;

	}

	public void removeFront() {
		if (!isEmpty())
			front = front.getNext();

		// else
		// System.out.println(�No front to remove!�);

	}

	public void remove(String word) {
		if (contains(word) == -1)
			System.out.println("Can't remove - string not found");
		else if (contains(word) == 0)
			removeFront();
		else if (contains(word) == size() - 1)
			removeLast();
		else {
			int num = contains(word) - 1;
			Node cur = front;
			for (int i = 0; i < num; i++) {
				cur = cur.getNext();
			}
			cur.setNext(cur.getNext().getNext());
			count--;

		}

	}

	public void addToEnd(String d) {
		Node n = new Node(d, null);
		if (isEmpty())
			front = n;
		else {
			Node cur = front;
			while (cur.getNext() != null)
				cur = cur.getNext();
			cur.setNext(n);
		}
	}

	public void removeLast() {
		if (!isEmpty()) {
			if (front.getNext() == null)
				front = null;
			else {
				Node cur = front;
				while (cur.getNext() != null)
					cur = cur.getNext();
				cur.setNext(null);
			}
			// } else { System.out.println(�No end to remove!�);
		}
	}

	public int contains(String d) {
		Node cur = front;
		boolean found = false;
		int index = -1;

		while (cur != null && !found) {
			index++;
			if (cur.getData().equals(d))
				found = true;
			cur = cur.getNext();
		}
		if (!found)
			index = -1;
		return index;
	}

	public void add(int index, String d) {
		if (index >= 0 && index <= size()) {
			if (index == 0)
				addToFront(d);
			else {
				Node cur = front;
				for (int i = 0; i < index - 1; i++)
					cur = cur.getNext();
				Node n = new Node(d, cur.getNext());
				cur.setNext(n);
			}
		}
		// else { System.out.println(�Index out of bounds!�); }
	}

	public void remove(int index) {
		if (index >= 0 && index <= size()) {
			if (index == 0)
				removeFront();
			else if (index == size() - 1)
				removeLast();
			else {
				Node cur = front;
				for (int i = 0; i < index - 1; i++)
					cur = cur.getNext();
				cur.setNext(cur.getNext().getNext());
			}
		}
		// else { System.out.println(�Index out of bounds!�); }
	}

	public Node getNode(int index) {
		Node cur = null;
		if (index >= 0 && index <= size()) {
			if (index == 0)
				cur = front;
			else {
				cur = front;
				for (int i = 0; i < index; i++)
					cur = cur.getNext();
			}
		} // else { System.out.println(�Index out of bounds!�); }
		return cur;
	}

	public void addAll(LinkedList other) {
		Node cur = other.getFrontNode();
		while (cur != null) {
			addToEnd(cur.getData());
			cur = cur.getNext();
		}
	}

	public static LinkedList merge(LinkedList first, LinkedList second) {
		LinkedList result = new LinkedList();

		Node cur = first.getFrontNode();
		while (cur != null) {
			result.addToEnd(cur.getData());
			cur = cur.getNext();
		}

		cur = second.getFrontNode();
		while (cur != null) {
			result.addToEnd(cur.getData());
			cur = cur.getNext();
		}
		return result;
	}

	public LinkedList subList(int start, int end) {
		LinkedList result = new LinkedList();
		if (!(start >= end || start < 0 || start > size() || end >= size())) {
			Node cur = getFrontNode();
			for (int i = 0; i < start; i++) {
				cur = cur.getNext();
			}
			for (int i = start; i <= end; i++) {
				addToEnd(cur.getData());
				cur = cur.getNext();
			}
		}
		return result;
	}

	public static LinkedList union(LinkedList first, LinkedList second) {
		LinkedList result = new LinkedList();
		Node cur = first.getFrontNode();
		while (cur != null) {
			result.addToEnd(cur.getData());
			cur = cur.getNext();
		}

		cur = second.getFrontNode();
		while (cur != null) {
			if (result.contains(cur.getData()) == -1)
				result.addToEnd(cur.getData());
			cur = cur.getNext();
		}

		return result;
	}

	public static LinkedList intersection(LinkedList first, LinkedList second) {
		LinkedList result = new LinkedList();
		Node cur = first.getFrontNode();
		while (cur != null) {
			if (second.contains(cur.getData()) != -1)
				result.addToEnd(cur.getData());
			cur = cur.getNext();
		}

		return result;
	}

}