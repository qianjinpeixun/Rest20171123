/*Assignment2, Question 1 CSCI 1101
  Board.java game is generic square-grid game boards player chose location and put location into array .
   July 11, 2017
   Yiping Liang B00744822
   This is entirely my own work. */
public class Board {

    private int rows;
    private int cols;
    //  rows and columns on the board
    private Chip[][] board;

    public Board(int r, int c) {
        this.rows = r;
        this.cols = c;
        board = new Chip[r][c];
    }

    public boolean isEmpty(int r, int c) {//if the position given by the row/column parameters does not contain a Chip object
        boolean empty = false;
        if (board[r][c] == null)
            empty = true;
        else
            empty = false;
        return empty;
    }

    public boolean add(int r, int c, Chip chip) {//adds the parameter Chip to the given row/column location
        if (isEmpty(r, c) == false)
            return false;
        else {
            board[r][c] = chip;
            return true;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Chip getChip(int r, int c) {//put it into array
        return board[r][c];
    }

}
