
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class is for the CSCI 2110 Computer Science III Data Structures and
 * Algorithms ASSIGNMENT NO. 1 Question 1a
 * 
 * This class can generate all possible paths of a lattice of a given size,
 * stores the paths as Strings in an array list and print the output.
 * 
 */
public class Question1a {

    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        Scanner kb = new Scanner(System.in);
        while (true) {
            l.clear();
            System.out.print("\nEnter the lattice size: ");
            int n = kb.nextInt();
            if (n == 0)
                break;
            // start to find all paths
            l = findPath(n);
            // found the all paths
            System.out.println("The lattice paths number is:" + l.size());
            System.out.println("The lattice paths are:" + l);
        }
    }

    public static String format(String s, int size) {
        while (s.length() < size) {
            s = "0" + s;
        }
        return s;

    }

    /**
     * This method is designed to find all the potential paths
     * 
     * @param n
     *            the size of grid
     * @return the all paths will be returned
     */
    public static ArrayList<String> findPath(int n) {
        ArrayList<String> l = new ArrayList<>();
        // the maximum steps is n*2
        int size = n * 2;
        String s = "";
        // the maximum binary number is 1111, for example, n=2
        for (int i = 0; i < size; i++) {
            s = s + "1";
        }
        // get the value
        long nn = Long.valueOf(s, 2);
        // start to find all path
        for (int i = 0; i <= nn; i++) {
            String str = Long.toBinaryString(i);
            // ensure the format is correct
            String str4 = format(str,size);
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (str4.charAt(j) == '1') {
                    count++;
                }
            }
            // if there are n for 1, this is a correct path
            if (count == n) {
                l.add(str4);
            }
        }
        // replace 1 0 with N or E
        ArrayList<String> ll = new ArrayList<>();
        for (String ss : l) {
            String sss = ss.replaceAll("1", "N");
            sss = sss.replaceAll("0", "E");
            ll.add(sss);
        }
        return ll;
    }// end of findPath
}
