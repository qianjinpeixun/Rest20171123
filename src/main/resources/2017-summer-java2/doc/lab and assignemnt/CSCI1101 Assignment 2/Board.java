/*Assigment2, Question 1 CSCI 1101
 Student.java holds information about a student at Dalhousie in CSCI1101
and
 their grades
 July 9, 2017
 Jiaming Han B00726481
 This is entirely my own work. */

public class Board {
   private int rows;
   private int cols;
   private Chip[][] board;
   private String winType; 
   private boolean winner;
   
   //constructor method
   public Board(int r , int c ){
      rows = r;
      cols = c;
      board = new Chip[r][c];
   }
   
   // get method
   public int getRows (){
      return rows;
   }
   public int getCols (){
      return cols;
   }
   
   public Chip[][] getBoard(){
      return board;
   }
   //get winTpye and check winner.
   public String getWinType(){
      return winType;
   }
   
   public boolean getWinner(){
      return winner;
   }   
   
   //set method    
   public void setRows (int r){
      rows = r;
   } 
   public void setCols (int c){
      cols = c;
   } 
   public void setBoard(Chip[][] b){
      board = b;
   } 

   public boolean isEmpty (int r, int c){
      return board[r][c]== null;      
   }
   
   public boolean add(int r, int c, Chip chip){
      if(isEmpty(r,c)== true) {
        board[r][c] = chip;
        checkWinner(r,c);
        return true;
      }
      return false;
   }  
   
   //check the winner for every step.(the win type have Horiz, verticle , right diag and left diag)
   public void checkWinner(int r, int c ){
      winner  = (checkHoriz(r,c)||checkVerticle(r,c)||checkLeft(r,c)||checkRight(r,c));
   }
   
   //Horizontal
   public boolean checkHoriz(int r,int c){ 
      int count = 0;
      Chip currentChip = board[r][c];
      Chip nextChip = currentChip;
      int nextPosition = 1;
      
      /* the loop wont be stop until the next chip is not null, and the count get enough. and make sure 
      the every chip steps would not out of index.*/
      while((nextChip != null)&&(currentChip.equals(nextChip))&&(count!=3)&&(c+nextPosition) < getCols()){
             nextChip = board[r][c+nextPosition];
             nextPosition ++;
        
             if(nextChip != null && (nextChip.equals(currentChip))){
                count ++;
             }
      }    
      //back to the current step.
         nextChip = currentChip;
         nextPosition = -1;
      while((nextChip != null)&&(currentChip.equals(nextChip))&&(count!=3)&&(c+nextPosition) >= 0){
            nextChip = board[r][c+nextPosition];
            nextPosition --;
            
            if((nextChip != null)&& (nextChip.getColor() == currentChip.getColor()))
               count ++;
      }
      //print out the winType.
      if(count == 3){
         winType = "Congratulation "; 
      }
      else{
         winType = "no victor currently !";  

      }
      // the winner would be created when someone connected 4.
       if(count == 3)
          return true;
        else   
          return false;
   }
   //Verticle
   public boolean checkVerticle(int r,int c){ 
      int count = 0;
      Chip currentChip = board[r][c];
      Chip nextChip = currentChip;
      int nextPosition = 1;
      
      while((nextChip != null)&&(currentChip.equals(nextChip))&&(count!=3)&&(r+nextPosition) < getRows()){
             nextChip = board[r+nextPosition][c];
             nextPosition ++;
        
             if(nextChip != null && (nextChip.equals(currentChip))){
                count ++;
             }
      }    
         nextChip = currentChip;
         nextPosition = -1;
      while((nextChip != null)&&(currentChip.equals(nextChip))&&(count!=3)&&(c+nextPosition) >= 0){
            nextChip = board[r][c+nextPosition];
            nextPosition --;
            
            if((nextChip != null)&& (nextChip.getColor() == currentChip.getColor()))
               count ++;
      }
      //print out the winType.
      if(count == 3){
         winType = "Congratulation "; 
      }
      else{
         winType = "no victor currently !";  

      }
       if(count == 3)
          return true;
        else   
          return false;
   }   
   //right diagonal.
   public boolean checkRight(int r,int c){ 
      int count = 0;
      Chip currentChip = board[r][c];
      Chip nextChip = currentChip;
      int nextPosition = 1;
      
      while((nextChip != null)&&(currentChip.equals(nextChip))&&(count!=3)&&(c+nextPosition<getCols())&&(r+nextPosition< getRows())){
             nextChip = board[r+nextPosition][c+nextPosition];
             nextPosition ++;
        
             if(nextChip != null && (nextChip.equals(currentChip))){
                count ++;
             }
      }    
      nextChip = currentChip;
      nextPosition = -1;
      while((nextChip != null)&&(currentChip.equals(nextChip))&&(count!=3)&&(c+nextPosition >= 0)&&(r+nextPosition >= 0)){
            nextChip = board[r+nextPosition][c+nextPosition];
            nextPosition --;
            
            if((nextChip != null)&& (nextChip.getColor() == currentChip.getColor()))
               count ++;
      }
      //print out the winType.
      if(count == 3){
         winType = "Congratulation "; 
      }
      else{
         winType = "no victor currently !";  

      }
       if(count == 3)
          return true;
        else   
          return false;
   }
   //left diagonal.  
   public boolean checkLeft(int r,int c){ 
      int count = 0;
      Chip currentChip = board[r][c];
      Chip nextChip = currentChip;
      int nextPosition = 1;
      
      while((nextChip != null)&&(currentChip.equals(nextChip))&&(count!=3)&&(c+nextPosition<getCols())&&(r-nextPosition >= 0)){
             nextChip = board[r-nextPosition][c+nextPosition];
             nextPosition ++;
        
             if(nextChip != null && (nextChip.equals(currentChip))){
                count ++;
             }
      }    
         nextChip = currentChip;
         nextPosition = -1;
      while((nextChip != null)&&(currentChip.equals(nextChip))&&(count!=3)&&(c+nextPosition >= 0)&&(r-nextPosition< getRows())){
            nextChip = board[r-nextPosition][c+nextPosition];
            nextPosition --;
            
            if((nextChip != null)&& (nextChip.getColor() == currentChip.getColor()))
               count ++;
      }
      //print out the winType.
      if(count == 3){
         winType = "Congratulation "; 
      }
      else{
         winType = "no victor currently !";  

      }
       if(count == 3)
          return true;
        else   
          return false;
   }  
}
