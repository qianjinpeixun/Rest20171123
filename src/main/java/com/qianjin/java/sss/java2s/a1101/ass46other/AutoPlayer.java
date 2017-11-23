package com.qianjin.java.sss.java2s.a1101.ass46other;

import java.util.Random;

public class AutoPlayer {

    private Connect4Board connect4Board;

    public int getBestPosition(Connect4Board connect4Board) {
        this.connect4Board = connect4Board;
        int position = winType();
        if (position != -1)
            return position;
        else {
            int random = getRandomPostion();
            return random;
        }
    }

    private int getRandomPostion() {
        int random = (int) (Math.random() * 6);
        return random;
    }

    private int winType() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Chip chip = connect4Board.getBoard()[i][j];
                if (chip != null) {
                    int win = winH(chip);
                    if (win != -1)
                        return win;
                    win = winV(chip);
                    if (win != -1)
                        return win;
                    win = winD1(chip);
                    if (win != -1)
                        return win;
                    win = winD2(chip);
                    if (win != -1)
                        return win;

                }
            }
        }
        return -1;
    }

    private int winH(Chip chip) {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (compareChips(i, j, chip) && compareChips(i, j + 1, chip) && compareChips(i, j + 2, chip) && connect4Board.getBoard()[i][j + 3] == null) {
                    if (i == 5) {
                        return j + 3;
                    } else {
                        if (connect4Board.getBoard()[i + 1][j + 3] != null) {
                            return j + 3;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private int winV(Chip chip) {

        for (int i = 0; i < 7; i++) {
            for (int j = 5; j >= 3; j--) {
                if (compareChips(j, i, chip) && compareChips(j - 1, i, chip) && compareChips(j - 2, i, chip) && connect4Board.getBoard()[j - 3][i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int winD1(Chip chip) {
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (compareChips(i, j, chip) && compareChips(i - 1, j + 1, chip) && compareChips(i - 2, j + 2, chip) && connect4Board.getBoard()[i - 3][j + 3] == null) {
                    if (connect4Board.getBoard()[i - 2][j + 3] != null) {
                        return j + 3;
                    }
                }
            }
        }
        return -1;
    }

    private int winD2(Chip chip) {

        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 7; j++) {
                if (compareChips(i, j, chip) && compareChips(i - 1, j - 1, chip) && compareChips(i - 2, j - 2, chip) && connect4Board.getBoard()[i - 3][j - 3] == null) {
                    if (connect4Board.getBoard()[i - 2][j - 3] != null) {
                        return j - 3;
                    }
                }
            }
        }

        return -1;
    }

    private boolean compareChips(int row1, int col1, Chip chip) {
        Chip chip1 = connect4Board.getBoard()[row1][col1];
        if (chip1 == null)
            return false;
        if (chip == null)
            return false;
        return chip1.equals(chip);
    }
}
