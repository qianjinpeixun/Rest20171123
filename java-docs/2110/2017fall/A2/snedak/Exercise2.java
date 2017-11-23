
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is designed for exercise 2 of assignment 2 which is on the
 * two-finger walking algorithm for ordered lists.
 * 
 *
 */
public class Exercise2 {

    /**
     * creates two ordered lists from these names, merges them and displays the
     * three lists
     */
    public static void main(String[] args) throws FileNotFoundException {

        // reads a list of names from a file and constructs an ordered list
        OrderedList<String> list1 = new OrderedList<String>();
        Scanner scanner = new Scanner(new File("file1.txt"));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            list1.insert(line.trim());
        }
        System.out.println("The first list reading from file1 is:");
        list1.enumerate();
        System.out.println();
        scanner.close();

        // reads anohter list of names from a file and constructs the second
        // ordered list
        OrderedList<String> list2 = new OrderedList<String>();
        scanner = new Scanner(new File("file2.txt"));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            list2.insert(line.trim());
        }
        System.out.println("The second list reading from filew is:");
        list2.enumerate();
        System.out.println();

        OrderedList<String> list3 = merge(list1, list2);
        System.out.println("The merged third list is:");
        list3.enumerate();

    }

    /**
     * takes as input two ordered lists and returns a third list that is a
     * merger of the two ordered lists. in order to merge two list, using the
     * two-finger walking algorithm
     * 
     * @param list1
     *            the first list
     * @param list2
     *            the second list
     * @return OrderList the merged list
     */
    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> list = new OrderedList<T>();
        // if the list1 is empty, just return the list2
        if (list1.isEmpty()) {
            list = new OrderedList<T>(list2.size());
            for (int i = 0; i < list2.size(); i++) {
                list.add(i, list2.get(i));
            }
            return list;
        }

        // if list2 is empty, just return list1
        if (list2.isEmpty()) {
            list = new OrderedList<T>(list1.size());
            for (int i = 0; i < list1.size(); i++) {
                list.add(i, list1.get(i));
            }
            return list;
        }

        int size1 = list1.size();
        int size2 = list2.size();
        int first = 0;
        int second = 0;
        // put list1 and list2 alternatively into new list one by one
        while (first < size1 && second < size2) {
            T item1 = list1.get(first);
            T item2 = list2.get(second);
            int c = item1.compareTo(item2);
            // get the position in new list
            if (c == 0) {
                list.add(0, item1);
                first++;
                second++;
            } else if (c < 0) {
                list.add(0, item1);
                first++;
            } else {
                list.add(0, item2);
                second++;
            }
        }
        // if the list1 has more elements, put them into new list
        if (first < size1) {
            for (int i = first; i < size1; i++) {
                list.add(0, list1.get(i));
            }
        }
        // if the second list has more elements, put them into new list
        if (second < size2) {
            for (int i = second; i < size2; i++) {
                list.add(0, list2.get(i));
            }
        }
        return list;
    }
}
