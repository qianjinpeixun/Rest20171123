package com.qianjin.java.sss.java2s.a1101.ass44gao;

public class Connect4Board extends Board {

    private final static int max_row = 6;// have 6 rows and 7 columns.
    private final static int max_col = 7;
    private String type = "";

    public Connect4Board() {
        super(max_row, max_col);
    }

    // add a Chip of the given colour in the column indicated by the parameter
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

    // find a suitable place in one row
    private boolean placeH(int i, int j, Chip chip) {
        int col = j - 1;
        while (col >= 0 && getChip(i, col) != null && getChip(i, col).equals(chip)) {
            col--;
        }

        if (col >= 0) {
            if (i == 5) {
                if (getChip(i, col) == null) {
                    add(col + 1, "YELLOW");
                    return true;
                }
            } else if (getChip(i + 1, col) != null) {
                add(col + 1, "YELLOW");
                return true;
            }
        }
        col = j + 1;
        while (col < 7 && getChip(i, col) != null && getChip(i, col).equals(chip)) {
            col++;
        }
        if (col < 7) {
            if (i == 5) {
                if (getChip(i, col) == null) {
                    add(col, "YELLOW");
                    return true;
                }
            } else if (getChip(i + 1, col) != null) {
                add(col, "YELLOW");
                return true;
            }
        }

        return false;
    }

    // find a suitable place in column
    private boolean placeV(int i, int j, Chip chip) {
        int row = i - 1;
        if (i == 0)
            return false;
        while (row > 0 && getChip(row, j) != null && getChip(row, j).equals(chip)) {
            row--;
        }
        if (row > 0) {
            if (getChip(row, j) == null) {
                add(j, "YELLOW");
                return true;
            }
        }
        return false;
    }

    private boolean placeD1(int i, int j, Chip chip) {
        int row = i - 1;
        int col = j - 1;
        while (row >= 0 && col >= 0 && getChip(row, col) != null && getChip(row, col).equals(chip)) {
            row--;
            col--;
        }
        if (row >= 0 && col >= 0) {
            if (getChip(row + 1, col) != null) {
                if (getChip(row, col) == null) {
                    add(col, "YELLOW");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean placeD2(int i, int j, Chip chip) {
        int row = i - 1;
        int col = j + 1;
        while (row >= 0 && col < 7 && getChip(row, col) != null && getChip(row, col).equals(chip)) {
            row--;
            col++;
        }
        if (row >= 0 && col < 7) {
            if (getChip(row + 1, col) != null) {
                if (getChip(row, col) == null) {
                    add(col, "YELLOW");
                    return true;
                }
            }
        }

        return false;
    }

    // the computer will play automatically
    public boolean auto() {
        Chip red = new Chip("RED");
        Chip yellow = new Chip("YELLOW");
        int h11, h12, v11, v12, d11, d12, d21, d22;

        boolean found = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Chip c = getChip(i, j);

                h12 = winH(i, j, yellow);
                v12 = winV(i, j, yellow);
                d12 = winD1(i, j, yellow);
                d22 = winD2(i, j, yellow);
                h11 = winH(i, j, red);
                v11 = winV(i, j, red);
                d11 = winD1(i, j, red);
                d21 = winD2(i, j, red);
                if (h12 != 99) {
                    if (placeH(i, j, yellow))
                        return true;
                }

                if (h11 != 99) {
                    System.out.println("h11=" + h11 + ",i=" + i + ",j=" + j);
                    if (placeH(i, j, red))
                        return true;
                }

                if (v12 != 99) {
                    System.out.println("v12=" + h12 + ",i=" + i + ",j=" + j);
                    if (placeV(i, j, yellow))
                        return true;
                }

                if (v11 != 99) {
                    System.out.println("v11=" + h12 + ",i=" + i + ",j=" + j);
                    if (placeV(i, j, red))
                        return true;
                }

                if (d12 != 99) {
                    System.out.println("d12=" + d12 + ",i=" + i + ",j=" + j);
                    if (placeD1(i, j, yellow))
                        return true;
                }

                if (d11 != 99) {
                    System.out.println("d11=" + d11 + ",i=" + i + ",j=" + j);
                    if (placeD1(i, j, red))
                        return true;
                }

                if (d22 != 99) {
                    System.out.println("d22=" + d22 + ",i=" + i + ",j=" + j);
                    if (placeD2(i, j, yellow))
                        return true;
                }

                if (d21 != 99) {
                    System.out.println("d21=" + d21 + ",i=" + i + ",j=" + j);
                    if (placeD2(i, j, red))
                        return true;
                }

            }
        }

        int position = (int) (1 + Math.random() * (7 - 1 + 1));
        position--;
        return autoPostion(position);

    }

    private boolean autoPostion(int position) {
        add(position, "YELLOW");
        return true;
    }

    private int winH(int row, int col, Chip chip) {
        int count = 0;
        int column = col;
        // start to check if there is a winner by rows
        while (column >= 0 && getChip(row, column) != null && getChip(row, column).equals(chip)) {
            count++;
            column--;
            if (count == 3) {
                return column;
            }
        }
        column = col + 1;
        while (column < getCols() && getChip(row, column) != null && getChip(row, column).equals(chip)) {
            count++;
            column++;
            if (count == 3) {
                return column;
            }
        }
        return 99;
    }

    private int winV(int row, int col, Chip chip) {
        // start to check if there is a winner by columns
        int count = 0;
        int column = col;
        int line = row - 1;
        while (line >= 0 && getChip(line, col) != null && getChip(line, col).equals(chip)) {
            count++;
            line--;
            if (count == 2) {
                return line;
            }
        }
        line = row + 1;
        while (line < getRows() && getChip(line, col) != null && getChip(line, col).equals(chip)) {
            count++;
            line++;
            if (count == 2) {
                return line;
            }
        }
        return 99;
    }

    private int winD1(int row, int col, Chip chip) {
        // start to check if there is a winner by diagonal
        int count = 0;
        int column = col - 1;
        int line = row - 1;
        while (column >= 0 && line >= 0 && getChip(line, column) != null && getChip(line, column).equals(chip)) {
            count++;
            column--;
            line--;
            if (count == 2) {
                return line;
            }
        }

        column = col + 1;
        line = row + 1;
        while (column < getCols() && line < getRows() && getChip(line, column) != null && getChip(line, column).equals(chip)) {
            count++;
            column++;
            line++;
            if (count == 2) {
                return line;
            }
        }
        return 99;
    }

    private int winD2(int row, int col, Chip chip) {
        // start to check if there is a winner by diagonal
        int count = 0;
        int column = col + 1;
        int line = row - 1;
        while (column < getCols() && line >= 0 && getChip(line, column) != null && getChip(line, column).equals(chip)) {
            count++;
            column++;
            line--;
            if (count == 3) {
                return line;
            }
        }

        column = col - 1;
        line = row + 1;
        while (column >= 0 && column < getCols() && line < getRows() && getChip(line, column) != null && getChip(line, column).equals(chip)) {
            count++;
            column--;
            line++;
            if (count == 3) {
                return line;
            }
        }
        return 99;
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

    // The type has been set during add method
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
        String result = "\r\n     1    2    3    4    5    6    7\r\n";
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
                    result = result + "\r\n";
            }
            result = result + "\r\n";
        }
        return result;
    }
}
