package com.qianjin.java.sss.java2s.a1101.ass43wu;

public class Board {
	private int rows;
	private int cols;
	private Chip[][] board;//2D arrays from Short Tutorial

	public Board(int r, int c) {
	        this.rows = r;
	        this.cols = c;
	        board = new Chip[r][c];
	    }

	public boolean isEmpty(int r, int c) {
		if (board[r][c] == null)
			return true;
		else
			return false;
	}

	public boolean add(int r, int c, Chip chip) {
		if (board[r][c] != null)
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

	public Chip[][] getBoard() {
		return board;
	}

}


