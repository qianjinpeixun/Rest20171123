
import java.util.*;
import java.io.*;

/**
 * This class is designed for CSCI 2110 Computer Science III Data Structures and
 * Algorithms ASSIGNMENT NO. 3
 * 
 * This is a demo program in order to show how to implement the Huffman coding
 * algorithm using the binary tree data structure.
 */
public class HuffmanDemo {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the file name ( by default is Pokemon.txt): ");
        String fileName = keyboard.nextLine();
        keyboard.close();
        // the default value is Pokemon.txt which is provided in class
        if (fileName == null || fileName.length() < 2)
            fileName = "Pokemon.txt";
        // read the file into an arraylist
        ArrayList<String> originalList = readFile(fileName);
        System.out.println("\nThe content of " + fileName + " is as follows:");
        for (int i = 0; i < originalList.size(); i++) {
            System.out.println(originalList.get(i));
        }
        System.out.println();

        // create a Pair object for each character in this file
        ArrayList<Pair> list = PairUtil.createPairList(originalList);
        // calculate each character's count and order the list again
        list = PairUtil.order(list);
        // Count the number of occurrences of each symbol (character)
        list = PairUtil.prob(list);

        HuffmanQueue queueS = PairUtil.createQueue(list);
        HuffmanQueue queueT = new HuffmanQueue();
        BinaryTree<Pair> root = PairUtil.getRoot(queueS, queueT);

        // Derive the Huffman codes
        String[] result = PairUtil.findEncoding(root);
        System.out.println("The Huffman code are as follows:");
        PairUtil.addPrefix(list, result);
        fileName = "Huffman.txt";
        PrintWriter p = new PrintWriter(new File(fileName));
        String ss = "Symbol    Prob.     Huffman code";
        System.out.println(ss);
        p.println(ss);
        for (int i = 0; i < list.size(); i++) {
            String Symbol = String.valueOf(list.get(i).getValue());
            String Prob = String.valueOf(list.get(i).getProb());
            String Huffmancode = String.valueOf(list.get(i).getPrefix());
            String line = String.format("%-10s%-10s%-10s", Symbol, Prob, Huffmancode);
            p.println(line);
            System.out.println(line);
        }
        p.close();
        System.out.println();

        // Encode the text file with the codes.
        ArrayList<String> decodeList = PairUtil.getEncode(originalList, list);
        p = new PrintWriter(new File("Encoded.txt"));
        System.out.println("The encode content is as follows:");
        for (int i = 0; i < decodeList.size(); i++) {
            p.println(decodeList.get(i));
            System.out.println(decodeList.get(i));
        }
        p.close();
        System.out.println();

        // Decode the encoded text file
        String original = PairUtil.getDecode(root, decodeList);
        System.out.println("After decode, the original content is:");
        System.out.println(original);
        p = new PrintWriter(new File("Decoded.txt"));
        p.print(original);
        p.close();
        
        System.out.println("Now, compare the original file contect and decode file");
        Scanner sc1=new Scanner(new File("Pokemon.txt"));
        Scanner sc2=new Scanner(new File("Decoded.txt"));
        String str="The content of these files are the same!";
        while(sc1.hasNextLine()){
            String ss1=sc1.nextLine();
            String ss2=sc2.nextLine();
            if(!ss1.equals(ss2)){
                str="There are differences!";
                break;
            }
        }
        System.out.println(str);
        sc1.close();
        sc2.close();
        
    }

    /**
     * Read a text file
     * 
     * @param fileName
     *            the file name
     * @return ArrayList<String> the file content will be stored in this list
     * @throws FileNotFoundException
     */
    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> originalList = new ArrayList<String>();
        Scanner scanner = new Scanner(new File(fileName));
        String str = "";
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            originalList.add(str);
        }
        scanner.close();
        return originalList;
    }// end of readFile

}
