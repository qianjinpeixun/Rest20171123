public class Chip{
/*Assignment 2 CSCI 1101
   Chip is a java class is set one colour. 
   July 15, 2017
   Ang Li B00751990 
   This is entirely my own work. */
   private String colour;
   
   public Chip(String c){//constructor
      this.colour=c;
   }
   public String getChip(){//get and set chip
      return colour;
   }
   public void setChip(String a){
      this. colour=a;
   }
   public boolean equals(Chip c){
      if(c.getChip()==this.colour){
         return true;
      }else{
         return false;
      }
   }
   public String toString(){//toString method return the chip
      String a="";
      a+=getChip();
      return a;
   }
}