package com.qianjin.java.sss.java2s.a1101.ass23gao;

public class Connect4Board extends Board {

    private final static int max_row = 6;
    private final static int max_col = 7;
    private String type = "";

    public Connect4Board() {
        super(max_row, max_col);
    }

    public boolean add(int c, String colour) {
        Chip chip = new Chip(colour);
        boolean full = true;
        int row = 0;
        for (int i = getRows() - 1; i >= 0; i--) {
            if (getChip(i, c) == null) {
                full = false;
                row = i;
                break;
            }
        }
        if (full)
            return false;
        else {
            boolean add = super.add(row, c, chip);
            // after place one chip, start to check if there is a winner
            type = checkWin(row, c, chip);
            return add;
        }
    }

    public String checkWin(int row, int col, Chip chip) {
        int count = 0;
        int column = col;
        // start to check if there is a winner by rows
        while (column >= 0 && getChip(row, column) != null && getChip(row, column).equals(chip)) {
            count++;
            column--;
            if (count == 4) {
                return "horizontal";

            }
        }
        column = col + 1;
        while (column < getCols() && getChip(row, column) != null && getChip(row, column).equals(chip)) {
            count++;
            column++;
            if (count == 4) {
                return "horizontal";

            }
        }

        // start to check if there is a winner by columns
        count = 0;
        int line = row - 1;
        while (line >= 0 && getChip(line, col) != null && getChip(line, col).equals(chip)) {
            count++;
            line--;
            if (count == 3) {
                return "vertical";
            }
        }
        line = row + 1;
        while (line < getRows() && getChip(line, col) != null && getChip(line, col).equals(chip)) {
            count++;
            line++;
            if (count == 3) {
                return "vertical";
            }
        }

        // start to check if there is a winner by diagonal
        count = 0;
        column = col - 1;
        line = row - 1;
        while (column >= 0 && line >= 0 && getChip(line, column) != null && getChip(line, column).equals(chip)) {
            count++;
            column--;
            line--;
            if (count == 3) {
                return "diagonal";
            }
        }

        column = col + 1;
        line = row + 1;
        while (column < getCols() && line < getRows() && getChip(line, column) != null && getChip(line, column).equals(chip)) {
            count++;
            column++;
            line++;
            if (count == 3) {
                return "diagonal";
            }
        }

        // start to check if there is a winner by diagonal
        count = 0;
        column = col + 1;
        line = row - 1;
        while (column < getCols() && line >= 0 && getChip(line, column) != null && getChip(line, column).equals(chip)) {
            count++;
            column++;
            line--;
            if (count == 3) {
                return "diagonal";
            }
        }

        column = col - 1;
        line = row + 1;
        while (column >= 0 && column < getCols() && line < getRows() && getChip(line, column) != null && getChip(line, column).equals(chip)) {
            count++;
            column--;
            line++;
            if (count == 3) {
                return "diagonal";
            }
        }

        return "";
    }

    //The type has been set during add method
    public String winType() {
        return type;
    }

    public boolean winner() {
        if (type != null) {
            if (type.equals("horizontal") || type.equals("vertical") || type.equals("diagonal"))
                return true;
            else
                return false;
        }
        return false;
    }

    public String toString() {
        String result = "\n     1    2    3    4    5    6    7\n";
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    result = result + (i + "    ");
                } else {
                    if (getChip(i - 1, j - 1) == null) {
                        result = result + ("     ");
                    } else {
                        result = result + (getChip(i - 1, j - 1) + "    ");
                    }
                }
                if (j == 7)
                    result = result + "\n";
            }
            result = result + "\n";
        }
        return result;
    }
}
