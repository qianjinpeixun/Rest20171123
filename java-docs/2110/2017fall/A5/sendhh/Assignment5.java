
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Assignment5 {

    private static int[][] adjMatrix;

    public static void main(String[] args) throws Exception {
        InputStreamReader reader;
        BufferedReader buffer;
        String line;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the file name:");
        String file = scanner.nextLine();
        reader = new InputStreamReader(new FileInputStream(file), "utf-8");
        buffer = new BufferedReader(reader);
        line = buffer.readLine();
        int num = Integer.parseInt(line);
        System.out.println();
        System.out.println("Display the adjacency matrix:");
        
        line = buffer.readLine();
        adjMatrix = new int[num][num];
        // got the num,start to set matirx with default value
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        while (line != null) {// begin to read file
            scanner = new Scanner(line);
            String firstVertex = scanner.next();
            String secondVertex = scanner.nextLine().trim();
            int x = firstVertex.charAt(0) - 65;
            int y = secondVertex.charAt(0) - 65;
            adjMatrix[x][y] = 1;
            adjMatrix[y][x] = 1;
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        boolean visit[] = new boolean[num];
        for (int i = 0; i < visit.length; i++) {
            visit[i] = false;
        }
        System.out.println();
        System.out.println("Depth First Search Result:");
        
        // start traverse the graph and print it
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == false) {
                dfs(visit, i);
            }
        }
    }

    private static void dfs(boolean visit[], int i) {
        // recursive method with dfs
        System.out.print(String.valueOf((char) (i + 65)) + " ");
        visit[i] = true;
        int w = getFirst(adjMatrix, i);
        while (w != -1) {
            if (!visit[w]) {
                dfs(visit, w);
            }
            // try to get next vertex
            w = getNext(adjMatrix, i, w);
        }
    }

    private static int getFirst(int[][] adjMatrix, int v) {
        // get the first vertex
        if (v < 0 || v > adjMatrix.length - 1)
            return -1;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[v][i] == 1)
                return i;
        }
        // if not found, return -1
        return -1;
    }

    private static int getNext(int[][] adjMatrix, int v1, int v2) {
        // get the next vertex of v2
        if (v1 < 0 || v1 > adjMatrix.length - 1 || v2 < 0 || v2 > adjMatrix.length - 1)
            return -1;
        for (int i = v2 + 1; i < adjMatrix.length; i++) {
            if (adjMatrix[v1][i] == 1)
                return i;
        }
        // if not found, return -1
        return -1;
    }

}
