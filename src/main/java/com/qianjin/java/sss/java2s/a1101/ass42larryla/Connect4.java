package com.qianjin.java.sss.java2s.a1101.ass42larryla;

public class Connect4 extends Board{
   public Connect4(){
   super(6,7);//set the array board is 6,7
   }
   
   public boolean add1(int c,String colour){//add1 method is add the colour to fall to the bottom
   int a=6;
      Chip c1 =new Chip(colour);
         while(a!=0){//use while loop see if add method is true,the row will minus 1.
            if(super.add(a,c,c1)==true){//when a=0.it will stop and return false;
               super.add(a,c,c1);
               return true;
            }else{
               a--;
            }
         }
      return false;            
   }
   public String winType(){//the winType method is see if the board can connect 4 
      for(int i=0;i<6;i++){//rows
         for(int j=0;j<4;j++){//cols because it will plus 1 or 2 or 3 so,it must be 4
            if(getBoard()[i][j]!=null&&getBoard()[i][j+1]!=null&&getBoard()[i][j+2]!=null&&getBoard()[i][j+3]!=null){
               if(getBoard()[i][j].equals(getBoard()[i][j+1])){//if that 4 not equals to null and they are equals
                  if(getBoard()[i][j+1].equals(getBoard()[i][j+2])){
                     if(getBoard()[i][j+2].equals(getBoard()[i][j+3])){
                        return "H";//return H
                     }
                  }
               }
            }
         }
      }
      for(int y=0;y<7;y++){
         for(int x=0;x<3;x++){//same method with last one
            if(getBoard()[x][y]!=null&&getBoard()[x+1][y]!=null&&getBoard()[x+2][y]!=null&&getBoard()[x+3][y]!=null){
               if(getBoard()[x][y].equals(getBoard()[x+1][y])){
                  if(getBoard()[x+1][y].equals(getBoard()[x+2][y])){
                     if(getBoard()[x+2][y].equals(getBoard()[x+3][y])){
                        return "V";
                     }
                  }
               }
            }
         }
      }
      for(int i=3;i<6;i++){
         for(int j=0;j<4;j++){//same method with last one
            if(getBoard()[i][j]!=null&&getBoard()[i-1][j+1]!=null&&getBoard()[i-2][j+2]!=null&&getBoard()[i-3][j+3]!=null){
               if(getBoard()[i][j].equals(getBoard()[i-1][j+1])){
                  if(getBoard()[i-1][j+1].equals(getBoard()[i-2][j+2])){
                     if(getBoard()[i-2][j+2].equals(getBoard()[i-3][j+3])){
                        return "D";
                     }
                  }
               }
            }
         }
      }
      for(int i=0;i<3;i++){
         for(int j=0;j<4;j++){//same method with last one
            if(getBoard()[i][j]!=null&&getBoard()[i+1][j+1]!=null&&getBoard()[i+2][j+2]!=null&&getBoard()[i+3][j+3]!=null){
               if(getBoard()[i][j].equals(getBoard()[i+1][j+1])){
                  if(getBoard()[i+1][j+1].equals(getBoard()[i+2][j+2])){
                     if(getBoard()[i+2][j+2].equals(getBoard()[i+3][j+3])){
                        return "D";
                     }
                  }
               }
            }
         }
      }
      return "E";         
   } 
   public boolean winner(){//this method will return true if it connect 4 and not null
   String a= winType();
      if(a.equals("H")||a.equals("V")||a.equals("D")){//when the method return H or V or D
         return true;//return true
      }else{
         return false;
      }
   }
   public String toString(){//toString method
      String b="";
      b=b+"Congratulations You Win! ";
      return b;
   }
}