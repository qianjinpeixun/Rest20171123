package com.qianjin.java.sss.java2s.a1101.ass24;

public class Board {

    private int rows;
    private int cols;
    // By default, the board is empty with null object
    private Chip[][] board;

    /*
     * In the constructor, initiate the board with 2D array
     */
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new Chip[rows][cols];
    }

    /*
     * Return true if the current position is empty
     */
    public boolean isEmpty(int r, int c) {
        return (board[r][c] == null);
    }

    /*
     * Return true if add a chip successfully
     */
    public boolean add(int r, int c, Chip chip) {
        if (!isEmpty(r, c))
            return false;
        else {
            board[r][c] = chip;
            return true;
        }
    }

    public Chip[][] getBoard() {
        return board;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

}
