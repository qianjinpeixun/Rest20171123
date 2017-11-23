public class Board{
/*Assignment 2 CSCI 1101
   Board is a java class is set the array and aggretation to chip. 
   July 15, 2017
   Ang Li B00751990 
   This is entirely my own work. */
   private int rows;
   private int cols;
   private Chip[][] board;//chip board that means only chip can store in the array
   
   public Board(int r,int c){//set how big the array is
      rows=r;
      cols=c;
      board=new Chip[r][c];
   }
   public int getRows(){//get rows
      return rows;
   }
   public int getCols(){//get cols
      return cols;
   }
   public Chip[][] getBoard(){//get the array board
      return board;
   }
   public boolean isEmpty(int r,int c){//see if the array of board is empty
      if(board[r-1][c-1]==null){//use if else statement
         return true;
      }else{
         return false;
      }
   }
   public boolean add(int r, int c, Chip chip){//add method is add a chip in the array if it is empty
      if(isEmpty(r,c)==true){
         board[r-1][c-1]=chip;//add a chip in there
         return true;
      }else{
         return false;
      }
   }
}
      