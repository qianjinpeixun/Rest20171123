
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Assignment 3 CSCI 2110
 * 
 * Huffman.java show how to implement huffman algorithm in Java
 * 
 * Nov 13rd, 2017 Yiping
 * 
 * Liang B00744822 This is entirely my own work.
 */
public class Huffman {

    ArrayList<Pair> pairs;
    Queue queue;
    BinaryTree root;

    public Huffman() {
        pairs = new ArrayList<Pair>();
    }

    // Read the encoded text file and decode it. Write the decoded file into yet
    // another text file, Decoded.txt
    public void decodeToFile() throws FileNotFoundException {
        PrintWriter printwriter = new PrintWriter(new File("Decoded.txt"));
        Scanner kb1 = new Scanner(new File("Encoded.txt"));
        String value = "";
        while (kb1.hasNextLine()) {
            String line = kb1.nextLine();
            value = value + decodeHuffmanText(line) + "\n";
        }
        value = value.substring(0, value.length() - 1);
        printwriter.print(value);
        printwriter.close();
        kb1.close();
        System.out.println("\n\nStep 6, decoded.txt is:");
        System.out.println(value);
    }

    // decode a string input using a huffman tree
    private String decodeHuffmanText(String line) {
        String value = "";
        char[] cc = line.toCharArray();
        BinaryTree<Pair> tree = root;
        for (int i = 0; i < cc.length; i++) {
            if (i == cc.length - 1 && cc[i] != ' ') {
                if (cc[i] == '0')
                    tree = tree.getLeft();
                else
                    tree = tree.getRight();
                char c = tree.getData().getCharacter();
                value = value + String.valueOf(c);
                break;
            }
            if (tree.getLeft() == null && tree.getRight() == null) {
                char c = tree.getData().getCharacter();
                value = value + String.valueOf(c);
                tree = root;
                i = i - 1;
                continue;
            }
            if (cc[i] == ' ') {
                value = value + " ";
                continue;
            }
            if (cc[i] == '0') {
                tree = tree.getLeft();
            } else {
                tree = tree.getRight();
            }
        }
        return value;
    }

    // Read the sample Pokemon text file (call it Pokemon.txt) and Huffman.txt
    // file, and encode it using the Huffman symbols.
    // Not encode spaces and newline characters.
    // Write the encoded file into another text file, Encoded.txt.
    public void encodeToFile() throws FileNotFoundException {
        System.out.println("\nStep 5, the Encoded.txt has been written:");
        Scanner kb1 = new Scanner(new File("Pokemon.txt"));
        PrintWriter printwriter = new PrintWriter(new File("Encoded.txt"));
        String value = "";
        while (kb1.hasNextLine()) {
            String line = kb1.nextLine();
            char[] cc = line.toCharArray();

            for (int i = 0; i < cc.length; i++) {
                if (cc[i] == ' ') {
                    value = value + " ";
                    continue;
                }
                if (cc[i] == '\n' || cc[i] > 255)
                    continue;
                value = value + getHuffmanCode(cc[i]);
            }
            value = value + "\n";
        }
        value = value.substring(0, value.length() - 1);
        printwriter.print(value);
        System.out.print(value);
        printwriter.close();
    }

    // find the huffman code in the Huffman.txt
    private String getHuffmanCode(char c) throws FileNotFoundException {
        String value = "";
        Scanner kb = new Scanner(new File("Huffman.txt"));
        while (kb.hasNextLine()) {
            String line = kb.nextLine();
            Scanner kb1 = new Scanner(line);
            String cc = kb1.next();
            String p = kb1.next();
            String code = kb1.next();
            if (cc.equals(String.valueOf(c))) {
                value = code;
                break;
            }
        }
        kb.close();
        return value;
    }

