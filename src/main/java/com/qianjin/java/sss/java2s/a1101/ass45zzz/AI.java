package com.qianjin.java.sss.java2s.a1101.ass45zzz;

public class AI {
    // This class is designed as a computer-controlled class
    // This class can find the best position to place a chip
    private Connect4Board connect4;
    private int currentx = 0;
    private int currenty = 0;
    private int winCount = 3;
    private static final int rows = 6;
    private static final int cols = 7;

    public AI(Connect4Board c4) {
        this.connect4 = c4;
    }

    // if the position with x,y is can placed, means that under this position,
    // there is a chip
    private boolean canPlaced(int x, int y) {
        if (x < 0 || x > 5)
            return false;
        if (y < 0 || y > 6)
            return false;
        if (connect4.getBoard()[x][y] != null)
            return false;
        if (x == 5)
            return false;
        if (connect4.getBoard()[x + 1][y] == null)
            return false;
        return true;
    }

    private int findCol() {
        int xx = currentx;
        int yy = currenty - 1;
        boolean b = canPlaced(xx, yy);
        // System.out.println("left findRow b=" + b + ",xx=" + xx + ",yy=" +
        // yy);
        if (b) {
            return yy;
        }
        xx = currentx;
        yy = currenty + 3;
        b = canPlaced(xx, yy);
        // System.out.println("right findRow2 b=" + b + ",xx=" + xx + ",yy=" +
        // yy);
        if (b) {
            return yy;
        }
        return -1;
    }

    private int findRow() {
        int xx = currentx - 1;
        int yy = currenty;
        boolean b = canPlaced(xx, yy);
        // System.out.println("top findRow b=" + b + ",xx=" + xx + ",yy=" + yy);
        if (b) {
            return yy;
        }
        return -1;
    }

    private int findDig() {
        int xx = currentx - 1;
        int yy = currenty - 1;
        boolean b = canPlaced(xx, yy);
        // System.out.println("left findDig b=" + b + ",xx=" + xx + ",yy=" +
        // yy);
        if (b) {
            return currenty - 1;
        }
        xx = currentx + 3;
        yy = currenty + 3;
        b = canPlaced(xx, yy);
        // System.out.println("right findDi b=" + b + ",xx=" + xx + ",yy=" +
        // yy);
        if (b) {
            return yy;
        }
        return -1;
    }

    private int findDig2() {
        int xx = currentx - 1;
        int yy = currenty + 1;
        boolean b = canPlaced(xx, yy);
        // System.out.println("right top findDig b=" + b + ",xx=" + xx + ",yy="
        // + yy);
        if (b) {
            return yy;
        }
        xx = currentx + 3;
        yy = currenty - 3;
        b = canPlaced(currentx + 3, currenty - 3);
        // System.out.println("left bottom findDig b=" + b + ",xx=" + xx +
        // ",yy=" + yy);
        if (b) {
            return yy;
        }
        return -1;
    }

    public int getColumn() {
        int b = -1;
        Chip chip1 = new Chip("Red");
        Chip chip2 = new Chip("Yellow");
        b = hasRowWin(chip2);
        // System.out.println("yellow after check row hasRowWin=" + b + ",x=" +
        // currentx + ",y=" + currentx);
        if (b != -1) {
            return b;
        }

        b = hasColWin(chip2);
        // System.out.println("yellow after check row hasColWin=" + b + ",x=" +
        // currentx + ",y=" + currentx);
        if (b != -1) {
            return b;
        }

        b = hasDigWin(chip2);
        // System.out.println("yellow after check row hasDigWin=" + b + ",x=" +
        // currentx + ",y=" + currentx);
        if (b != -1) {
            return b;
        }

        b = hasDig2Win(chip2);
        // System.out.println("yellow after check row hasDig2Win=" + b + ",x=" +
        // currentx + ",y=" + currentx);
        if (b != -1) {
            return b;
        }

        b = hasRowWin(chip1);
        // System.out.println("Red after check row hasRowWin=" + b + ",x=" +
        // currentx + ",y=" + currentx);
        if (b != -1) {
            return b;
        }

        b = hasColWin(chip1);
        // System.out.println("Red after check row hasColWin=" + b + ",x=" +
        // currentx + ",y=" + currentx);
        if (b != -1) {
            return b;
        }

        b = hasDigWin(chip1);
        // System.out.println("Red after check row hasDigWin=" + b + ",x=" +
        // currentx + ",y=" + currentx);
        if (b != -1) {
            return b;
        }

        b = hasDig2Win(chip1);
        // System.out.println("Red after check row hasDig2Win=" + b + ",x=" +
        // currentx + ",y=" + currentx);
        if (b != -1) {
            return b;
        }
        return getRandom();
    }

