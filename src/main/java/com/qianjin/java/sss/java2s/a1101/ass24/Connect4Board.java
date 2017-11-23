package com.qianjin.java.sss.java2s.a1101.ass24;

public class Connect4Board extends Board {

    /*
     * In the constructor, set the rows and cols of the board
     */
    public Connect4Board() {
        super(6, 7);
    }

    /*
     * The chip should fall in the most bottom
     */
    public boolean add(int c, String colour) {
        if(c>6 || c<0) return false;
        Chip chip = new Chip(colour);
        for (int i = 5; i >= 0; i--) {
            if (getBoard()[i][c] == null) {
                return super.add(i, c, chip);
            }
        }
        return false;
    }
    
    /*
     * Return true if the board is full
     */
    public boolean boardIsFull(){
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                if(isEmpty(i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * Return true if there winner in each direction
     */
    public boolean winner() {
        String ret = winType();
        if (ret.equals("h") || ret.equals("v") || ret.equals("d"))
            return true;
        else
            return false;
    }

    
    public String winType() {
        // Iterate each point in the board
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Chip chip = getBoard()[i][j];
                // if the current point is not empty, start to check if there is
                // a winner
                if (chip != null) {
                    //start to check in all 8 directions.
                    for(int l=-1;l<2;l++){
                        for(int k=-1;k<2;k++){
                            if(hasWinner(chip, i, j, l, k)){
                                if(l==0){
                                    return "v";
                                }else if(k==0){
                                    return "h";
                                }else{
                                    return "d";
                                }
                            }
                        }
                    }
                }
            }
        }
        return "";
    }
   

    /*
     * Return true if there is a winner which has 4 same chips connected
     */
    private boolean hasWinner(Chip chip, int row, int col, int rowStep, int colStep) {
        if(rowStep==0 && colStep==0) return false;
        // If the next same chip is closed to current point
        boolean close = false;
        // number of same chips
        int counts = 0;

        while (row < 6 && row >= 0 && col < 7 && col >= 0 && !isEmpty(row,col)) {
            // if found different chip, then break the loop
            if (!getBoard()[row][col].equals(chip) && close) {
                break;
            } else if (getBoard()[row][col].equals(chip)) {
                // if found the same chip next to current position
                close = true;
                counts++;
            }
            row = row + rowStep;
            col = col + colStep;
        }
        // if there are 4 same chips, means there is a winner
        return (counts == 4);
    }

    public String toString() {
        String ss = "";
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                ss = "     1    2    3    4    5    6    7\n";
                continue;
            }
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    ss = ss + i + "    ";
                } else {
                    if (getBoard()[i - 1][j - 1] == null) {
                        ss = ss + "     ";
                    } else {
                        ss = ss + getBoard()[i - 1][j - 1] + "    ";
                    }
                }
            }
            ss = ss + "\n";
        }
        return ss+"\n";
    }
}
