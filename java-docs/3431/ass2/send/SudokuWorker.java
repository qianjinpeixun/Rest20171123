
import java.util.Arrays;

/**
 * 
 * This is a worker class implement the Runnable interface in order to support
 * multi threading.
 *
 */
public class SudokuWorker implements Runnable {

    private int[][] numbers;
    private int id;
    private int[] flags;

    // The parent thread will create the worker threads, passing each worker the
    // location that it must check in the Sudoku grid.
    public SudokuWorker(int[][] numbers, int id, int[] flags) {
        this.numbers = numbers;
        this.id = id;
        this.flags = flags;
    }

    /**
     * the body of multi threading
     */
    public void run() {
        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            int[] checks = numbers[i];
            Arrays.sort(checks);
            String str = Arrays.toString(checks);
            // Once a worker has performed this check, it must pass its results
            // back to the parent. If a worker sets its corresponding value to
            // 1, it is indicating
            // that its region of the Sudoku puzzle is valid. A value of 0 would
            // indicate otherwise.
            if (str.equals("[1, 2, 3, 4, 5, 6, 7, 8, 9]"))
                flags[id] = 1;
            else {
                flags[id] = 0;
                return;
            }
        }
    }

}
