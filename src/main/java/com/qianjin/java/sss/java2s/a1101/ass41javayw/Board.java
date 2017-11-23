package com.qianjin.java.sss.java2s.a1101.ass41javayw;

public class Board {
    private int rows;
    private int cols;
    private Chip[][] board;
    private String winType;
    private boolean winner;

    // constructor method
    public Board(int r, int c) {
        rows = r;
        cols = c;
        board = new Chip[r][c];
    }

    // get method
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Chip[][] getBoard() {
        return board;
    }

    // get winTpye and check winner.
    public String getWinType() {
        return winType;
    }

    public boolean getWinner() {
        return winner;
    }

    // set method
    public void setRows(int r) {
        rows = r;
    }

    public void setCols(int c) {
        cols = c;
    }

    public void setBoard(Chip[][] b) {
        board = b;
    }

    public boolean isEmpty(int r, int c) {
        return board[r][c] == null;
    }

    public boolean add(int r, int c, Chip chip) {
        if (isEmpty(r, c) == true) {
            board[r][c] = chip;
            checkWinner(r, c);
            return true;
        }
        return false;
    }

    // check the winner for every step.(the win type have Horiz, verticle ,
    // right diag and left diag)
    public void checkWinner(int r, int c) {
        winner = (checkHoriz(r, c) || checkVerticle(r, c) || checkLeft(r, c) || checkRight(r, c));
        //System.out.println("winnerwinner=" + winner + ",r=" + r + ",c=" + c);
    }

