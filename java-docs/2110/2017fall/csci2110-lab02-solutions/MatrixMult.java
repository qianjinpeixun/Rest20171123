
import java.util.Scanner;

/**
 * 
 * This is for CSCI 2110- Data Structures and Algorithms Laboratory No. 2
 * Exercise 3.
 * 
 * This class is designed to multiply two matrices.
 *
 */

public class MatrixMult {

    /** Main method */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n;
        double num;
        System.out.print("Enter the size of each matrix: ");
        n = keyboard.nextInt();
        System.out.println("Enter the matrix element");
        System.out.print("All elements of the matrices are assumed to be the same: ");
        num = keyboard.nextDouble();
        double[][] matrix1 = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix1[i][j] = num;
        double[][] matrix2 = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix2[i][j] = num;
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();
        double[][] resultMatrix = multiplyMatrix(matrix1, matrix2);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + "        millisecs");
    }

    /** The method for multiplying two matrices */
    public static double[][] multiplyMatrix(double[][] m1, double[][] m2) {
        // the size of new matrix is the same with m1 and m2
        double[][] m = new double[m1.length][m1.length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                double sum = 0.0;
                //start to calculate the cij
                for (int k = 0; k < m1.length; k++) {
                    sum = sum + m1[i][k] * m2[k][j];
                }
                // put the value to array
                m[i][j] = sum;
            }
        }
        return m;
    }
}
