package com.qianjin.java.sss.java2s.a1101.ass43wu;

public class Connect4Board extends Board {
    private int currentR;
    private int currentC;

    private int redx;
    private int redy;

    private int yellowx;
    private int yellowy;

    private String currentColor;

    public String getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
    }

    public Connect4Board() {
        super(6, 7);
    }

    public void robot(String color) {
        int col = 1;
        int num = (int) (Math.random() * 6);
        num = num + 1;
        int yellowH = checkH(2, yellowx, yellowy);
        int redH = checkH(2, redx, redy);

        int yellowV = checkV(2, yellowx, yellowy);
        int redV = checkV(2, redx, redy);

        int yellowD = checkD(2, yellowx, yellowy);
        int redD = checkD(2, redx, redy);

        if (yellowH != -1) {
            add(yellowH, color);
        } else if (yellowV != -1) {
            add(yellowV, color);
        } else if (redH != -1) {
            add(redH, color);
        } else if (redV != -1) {
            add(redV, color);
        } else {
            add(num, color);
        }

    }

    public boolean add(int c, String colour) {
        c = c - 1;
        Chip chip = new Chip(colour);
        if (!isEmpty(0, c))
            return false;
        int row = 0;
        for (int i = 0; i < 6; i++) {
            row = i;
            if (!isEmpty(i, c)) {
                row = i - 1;
                break;
            }
        }
        boolean a = super.add(row, c, chip);
        currentR = row;
        currentC = c;
        if (colour.equalsIgnoreCase("R")) {
            redx = row;
            redy = c;
        } else {
            yellowx = row;
            yellowy = c;
        }
        return a;
    }

    public String winType() {
        if (checkH(3, currentR, currentC) != -1)
            return "H";
        if (checkV(3, currentR, currentC) != -1)
            return "V";
        if (checkD(3, currentR, currentC) != -1)
            return "D";
        return "N";
    }

    public boolean winner() {
        String s = winType();
        if (s.equals("H") || s.equals("V") || s.equals("D"))
            return true;
        else
            return false;
    }

    public boolean full() {
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++) {
                Chip chip = getBoard()[i][j];
                if (chip == null) {
                    return false;
                }
            }
        return true;
    }

    public void reset() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Chip chip = getBoard()[i][j];
                if (chip != null)
                    getBoard()[i][j] = null;
            }
        }
    }

    private int checkH(int count, int currentRow, int currentCol) {
        int left = currentCol;
        int right = currentCol;
        for (int i = currentCol - 1; i >= 0; i--) {
            if (i >= 0) {
                if (getBoard()[currentRow][i] == null) {
                    break;
                }
                if (getBoard()[currentRow][currentCol].equals(getBoard()[currentRow][i])) {
                    left = i;
                } else {
                    break;
                }
            }
        }

        for (int i = currentCol + 1; i <= 7; i++) {
            if (i <= 6) {
                if (getBoard()[currentRow][i] == null) {
                    break;
                }
                if (getBoard()[currentRow][currentCol].equals(getBoard()[currentRow][i])) {
                    right = i;
                } else {
                    break;
                }
            }
        }
        if ((right - left) == count) {
            if (count == 3)
                return 1;
            if (left > 0) {
                if (getBoard()[currentRow][left - 1] == null)
                    return left;
            }
            if (right < 6) {
                if (getBoard()[currentRow][right] == null)
                    return right;
            }
        } else {
            return -1;
        }
        return -1;
    }

    private int checkV(int count, int currentRow, int currentCol) {

        int top = currentRow;
        int bottom = currentRow;
        for (int i = currentRow - 1; i >= 0; i--) {
            if (i >= 0) {
                if (getBoard()[i][currentCol] == null) {
                    break;
                }
                if (getBoard()[currentRow][currentCol].equals(getBoard()[i][currentCol])) {
                    top = i;
                } else {
                    break;
                }
            }
        }

        for (int i = currentRow + 1; i <= 6; i++) {
            if (i <= 5) {
                if (getBoard()[i][currentCol] == null) {
                    break;
                }
                if (getBoard()[currentRow][currentCol].equals(getBoard()[i][currentCol])) {
                    bottom = i;
                } else {
                    break;
                }
            }
        }
        if ((bottom - top) == count) {
            if (count == 3)
                return 1;
            if (top > 1 && getBoard()[top - 2][currentCol] == null) {
                return currentCol + 1;
            }
        } else {
            return -1;
        }
        return -1;
    }

    private int checkD(int count, int currentRow, int currentCol) {
        int top = 0;
        int bottom = 0;
        int newRow = currentRow;
        int newCol = currentCol;
        for (int i = currentRow; i >= 0; i--) {
            newRow--;
            newCol--;
            if (newRow < 0 || newCol < 0) {
                break;
            }
            if (getBoard()[newRow][newCol] == null)
                break;
            else {
                if (getBoard()[currentRow][currentCol].equals(getBoard()[newRow][newCol])) {
                    top++;
                } else {
                    break;
                }
            }
        }

        newRow = currentRow;
        newCol = currentCol;
        for (int i = currentRow; i < 7; i++) {
            newRow++;
            newCol++;
            if (newRow > 5 || newCol > 6)
                break;
            if (getBoard()[newRow][newCol] == null)
                break;
            else {
                if (getBoard()[currentRow][currentCol].equals(getBoard()[newRow][newCol])) {
                    bottom++;
                } else {
                    break;
                }
            }
        }

        if ((top + bottom) == count) {
            if (count == 3)
                return 1;
            else {
                int x = currentRow - top - 1;
                int y = currentCol - top - 1;
                System.out.println("check d1" + ",x=" + x + ",y=" + y);
                if (x >= 0 && y >= 0) {
                    if (getBoard()[x + 1][y] != null && getBoard()[x][y] == null) {
                        return y;
                    }
                }
                x = currentRow + bottom;
                y = currentCol + bottom;
                System.out.println("check d2" + ",x=" + x + ",y=" + y);
                if (x < 5 && y < 7) {
                    if (getBoard()[x + 1][y] != null && getBoard()[x][y] == null) {
                        return y;
                    }
                }
            }
        }

        top = 0;
        bottom = 0;
        newRow = currentRow;
        newCol = currentCol;
        for (int i = currentRow; i >= 0; i--) {
            newRow--;
            newCol++;
            if (newRow < 0 || newCol > 6) {
                break;
            }
            if (getBoard()[newRow][newCol] == null)
                break;
            else {
                if (getBoard()[currentRow][currentCol].equals(getBoard()[newRow][newCol])) {
                    top++;
                } else {
                    break;
                }
            }
        }

        newRow = currentRow;
        newCol = currentCol;
        for (int i = currentRow; i < 7; i++) {
            newRow++;
            newCol--;
            if (newRow > 5 || newCol < 0)
                break;
            if (getBoard()[newRow][newCol] == null)
                break;
            else {
                if (getBoard()[currentRow][currentCol].equals(getBoard()[newRow][newCol])) {
                    bottom++;
                } else {
                    break;
                }
            }
        }

        if ((top + bottom) == count) {
            if (count == 3)
                return 1;
            else {
                int x = currentRow - top - 1;
                int y = currentCol + top;
                System.out.println("check d4" + ",x=" + x + ",y=" + y);
                if (x >= 0 && y < 7) {
                    if (getBoard()[x + 1][y] != null && getBoard()[x][y] == null) {
                        return y;
                    }
                }
                x = currentRow + bottom;
                y = currentCol - bottom;
                System.out.println("check d2" + ",x=" + x + ",y=" + y);
                if (x < 5 && y > 0) {
                    if (getBoard()[x + 1][y] != null && getBoard()[x][y] == null) {
                        return y;
                    }
                }
            }
        }
        return -1;
    }

    public String toString() {
        String s = "       1  2  3  4  5  6  7\r\n";
        for (int i = 0; i < 6; i++) {
            s = s + "    " + String.valueOf(i + 1) + "  ";
            for (int j = 0; j < 7; j++) {
                if (getBoard()[i][j] == null) {
                    s = s + "   ";
                } else {
                    s = s + getBoard()[i][j].toString() + "  ";
                }
            }
            s = s + "\r\n\r\n";
        }
        return s;
    }
}
