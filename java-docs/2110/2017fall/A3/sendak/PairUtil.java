
import java.util.ArrayList;

/*
 * This class is designed as an Util class in order to implement the Huffman
 * algorithm and other methods
 */
public class PairUtil {

    // create an arraylist contains the Pair objects
    public static ArrayList<Pair> createPairList(ArrayList<String> originalList) {
        ArrayList<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < originalList.size(); i++) {
            list = PairUtil.add(originalList.get(i), list);
        }
        return list;
    }

    // calculate the huffman tree, and return the root node
    public static BinaryTree<Pair> getRoot(HuffmanQueue queueS, HuffmanQueue queueT) {
        // if the queue S is not empty
        while (!queueS.isEmpty()) {
            BinaryTree<Pair> t1;
            BinaryTree<Pair> t2;
            // If T is empty, A and B are respectively the front and next to
            // front entries of S. Dequeue them from S.
            if (queueT.isEmpty()) {
                t1 = queueS.dequeue();
                t2 = queueS.dequeue();
            } else if (queueT.size() == 1) {
                // If T is not empty, Find the smaller weight tree of the trees
                // in front of S and in front of T. This is A.
                // Dequeue it.
                // ii) Find the smaller weight tree of the trees in front of S
                // and in front of T. This is B.
                // Dequeue it.
                if (queueS.peek().getData().getProb() <= queueT.peek().getData().getProb()) {
                    t1 = queueS.dequeue();
                    if (queueS.peek().getData().getProb() < queueT.peek().getData().getProb()) {
                        t2 = queueS.dequeue();
                    } else {
                        t2 = queueT.dequeue();
                    }
                } else {
                    t1 = queueT.dequeue();
                    t2 = queueS.dequeue();
                }
            } else if (queueS.size() == 1) {
                // If T is not empty, Find the smaller weight tree of the trees
                // in front of S and in front of T. This is A.
                // Dequeue it.
                // ii) Find the smaller weight tree of the trees in front of S
                // and in front of T. This is B.
                // Dequeue it.
                if (queueT.peek().getData().getProb() < queueS.peek().getData().getProb()) {
                    t1 = queueT.dequeue();
                    if (queueT.peek().getData().getProb() < queueS.peek().getData().getProb()) {
                        t2 = queueT.dequeue();
                    } else {
                        t2 = queueS.dequeue();
                    }
                } else {
                    t1 = queueS.dequeue();
                    t2 = queueT.dequeue();
                }
            } else {
                // If T is not empty, Find the smaller weight tree of the trees
                // in front of S and in front of T. This is A.
                // Dequeue it.
                // ii) Find the smaller weight tree of the trees in front of S
                // and in front of T. This is B.
                // Dequeue it.
                if (queueS.peek().getData().getProb() < queueT.peek().getData().getProb()) {
                    t1 = queueS.dequeue();
                } else {
                    t1 = queueT.dequeue();
                }
                if (queueS.peek().getData().getProb() < queueT.peek().getData().getProb()) {
                    t2 = queueS.dequeue();
                } else {
                    t2 = queueT.dequeue();
                }
            }
            // Construct a new tree P by creating a root and attaching A and B
            // as the subtrees of this root.
            // The weight of the root is the combined weights of the roots of A
            // and B.

            BinaryTree<Pair> tt = new BinaryTree<Pair>();
            Pair pp = new Pair('0');
            pp.setProb(t1.getData().getProb() + t2.getData().getProb());
            tt.makeRoot(pp);
            tt.attachLeft(t1);
            tt.attachRight(t2);
            queueT.enqueue(tt);
        }

        // if T's size is > 1, dequeue two nodes at a time, combine them and
        // enqueue the
        // combined tree until T's size is 1. The last node remaining in the
        // queue T will be the final
        // Huffman tree
        while (queueT.size() > 1) {
            BinaryTree<Pair> t1;
            BinaryTree<Pair> t2;
            t1 = queueT.dequeue();
            t2 = queueT.dequeue();
            Pair pp = new Pair('0');
            pp.setProb(t1.getData().getProb() + t2.getData().getProb());
            BinaryTree<Pair> tt = new BinaryTree<Pair>();
            tt.makeRoot(pp);
            tt.attachLeft(t1);
            tt.attachRight(t2);
            queueT.enqueue(tt);
        }
        return queueT.peek();
    }

    // set the huffman codes for each Pair objects
    public static void addPrefix(ArrayList<Pair> list, String[] str) {
        for (int i = 0; i < list.size(); i++) {
            char cc = list.get(i).getValue();
            list.get(i).setPrefix(str[(byte) (cc)]);
        }
    }

    // return the huffman codes according the input char
    public static String getPrefix(ArrayList<Pair> list, char c) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue() == c) {
                return list.get(i).getPrefix();
            }
        }
        return null;
    }

    // adding a string into the list
    public static ArrayList<Pair> add(String str, ArrayList<Pair> list) {

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ' && c != '\n' && c != 65279) {
                list = addChar(c, list);
            }
        }
        return list;
    }

    // adding a char into list and calculate the count of occurrence
    private static ArrayList<Pair> addChar(char c, ArrayList<Pair> list) {

        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);
            if (p.getValue() == c) {
                p.setCount(p.getCount() + 1);
                found = true;
                break;
            }
        }
        if (found == false) {
            Pair p = new Pair(c);
            p.setCount(1);
            list.add(p);
        }
        return list;
    }

    // order one list
    public static ArrayList<Pair> order(ArrayList<Pair> list) {
        ArrayList<Pair> orderList = new ArrayList<Pair>();
        while (!list.isEmpty()) {
            orderList.add(list.remove(min(list)));
        }
        return orderList;
    }

    // get the smallest probability in one list, return the index
    private static int min(ArrayList<Pair> list) {
        Pair p = list.get(0);
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCount() < p.getCount()) {
                p = list.get(i);
                index = i;
            }
        }
        return index;
    }

    // calculate the probability
    public static ArrayList<Pair> prob(ArrayList<Pair> list) {
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            total = total + list.get(i).getCount();
        }

        for (int i = 0; i < list.size(); i++) {
            int c = list.get(i).getCount();
            double prob = ((double) c / total);
            list.get(i).setProb(Double.parseDouble(String.format("%.3f", prob)));
        }
        return list;
    }

    // Create a queue of Binary Tree nodes. Each Binary Tree node is of type
    // Pair
    public static HuffmanQueue createQueue(ArrayList<Pair> list) {
        HuffmanQueue q = new HuffmanQueue();
        for (int i = 0; i < list.size(); i++) {
            BinaryTree<Pair> t = new BinaryTree<Pair>();
            t.makeRoot(list.get(i));
            q.enqueue(t);
        }
        return q;
    }

    // They use a String array of 256 to cover all characters in the Unicode
    // set.
    public static void findEncoding(BinaryTree<Pair> t, String[] a, String prefix) {
        if (t.getLeft() == null && t.getRight() == null) {
            a[(byte) (t.getData().getValue())] = prefix;
        } else {
            findEncoding(t.getLeft(), a, prefix + "0");
            findEncoding(t.getRight(), a, prefix + "1");
        }
    }

    // They use a String array of 256 to cover all characters in the Unicode
    // set.
    public static String[] findEncoding(BinaryTree<Pair> t) {
        String[] result = new String[256];
        findEncoding(t, result, "");
        return result;
    }

    // decode the content
    public static String getDecode(BinaryTree root, ArrayList<String> decodeList) {
        String original = "";
        for (int i = 0; i < decodeList.size(); i++) {
            String line = decodeList.get(i);
            original = original + getChar(root, line) + "\n";
        }
        return original.substring(0,original.length()-1);
    }

    // calculate the encode string
    public static ArrayList<String> getEncode(ArrayList<String> originalList, ArrayList<Pair> list) {
        ArrayList<String> oo = new ArrayList<String>();
        for (int j = 0; j < originalList.size(); j++) {
            String output = "";
            String str = originalList.get(j);
            for (int i = 0; i < str.length(); i++) {
                char cc = str.charAt(i);
                if (cc == ' ') {
                    output = output + " ";
                } else if (cc != '\n' && cc != 65279) {
                    output = output + getPrefix(list, cc);
                }
            }
            oo.add(output);
        }
        return oo;
    }

    // using huffman tree to decode one string
    public static String getChar(BinaryTree<Pair> tt, String pre) {
        String orginal = "";
        String[] ss = pre.split(" ");
        for (int i = 0; i < ss.length; i++) {
            // System.out.println(ss[i]);
            orginal = orginal + decode(tt, ss[i]) + " ";
            // System.out.print(" " );
        }
        if(pre.charAt(pre.length()-1)!=' '){
            orginal =orginal.substring(0,orginal.length()-1);
        }
        return orginal;
    }

    // using the huffman tree to decode a string
    public static String decode(BinaryTree<Pair> tt, String pre) {
        String orginal = "";
        while (pre.length() > 0) {
            // each loop, search from the root node of huffman tree
            BinaryTree<Pair> tree = tt;
            char[] prefix = pre.toCharArray();
            int index = 0;
            while (true) {
                if (index == prefix.length)
                    break;
                // if 0, then enter left sub tree
                if (prefix[index] == '0') {
                    if (tree.getLeft() != null)
                        tree = tree.getLeft();
                    else
                        break;
                } else {
                    if (tree.getRight() != null)
                        tree = tree.getRight();
                    else
                        break;
                }
                index++;
            }
            pre = pre.substring(index);
            char c = tree.getData().getValue();
            orginal = orginal + String.valueOf(c);
        }
        return orginal;
    }

}
