/*Assignment1, CSCI 1101
 We can use four for loop to write the program.
 July 16, 2017
 Longhao Liu B00743382
 This is entirely my own work. */
public class Board {

    // the number of rows on the board,
    private int rows;
    // the number of columns on the board,
    private int cols;
    // a two-dimensional array stores the actual Chips
    private Chip[][] board;

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Chip[][] getBoard() {
        return board;
    }

    // initialize all the instance variables
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new Chip[rows][cols];

    }

    // returns true if the position given by the row/column parameters does not
    // contain a Chip object, and returns false otherwise.
    public boolean isEmpty(int row, int col) {
        if (board[row][col] == null)
            return true;
        else
            return false;
    }

    // adds the parameter Chip to the given row/column location, so long as this
    // is a valid and empty location; the method returns true if the Chip was
    // successfully added, and false otherwise
    public boolean add(int row, int col, Chip chip) {
        if (isEmpty(row, col)) {
            board[row][col] = chip;
            return true;
        } else {
            return false;
        }
    }

}
