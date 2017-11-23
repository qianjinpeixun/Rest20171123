package com.qianjin.java.sss.java2s.a1101.ass45zzz;

public class Connect4Board extends Board {

    private static final int rows = 6;
    private static final int cols = 7;
    private int winCount = 4;
    private String winnerType = "";

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    private int currentx = 0;
    private int currenty = 0;

    public int getCurrentx() {
        return currentx;
    }

    public void setCurrentx(int currentx) {
        this.currentx = currentx;
    }

    public int getCurrenty() {
        return currenty;
    }

    public void setCurrenty(int currenty) {
        this.currenty = currenty;
    }

    // always have 6 rows and 7 columns.
    public Connect4Board() {
        super(rows, cols);
    }

    // attempt to add a Chip of the given colour in the column indicated by the
    // parameter, returning true if this was successful, and false otherwise.

    // Chips in Connect 4 are added to a column and should “fall”
    // to the bottom-most available location.
    public boolean add(int col, String colour) {
        Chip chip = new Chip(colour);
        for (int i = rows - 1; i >= 0; i--) {
            if (isEmpty(i, col)) {
                return super.add(i, col, chip);
            }
        }
        return false;
    }

    // return true,if the board is full and no more pieces may be added
    public boolean isFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBoard()[i][j] == null)
                    return false;
            }
        }
        return true;
    }

    // return a String that represents whether the current victory was because
    // of a horizontal, vertical, or diagonal match;
    // there is no current winner, return type is blank
    public String winType() {
        if (hasRowWin()) {
            return "horizontal";
        }
        if (hasColWin()) {
            return "vertical";
        }
        if (hasDigWin()) {
            return "diagonal";
        }
        if (hasDig2Win()) {
            return "diagonal2";
        }
        return "";
    }

    // returns true if either of the players has won the game, either with a
    // vertical, horizontal, or diagonal match
    public boolean winner() {
        String result = winType();
        if (result == null || result.equals(""))
            return false;
        if (result.equals("horizontal") || result.equals("vertical") || result.equals("diagonal") || result.equals("diagonal2"))
            return true;
        return false;
    }

    // loop for each column to see if there is a winner
    private boolean hasColWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBoard()[i][j] != null) {

                    boolean colWin = colHasFour(i, j);
                    if (colWin) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    // loop for each row to see if there is a winner
    private boolean hasRowWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBoard()[i][j] != null) {
                    boolean rowWin = rowHasFour(i, j);
                    if (rowWin) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private boolean hasDigWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBoard()[i][j] != null) {
                    boolean diaWin = diaHasFour(i, j);
                    if (diaWin) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private boolean hasDig2Win() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBoard()[i][j] != null) {
                    boolean diaWin = dia2HasFour(i, j);
                    if (diaWin) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    // the maximum number of same chips left corner of the input parameter
    // if it's equal 4, there is a winner
    private boolean dia2HasFour(int row, int col) {
        boolean four = false;
        int colCount = 0;
        if (getBoard()[row][col] == null)
            return false;
        if (row < rows - 1 && col > 0)
            for (int i = row + 1, j = col - 1; i < rows && j > 0; i++, j--) {
                if (getBoard()[i][j] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[i][j])) {
                    colCount++;
                } else {
                    break;
                }
            }

        if (row > 0 && col < cols - 1)
            for (int i = row - 1, j = col + 1; i > 0 && j < cols; i--, j++) {
                if (getBoard()[i][j] == null) {
                    break;
                }

                if (getBoard()[row][col].equals(getBoard()[i][j])) {
                    colCount++;
                } else {
                    break;
                }
            }
        if (colCount >= (winCount - 1)) {
            four = true;
        }
        return four;
    }

    // the maximum number of same chips right corner of the input parameter
    // if it's equal 4, there is a winner
    private boolean diaHasFour(int row, int col) {
        boolean four = false;
        int colCount = 0;
        if (getBoard()[row][col] == null)
            return false;
        if (row < rows - 1 && col < cols - 1)
            for (int i = row + 1, j = col + 1; i < rows && j < cols; i++, j++) {
                if (getBoard()[i][j] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[i][j])) {
                    colCount++;
                } else {
                    break;
                }
            }

        if (row > 0 && col > 0)
            for (int i = row - 1, j = col - 1; i > 0 && j > 0; i--, j--) {
                if (getBoard()[i][j] == null) {
                    break;
                }

                if (getBoard()[row][col].equals(getBoard()[i][j])) {
                    colCount++;
                } else {
                    break;
                }
            }
        if (colCount >= (winCount - 1)) {
            four = true;
        }
        return four;
    }

    // the maximum number of same chips above and below of the input parameter
    // if it's equal 4, there is a winner
    private boolean colHasFour(int row, int col) {
        boolean four = false;
        int colCount = 0;
        if (getBoard()[row][col] == null)
            return false;
        if (col < cols - 1) {
            for (int i = col + 1; i < cols; i++) {
                if (getBoard()[row][i] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[row][i])) {
                    colCount++;
                } else {
                    break;
                }
            }
        }
        if (col > 0) {
            for (int i = col - 1; i > 0; i--) {
                if (getBoard()[row][i] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[row][i])) {
                    colCount++;
                } else {
                    break;
                }
            }
        }
        if (colCount >= (winCount - 1)) {
            four = true;
        }
        return four;
    }

    // the maximum number of same chips left and right of the input parameter
    // if it's equal 4, there is a winner
    private boolean rowHasFour(int row, int col) {
        boolean four = false;
        int rowCount = 0;
        if (getBoard()[row][col] == null)
            return false;
        rowCount = 0;
        if (row < rows - 1) {
            for (int i = row + 1; i < rows; i++) {
                if (getBoard()[i][col] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[i][col])) {
                    rowCount++;
                } else {
                    break;
                }
            }
        }
        if (row > 0) {
            for (int i = row - 1; i > 0; i--) {
                if (getBoard()[i][col] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[i][col])) {
                    rowCount++;
                } else {
                    break;
                }
            }
        }
        if (rowCount >= (winCount - 1)) {
            four = true;
        }
        return four;
    }

    // return a String that visually represents the current state of the board
    public String toString() {
        String returnString = "";
        returnString = returnString + "\r\n";
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < cols + 1; j++) {
                if (i == 0 && j == 0) {
                    returnString = returnString + "  ";
                    continue;
                }
                if (i == 0) {
                    if (j > 0) {
                        returnString = returnString + (j + " ");
                    }
                    if (j == 8) {
                        returnString = returnString + "\r\n";
                    }
                } else {
                    if (j > 0) {
                        if (!isEmpty(i - 1, j - 1)) {
                            returnString = returnString + (getBoard()[i - 1][j - 1] + " ");
                        } else {
                            returnString = returnString + "  ";
                        }
                    }
                }
                if (j == 0) {
                    returnString = returnString + (i + " ");
                }

            }
            returnString = returnString + "\r\n";
        }
        return returnString;
    }
}