    // Build the Huffman tree according to the algorithm discussed in the
    // lectures
    public BinaryTree<Pair> createHuffmanTree() {
        while (queue.size() > 1) {
            BinaryTree<Pair> node1 = queue.dequeue();
            BinaryTree<Pair> node2 = queue.dequeue();
            BinaryTree<Pair> node = new BinaryTree<Pair>();
            Pair pair = new Pair();
            pair.setCharacter('0');
            double d1 = node1.getData().getProbability();
            double d2 = node2.getData().getProbability();
            double value = d1 + d2;
            DecimalFormat df = new DecimalFormat("0.0000");
            df.setRoundingMode(RoundingMode.HALF_UP);
            value = Double.parseDouble(df.format(value));
            pair.setProbability(value);
            node.makeRoot(pair);
            node.attachLeft(node1);
            node.attachRight(node2);
            // after enqueue, the order has been adjusted
            queue.enqueue(node);
        }
        root = queue.peeke();
        return root;
    }

    // using the source code provided by teacher, get the huffman codes
    public void getHuffmanCodes() {
        String[] result = findEncoding(root);
        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                char c = (char) i;
                for (int j = 0; j < pairs.size(); j++) {
                    if (pairs.get(j).getCharacter() == c) {
                        pairs.get(j).setHuffman_code(result[i]);
                        break;
                    }
                }
            }
        }
    }

    // output the huffman codes into files
    public void printHuffmanCodeFile(File file) throws FileNotFoundException {
        PrintWriter printwriter = new PrintWriter(file);
        printwriter.println("Symbol\tProb.\tHuffman code");
        System.out.println("\n\nStep 4,The huffman codes have been written into Huffman.txt.\nSymbol\tProb.\tHuffman code");
        for (int j = 0; j < pairs.size(); j++) {
            printwriter.print(pairs.get(j).getCharacter());
            printwriter.print("\t");
            printwriter.print(pairs.get(j).getProbability());
            printwriter.print("\t");
            printwriter.print(pairs.get(j).getHuffman_code());
            printwriter.println();
            System.out.println(pairs.get(j).getCharacter() + "\t" + pairs.get(j).getProbability() + "\t" + pairs.get(j).getHuffman_code());
        }
        printwriter.close();
    }

    private void findEncoding(BinaryTree<Pair> t, String[] a, String prefix) {
        if (t.getLeft() == null && t.getRight() == null) {
            a[(byte) (t.getData().getCharacter())] = prefix;
        } else {
            findEncoding(t.getLeft(), a, prefix + "0");
            findEncoding(t.getRight(), a, prefix + "1");
        }
    }

    private String[] findEncoding(BinaryTree<Pair> t) {
        String[] result = new String[256];
        findEncoding(t, result, "");
        return result;
    }

    // put all of the pair objects into a queue
    public Queue createQueue() {
        queue = new Queue();
        for (int i = 0; i < pairs.size(); i++) {
            BinaryTree<Pair> node = new BinaryTree<Pair>();
            node.makeRoot(pairs.get(i));
            queue.enqueue(node);
        }
        return queue;
    }

    // set the probability value of each character according to the occurrence
    // in the file
    public void setProbability() {
        int p = 0;
        for (int i = 0; i < pairs.size(); i++) {
            p = p + pairs.get(i).getCount();
        }
        for (int i = 0; i < pairs.size(); i++) {
            double pp = pairs.get(i).getCount();
            double value = (double) pp / p;
            // round it up to the nearest decimal value with 4 digitals
            DecimalFormat df = new DecimalFormat("0.0000");
            df.setRoundingMode(RoundingMode.HALF_UP);
            value = Double.parseDouble(df.format(value));
            pairs.get(i).setProbability(value);
        }
        System.out.println("\nStep 2, The probability:");
        for (int i = 0; i < pairs.size(); i++) {
            System.out.println(pairs.get(i).getCharacter() + "=" + pairs.get(i).getProbability());
        }
    }

    // add a new string into the current arraylist
    public void addLine(String line) {
        char[] cs = line.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ' || cs[i] == '\n' || cs[i] > 255)
                continue;
            int index = isInParis(cs[i]);
            if (index != -1) {
                int count = pairs.get(index).getCount();
                count++;
                pairs.get(index).setCount(count);
            } else {
                Pair pair = new Pair();
                pair.setCharacter(cs[i]);
                pair.setCount(1);
                pairs.add(pair);
            }
        }
    }

    // search a char in the current arrayList
    private int isInParis(char c) {
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).getCharacter() == c)
                return i;
        }
        return -1;
    }
}
