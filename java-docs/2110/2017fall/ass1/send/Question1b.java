
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class is for the CSCI 2110 Computer Science III Data Structures and
 * Algorithms ASSIGNMENT NO. 1 Question 1b
 * 
 * This class extends question 1a to generate all possible paths in a n x n grid
 * if diagonal moves within a square (from bottom left to top right) are also
 * allowed. For example, in a 1 x 1 grid, the possible paths would be: [NE, EN,
 * D] where D is the diagonal hop.
 */

public class Question1b {

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

    /**
     * calculate the all potential paths
     * 
     * @param n
     *            the size of grid
     * @return the all paths
     */

    public static ArrayList<String> findPath(int n) {
        // Firstly, to find all path with two directions
        ArrayList<String> l = Question1a.findPath(n);
        // then the diagonal path based on the two direction paths
        l = findPathD(l);
        return l;
    }// end of findPath

    public static int countD(String str, String substr) {
        int count = 0;
        String ss = str;
        while (ss.contains(substr)) {
            count++;
            ss = ss.substring(0, ss.indexOf(substr)) + "D" + ss.substring(ss.indexOf(substr) + 2);
        }
        return count;
    }// end of countD

    /**
     * This is a function in order to know how to replace the possible
     * permutations of replacement
     * 
     * @param t
     *            the total number of occurrence of NE
     * @param c
     *            the current numbers
     * @return an arrayList
     */
    public static ArrayList<String> getCountList(int t, int c) {
        ArrayList<String> l = new ArrayList<>();
        int size = t;
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + "1";
        }
        long nn = Long.valueOf(s, 2);
        for (int i = 0; i <= nn; i++) {
            String str = Long.toBinaryString(i);
            long value = Long.parseLong(str);
            String format = "%0" + size + "d";
            String str4 = String.format(format, value);
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (str4.charAt(j) == '1') {
                    count++;
                }
            }
            if (count == c) {
                l.add(str4);
            }
        }
        return l;
    }

    /**
     * 
     * @param str
     *            the current path
     * @param sub
     *            the replaced string
     * @param index
     *            which number of sub should be replaced
     * @return the new path
     */
    public static String rp(String str, String sub, int index) {

        String ret = "";
        int count = 0;
        String ss = str;
        String tt = "";
        // replace the number index NE/EN with D
        while (true) {
            tt = tt + ss.substring(0, ss.indexOf(sub));
            ss = ss.substring(ss.indexOf(sub) + 2);
            if (count == index)
                break;
            tt = tt + sub;
            count++;
        }
        ret = tt + "D" + ss;
        return ret;
    }// end of rp

    /**
     * 
     * @param str
     *            the path string
     * @param sub
     *            the string which should be replaced, NE or EN
     * @param t
     *            the total number of NE occur in this current path
     * @param c
     *            how many NE should be replace
     * @return
     */
    public static ArrayList<String> replace(String str, String sub, int t, int c) {
        ArrayList<String> r = new ArrayList<>();
        // get the possible permutations of replacement
        ArrayList<String> s = getCountList(t, c);

        // start to replace NE with D
        /*
         * the basic idea is as below: for example, there are 3 NE in this path,
         * NNENENEE, the number of replace will be C(3,1)+C(3,2)+C(3,3) for
         * example, the first two NE replaced with D, the first and third NE,
         * and so on
         */
        for (String ss : s) {
            String tt = str;
            int index = 0;
            for (int i = 0; i < ss.length(); i++) {
                if (ss.charAt(i) == '1') {
                    tt = rp(tt, sub, (i - index));
                    index++;
                }
            }
            r.add(tt);
        }
        return r;
    }

    /**
     * This method is designed to find all the potential paths
     * 
     * @param l
     *            the all path with two directions
     * @return all path with 3 directions
     */
    public static ArrayList<String> findPathD(ArrayList<String> l) {

        ArrayList<String> d3 = new ArrayList<>();
        ArrayList<String> d4 = new ArrayList<>();
        ArrayList<String> d33 = new ArrayList<>();
        ArrayList<String> d44 = new ArrayList<>();

        // in a loop, try to replace all NE with D, EN with D
        for (String s : l) {
            // how many NE in this path
            int count = countD(s, "NE");
            if (count == 0)
                continue;
            // if there are 3 NE in this path for example, in a loop to replace
            // all possible cases
            for (int j = 1; j <= count; j++) {
                d3.clear();
                d3 = replace(s, "NE", count, j);
                d33.addAll(d3);
            }
            // how many EN in this path
            count = countD(s, "EN");
            if (count == 0)
                continue;
            // repleace all possible cases for EN to D
            for (int j = 1; j <= count; j++) {
                d4.clear();
                d4 = replace(s, "EN", count, j);
                d44.addAll(d4);
            }
        }
        // maybe there are some same data after replacing EN and NE
        // only one case should be stored if the path is the same
        ArrayList<String> d2 = new ArrayList<>();
        for (int i = 0; i < d33.size(); i++) {
            if (!d2.contains(d33.get(i))) {
                d2.add(d33.get(i));
            }
        }
        for (int i = 0; i < d44.size(); i++) {
            if (!d2.contains(d44.get(i))) {
                d2.add(d44.get(i));
            }
        }
        l.addAll(d2);
        return l;
    }// end of findPathD
}
