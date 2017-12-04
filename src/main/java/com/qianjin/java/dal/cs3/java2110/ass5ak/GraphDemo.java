package com.qianjin.java.dal.cs3.java2110.ass5ak;

/**
 * This class is design for assignment 5 of CSCI 2110 Computer Science III.
 * 
 * This class will read a text file containing information about an undirected,
 * unweighted graph, create an adjacency matrix representation, and traverse the
 * graph using breadth-first search methods
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphDemo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        // Read a text file (specified by the user –not hard code!)
        System.out.print("Please enter the file name ( by default is graph.txt): ");
        String fileName = keyboard.nextLine();
        keyboard.close();
        // the default value is Pgraph.txt which is provided in class
        if (fileName == null || fileName.length() < 2)
            fileName = "graph.txt";
        Scanner inputFile = new Scanner(new File(fileName));
        int num = Integer.parseInt(inputFile.nextLine());
        // create an adjacency matrix that represents the graph
        // num is the value that is read on the first line
        int[][] adjMatrix = new int[num][num];
        int lastx = 0;
        while (inputFile.hasNext()) {
            String firstVertex = inputFile.next();
            String secondVertex = inputFile.next();
            int x = firstVertex.charAt(0) - 65;
            int y = secondVertex.charAt(0) - 65;
            adjMatrix[x][y] = 1;
            adjMatrix[y][x] = 1;
            lastx = x;
        }
        inputFile.close();
        System.out.println("\nDisplay the adjacency matrix:");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(adjMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        // start with Breadth First Search (BFS)
        // Initialize an empty queue and a result list
        Queue<String> queue = new Queue<String>();
        ArrayList<String> list = new ArrayList<String>();
        // Assume the starting vertex is the last node
        // but it can be any node as the starting vertex
        // Enqueue the first vertex.
        queue.enQueue(String.valueOf((char) (lastx + 65)));
        // Start at a vertex v1.
        while (!queue.isEmpty()) {
            // Dequeue and list the vertex v in the result list
            String item = queue.deQueue();
            list.add(item);
            // get all the neighbors of v1.
            ArrayList<String> l = getNeighbours((int) (item.charAt(0)) - 65, adjMatrix);
            // Enqueue each neighbor of v1
            for (int i = 0; i < l.size(); i++) {
                String r = l.get(i);
                // (if it is not already in the result list or not already in
                // the queue
                if (!queue.contains(r) && !list.contains(r)) {
                    queue.enQueue(r);
                }
            }

        }
        // Print the traversal
        System.out.println("\nPrint the traversal:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");

        }
    }

    /**
     * 
     * @param x
     *            the position in matrix
     * @param adjMatrix
     *            the matrix
     * @return the neighbours of x
     */
    private static ArrayList<String> getNeighbours(int x, int[][] adjMatrix) {
        ArrayList<String> list = new ArrayList<String>();
        int num = adjMatrix.length;
        for (int i = 0; i < num; i++) {
            // if the value is 1, means there is an edge
            if (adjMatrix[x][i] == 1) {
                list.add(String.valueOf((char) (i + 65)));
            }
        }
        return list;
    }

}