    // Horizontal
    public int checkH(int r, int c) {
        int count = 0;
        Chip currentChip = board[r][c];
        Chip nextChip = currentChip;
        int left = 0;
        int right = 0;

        int nextPosition = 1;

        /*
         * the loop wont be stop until the next chip is not null, and the count
         * get enough. and make sure the every chip steps would not out of
         * index.
         */
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition) < getCols()) {
            nextChip = board[r][c + nextPosition];
            nextPosition++;

            if (nextChip != null && (nextChip.equals(currentChip))) {
                count++;
            }
        }
        right = c + nextPosition - 1;
        // back to the current step.
        nextChip = currentChip;
        nextPosition = -1;
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition) >= 0) {
            nextChip = board[r][c + nextPosition];
            nextPosition--;

            if ((nextChip != null) && (nextChip.getColor() == currentChip.getColor()))
                count++;
        }
        left = c + nextPosition + 1;
        // print out the winType.
        if (count == 3) {
            winType = "Congratulation ";
        } else {
            winType = "no victor currently !";

        }
        // the winner would be created when someone connected 4.
        if (count == 2) {

            if (left > -1) {
                if (board[r][left] == null) {
                    if (r == 5) {
                        return left + 1;
                    } else {
                        if (board[r + 1][left] != null) {
                            return left + 1;
                        }
                    }
                }

            }
            if (right < getCols()) {
                if (board[r][right] == null) {
                    if (r == 5) {
                        return right + 1;
                    } else {
                        if (board[r + 1][left] != null) {
                            return right + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    // Horizontal
    public boolean checkHoriz(int r, int c) {
        int count = 0;
        Chip currentChip = board[r][c];
        Chip nextChip = currentChip;
        int nextPosition = 1;

        /*
         * the loop wont be stop until the next chip is not null, and the count
         * get enough. and make sure the every chip steps would not out of
         * index.
         */
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition) < getCols()) {
            nextChip = board[r][c + nextPosition];
            nextPosition++;

            if (nextChip != null && (nextChip.equals(currentChip))) {
                count++;
            }
        }
        // back to the current step.
        nextChip = currentChip;
        nextPosition = -1;
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition) >= 0) {
            nextChip = board[r][c + nextPosition];
            nextPosition--;

            if ((nextChip != null) && (nextChip.getColor() == currentChip.getColor()))
                count++;
        }
        // print out the winType.
        if (count == 3) {
            winType = "Congratulation ";
        } else {
            winType = "no victor currently !";

        }
        // the winner would be created when someone connected 4.
        if (count == 3) {
           // System.out.println("checkHoriz nextPosition="+nextPosition);
            return true;
        } else
            return false;

    }

    // Verticle
    public int checkV(int r, int c) {
        int count = 0;
        Chip currentChip = board[r][c];
        Chip nextChip = currentChip;
        int nextPosition = 1;
        int left = 0;
        int right = 0;

        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (r + nextPosition) < getRows()) {
            nextChip = board[r + nextPosition][c];
            nextPosition++;

            if (nextChip != null && (nextChip.equals(currentChip))) {
                count++;
            }
        }
        right = r + nextPosition - 1;
        nextChip = currentChip;
        nextPosition = -1;
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (r + nextPosition) >= 0) {
            nextChip = board[r+ nextPosition][c ];
            nextPosition--;

            if ((nextChip != null) && (nextChip.getColor() == currentChip.getColor()))
                count++;
        }
        left = r + nextPosition;
        // print out the winType.
        if (count == 3) {
            winType = "Congratulation ";
        } else {
            winType = "no victor currently !";

        }

        // the winner would be created when someone connected 4.
        if (count == 2) {
            if (r == 0) {
                return -1;
            } else {
                if (board[left][c] == null)
                    return 1;
            }
        }
        return -1;
    }

    // Verticle
    public boolean checkVerticle(int r, int c) {
        int count = 0;
        Chip currentChip = board[r][c];
        Chip nextChip = currentChip;
        int nextPosition = 1;

        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (r + nextPosition) < getRows()) {
            nextChip = board[r + nextPosition][c];
            nextPosition++;

            if (nextChip != null && (nextChip.equals(currentChip))) {
                count++;
            }
        }
        nextChip = currentChip;
        nextPosition = -1;
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (r + nextPosition) >= 0) {
            nextChip = board[r + nextPosition][c];
            nextPosition--;

            if ((nextChip != null) && (nextChip.getColor() == currentChip.getColor()))
                count++;
        }
        // print out the winType.
        if (count == 3) {
            winType = "Congratulation ";
        } else {
            winType = "no victor currently !";

        }
        if (count == 3) {
            //System.out.println("checkVerticle nextPosition="+nextPosition);

            return true;
        } else
            return false;
    }

    // right diagonal.
    public int checkR(int r, int c) {
        int count = 0;
        Chip currentChip = board[r][c];
        Chip nextChip = currentChip;
        int nextPosition = 1;
        int left = 0;
        int right = 0;
        int rightX = 0;
        int rightY = 0;
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition < getCols()) && (r + nextPosition < getRows())) {
            nextChip = board[r + nextPosition][c + nextPosition];
            nextPosition++;
            rightX = r + nextPosition;
            rightY = c + nextPosition;
            if (nextChip != null && (nextChip.equals(currentChip))) {
                count++;
            }
        }
        right = r + nextPosition - 1;
        nextChip = currentChip;
        nextPosition = -1;
        int leftX = 0;
        int leftY = 0;
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition >= 0) && (r + nextPosition >= 0)) {
            nextChip = board[r + nextPosition][c + nextPosition];
            leftX = r + nextPosition;
            leftY = c + nextPosition;
            nextPosition--;

            if ((nextChip != null) && (nextChip.getColor() == currentChip.getColor()))
                count++;
        }
        left = r + nextPosition;
        // print out the winType.
        if (count == 3) {
            winType = "Congratulation ";
        } else {
            winType = "no victor currently !";

        }
        if (count == 2) {
            if (leftX > 0) {
                if (board[leftX + 1][leftY] != null) {
                    return leftX;
                }
            }
            if (rightX < 6 && rightX > 0) {
                if (board[rightX - 1][rightY] != null) {
                    return rightY + 1;
                }
            }
        }
        return -1;
    }

    // right diagonal.
    public boolean checkRight(int r, int c) {
        int count = 0;
        Chip currentChip = board[r][c];
        Chip nextChip = currentChip;
        int nextPosition = 1;

        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition < getCols()) && (r + nextPosition < getRows())) {
            nextChip = board[r + nextPosition][c + nextPosition];
            nextPosition++;

            if (nextChip != null && (nextChip.equals(currentChip))) {
                count++;
            }
        }
        nextChip = currentChip;
        nextPosition = -1;
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition >= 0) && (r + nextPosition >= 0)) {
            nextChip = board[r + nextPosition][c + nextPosition];
            nextPosition--;

            if ((nextChip != null) && (nextChip.getColor() == currentChip.getColor()))
                count++;
        }
        // print out the winType.
        if (count == 3) {
            winType = "Congratulation ";
        } else {
            winType = "no victor currently !";

        }
        if (count == 3) {
           // System.out.println("checkRight nextPosition="+nextPosition);

            return true;
        } else
            return false;
    }

    // left diagonal.
    public int checkL(int r, int c) {
        int count = 0;
        Chip currentChip = board[r][c];
        Chip nextChip = currentChip;
        int nextPosition = 1;

        int rightX = 0;
        int rightY = 0;
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition < getCols()) && (r - nextPosition >= 0)) {
            nextChip = board[r - nextPosition][c + nextPosition];
            rightX = r - nextPosition;
            rightY = c + nextPosition;
            nextPosition++;

            if (nextChip != null && (nextChip.equals(currentChip))) {
                count++;
            }
        }
        nextChip = currentChip;
        nextPosition = -1;
        int leftX = 0;
        int leftY = 0;
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition >= 0) && (r - nextPosition < getRows())) {
            nextChip = board[r - nextPosition][c + nextPosition];
            leftX = r - nextPosition;
            leftY = c + nextPosition;
            nextPosition--;

            if ((nextChip != null) && (nextChip.getColor() == currentChip.getColor()))
                count++;
        }
        // print out the winType.
        if (count == 3) {
            winType = "Congratulation ";
        } else {
            winType = "no victor currently !";

        }

       // System.out.println("r=" + r + ",c=" + c + ",count =" + count + ",leftX=" + leftX + ",leftY=" + leftY + ",rightX=" + rightX + ",rightY=" + rightY);

        if (count == 2) {

            if (leftX < 5 && leftX > 0) {
                if (board[leftX + 1][leftY] != null) {
                    return leftX;
                }
            }
            if (rightX > 0) {
                if (board[rightX + 1][rightY] != null) {
                    return rightY + 1;
                }
            }
        }
        return -1;
    }

    // left diagonal.
    public boolean checkLeft(int r, int c) {
        int count = 0;
        Chip currentChip = board[r][c];
        Chip nextChip = currentChip;
        int nextPosition = 1;

        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition < getCols()) && (r - nextPosition >= 0)) {
            nextChip = board[r - nextPosition][c + nextPosition];
            nextPosition++;

            if (nextChip != null && (nextChip.equals(currentChip))) {
                count++;
            }
        }
        nextChip = currentChip;
        nextPosition = -1;
        while ((nextChip != null) && (currentChip.equals(nextChip)) && (count != 3) && (c + nextPosition >= 0) && (r - nextPosition < getRows())) {
            nextChip = board[r - nextPosition][c + nextPosition];
            nextPosition--;

            if ((nextChip != null) && (nextChip.getColor() == currentChip.getColor()))
                count++;
        }
        // print out the winType.
        if (count == 3) {
            winType = "Congratulation ";
        } else {
            winType = "no victor currently !";

        }
        if (count == 3) {
           // System.out.println("checkLeft nextPosition="+nextPosition);

            return true;
        } else
            return false;
    }
}