    public int getRandom() {
        int random = (int) (Math.random() * 6);
        random++;
        // System.out.println("random=" + random);
        return random;
    }

    // loop for each column to see if there is a winner
    public int hasColWin(Chip chip) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (connect4.getBoard()[i][j] != null && connect4.getBoard()[i][j].equals(chip)) {

                    boolean colWin = colHasFour(i, j);
                    if (colWin) {
                        currentx = i;
                        currenty = j;
                        int z = findCol();
                        if (z != -1)
                            return z;
                    }

                }
            }
        }
        return -1;
    }

    // loop for each row to see if there is a winner
    public int hasRowWin(Chip chip) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (connect4.getBoard()[i][j] != null && connect4.getBoard()[i][j].equals(chip)) {
                    boolean rowWin = rowHasFour(i, j);
                    if (rowWin) {
                        currentx = i;
                        currenty = j;
                        int z = findRow();
                        if (z != -1)
                            return z;
                    }

                }
            }
        }
        return -1;
    }

    public int hasDigWin(Chip chip) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (connect4.getBoard()[i][j] != null && connect4.getBoard()[i][j].equals(chip)) {
                    boolean diaWin = diaHasFour(i, j);
                    if (diaWin) {
                        currentx = i;
                        currenty = j;
                        int z = findDig();
                        if (z != -1)
                            return z;
                    }

                }
            }
        }
        return -1;
    }

    public int hasDig2Win(Chip chip) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (connect4.getBoard()[i][j] != null && connect4.getBoard()[i][j].equals(chip)) {
                    boolean diaWin = dia2HasFour(i, j);
                    if (diaWin) {
                        currentx = i;
                        currenty = j;
                        int z = findDig2();
                        if (z != -1)
                            return z;
                    }

                }
            }
        }
        return -1;
    }

    // the maximum number of same chips left corner of the input parameter
    // if it's equal 4, there is a winner
    private boolean dia2HasFour(int row, int col) {
        boolean four = false;
        int colCount = 0;
        if (connect4.getBoard()[row][col] == null)
            return false;
        if (row < rows - 1 && col > 0)
            for (int i = row + 1, j = col - 1; i < rows && j > 0; i++, j--) {
                if (connect4.getBoard()[i][j] == null) {
                    break;
                }
                if (connect4.getBoard()[row][col].equals(connect4.getBoard()[i][j])) {
                    colCount++;
                } else {
                    break;
                }
            }

        if (row > 0 && col < cols - 1)
            for (int i = row - 1, j = col + 1; i > 0 && j < cols; i--, j++) {
                if (connect4.getBoard()[i][j] == null) {
                    break;
                }

                if (connect4.getBoard()[row][col].equals(connect4.getBoard()[i][j])) {
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
        if (connect4.getBoard()[row][col] == null)
            return false;
        if (row < rows - 1 && col < cols - 1)
            for (int i = row + 1, j = col + 1; i < rows && j < cols; i++, j++) {
                if (connect4.getBoard()[i][j] == null) {
                    break;
                }
                if (connect4.getBoard()[row][col].equals(connect4.getBoard()[i][j])) {
                    colCount++;
                } else {
                    break;
                }
            }

        if (row > 0 && col > 0)
            for (int i = row - 1, j = col - 1; i > 0 && j > 0; i--, j--) {
                if (connect4.getBoard()[i][j] == null) {
                    break;
                }

                if (connect4.getBoard()[row][col].equals(connect4.getBoard()[i][j])) {
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
        if (connect4.getBoard()[row][col] == null)
            return false;
        if (col < cols - 1) {
            for (int i = col + 1; i < cols; i++) {
                if (connect4.getBoard()[row][i] == null) {
                    break;
                }
                if (connect4.getBoard()[row][col].equals(connect4.getBoard()[row][i])) {
                    colCount++;
                } else {
                    break;
                }
            }
        }
        if (col > 0) {
            for (int i = col - 1; i > 0; i--) {
                if (connect4.getBoard()[row][i] == null) {
                    break;
                }
                if (connect4.getBoard()[row][col].equals(connect4.getBoard()[row][i])) {
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
        if (connect4.getBoard()[row][col] == null)
            return false;
        rowCount = 0;
        if (row < rows - 1) {
            for (int i = row + 1; i < rows; i++) {
                if (connect4.getBoard()[i][col] == null) {
                    break;
                }
                if (connect4.getBoard()[row][col].equals(connect4.getBoard()[i][col])) {
                    rowCount++;
                } else {
                    break;
                }
            }
        }
        if (row > 0) {
            for (int i = row - 1; i > 0; i--) {
                if (connect4.getBoard()[i][col] == null) {
                    break;
                }
                if (connect4.getBoard()[row][col].equals(connect4.getBoard()[i][col])) {
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
}
