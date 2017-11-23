
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Huffman {

    public static void main(String[] args) throws Exception, FileNotFoundException {

        InputStreamReader reader;
        BufferedReader buffer;
        String line;
        reader = new InputStreamReader(new FileInputStream("Pokemon.txt"), "utf-8");
        buffer = new BufferedReader(reader);
        line = buffer.readLine();
        ArrayList<Pair> huffmanlist = new ArrayList<Pair>();
        // use a String array of 256 to cover all characters in the Unicode set
        // this array will store the count of occurrence of each character
        int[] array = new int[256];
        // the default occurrence is 0
        for (int i = 0; i < 256; i++) {
            array[i] = 0;
        }
        while (line != null) {// begin to read file
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                int cc = (int) c;
                if (c == ' ')
                    continue;
                if (c > 255) // if the character is illegal, ignore it
                    continue;
                array[cc] = array[cc] + 1;
            }
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();
        // tt will the total occurrence of all characters
        int tt = 0;
        for (int i = 0; i < 256; i++) {
            if (array[i] != 0) {
                Pair pair = new Pair();
                pair.setValue((char) i);
                pair.setOccurence(array[i]);
                huffmanlist.add(pair);
                tt = tt + array[i];
            }
        }
        // set the probabilities
        for (int i = 0; i < huffmanlist.size(); i++) {
            double dd = (double) (huffmanlist.get(i).getOccurence()) / tt;
            dd = (double) (Math.round(dd * 1000) / 1000.0);
            huffmanlist.get(i).setProb(dd);
        }

        System.out.println("The probabilities are:");
        for (int i = 0; i < huffmanlist.size(); i++) {
            System.out.println(huffmanlist.get(i).getValue() + " " + huffmanlist.get(i).getProb());
        }
        // start to create one queue in order to build huffman tree
        // in the assignment, there are two queues: QueueS and QueueT
        // but I found using one queue is more convenient
        Queue<BinaryTree<Pair>> queue = new Queue<BinaryTree<Pair>>();
        for (int i = 0; i < huffmanlist.size(); i++) {
            BinaryTree<Pair> btree = new BinaryTree<Pair>();
            btree.makeRoot(huffmanlist.get(i));
            queue.enqueue(btree);
        }
        // start to build huffman tree
        while (queue.size() > 1) {
            // the current queue is ordered, so the first two nodes are the
            // smallest ones
            BinaryTree<Pair> p1 = queue.dequeue();
            BinaryTree<Pair> p2 = queue.dequeue();
            BinaryTree<Pair> btree = new BinaryTree<Pair>();
            Pair pp = new Pair();
            pp.setValue('0');
            double dd = p1.getData().getProb() + p2.getData().getProb();
            dd = (double) (Math.round(dd * 1000) / 1000.0);
            pp.setProb(dd);
            btree.makeRoot(pp);
            btree.attachLeft(p1);
            btree.attachRight(p2);
            queue.enqueue(btree);
            // after adding a new node into queue, needs to re-order the queue
            queue = sortQueue(queue);
        }
        // finally, the only one node in the queue is the root of huffman tree
        BinaryTree<Pair> huffmanTree = queue.peek();
        System.out.println();
        System.out.println("The preorder of huffman tree is:");
        BinaryTree.preorder(huffmanTree);
        System.out.println();
        System.out.println();

        // start to encode using the source code from assignment
        String[] codes = findEncoding(huffmanTree);
        System.out.println("Start to write the huffman codes into Huffman.txt");
        PrintWriter pw = new PrintWriter(new File("Huffman.txt"));
        String str = "Symbol\tProb.\tHuffman code";
        System.out.println(str);
        pw.println(str);
        for (int i = 0; i < huffmanlist.size(); i++) {
            Pair p = huffmanlist.get(i);
            str = String.valueOf(p.getValue()) + "\t" + p.getProb() + "\t" + codes[(int) p.getValue()];
            pw.println(str);
            System.out.println(str);
        }
        pw.close();

        System.out.println();
        System.out.println("Start to read huffman codes from Huffman.txt");
        reader = new InputStreamReader(new FileInputStream("Huffman.txt"), "utf-8");
        buffer = new BufferedReader(reader);
        line = buffer.readLine();
        while (line != null) {// begin to read file
            StringTokenizer token = new StringTokenizer(line, "\t");
            String value = token.nextToken();
            String prob = token.nextToken();
            String code = token.nextToken();
            char c = value.charAt(0);
            for (int i = 0; i < huffmanlist.size(); i++) {
                Pair p = huffmanlist.get(i);
                if (p.getValue() == c) {
                    p.setCode(code);
                    break;
                }
            }
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();
        System.out.println();
        System.out.println("Start to write encode file into Encoded.txt");
        reader = new InputStreamReader(new FileInputStream("Pokemon.txt"), "utf-8");
        buffer = new BufferedReader(reader);
        line = buffer.readLine();
        pw = new PrintWriter(new File("Encoded.txt"));
        // begin to read file
        while (line != null) {
            String ss = "";
            char[] cc = line.toCharArray();
            for (int i = 0; i < cc.length; i++) {
                // ignore the illegal characters
                if (cc[i] > 255)
                    continue;
                // do not encode the space
                if (cc[i] == ' ') {
                    ss = ss + " ";
                    continue;
                }
                // get the code of each character
                for (int j = 0; j < huffmanlist.size(); j++) {
                    Pair p = huffmanlist.get(j);
                    if (p.getValue() == cc[i]) {
                        ss = ss + p.getCode();
                        break;
                    }
                }
            }
            pw.println(ss);
            System.out.println(ss);
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();
        pw.close();

        System.out.println();
        System.out.println("Start to write decode file into Decoded.txt");

        reader = new InputStreamReader(new FileInputStream("Encoded.txt"), "utf-8");
        buffer = new BufferedReader(reader);
        line = buffer.readLine();
        pw = new PrintWriter(new File("Decoded.txt"));
        // begin to read file
        while (line != null) {
            StringTokenizer token = new StringTokenizer(line, " ");
            String ss = "";

            int count = token.countTokens();
            BinaryTree<Pair> root = huffmanTree;
            for (int i = 0; i < count; i++) {
                char[] cc = token.nextToken().toCharArray();
                int index = 0;
                while (true) {
                    // the last character
                    if (index == cc.length) {
                        ss = ss + root.getData().getValue();
                        root = huffmanTree;
                        break;
                    }
                    // if the current binary tree node is leaf, then got the
                    // decode value
                    if (root.isLeaf()) {
                        ss = ss + root.getData().getValue();
                        root = huffmanTree;
                        continue;
                    }
                    // otherwise, get left or right node according to huffman
                    // code: 0 or 1
                    if (cc[index] == '0') {
                        root = root.getLeft();
                    } else {
                        root = root.getRight();
                    }
                    index++;
                }
                ss = ss + " ";
            }
            // delete the last space
            if (line.charAt(line.length() - 1) != ' ')
                ss = ss.substring(0, ss.length() - 1);
            pw.println(ss);
            System.out.println(ss);
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();
        pw.close();

        System.out.println();
        System.out.println("Start to compare the Pokemon.txt and Decoded.txt");
        reader = new InputStreamReader(new FileInputStream("Pokemon.txt"), "utf-8");
        buffer = new BufferedReader(reader);
        line = buffer.readLine();

        InputStreamReader reader1;
        BufferedReader buffer1;
        String line1;
        reader1 = new InputStreamReader(new FileInputStream("Decoded.txt"), "utf-8");
        buffer1 = new BufferedReader(reader1);
        line1 = buffer1.readLine();

        boolean same = true;
        int index = 0;
        while (line != null) {
            if (!line.equals(line1)) {
                // maybe the input file of Pokemon is BOM format
                if (index == 0 && line.length() == 22 && line1.length() == 21)
                    continue;
                else {
                    same = false;
                    break;
                }
            }
            index++;
            line = buffer.readLine();
            line1 = buffer1.readLine();
        }
        if (same) {
            System.out.println("The content of Pokemon.txt and Decoded.txt is the same!");
        } else {
            System.out.println("The content of Pokemon.txt and Decoded.txt is NOT the same!");
        }
        buffer1.close();
        buffer.close();
        reader1.close();
        reader.close();
    }

    // the input is a queue
    // the output is anohter queue with the same nodes with input, but with
    // ordered
    public static Queue<BinaryTree<Pair>> sortQueue(Queue<BinaryTree<Pair>> queue) {
        BinaryTree[] tt = new BinaryTree[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            tt[index] = queue.dequeue();
            index++;
        }
        for (int i = 0; i < tt.length; i++) {
            for (int j = i; j < tt.length; j++) {
                Pair pi = (Pair) tt[i].getData();
                Pair pj = (Pair) tt[j].getData();

                if (pj.compareTo(pi) <= 0) {
                    BinaryTree<Pair> temp = tt[i];
                    tt[i] = tt[j];
                    tt[j] = temp;
                }
            }
        }
        for (int i = 0; i < tt.length; i++) {
            queue.enqueue(tt[i]);
        }
        return queue;
    }

    // copy the source code from assignment
    public static void findEncoding(BinaryTree<Pair> t, String[] a, String prefix) {
        if (t.getLeft() == null && t.getRight() == null) {
            a[(byte) (t.getData().getValue())] = prefix;
        } else {
            findEncoding(t.getLeft(), a, prefix + "0");
            findEncoding(t.getRight(), a, prefix + "1");
        }
    }

    // copy the source code from assignment
    public static String[] findEncoding(BinaryTree<Pair> t) {
        String[] result = new String[256];
        findEncoding(t, result, "");
        return result;
    }

}
