
import java.util.ArrayList;

/*
 * This class is designed as a queue which is implemented as a simple arraylist,
 * where enqueue means adding an item to the end of the arraylist and dequeue
 * means removing the item at index 0. That is, the queue is an arraylist of
 * type <BinaryTree<Pair>>.
 */
public class HuffmanQueue {

    // return the size
    public int size() {
        return list.size();
    }

    public BinaryTree<Pair> peek(int index) {
        if (list != null && !list.isEmpty())
            return list.get(index);
        else
            return null;
    }

    public BinaryTree<Pair> peek() {
        if (list != null && !list.isEmpty())
            return list.get(0);
        else
            return null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    ArrayList<BinaryTree<Pair>> list;

    public HuffmanQueue() {
        list = new ArrayList<BinaryTree<Pair>>();
    }

    public void enqueue(BinaryTree<Pair> p) {
        list.add(p);
    }

    public BinaryTree<Pair> dequeue() {
        return list.remove(0);
    }

    public void enumerate() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
