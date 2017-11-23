/*Assigment2, Question 1 CSCI 1101
 Student.java holds information about a student at Dalhousie in CSCI1101
and
 their grades
 July 9, 2017
 Jiaming Han B00726481
 This is entirely my own work. */

public class Connect4Board extends Board {
   public Connect4Board (){
      super(6,7);
   }
   // improve the add method, add one chip in the arrays.
   public boolean add (int c, String color){
     Chip c1 = new Chip(color);
     int r = 5;
     while(r!=0){
       if(super.isEmpty(r,c-1)){
         super.add(r,c-1,c1);
         return true;
       }
       else {
         r--;
       } 
     }
     return false; 
   }
   //get winType.
   public String winType(){
     return  getWinType();
   }
   // get winner.
   public boolean winner(){
    return getWinner();
   }
   
   //make a chessboard.
   public String toString(){
      String ts =" \t1 \t2 \t3 \t4 \t5 \t6 \t7";
      Chip [][] board = super.getBoard();
      int n = 1;
      for(int i=0; i< super.getRows();i++){
        ts += "\n" + n;
        for(int j =0; j < super.getCols();j++) {
          if(board[i][j]==null){
            ts += "[ ]";
          }
          else{
             ts += "["+board[i][j]+"]";
          }
        }
         n++;
      }   
      return ts;
   }
}

